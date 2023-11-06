package com.ihg.portlet.journal.service;

import com.ihg.security.util.JournalArticleSecurityUtil;
import com.ihg.security.util.ValidationUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.journal.ArticleDisplayDateException;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalService;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceWrapper;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;

public class CustomJournalArticleLocalServiceImpl extends JournalArticleLocalServiceWrapper {

	private static final Log LOGGER = LogFactoryUtil.getLog(CustomJournalArticleLocalServiceImpl.class);
	public CustomJournalArticleLocalServiceImpl(
			JournalArticleLocalService journalArticleService) {
		super(journalArticleService);
	}

	@Override
	public JournalArticle addArticle(long userId, long groupId, long folderId,
			long classNameId, long classPK, String articleId,
			boolean autoArticleId, double version,
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap,
			String content, String type, String ddmStructureKey,
			String ddmTemplateKey, String layoutUuid, int displayDateMonth,
			int displayDateDay, int displayDateYear, int displayDateHour,
			int displayDateMinute, int expirationDateMonth,
			int expirationDateDay, int expirationDateYear,
			int expirationDateHour, int expirationDateMinute,
			boolean neverExpire, int reviewDateMonth, int reviewDateDay,
			int reviewDateYear, int reviewDateHour, int reviewDateMinute,
			boolean neverReview, boolean indexable, boolean smallImage,
			String smallImageURL, File smallImageFile,
			Map<String, byte[]> images, String articleURL,
			ServiceContext serviceContext) throws PortalException,
			SystemException {
		
			String xmlContent = updateContent(content);
			if (Validator.isNull(xmlContent)) {
				xmlContent = content;
			}
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("new article content :"+xmlContent);
			}
			
			//bf-hook merged
			String communityName = GroupLocalServiceUtil.getGroup(groupId).getName();

			if (isBrandFrameworkCommunity(communityName)
					&& (serviceContext.getAssetCategoryIds() == null || serviceContext.getAssetCategoryIds().length == 0)) {
				throw new ArticleDisplayDateException("No Category Selected");
			}
		
		JournalArticle article =  super.addArticle(userId, groupId, folderId, classNameId, classPK,
				articleId, autoArticleId, version, titleMap, descriptionMap, xmlContent,
				type, ddmStructureKey, ddmTemplateKey, layoutUuid, displayDateMonth,
				displayDateDay, displayDateYear, displayDateHour, displayDateMinute,
				expirationDateMonth, expirationDateDay, expirationDateYear,
				expirationDateHour, expirationDateMinute, neverExpire, reviewDateMonth,
				reviewDateDay, reviewDateYear, reviewDateHour, reviewDateMinute,
				neverReview, indexable, smallImage, smallImageURL, smallImageFile,
				images, articleURL, serviceContext);
		
			/*This block of code to apply default role and category to article*/
	 	   try
	 	   {
	 	       if(ValidationUtil.isValidMerlinContent(ddmStructureKey, groupId))
	            {
	                LOGGER.info("Updating Articles for merlin specific categories ... for groupId:"+ groupId + " and structureId:"+ ddmStructureKey);
	                JournalArticleSecurityUtil.addOrUpdateArticleEntry(article,articleId, article.getResourcePrimKey(), groupId, content, userId, ddmStructureKey);
	            }
	 	   }
	 	   catch (Exception e) 
	 	   {
	 	       // TODO: handle exception
	 	       LOGGER.info("While Creating Journal Article Exception has raised : "+e.getMessage());
	 	   }
	
		 return article;
	}
	
	
	@Override
	public JournalArticle updateArticle(long userId, long groupId,
			long folderId, String articleId, double version,
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap,
			String content, String type, String ddmStructureKey,
			String ddmTemplateKey, String layoutUuid, int displayDateMonth,
			int displayDateDay, int displayDateYear, int displayDateHour,
			int displayDateMinute, int expirationDateMonth,
			int expirationDateDay, int expirationDateYear,
			int expirationDateHour, int expirationDateMinute,
			boolean neverExpire, int reviewDateMonth, int reviewDateDay,
			int reviewDateYear, int reviewDateHour, int reviewDateMinute,
			boolean neverReview, boolean indexable, boolean smallImage,
			String smallImageURL, File smallImageFile,
			Map<String, byte[]> images, String articleURL,
			ServiceContext serviceContext) throws PortalException,
			SystemException {
		
			String xmlContent = updateContent(content);
			if (Validator.isNull(xmlContent)) {
				xmlContent = content;
			}
		
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Updated article content :"+xmlContent);
			}
			
			Group groupOb = GroupLocalServiceUtil.getGroup(groupId);
			String communityName = groupOb.getName();
			//bf-hook merged
			if (isBrandFrameworkCommunity(communityName)
					&& (serviceContext.getAssetCategoryIds() == null || serviceContext.getAssetCategoryIds().length == 0)) {
				throw new ArticleDisplayDateException("No Category Selected");
			}
			JournalArticle article =  super.updateArticle(userId, groupId, folderId, articleId, version,
				titleMap, descriptionMap, xmlContent, type, ddmStructureKey,
				ddmTemplateKey, layoutUuid, displayDateMonth, displayDateDay,
				displayDateYear, displayDateHour, displayDateMinute,
				expirationDateMonth, expirationDateDay, expirationDateYear,
				expirationDateHour, expirationDateMinute, neverExpire, reviewDateMonth,
				reviewDateDay, reviewDateYear, reviewDateHour, reviewDateMinute,
				neverReview, indexable, smallImage, smallImageURL, smallImageFile,
				images, articleURL, serviceContext);
		
			try
			{
				if (isHookappliedForCommunity(groupOb))
				{
		            LOGGER.info("Articel Service Hook is applying :: "+communityName );
		            DynamicQuery query = DynamicQueryFactoryUtil
		                    .forClass(JournalArticle.class, "jarticle", PortalClassLoaderUtil.getClassLoader())
		                    .add(PropertyFactoryUtil.forName("groupId").eq(groupId))
		                    .add(PropertyFactoryUtil.forName("articleId").eq(article.getArticleId()))
		                    .add(PropertyFactoryUtil.forName("status").eq(WorkflowConstants.STATUS_APPROVED))
		                    .addOrder(OrderFactoryUtil.desc("version"));
		            List<JournalArticle> jArticleList = JournalArticleLocalServiceUtil.dynamicQuery(query);
		            if (jArticleList != null){
		                for (int i = 1; i < jArticleList.size(); i++)
		                {
		                    JournalArticle jArticle = jArticleList.get(i);
		                    LOGGER.info(jArticle.getVersion());
		                    jArticle.setStatus(WorkflowConstants.STATUS_EXPIRED);
		                    JournalArticleLocalServiceUtil.updateJournalArticle(jArticle);
		                }
		            }	
				}
			}
			catch (Exception e) {
				LOGGER.info("While Updating Journal Article Exception has raised : "+e.getMessage());
			}
 		  
			try
			{
				if(ValidationUtil.isValidMerlinContent(ddmStructureKey, groupId))
				{
					LOGGER.info("Updating Articles for merlin specific categories ... ");
					JournalArticleSecurityUtil.addOrUpdateArticleEntry(article,articleId, article.getResourcePrimKey(), groupId, content, userId, ddmStructureKey);
 		     	}
			} catch(Exception e)
			{
				LOGGER.error("Error in applying default category to Merlin content", e);
			}
		return article;
	}

	/**
	 * 
	 * @param content
	 * @return String
	 */
	private String updateContent (String content) {
		Document xmlContent = null;
		String articleContent = null;
		if (Validator.isNotNull(content)) {
			
			
			try {
				xmlContent = DocumentHelper.parseText(content);
				if (xmlContent != null) {
					List<Node> ddmNodes = xmlContent.selectNodes("//root/dynamic-element[@type='ddm-date-time']");
					if (ddmNodes != null && !ddmNodes.isEmpty()) {
						for (Node ddmNode : ddmNodes) {
							Node dateNode =  ddmNode.selectSingleNode("dynamic-content");
							if ( dateNode.getText() != null) {
								long dateValue = GetterUtil.getLong(dateNode.getText(), 0l);
								if (dateValue != 0l) {
									Date date = new Date(dateValue);
									LOGGER.info("Date is :"+date);
									SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
									String dynamicContent = formatter.format(date);
									org.dom4j.Element dynamicContentElement = (org.dom4j.Element) dateNode;
									dynamicContentElement.clearContent();
									dynamicContentElement.addCDATA(dynamicContent);
									LOGGER.info("formatted date is :"+dateNode.getText());
								}
							}
						}
						articleContent = xmlContent.asXML();
					}
					
				}
			} catch (DocumentException e) {
				e.printStackTrace();
			}
			
		}
		return articleContent;
	}
	
	
	 /**
     * @param name
     * @return true or false based on community setting in portal-ext
     */
    private boolean isHookappliedForCommunity(Group group)
    {
        boolean flag = false;
        String name = group.getName();
        String groupName = PropsUtil.get("article.service.hook.community.name");
        if (Validator.isNotNull(groupName))
        {
            String[] communities = groupName.split(",");
            for (int i = 0; i < communities.length; i++)
            {
                if (name.equalsIgnoreCase(communities[i]))
                {
                    flag = true;
                    break;
                }
            }
        }
        try {
        	LOGGER.info("Group name is " + name);
        	if(group.isOrganization()) {
        		LOGGER.info("Group is organization and name is : " + name);
        		Organization organization = OrganizationLocalServiceUtil.getOrganization(group.getOrganizationId());
        		ExpandoBridge organizationExpandoBridge = organization.getExpandoBridge();
        		String[] organizationType = (String[]) organizationExpandoBridge.getAttribute("Type");
        		//LOGGER.info("org type is  " + organizationType);
        		if(ArrayUtil.isNotEmpty(organizationType) && organizationType.length>0) {
        			LOGGER.info("org type is not null and value at zero is " + organizationType[0]);
        			if(Validator.isNotNull(organizationType[0]) && organizationType[0].equalsIgnoreCase("Department")) {
        				flag = true;
        			}
        		}
        	}
        } catch (Exception e) {
        	flag = false;
        }
        
        return flag;
    }
    
    private Boolean isBrandFrameworkCommunity(String name) {
		if (name.equalsIgnoreCase("Brand Framework EX")) {
			return true;
		}

		return false;
	}

}
