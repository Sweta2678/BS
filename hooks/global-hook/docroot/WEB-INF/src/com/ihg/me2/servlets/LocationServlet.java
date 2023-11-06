package com.ihg.me2.servlets;

import com.ihg.me2.framework.custom.security.actions.PostLoginAction;
import com.ihg.me2.search.Hotel;
import com.ihg.me2.search.HotelSearchUtil;
import com.ihg.me2.search.ServletResponseUtil;
import com.ihg.me2.utils.session.MerlinCache;
import com.ihg.me2.utils.session.MerlinSession;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LocationServlet
 */
@WebServlet("/locationServlet")
public class LocationServlet extends HttpServlet {
       
    private static final String QUERY_PARAMETER = "q";

	private static final String CMD_SEARCH_HOTELS = "searchHotels";

	private static final String CMD = "action";
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public LocationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		String action = request.getParameter(CMD);
		if (CMD_SEARCH_HOTELS.equalsIgnoreCase(action))
		{
			doSearchLocations(request, response);
		}
		else
		{
			doFilter(request, response);
		}
	}
	
	private void doSearchLocations(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String keyword = request.getParameter(QUERY_PARAMETER);
		try
		{
			List<Hotel> hotels = HotelSearchUtil.searchByKeyword(keyword);
			OrderByComparator comparator = OrderByComparatorFactoryUtil.create(StringPool.BLANK, "holidex", true);
			Collections.sort(hotels, comparator);
			String json = JSONFactoryUtil.looseSerialize(hotels);
			ServletResponseUtil.writeJSON(response, json);
		}
		catch (PortalException e)
		{
			_logger.error(e.getMessage());
			ServletResponseUtil.sendError(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error while searching. ");
		}
	}
	
	/**
	 * Filter method to change something.
	 * @param req
	 * @param res
	 * @throws IOException
	 * @throws ServletException
	 */
	private void doFilter(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		_logger.info("LocationChangeFilter.doFilter");
		
		Date start = new Date();
		String hotelCode = request.getParameter(HTLCD_REQ_PARAM);
		JSONObject jsonObject = JSONFactoryUtil.getJSONFactory().createJSONObject();
		jsonObject.put("status", "failure");
		
		_logger.info("Processing Hotel Code: " + hotelCode);
		try 
		{
			long userId = Long.valueOf(request.getParameter(USER_ID));
			_logger.info("User ID: " + userId);
			if (userId > 0)	
			{
				User user = UserLocalServiceUtil.getUser(userId);
				String screenName = user.getScreenName();
				_logger.info("User Screenname: " + screenName);
				if (hotelCode != null) 
				{
					if (MerlinSession.get(screenName) != null ) 
					{
						Map<String, String> session = MerlinSession.get(screenName); 
						String userType = (String)session.get(USR_TYP);
						String primLoc = (String) session.get(PRIMARYLOCATION);
						if (hasAccess(hotelCode, session))
						{
							_logger.info("User has access to requested hotel");
							_logger.info("The HotelCode is : " + hotelCode + " The Primary Location is : " + primLoc + "UserType is : " + userType);
							
							if ((userType != null && ("C".equalsIgnoreCase(userType.trim()) || "T".equalsIgnoreCase(userType.trim()) || "V".equalsIgnoreCase(userType.trim()))) && (null != hotelCode && null != primLoc) && hotelCode.equalsIgnoreCase(primLoc))
							{
								_logger.info("Removing Session Parameters");
								session.remove("CURRSTATUS");
								session.remove("CURRCHN");
								session.remove("CURRBRND");
								session.remove("CURRMGTTYP");
							}
							_logger.info("After Security Session CurrentManagement : " + session.get("CURRMGTTYP"));
							setCurrentLocation(hotelCode, session);
							jsonObject.put("status", "success");
						}
						else
						{
							_logger.info("User does not have access to requested hotel. Default to primary location.");
							String primaryLocation = (String) session.get(PRIMARYLOCATION);
							if (primaryLocation != null && !"".equalsIgnoreCase(primaryLocation))
							{
								setCurrentLocation(primaryLocation, session);
								jsonObject.put("status", "success");
							}
						}
					}
				}
			}
			response.getWriter().write(jsonObject.toString());
		}
		catch (Exception exc) 
		{
			throw new ServletException(exc);
		}
		finally
		{
			_logger.debug("LocationChangeFilter.doFilter"+( new Date().getTime() - start.getTime()));
		}
	}
	
	/**
	 * Check if user has access to the location
	 * @param hotelCode
	 * @param session
	 * @return
	 */
	private boolean hasAccess(String hotelCode, Map<String, String> session) 
	{
		boolean returnVal = false;
		
		_logger.info("LocationChangeFilter.hasAccess");
		Date start = new Date();
		String userType = (String)session.get(USR_TYP);
		_logger.info("User Type : " + userType);
		String[] accessTo = ALLOWED_USER_TYPES.split(SESSION_DELIMETER);
		if (userType != null)
		{
			for (String accessType : accessTo)
			{
				if (accessType.equalsIgnoreCase(userType))
				{
					_logger.debug("All User with User Type " + accessTo + " are allowed.");
					returnVal = true;
				}
			}
		}
		String allLocationKey = BASE_ATTRIBUTE;
		String locationVals = session.get(allLocationKey);
		String[] locations = locationVals.split(SESSION_DELIMETER);
		for (String location : locations)
		{
			if (location.equals(hotelCode))
			{
				_logger.debug("User has access to " + hotelCode);
				returnVal = true;
			}
		}

		_logger.debug("User does not have access to " + hotelCode);
		_logger.debug("LocationChangeFilter.hasAccess "+ (new Date().getTime() - start.getTime()));
		return returnVal;
	}

	/**
	 * Setting the correct location.
	 * @param hotelCode
	 * @param session
	 * @throws MerlinDataAccessException 
	 * @throws SecurityXMLException 
	 */
	private void setCurrentLocation(String hotelCode, Map<String, String> session) throws Exception
	{
		_logger.info("LocationChangeFilter.setCurrentLocation");
		Date start = new Date();
		try
		{
			String currentLocation = (String) session.get(CURRENT_ATTRIBUTE);
			if (currentLocation != null && currentLocation.equalsIgnoreCase(hotelCode))
			{
				return;
			}
			session.put(CURRENT_ATTRIBUTE, hotelCode);
			currentLocation = (String) session.get(CURRENT_ATTRIBUTE);
			
			//CacheManager cacheManager = (CacheManager) BeanFactory.getBean(BeanFactory.CACHE_MANAGER);
			
			String ids = SECURITY_ID_VALUE_LOOKUP;
			String[] securityXMLIds = ids.split(SESSION_DELIMETER);
			
			for (String securityId : securityXMLIds) 
			{
				System.out.println("securityId"+securityId);
				Map<String, Object> mainMap = MerlinCache.getCacheMap(securityId);
				if (mainMap != null) 
				{
					Map<String, Object> dataMap = MerlinCache.getCacheData(securityId) ;
					System.out.println("dataMap"+dataMap.size());
					@SuppressWarnings("unchecked")
					Map<String, String> innerMap = (Map<String, String>) dataMap.get(currentLocation);
					if (innerMap != null) 
					{
						PostLoginAction.processSessionValues(currentLocation, innerMap, session, true, false);
					}
				}
			}
		}
		finally
		{
			_logger.info("LocationChangeFilter.setCurrentLocation"+( new Date().getTime() - start.getTime()));
		}
	}
	
	private static Log _logger = LogFactoryUtil.getLog(LocationServlet.class);
	
	private static final long serialVersionUID = 1L;
	private static final String PRIMARYLOCATION = "PRIMARYLOCATION";
	private static final String HTLCD_REQ_PARAM = "htlcd";
	private static final String SESSION_DELIMETER = ";";
	private static final String ALLOWED_USER_TYPES = "C;V;T";
	private static final String USR_TYP = "USRTYP";
	private static final String BASE_ATTRIBUTE = "LOCATIONS";
	private static final String CURRENT_ATTRIBUTE = "CURRLOCATION";
	private static final String SECURITY_ID_VALUE_LOOKUP = "HTL;OFC";
	private static final String USER_ID = "userId";
}
