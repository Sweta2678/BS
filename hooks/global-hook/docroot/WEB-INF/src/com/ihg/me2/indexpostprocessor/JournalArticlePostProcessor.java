package com.ihg.me2.indexpostprocessor;

import java.util.List;

import com.ihg.me2.indexpostprocessor.util.CustomIndexerConstant;
import com.ihg.me2.indexpostprocessor.util.CustomIndexerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexerPostProcessor;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;

/**
 * @author PatelHet
 *
 */
public class JournalArticlePostProcessor extends BaseIndexerPostProcessor
{

	@Override
	public void postProcessDocument(Document doc, Object obj)	throws Exception 
	{
		JournalArticle article = (JournalArticle)obj;
		Group group = CustomIndexerUtil.getGroupById(article.getGroupId());
		
		if (doc != null) 
		{
			try 
			{
		
		/**
		 * This method will update Date type field value format from long to date
		 */
		doc = updateDateTypeFieldValue(doc, article);
		
		if(!group.isOrganization() && CustomIndexerUtil.isContentFromMerlin(group,PrefsPropsUtil.getString("tag-merlin")))
		{
			if(group.getName().equals(PrefsPropsUtil.getString("news-room-community-name")) && CustomIndexerUtil.isArticleMerlin(article, PrefsPropsUtil.getString("structure-id-news")))
			{
				doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_SOURCE, PrefsPropsUtil.getString("meta-data-content-source-value"));
				doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_TYPE, PrefsPropsUtil.getString("meta-data-content-type-news-article"));
				doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_LINK,CustomIndexerConstant.NEWSROOM_ARTICLE_URL+ article.getResourcePrimKey());
				doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_NAME, CustomIndexerConstant.NEWS_PARENT_NAME);
				doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_LINK,CustomIndexerConstant.NEWS_PARENT_LINK);
				doc.addKeyword(CustomIndexerConstant.META_DATA_PARENT_CONTENT_TYPE,PrefsPropsUtil.getString("meta-data-content-news-article"));
			} else if(group.getName().equals(PrefsPropsUtil.getString("app-stor-community-name")) && CustomIndexerUtil.isArticleMerlin(article, PrefsPropsUtil.getString("structure-id-apps")))
			{
				doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_SOURCE, PrefsPropsUtil.getString("meta-data-content-source-value"));
				doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_TYPE, PrefsPropsUtil.getString("meta-data-content-type-application"));
				//Hotel_Solution_id
				//ExpandoBridge customField = article.getExpBridge();
				
				
				
				//if(Validator.isNotNull(customField) && Validator.isNotNull(customField.getAttribute("Hotel_Solution_id")))
				//{	
					String hotelSolutionId= CustomIndexerUtil.getExpandoString(article.getCompanyId(), article.getClassPK(), JournalArticle.class.getName(), "Hotel_Solution_id");
					if(!hotelSolutionId.isEmpty() && !hotelSolutionId.equals("-1"))
					{
						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_LINK,CustomIndexerConstant.HOTEL_SOLUTION_ARTICLE_URL+ hotelSolutionId);
					} else
					{
						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_LINK,CustomIndexerConstant.APPLICATIONS_ARTICLE_URL+ article.getResourcePrimKey());
					}
				/*} else
				{
					doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_LINK,CustomIndexerConstant.APPLICATIONS_ARTICLE_URL+ article.getResourcePrimKey());
				}*/
				doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_NAME,CustomIndexerConstant.APPS_PARENT_NAME);
				doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_LINK,CustomIndexerConstant.APPS_PARENT_LINK);
				doc.addKeyword(CustomIndexerConstant.META_DATA_PARENT_CONTENT_TYPE,PrefsPropsUtil.getString("meta-data-content-type-application"));
			}else
			{
			    doc=updateMerlinMetadata(Group.class.getName(), group.getGroupId() ,doc, group, article);
			}
			_log.info("Done reindexing for artcile with ID:" + article.getId());
		}else if (group.isOrganization() ){
			Organization org = CustomIndexerUtil.getOrganizationById(group.getClassPK());
			if(CustomIndexerUtil.isMerlinTag(Organization.class.getName(), org.getOrganizationId(), PrefsPropsUtil.getString("tag-merlin")))
			{
	    			if(CustomIndexerUtil.isOrganziationDepartment(org) && CustomIndexerUtil.isArticleMerlin(article, PrefsPropsUtil.getString("structure-id-hot-topics")))
	    			{
	    				doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_SOURCE, PrefsPropsUtil.getString("meta-data-content-source-value"));
	    				doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_TYPE, PrefsPropsUtil.getString("meta-data-content-type-hot-topics"));
	    				doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_LINK, CustomIndexerConstant.WEB + group.getFriendlyURL() + CustomIndexerConstant.ARTICLE_ID+ article.getResourcePrimKey());
	    				doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_NAME,  group.getFriendlyURL().substring(1));
	    				doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_LINK, CustomIndexerConstant.WEB + group.getFriendlyURL() +CustomIndexerConstant.HOME);
	    				doc.addKeyword(CustomIndexerConstant.META_DATA_PARENT_CONTENT_TYPE,PrefsPropsUtil.getString("meta-data-content-type-department"));
	    			}else
	    			{
	    			    Group orgGroup = CustomIndexerUtil.getGroupById(org.getGroup().getGroupId());
	    			    doc=updateMerlinMetadata(Organization.class.getName(),org.getOrganizationId(), doc, orgGroup, article);
	    			}
			}
			_log.info("Done reindexing for artcile with ID:" + article.getId());
		}
		
		
		} 
			catch (Exception ex) 
			{
				_log.error("Problem while indexing web-content :" 	+ ex.getMessage(), ex);
			}
		}
		
		doc.addText("customModified_sortable", String.valueOf(article.getModifiedDate().getTime()));
		
		doc.addText("customDisplayDate_sortable", String.valueOf(article.getDisplayDate().getTime()));
		//Recent Activities in IWOS should be sort based on create date [
		doc.addText("customCreateDate_sortable", String.valueOf(article.getCreateDate().getTime()));
		//]
		
		_log.info("====================== customModified & customDisplayDate value added for =========== "+  article.getArticleId());
		
		super.postProcessDocument(doc, obj);
	}
	
	/**
     * @param className
     * @param classPk
     * @param doc
     * @param group
     * @param article
     * @return
     */
    private Document updateMerlinMetadata(String className, long classPk, Document doc, Group group, JournalArticle article)
    {
        try
        {
            String searchEnabledTagName = CustomIndexerUtil.getGroupSearchEnabledTagName(className,classPk,"wc-search-tag-list");
            if (Validator.isNotNull(searchEnabledTagName) && hasValidStructure(article))
            {
                doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_SOURCE, PrefsPropsUtil.getString("meta-data-content-source-value"));
                doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_TYPE, PrefsPropsUtil.getString(CustomIndexerConstant.WC_CONTENT_TYPE+searchEnabledTagName));
                doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_LINK,CustomIndexerConstant.WEB + group.getFriendlyURL() + CustomIndexerConstant.ARTICLE_ID+ article.getResourcePrimKey());
                doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_NAME, group.getName());
                doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_LINK,CustomIndexerConstant.WEB + group.getFriendlyURL() + CustomIndexerConstant.HOME);
                doc.addKeyword(CustomIndexerConstant.META_DATA_PARENT_CONTENT_TYPE,PrefsPropsUtil.getString(CustomIndexerConstant.PARENT_CONTENT_TYPE+searchEnabledTagName));
                _log.info("Addig custom metadata for " + searchEnabledTagName + " to JournalArticle Id:-" + article.getArticleId());
            }else
            {
                _log.info("Either search tag OR structure-Id is not valid, Hence Merlin custom meatadta are not added for ArticleId:-" + article.getArticleId());
            }
        } catch (Exception e)
        {
            _log.error("Error while udating Merlin custom metadata  : " + e.getMessage(), e);
        }
        return doc;
    }
    
    /**
     * @param article
     * @return True if structure Id for article is valid for search or false
     */
    private boolean hasValidStructure(JournalArticle article)
    {
        boolean flag=false;
        try
        {
            String structureList=PrefsPropsUtil.getString("valid-structure-id-list");
            if(Validator.isNotNull(structureList))
            {
                List<String> validStructureList=CustomIndexerUtil.convertStringtoList(structureList, ",");
                if(Validator.isNotNull(validStructureList))
                {
                    if(validStructureList.contains(article.getStructureId()))
                    {
                        flag=true;
                    }
                }
            }
        } catch (Exception e)
        {
            _log.error("Error in validating structure  : " + e.getMessage());
        }
        
        return flag;
    }
    

	/**
	 * This nmethod will check if article has ddm-date-time field then update value
	 * of that field with yyyy-mm-dd format (work around for all existing portlets)
	 * 
	 * Added by : Gaurang Sheladia
	 * 
	 * @param doc
	 * @param article
	 * @throws DocumentException
	 */
	private Document updateDateTypeFieldValue(Document doc, JournalArticle article) 
	{
		
		try
		{
			if (article != null && article.getContent() != null && !"".equals(article.getContent())) {
				
				com.liferay.portal.kernel.xml.Document document =  SAXReaderUtil.read(article.getContent());
				List<Node> ddmDateElements = document.selectNodes("//root/dynamic-element[@type='ddm-date-time']");
				
				if (ddmDateElements != null && !ddmDateElements.isEmpty()) {
					
					for (Node ddmDate : ddmDateElements) {
						Element ddmElement = (Element)ddmDate;
						long structureId = getStructureId(article.getGroupId(), article.getStructureId()); 
						String fieldName = CustomIndexerConstant.DDM + StringPool.SLASH + structureId + StringPool.SLASH + ddmElement.attributeValue(CustomIndexerConstant.NAME) + StringPool.UNDERLINE + article.getDefaultLanguageId();
						Node dateNode =  ddmDate.selectSingleNode(CustomIndexerConstant.DYNAMIC_CONTENT);
						if (dateNode != null && dateNode.getText() != null && !"".equals(dateNode.getText())) {
								String dateValue = dateNode.getText();
								_log.info("Updated Journal Document with Field Name ::: "+fieldName + "\t Value :: " + dateValue);
								doc.addKeyword(fieldName, dateValue);
						}
					}
				}
				ddmDateElements = document.selectNodes("//root/dynamic-element[@type='date']");
				if (ddmDateElements != null && !ddmDateElements.isEmpty()) {
					
					for (Node ddmDate : ddmDateElements) {
						Element ddmElement = (Element)ddmDate;
						long structureId = getStructureId(article.getGroupId(), article.getStructureId()); 
						String fieldName = CustomIndexerConstant.DDM + StringPool.SLASH + structureId + StringPool.SLASH + ddmElement.attributeValue(CustomIndexerConstant.NAME) + StringPool.UNDERLINE + article.getDefaultLanguageId();
						Node dateNode =  ddmDate.selectSingleNode(CustomIndexerConstant.DYNAMIC_CONTENT);
						if (dateNode != null && dateNode.getText() != null && !"".equals(dateNode.getText())) {
								String dateValue = dateNode.getText();
								_log.info("Updated Journal Document with Field Name ::: "+fieldName + "\t Value :: " + dateValue);
								doc.addKeyword(fieldName, dateValue);
						}
					}
				}
			}
		} catch (Exception e)
        {
            _log.error("Error while udating Date Type field metadata  : " + e.getMessage(), e);
        }
		
		return doc;
	}
    
    /**
     * 
     * @param groupId
     * @param structureKey
     * @return long
     */
    private static long getStructureId (long groupId, String structureKey) {
    	DDMStructure structure = null;
    	long structureId = 0l;
    	if (Validator.isNotNull(structureKey)) {
    		long classNameId = PortalUtil.getClassNameId(JournalArticle.class);
    		try {
				structure = DDMStructureLocalServiceUtil.getStructure(groupId, classNameId, structureKey);
			} catch (PortalException e) {
				_log.error(e.getMessage(), e);
			} catch (SystemException e) {
				_log.error(e.getMessage(), e);
			}
    		if (Validator.isNotNull(structure)) {
    			structureId = structure.getStructureId();
    		}
    	}
    	return structureId;
    }
    
	
	private static final Log _log = LogFactoryUtil.getLog(JournalArticlePostProcessor.class);

}
