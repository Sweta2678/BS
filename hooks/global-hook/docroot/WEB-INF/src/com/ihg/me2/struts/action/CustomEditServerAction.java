package com.ihg.me2.struts.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.ihg.me2.service.indexer.GroupIndexer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;

public class CustomEditServerAction extends BaseStrutsPortletAction
{
	private static Log _log = LogFactoryUtil.getLog(CustomEditServerAction.class);

	@Override
	public void processAction(StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception 
	{
		/*Calling Original action*/
		originalStrutsPortletAction.processAction(
	            originalStrutsPortletAction, portletConfig, actionRequest,
	            actionResponse);
		
		/*Extended code to re-index  Group documents*/
		try 
		{
			/*Getting all company Ids of Portal instance*/
			long[] companyIds= PortalUtil.getCompanyIds();
			
			/* Registering GroupIndexer */
			
			Indexer indexer= IndexerRegistryUtil.getIndexer(GroupIndexer.class);
			
			if(Validator.isNull(indexer))
			{
				_log.info("Registering GroupIndexer class ... ");
				
				IndexerRegistryUtil.register(new GroupIndexer());
			}
			
			indexer = IndexerRegistryUtil.nullSafeGetIndexer(GroupIndexer.class);
			
			for (long companyId : companyIds) 
			{
				/*Deleting all Group indexed documents*/
				SearchEngineUtil.deletePortletDocuments(indexer.getSearchEngineId(), companyId, GroupIndexer.PORTLET_ID);
			}
			
			_log.info("All documents are deleted for indexer ::: "+ indexer.getClass());
			
			/*Reindexing Group documents for each instance of Portal*/
			for (long companyId : companyIds) 
			{
				indexer.reindex(new String[] {String.valueOf(companyId)});
			}
			
			_log.info("Re-indexing is completed for indexer ::: "+ indexer.getClass());
			
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public String render(StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception
	{
		return originalStrutsPortletAction.render(
	            null, portletConfig, renderRequest, renderResponse);
	}

}
