package com.ihg.brandstandards.bridge.portlet;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.scheduler.SchedulerEngine;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;
import com.liferay.portal.kernel.scheduler.TriggerType;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Portlet implementation class SchedulerPortlet
 */
@WebListener
public class SchedulerPortlet extends MVCPortlet implements MessageListener{

	private static final Log LOG = LogFactoryUtil.getLog(SchedulerPortlet.class);
	private static final String DEFAULT_TIME_STAMP = "defaultTiemStemp";
	

	@SuppressWarnings("unchecked")
	@Override
	public void init() throws PortletException {
		LOG.info(" This is init method without parameter...................");
		
		ClassLoader cl = PortalClassLoaderUtil.getClassLoader();
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
			com.liferay.portal.model.PortletPreferences.class, cl).add(
		        PropertyFactoryUtil.forName("portletId").like("%scheduler_WAR_BSBridgeportlet%"));

		List<Object> preferences = new ArrayList<Object>();
		String defaultTime = "";
		String cron = "";
		try
		{
			preferences = PortletPreferencesLocalServiceUtil.dynamicQuery(query);
		
			for (Object preferencesPart : preferences) {
				System.out.println("Preferences are: " + preferences + ", size is: " + preferences.size());
		        System.out.println(((com.liferay.portal.model.PortletPreferences) preferencesPart).getPreferences());
		        PortletPreferences schedulerPreferences;
		        schedulerPreferences = PortletPreferencesFactoryUtil.fromDefaultXML(((com.liferay.portal.model.PortletPreferences) preferencesPart).getPreferences());
				
		        if(Validator.isNotNull(schedulerPreferences)){
		        	defaultTime = schedulerPreferences.getValue(DEFAULT_TIME_STAMP, "5");
		        	System.out.println(defaultTime);
		        }
			}
		}
		catch(SystemException e){
			LOG.error(e);
		}
		
		if(defaultTime.equals("5")){
			cron = "0/05 0/1 * 1/1 * ? *"; 
		}
		else if(defaultTime.equals("10"))
		{
			cron = "0/10 0/1 * 1/1 * ? *"; 
		}
		else if(defaultTime.equals("15"))
		{
			cron = "0/15 0/1 * 1/1 * ? *"; 
		}
		
        Trigger trigger = null;  
	     try {  
	      trigger = TriggerFactoryUtil.buildTrigger(TriggerType.CRON, SchedulerPortlet.class.getName(), SchedulerPortlet.class.getName(), new Date(), null, cron);  
	     } catch (SchedulerException e) {  
	      e.printStackTrace();  
	     }  
	       
	     Message message = new Message();  
	     //message.put(SchedulerEngine.CONTEXT_PATH, portlet.getContextPath());  
	     message.put(SchedulerEngine.MESSAGE_LISTENER_CLASS_NAME, SchedulerPortlet.class.getName());  
	     message.put(SchedulerEngine.PORTLET_ID, "scheduler_WAR_BSBridgeportlet");  
	       
	     try {  
	      SchedulerEngineHelperUtil.schedule(trigger, StorageType.PERSISTED, "", "liferay/scheduler_dispatch", message, 5);  
	     } catch (SchedulerException e) {  
	      e.printStackTrace();  
	     }
		
		super.init();
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		PortletPreferences preferences = renderRequest.getPreferences();
		String defaultTime = preferences.getValue(DEFAULT_TIME_STAMP, "10");
		renderRequest.setAttribute("defaultTime", defaultTime);
		super.doEdit(renderRequest, renderResponse);
	}

	@ProcessAction(name="setDefaultTimeStamp")
	public void setDefaultTimeStamp(ActionRequest actionRequest, ActionResponse actionResponse){
		
		PortletPreferences preferences = actionRequest.getPreferences();
		String defaultTime = "";
		String cron = "";
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "timeSlot"))){
			try {
				defaultTime = ParamUtil.getString(actionRequest, "timeSlot");
				preferences.setValue(DEFAULT_TIME_STAMP, ParamUtil.getString(actionRequest, "timeSlot"));
				preferences.store();
				actionResponse.setPortletMode(PortletMode.VIEW);
			} catch (Exception e) {
				LOG.error(e);
			}
		}
		
		if(defaultTime.equals("5")){
			cron = "0/05 0/1 * 1/1 * ? *"; 
		}
		else if(defaultTime.equals("10"))
		{
			cron = "0/10 0/1 * 1/1 * ? *"; 
		}
		else if(defaultTime.equals("15"))
		{
			cron = "0/15 0/1 * 1/1 * ? *"; 
		}
		
        Trigger trigger = null;  
	     try {  
	    	 trigger = TriggerFactoryUtil.buildTrigger(TriggerType.CRON, SchedulerPortlet.class.getName(), SchedulerPortlet.class.getName(), new Date(), null, cron);  
	     } catch (SchedulerException e) {  
	      e.printStackTrace();  
	     }  
	       
	     Message message = new Message();  
	     //message.put(SchedulerEngine.CONTEXT_PATH, portlet.getContextPath());  
	     message.put(SchedulerEngine.MESSAGE_LISTENER_CLASS_NAME, SchedulerPortlet.class.getName());  
	     message.put(SchedulerEngine.PORTLET_ID, "scheduler_WAR_BSBridgeportlet");  
		
		try
		{
			SchedulerEngineHelperUtil.update(trigger, StorageType.PERSISTED);
		}
		catch (SchedulerException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void receive(Message message)
		throws MessageListenerException
	{
		System.out.println("In receive method.....");
	}
}
