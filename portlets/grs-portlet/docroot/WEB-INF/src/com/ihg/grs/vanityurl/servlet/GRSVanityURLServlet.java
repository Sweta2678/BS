package com.ihg.grs.vanityurl.servlet;



import com.ihg.me2.utils.session.MerlinSession;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.portlet.PortletProps;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GRSVanityURLServlet
 */
public class GRSVanityURLServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil.getLog(GRSVanityURLServlet.class);
	private static final String ERROR_PAGE_URL = "/static/maintpages/404.html";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GRSVanityURLServlet() {

		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		String errorPage =
			request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + ERROR_PAGE_URL;

		String redirectURL = doService(request);

		try {
			if(Validator.isNull(redirectURL)){
				response.sendRedirect(errorPage);
			}else{
				request.getRequestDispatcher("/html/redirecting.jsp").forward(request, response);
			}
		}
		catch (ServletException e) {
			LOGGER.error("Unable to forward to redirect JSP, " + e.getMessage());
		}
		catch (IOException e) {
			LOGGER.error("Unable to forward to redirect JSP, " + e.getMessage());
		}

	}

	private String doService(HttpServletRequest request) {
		long startTime = System.currentTimeMillis();
		String fullURL = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
		String pathInfo = request.getPathInfo();
		String userScreenName = request.getHeader("SAMACCOUNTNAME").toLowerCase();
		String redirectURL = null;
		Map<String, String> sessMap = MerlinSession.get(userScreenName);
		if (Validator.isNotNull(pathInfo) && !pathInfo.isEmpty()) {
			pathInfo = pathInfo.toLowerCase().replaceAll("/", "").replaceAll("\\s", "");
			String userType = sessMap != null ? sessMap.get("USRTYP") : null;
			if(isHMOUser(userType)){
				redirectURL = fullURL.concat(PortletProps.get("grs.hotel.site.url"));
			}
			else{
				redirectURL = fullURL.concat(PortletProps.get("grs.regular.site.url"));
			}
			request.setAttribute("redirectURL", redirectURL);
		}
		
		long endTime = System.currentTimeMillis();
		LOGGER.info(" Exceution time (in ms) to fetch Vanity URL: - " + (endTime - startTime) + " ms for user: " +
			userScreenName);
		return redirectURL;
	}
	
	public boolean isHMOUser(String userType)
	{
		boolean result = false;
		if (Validator.equals(userType, "H") || Validator.equals(userType, "O") || Validator.equals(userType, "M"))
		{
			result = true;
		}
		return result;
	}

}
