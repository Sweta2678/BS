package com.ihg.brandstandards.bridge.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;
import com.liferay.counter.model.Counter;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;

public class SyncLiferayCounterPortlet extends MVCPortlet {

	private static final Log LOG = LogFactoryUtil.getLog(SyncLiferayCounterPortlet.class);
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		boolean hasSyncCounterPortletAccess = false;
		try {
			hasSyncCounterPortletAccess = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), PortletProps.get("sync.counter.portlet.access.role"), false);
            renderRequest.setAttribute("hasSyncCounterPortletAccess", hasSyncCounterPortletAccess);
        } catch (Exception e) {
            LOG.error("Failed to check whether user has role"+PortletProps.get("sync.counter.portlet.access.role"), e);
        }
		
		if(hasSyncCounterPortletAccess) {
			Properties portletProps = PortletProps.getProperties();
			Map<String, Long> bsTableCounters = new LinkedHashMap<String, Long>();
			List<Counter> bsSyncCounters = new ArrayList<Counter>();
			try {
				List<Counter> lrCounters = CounterLocalServiceUtil.getCounters(-1, -1);
				for(Map.Entry<Object, Object> counterEntry : portletProps.entrySet()){
					if(counterEntry.getKey().toString().startsWith("counter.")) {
						boolean foundCounter = false;
						for(Counter counter: lrCounters){
							if(counterEntry.getKey().equals("counter."+counter.getName())){
								long lockedCount = StandardsLocalServiceUtil.getTableSequenceEntryCount(counterEntry.getValue().toString());
								bsTableCounters.put(counter.getName(), lockedCount);
								bsSyncCounters.add(counter);
								foundCounter = true;
								LOG.info("Found Counter with Entity Name:"+counter.getName()+":::LR Counter:"+counter.getCurrentId()+"::: BS Counter"+lockedCount);
								break;
							}
						}
						if(!foundCounter){
							LOG.info("Not Found Counter with Entity Name:"+counterEntry.getKey().toString().replace("counter.", ""));
						}
					}
				}
			} catch(Exception e) {
				LOG.error(e);
			}
			renderRequest.setAttribute("bsSyncCounters", bsSyncCounters);
			renderRequest.setAttribute("bsTableCounters", bsTableCounters);
		}
		include(viewTemplate, renderRequest, renderResponse);
	}
	
	@ProcessAction(name="syncCounters")
	public void syncLiferayCountersForBrandStandards(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		
		String environment = System.getProperty("app.environment.type") != null ? System.getProperty("app.environment.type").trim() : "ENVIRONMENT_QA";
		if (Arrays.asList(PortletProps.get("sync.counter.portlet.access.environments").split(StringPool.COMMA)).contains(environment))  {
        	LOG.info("processing Sync Counter for current environment:"+environment );
			Properties portletProps = PortletProps.getProperties();
			try {
				List<Counter> lrCounters = CounterLocalServiceUtil.getCounters(-1, -1);
				for(Map.Entry<Object, Object> counterEntry : portletProps.entrySet()){
					if(counterEntry.getKey().toString().startsWith("counter.")) {
						for(Counter counter: lrCounters){
							if(counterEntry.getKey().equals("counter."+counter.getName())){
								long lockedCount = StandardsLocalServiceUtil.getTableSequenceEntryCount(counterEntry.getValue().toString());
								if(counter.getCurrentId() < lockedCount){
									LOG.info("Found Counter which is not in Sync. Entity Name:"+counter.getName()+":::LR Counter:"+counter.getCurrentId()+"::: BS Counter"+lockedCount);
									counter.setCurrentId(lockedCount+1);
									CounterLocalServiceUtil.updateCounter(counter);
									LOG.info("Updated Counter with Entity Name:"+counter.getName()+":::LR Counter:"+counter.getCurrentId()+"::: BS Counter"+lockedCount);
									break;
								}
							}
						}
					}
				}
			} catch(Exception e){
				LOG.error(e);
			}
        } else {
        	LOG.info("This functionality is not enabled in portlet.properties for current environment:"+environment );
        }
	}

}
