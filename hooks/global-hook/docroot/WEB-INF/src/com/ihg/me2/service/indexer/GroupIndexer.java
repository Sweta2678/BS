package com.ihg.me2.service.indexer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletURL;

import com.ihg.me2.indexpostprocessor.util.CustomIndexerConstant;
import com.ihg.me2.indexpostprocessor.util.CustomIndexerUtil;
import com.ihg.me2.service.indexer.util.CommunityIndexerConstant;
import com.ihg.me2.service.indexer.util.CommunityIndexerUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.persistence.GroupActionableDynamicQuery;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;

/**
 * @author PatelHet
 *
 */
public class GroupIndexer extends BaseIndexer
{
	
	private static Log _log = LogFactoryUtil.getLog(GroupIndexer.class);

	public static final String[] CLASS_NAMES = {Group.class.getName()};

	public static final String PORTLET_ID = PortletKeys.SITES_ADMIN;

	public GroupIndexer() 
	{
		setPermissionAware(true);
		setStagingAware(false);
	}

	public String[] getClassNames() 
	{
		return CLASS_NAMES;
	}

	public Summary getSummary(Document document, String snippet, PortletURL portletURL) 
	{

		String title = document.get("name");

		String content = null;

		String groupId = document.get(Field.GROUP_ID);

		portletURL.setParameter("groupId", groupId);
		
		return new Summary(title, content, portletURL);
	}
	
	

	@Override
	public String getPortletId() 
	{
		return PORTLET_ID;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale,
			String snippet, PortletURL portletURL) throws Exception 
	{
		// TODO Auto-generated method stub
		return null;
	}

	protected void doDelete(Object obj) throws Exception 
	{
		Group group = (Group)obj;

		Document document = new DocumentImpl();

		document.addUID(PORTLET_ID, group.getGroupId());
		
		_log.info("Community Deleted");
		
		SearchEngineUtil.deleteDocument(getSearchEngineId(),group.getCompanyId(), document.get(Field.UID));
	}

	protected Document doGetDocument(Object obj) throws Exception 
	{
		Group group = (Group)obj;
		
		Document document = getBaseModelDocument(PORTLET_ID, group);
		
		long companyId = group.getCompanyId();
		
		long groupId = group.getGroupId();

		document.addUID(PORTLET_ID, groupId);

		document.addKeyword(Field.COMPANY_ID, companyId);
		
		document.addKeyword(Field.PORTLET_ID, PORTLET_ID);
		
		document.addKeyword(Field.GROUP_ID, groupId);
		
		document.addKeyword("parentGroupId", group.getParentGroupId());
		
		document.addKeyword("liveGroupId", group.getLiveGroupId());
		
		document.addKeyword(Field.NAME, group.getName());
		
		document.addKeyword("name_sortable", group.getName());
		
		/*Below code can be used to add modified date attribute into index document. Modified date is not stored into Group table, so below code just
		 * put modified date into solr. Dark side is re-indexing will consider current date as modified date*/
		
		document.addText("customModified_sortable", String.valueOf(new Date().getTime()));
		_log.info("====================== customModified value added for =========== "+  group.getGroupId());
		
		document.addKeyword(Field.DESCRIPTION, group.getDescription());
		
		document.addKeyword(Field.TYPE, group.getType());

		document.addKeyword(Field.ENTRY_CLASS_NAME, Group.class.getName());
		
		document.addKeyword(Field.ENTRY_CLASS_PK, groupId);
		
		document.addDate(Field.MODIFIED_DATE, new Date());
		
		String[] assetTagNames = AssetTagLocalServiceUtil.getTagNames(Group.class.getName(), groupId);	
		
        /*Code to check if Group belongs to Merlin, will add merlin specific attributes into document*/		
		if (document != null) 
		{
			if(CommunityIndexerUtil.isMerlinTag(assetTagNames, CommunityIndexerConstant.PARAM_TAG_MERLIN))
			{
			    if(CommunityIndexerUtil.isMerlinTag(assetTagNames, CommunityIndexerConstant.PARAM_TAG_TEAMSPACE))
			    {	
					
					document.addKeyword(CommunityIndexerConstant.META_DATA_CONTENT_SOURCE, CommunityIndexerConstant.FIELD_CONTENT_SOURCE_VALUE);
					
					document.addKeyword(CommunityIndexerConstant.META_DATA_CONTENT_TYPE, CommunityIndexerConstant.FIELD_CONTENT_TYPE);
					
					document.addKeyword(CommunityIndexerConstant.META_DATA_CONTENT_LINK, CommunityIndexerConstant.WEB+ group.getFriendlyURL() + CommunityIndexerConstant.HOME);
					
					document.addKeyword(CommunityIndexerConstant.META_DATA_CONTENT_PARENT_NAME, CommunityIndexerConstant.META_DATA_CONTENT_PARENT_NAME_TAG );
					
					document.addKeyword(CommunityIndexerConstant.META_DATA_CONTENT_PARENT_LINK, "/web/teamspaces/home/");
			    }
			    else
	            {
	                document=updateMerlinMetadata(Group.class.getName(),group.getGroupId(), document, group);
	            }
			    
			    _log.info("Group with ID:" + groupId + " is a Merlin Community, so add Custom Meta-data for Global Search...");
			}
		}     
		
		return document;
	}
	
	/**
         * @param doc
         * @param group
         * @return
         */
    private Document updateMerlinMetadata(String className, long classPk,Document doc, Group group)
    {
        try
        {
            String searchEnabledTagName = CustomIndexerUtil.getGroupSearchEnabledTagName(className, classPk, "community-search-tag-list");
            if (Validator.isNotNull(searchEnabledTagName))
            {
                doc.addKeyword(CommunityIndexerConstant.META_DATA_CONTENT_SOURCE, CommunityIndexerConstant.FIELD_CONTENT_SOURCE_VALUE);
                
                String parentContentTypeKey=CustomIndexerConstant.PARENT_CONTENT_TYPE+searchEnabledTagName;
                
                doc.addKeyword(CommunityIndexerConstant.META_DATA_CONTENT_TYPE,  PrefsPropsUtil.getString(parentContentTypeKey ));
                
                doc.addKeyword(CommunityIndexerConstant.META_DATA_CONTENT_LINK, CommunityIndexerConstant.WEB+ group.getFriendlyURL() + CommunityIndexerConstant.HOME);
                
                doc.addKeyword(CommunityIndexerConstant.META_DATA_CONTENT_PARENT_NAME, PrefsPropsUtil.getString(parentContentTypeKey ));
                
                doc.addKeyword(CommunityIndexerConstant.META_DATA_CONTENT_PARENT_LINK, PrefsPropsUtil.getString(CustomIndexerConstant.PARENT_LINK+searchEnabledTagName  ));
                
                _log.info("Added custom metadata for " + searchEnabledTagName + " to community group id: "+classPk );
            }
        } catch (Exception e)
        {
            _log.error("Error while udating Merlin custom metadata  : " + e.getMessage(), e);
        }
        return doc;
    }
    

	@SuppressWarnings("unchecked")
	protected void doReindex(Object obj) throws Exception 
	{
		
		if (obj instanceof List<?>) 
		{
			List<Group> groups = (List<Group>)obj;

			for (Group group : groups) 
			{
				doReindex(group);
			}
		}
		else if (obj instanceof Long) 
		{
			long groupId = (Long)obj;

			Group group = GroupLocalServiceUtil.getGroup(groupId);

			doReindex(group);
		}
		else if (obj instanceof long[]) 
		{
			long[] groupIds = (long[])obj;

			Map<Long, Collection<Document>> documentsMap = new HashMap<Long, Collection<Document>>();

			for (long groupId : groupIds) 
			{
				Group group = GroupLocalServiceUtil.getGroup(groupId);

				Document document = getDocument(group);

				long companyId = group.getCompanyId();

				Collection<Document> documents = documentsMap.get(companyId);

				if (documents == null) 
				{
					documents = new ArrayList<Document>();

					documentsMap.put(companyId, documents);
				}

				documents.add(document);
			}

			for (Map.Entry<Long, Collection<Document>> entry : documentsMap.entrySet()) 
			{

				long companyId = entry.getKey();
				Collection<Document> documents = entry.getValue();

				SearchEngineUtil.updateDocuments(getSearchEngineId(),companyId, documents);
			}
		}
		else if (obj instanceof Group) 
		{
			Group group = (Group)obj;

			Document document = getDocument(group);

			SearchEngineUtil.updateDocument(getSearchEngineId(),group.getCompanyId(), document);
		}
		_log.info("Reindexing of groups is done");
	}

	protected void doReindex(String className, long classPK) throws Exception 
	{
		Group group = GroupLocalServiceUtil.getGroup(classPK);

		doReindex(group);
	}

	protected void doReindex(String[] ids)
	{
		try
		{
			for(String companyId: ids)
			{
	
			_log.info("CommunityIndexer.doReindex()...START FULL RE-INDEXING with companyId:" + companyId);
			
			  reindexCommunity(Long.valueOf(companyId));
			
			_log.info("CommunityIndexer.doReindex()...END FULL RE-INDEXING with companyId:" + companyId);
			}
		}
		catch(Exception e)
		{
			_log.error("Error in rindexing ",e);
		}
	}

	protected String getPortletId(SearchContext searchContext) 
	{
		return PORTLET_ID;
	}

	
	/**
	 * @param companyId
	 * @throws Exception
	 */
	protected void reindexCommunity(long companyId) throws Exception 
	{
		ActionableDynamicQuery actionableDynamicQuery =	new GroupActionableDynamicQuery() 
		{
			@Override
			protected void performAction(Object object) throws PortalException,	SystemException 
			{
				Group group = (Group)object;

				Document document = getDocument(group);

				addDocument(document);
						
			}
		};
				
		actionableDynamicQuery.setCompanyId(companyId);
				
		actionableDynamicQuery.setSearchEngineId(this.getSearchEngineId());

		actionableDynamicQuery.performActions();
	}
	
 /*protected void reindexCommunity(long companyId) throws Exception {
		
		int count = GroupLocalServiceUtil.getGroupsCount();

		int pages = count / INDEX_FILTER_SEARCH_LIMIT;

		for (int i = 0; i <= pages; i++) {
			int start = (i * INDEX_FILTER_SEARCH_LIMIT);
			int end = start + INDEX_FILTER_SEARCH_LIMIT;

			reindexCommunity(companyId, start, end);
		}
		_log.info("Reindexing community  by companyid");
	}

	protected void reindexCommunity(long companyId, int start, int end)	throws Exception {

		List<Group> groups = GroupLocalServiceUtil.getGroups(start, end);

		if (groups.isEmpty()) {
			return;
		}

		Collection<Document> documents = new ArrayList<Document>();

		for (Group group : groups) {
			Document document = getDocument(group);

			documents.add(document);
		}
		_log.info("Reindex community with comapnyid start and end parameter");
		SearchEngineUtil.updateDocument(searchEngineId, companyId, document);
	}*/

}
