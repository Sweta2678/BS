package com.ihg.brandstandards.bridge.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.ihg.brandstandards.bridge.util.ProgressSchedulerUtil;
import com.ihg.brandstandards.util.BrandStandardsUtil;
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
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

/**
 * Portlet implementation class ProgressSchedulerPortlet
 */
public class ProgressSchedulerPortlet extends ProgressMVCPortlet implements MessageListener{

	private static final Log LOG = LogFactoryUtil.getLog(ProgressSchedulerPortlet.class);
	private static final String DEFAULT_TIME_STAMP = "defaultTiemStemp";
	private static final String PORTLET_ID = "progressscheduler_WAR_BSBridgeportlet"; 
	
	@SuppressWarnings("unchecked")
	@Override
	public void init() throws PortletException {
		LOG.debug(" Progress Shedular Init Call for System :::::::::::::::::::::::::::::::::::::::::::::::::::::: "+PortalUtil.getComputerName());
		
		if(isBackendProcessSystem()){
			LOG.debug(" Progress Shedular Init process intiated ");
			LOG.info(" This is init method without parameter...................");
			
			ClassLoader cl = PortalClassLoaderUtil.getClassLoader();
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(
				com.liferay.portal.model.PortletPreferences.class, cl).add(
			        PropertyFactoryUtil.forName("portletId").like("%"+PORTLET_ID+"%"));
	
			List<Object> preferences = new ArrayList<Object>();
			String defaultTime = "5";
			String cron = "";
			try
			{
				preferences = PortletPreferencesLocalServiceUtil.dynamicQuery(query);
			
				for (Object preferencesPart : preferences) {
					LOG.info("Preferences are: " + preferences + ", size is: " + preferences.size());
					LOG.info(((com.liferay.portal.model.PortletPreferences) preferencesPart).getPreferences());
			        PortletPreferences schedulerPreferences;
			        schedulerPreferences = PortletPreferencesFactoryUtil.fromDefaultXML(((com.liferay.portal.model.PortletPreferences) preferencesPart).getPreferences());
					
			        if(Validator.isNotNull(schedulerPreferences)){
			        	defaultTime = schedulerPreferences.getValue(DEFAULT_TIME_STAMP, "5");
			        	LOG.info(defaultTime);
			        }
				}
			}
			catch(SystemException e){
				LOG.error(e);
			}
			
			cron = 	"0 0/"+defaultTime+" * 1/1 * ? *";//"0 0/"+setSchedule+" 0 ? * * *";
			//cron = "0 0/1 * 1/1 * ? *";//0 * * ? * *";
	        Trigger trigger = null;  
		     try {  
		      trigger = TriggerFactoryUtil.buildTrigger(TriggerType.CRON, ProgressSchedulerPortlet.class.getName(), ProgressSchedulerPortlet.class.getName(), new Date(), null, cron);  
		     } catch (SchedulerException e) {  
		      e.printStackTrace();  
		     }  
		       
		     Message message = new Message();  
		    // message.put(SchedulerEngine.CONTEXT_PATH, portlet.getContextPath());  
		     message.put(SchedulerEngine.MESSAGE_LISTENER_CLASS_NAME, ProgressSchedulerPortlet.class.getName());  
		     message.put(SchedulerEngine.PORTLET_ID, PORTLET_ID);  
		       
		     try {  
		      SchedulerEngineHelperUtil.schedule(trigger, StorageType.PERSISTED, "", "liferay/scheduler_dispatch", message, 5);  
		     } catch (SchedulerException e) {  
		      e.printStackTrace();  
		     }
		}
		super.init();
	}
	
	@Override
	public void receive(Message message)
		throws MessageListenerException
	{
		LOG.debug(" Progress Shedular executed from System :::::::::::::::::::::::::::::::::::::::::::::::::::::: "+PortalUtil.getComputerName());
		if(isBackendProcessSystem()){
			
			long startTime = System.currentTimeMillis();
			LOG.debug("Progress Shedular Start time : "+ new Date());
			ProgressSchedulerUtil.processProgressJob();
			long endTime = System.currentTimeMillis();
			LOG.debug("Progress Shedular End time : "+ new Date() + " ::: Time elapsed :: "+(endTime - startTime) + " ms" );
		}
		
	}
	
	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		PortletPreferences preferences = renderRequest.getPreferences();
		String defaultTime = preferences.getValue(DEFAULT_TIME_STAMP, "5");
		renderRequest.setAttribute("defaultTime", defaultTime);
		super.doEdit(renderRequest, renderResponse);
	}

	@ProcessAction(name="setDefaultTimeStamp")
	public void setDefaultTimeStamp(ActionRequest actionRequest, ActionResponse actionResponse){
		
		PortletPreferences preferences = actionRequest.getPreferences();
		String defaultTime = "5";
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
		
		cron = 	"0 0/"+defaultTime+" * 1/1 * ? *";//"0 0/"+setSchedule+" 0 ? * * *";
		
        Trigger trigger = null;  
	     try {  
	    	 trigger = TriggerFactoryUtil.buildTrigger(TriggerType.CRON, ProgressSchedulerPortlet.class.getName(), ProgressSchedulerPortlet.class.getName(), new Date(), null, cron);  
	     } catch (SchedulerException e) {  
	      e.printStackTrace();  
	     }  
	       
	     Message message = new Message();  
	     //message.put(SchedulerEngine.CONTEXT_PATH, portlet.getContextPath());  
	     message.put(SchedulerEngine.MESSAGE_LISTENER_CLASS_NAME, ProgressSchedulerPortlet.class.getName());  
	     message.put(SchedulerEngine.PORTLET_ID, PORTLET_ID);  
		
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
	private boolean isBackendProcessSystem(){
		String systemName = PortalUtil.getComputerName();		
		return (systemName.equalsIgnoreCase("adcmerlinappp2.hiw.com") || systemName.equalsIgnoreCase("adcmerlinappq2.hiw.com"));
	}
    
}
