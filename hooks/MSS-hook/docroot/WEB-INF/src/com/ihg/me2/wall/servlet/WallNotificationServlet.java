package com.ihg.me2.wall.servlet;

import com.ihg.me2.wall.dto.UserSubscriptionInfo;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Subscription;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.SubscriptionLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.service.MBCategoryLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBThreadLocalServiceUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WallNotificationServlet extends HttpServlet {

	private static final String THREADID="threadId";
	private static final String CATEGORYID="categoryId";
	private static final String CLASSPK="classPK";
	private static final String CLASSNAMEID="classNameId";
	private static final String USERID="userId";
	private static final String USERNAME="userName";
	private static final String GROUPID="groupId";
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		sendWallNotifications(req);
	}

	private static Map<Long,String> groupIds;

	public static Map<Long,String> getGroupIds() throws SystemException, PortalException {

		if (groupIds == null) {
			_log.info("Instantiating the groupList...");
			groupIds = new HashMap<Long, String>();
			
			Long companyId = PortalUtil.getDefaultCompanyId();
			_log.info(companyId);
			StringTokenizer st = new StringTokenizer(PropsUtil.get("groupList"));

			while (st.hasMoreTokens()) {
				Group group=GroupLocalServiceUtil.getGroup(companyId, st.nextToken(","));
					groupIds.put(group.getGroupId(),group.getFriendlyURL());
					
			}
			
		}
		//System.out.println("friendly URL :"+GroupLocalServiceUtil.getGroup(groupIds.get(0)).getFriendlyURL());
		return groupIds;
	}

	
	public boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional
												// '-' and decimal.
	}

	public List<Long> getCategoryids(){
		
		List<Long> mbCategoryList=new ArrayList<Long>();
		try {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBCategory.class);
		ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
		projectionList.add(ProjectionFactoryUtil.property(CATEGORYID));
		dynamicQuery.add(RestrictionsFactoryUtil.in(GROUPID, getGroupIds().keySet()));
		dynamicQuery.setProjection(projectionList);
		mbCategoryList = (List<Long>) MBCategoryLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mbCategoryList;
	}
	
	public List<Long> getThreadids(List<Long> categoryIds){
		
		List<Long> mbThreadList=new ArrayList<Long>();
		try {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBThread.class);
		ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
		projectionList.add(ProjectionFactoryUtil.property(THREADID));
		dynamicQuery.add(RestrictionsFactoryUtil.in(CATEGORYID, categoryIds));
		dynamicQuery.setProjection(projectionList);
		mbThreadList = (List<Long>) MBThreadLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mbThreadList;
	}
	
	
	public DynamicQuery getDynamicQueryForThreads(List<Long> categoryIds){
		
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBThread.class);

		ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
		projectionList.add(ProjectionFactoryUtil.property(THREADID));
		dynamicQuery.add(RestrictionsFactoryUtil.in(CATEGORYID, categoryIds));
		dynamicQuery.setProjection(projectionList);
		//mbThreadList = (List<Long>) MBThreadLocalServiceUtil.dynamicQuery(dynamicQuery);
		return dynamicQuery;
	}
	

	// code by manushi
	public List<UserSubscriptionInfo> getSubscribersList()
			throws SystemException {
		
		long mbThreadId=ClassNameLocalServiceUtil.fetchClassNameId(MBThread.class);
		long mbCategoryClassId=ClassNameLocalServiceUtil.fetchClassNameId(MBCategory.class);
		_log.info("ids--------"+mbCategoryClassId+mbThreadId);
		List<Long> mbCategoryList=getCategoryids();
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Subscription.class);
		
			//projection list
			ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
			projectionList.add(ProjectionFactoryUtil.property(USERID));//arrayobject[0]
			projectionList.add(ProjectionFactoryUtil.property(CLASSPK));//arrayobject[1]
			projectionList.add(ProjectionFactoryUtil.property(CLASSNAMEID));//arrayobject[2]
			projectionList.add(ProjectionFactoryUtil.property(USERNAME));//arrayobject[3]
			
			//criteria
			List<Long> classids=new ArrayList<Long>();
			classids.add(mbCategoryClassId);
			classids.add(mbThreadId);
			Criterion criteriaForSubQuery=PropertyFactoryUtil.forName(CLASSPK).in( getDynamicQueryForThreads(mbCategoryList));
			Criterion criteriaForClassPK=RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.in(CLASSPK, mbCategoryList), criteriaForSubQuery);
			
			
			
			Criterion criteriaForClassNameIds= RestrictionsFactoryUtil.in(CLASSNAMEID,classids);
			dynamicQuery.add(RestrictionsFactoryUtil.and(criteriaForClassNameIds, criteriaForClassPK));
			dynamicQuery.setProjection(projectionList);
			UserSubscriptionInfo userSubscriptionInfoDTO;
			Map<Long,UserSubscriptionInfo> userSubscriptionInfoMap=new HashMap<Long, UserSubscriptionInfo>();
			List<Object> objectList = (List<Object>) SubscriptionLocalServiceUtil.dynamicQuery(dynamicQuery);
			//_log.info("List is :"+subscriptionList.toString());
			if(Validator.isNotNull(objectList)){
				
				 for(Object object:objectList){
					 Object[] arrayobject=(Object[])object;
					 userSubscriptionInfoDTO=new UserSubscriptionInfo();
					 //set the DTO
					 long userId=new Long(arrayobject[0].toString());
					 long categoryOrThreadId = new Long(arrayobject[1].toString());
					 if(userSubscriptionInfoMap.containsKey(userId)){
						 userSubscriptionInfoDTO=userSubscriptionInfoMap.get(userId);
						}
					
						userSubscriptionInfoDTO.setUserId(userId);
						userSubscriptionInfoDTO.setUserName(arrayobject[3].toString());
							if (arrayobject[2].equals(mbCategoryClassId)){//to check whether its a category or not
								userSubscriptionInfoDTO.getCategoryIds().add(categoryOrThreadId);
							 }
							 else{
								 userSubscriptionInfoDTO.getThreadIds().add(categoryOrThreadId);
							 }
					 	
					 userSubscriptionInfoMap.put(userId, userSubscriptionInfoDTO);
				 }
			}
			_log.info("subscriber s list building finished.....");
			return new ArrayList<UserSubscriptionInfo>(userSubscriptionInfoMap.values());
			
	
	}
	
	
	public List<MBMessage> getMessageList(List<Long> categoryids,List<Long> threadids) throws SystemException, PortalException{
		int duration = Integer.valueOf(PropsUtil.get("duration"));
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -duration);
		Date date = cal.getTime();
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class);
		Criterion criteria1=RestrictionsFactoryUtil.in(CATEGORYID, categoryids);
		Criterion criteria2=RestrictionsFactoryUtil.in(THREADID, threadids);
		Criterion criteria3=RestrictionsFactoryUtil.ge("modifiedDate", date);
		if ((categoryids.size() > 0) && (threadids.size() > 0)){
			Criterion criteria4=RestrictionsFactoryUtil.or(criteria1, criteria2);
			dynamicQuery.add(RestrictionsFactoryUtil.and(criteria3, criteria4));	
		}
		else {
						if (categoryids.size()>0){ 
							dynamicQuery.add(RestrictionsFactoryUtil.and(criteria3, criteria1));
						}
						else if(threadids.size() > 0){
							dynamicQuery.add(RestrictionsFactoryUtil.and(criteria3, criteria2));
						}
		}
		
		//dynamicQuery.add(RestrictionsFactoryUtil.in(GROUPID, groupIds));
		List<MBMessage> messageList = MBMessageLocalServiceUtil.dynamicQuery(dynamicQuery);
		//_log.info("message list delivered.....");
		return messageList;
		//categoryId
	}
	
		
	// Action method which contains entire logic for mail notification to
	// respective subscribers
	public void sendWallNotifications(HttpServletRequest req) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		try {
			// Will contain map of threadIds as keys and List of Messages as values
			Map<Long, List<MBMessage>> threadMessageList = new LinkedHashMap();
			
			
			List<UserSubscriptionInfo> UserSubscriptionInfoList = getSubscribersList();
			// The following code block executes only if messageList containes messages
			
			if (Validator.isNotNull(UserSubscriptionInfoList)) {

				// To store the companyId of messages. It is assumed that all the messages will be coming from only one company
				//long companyId = messageList.get(0).getCompanyId();

				_log.info("Admin email: " + PropsUtil.get(PropsKeys.ADMIN_EMAIL_FROM_ADDRESS));

				String domain = StringPool.BLANK;
				String environment = System.getProperty("app.environment.type") != null ? System.getProperty("app.environment.type").trim() : "ENVIRONMENT_QA";
				if(environment.equalsIgnoreCase("ENVIRONMENT_QA")){
					domain = "https://me2qa.ihgmerlin.com";
				}else{
					domain = "https://me2.ihgmerlin.com";
				}
				
				//code by Manushi
				for(UserSubscriptionInfo usersubsinfo : UserSubscriptionInfoList){
					
					List<MBMessage> mbMessages= getMessageList(usersubsinfo.getCategoryIds(), usersubsinfo.getThreadIds());
					usersubsinfo.setMbMessages(mbMessages);
					
				}
				//Iterating the list of DTO for sending mail
				for (UserSubscriptionInfo usersubsinfo : UserSubscriptionInfoList)
				{
					long userid=usersubsinfo.getUserId();
				    List<MBMessage> messagingList=usersubsinfo.getMbMessages();
				    Set<MBMessage> finalset = new HashSet<MBMessage>(messagingList);
				    StringBuffer messageBody = new StringBuffer("");
					
					String subject = StringUtil.read(getClass().getClassLoader(), "/emailTemplates/email_subject.vm", false);
					String body = StringUtil.read(getClass().getClassLoader(), "/emailTemplates/email_body.vm", false);
					
					// To generate messageBody of mail which will contain all
					// messages belonging to respective thread
					
					if(Validator.isNotNull(finalset) && !finalset.isEmpty() && finalset.size() >=1 ){
						//_log.info("Inside if");
						for (MBMessage message : finalset) {

							//String URL= req.getRequestURL().substring(0,req.getRequestURL().length()-req.getRequestURI().length())+"/web"+getGroupIds().get(message.getGroupId())+"/social";

							String URL = domain + "/web"+getGroupIds().get(message.getGroupId())+"/social";
							
							//_log.info("Inside if if...");
							messageBody.append("<br>");
							if (message.getRootMessageId()==message.getMessageId()){
								messageBody.append("" + message.getUserName() +StringPool.SPACE +"started a new conversation...<br>");
							}
							else{
								messageBody.append("" + message.getUserName() +StringPool.SPACE+ "replied to the conversation...<br>");
							}
							messageBody.append("\"<a href='"+URL+"' target='_blank'> " + message.getBody() + " </a> \"<br>");
							
						}
						_log.info("\n");
						// To actually send mails to the thread subscribers
						
						_log.info("This thread will be posted to following mail addresses:");
						//InternetAddress fromAddress = new InternetAddress(PropsUtil.get(PropsKeys.ADMIN_EMAIL_FROM_ADDRESS));
						InternetAddress fromAddress = new InternetAddress("IHGMeetingPoint@ihg.com");

						String emailaddress=UserLocalServiceUtil.getUser(userid).getEmailAddress();
						InternetAddress toAddress = new InternetAddress(emailaddress);
						body = StringUtil.replace(body, new String[] { "[$TO_NAME$]","[$MSG_BODY$]"}, new String[] {usersubsinfo.getUserName(), messageBody.toString()}); 
						
						MailMessage mailMessage = new MailMessage();
						
						mailMessage.setTo(toAddress);
						mailMessage.setFrom(fromAddress);
						//mailMessage.setSubject(messageSubject.toString());
						mailMessage.setBody(body);
						mailMessage.setHTMLFormat(true);
						mailMessage.setSubject(subject);
					
						MailServiceUtil.sendEmail(mailMessage);
						//req.getRequestURL().length()-req.getRequestURL().length();
						_log.info(emailaddress);
					}
				}
				/** code end */
				
				threadMessageList.clear();

				Date date = new Date();
				_log.info("Triggered..." + date.toString());
			}

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private static final Log _log = LogFactoryUtil.getLog(WallNotificationServlet.class);
}
