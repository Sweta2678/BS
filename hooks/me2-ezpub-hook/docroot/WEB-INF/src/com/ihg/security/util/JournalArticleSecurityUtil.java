package com.ihg.security.util;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.journal.model.JournalArticle;

/**
 * @author PatelHet
 *
 */
public class JournalArticleSecurityUtil
{
    private static final Log LOGGER = LogFactoryUtil.getLog(JournalArticleSecurityUtil.class);
    
    private static  Map<String, AssetCategory> GLOBAL_CAT_MAP=new HashMap<String, AssetCategory>();
    
    
    /**
     * @param article
     */
    public static void addOrUpdateArticleEntry(JournalArticle article,String articleId, long resourcePK, long groupId, String xmlContent, long userId, String structureId)
    {
            try
            {
                Group groupOb=GroupLocalServiceUtil.getGroup(groupId);
                
                String communityName = groupOb.getName();
                
                LOGGER.info(" communityName "+communityName);
                        
                       GLOBAL_CAT_MAP=buildGlobalCategoriesMap();
                       
                       /*Getting list of associated categories of current Article*/
                       List<AssetCategory> catList= new ArrayList<AssetCategory>();
                       
                       if(SecurityConstants.CONF_STRUCTURE_IDS_LIST.contains(structureId) 
                               || SecurityConstants.INITIATIVES_STRUCTURE_IDS_LIST.contains(structureId))
                       {
                           /*Getting global categories for group*/
                           List<AssetCategory> groupCatList= getInitConfGroupCategoryList(groupId);
                           
                           catList = getArticleCategoriesForInitConf(resourcePK, groupCatList);
                       }else
                       {
                           catList = getArticleCategories(resourcePK);
                       }
                        
                        /*Getting list of default categories to apply to current article*/
                        catList = addGlobalAssetCategoryList(SecurityConstants.DEFAULT_GLOBAL_CATEGORY, catList);
                        
                        /*For Appstore community, Map audience fileds to Brands categories*/
                        if(communityName.equalsIgnoreCase(PropsUtil.get("COMMUNITY_APPLICATION")) 
                                && SecurityConstants.APPLICATION_STRUCTURE_IDS_LIST.contains(structureId))
                        {
                            /*Getting list of audience mapped categories to apply to current article*/
                            catList= addAudienceCategoryList(xmlContent,articleId, catList);
                        }
                        
                        /*For Newsroom community Map Region custom fields values to Categories*/
                        if (communityName.equalsIgnoreCase(PropsUtil.get("COMMUNITY_NEWSROOM")) 
                                && SecurityConstants.NEWSROOM_STRUCTURE_IDS_LIST.contains(structureId))
                        {
                            catList=addNewsroomRegionCategories(article, articleId, catList);
                        }
                        /*Getting array of all categories ID to update article entry*/
                        long[] catIdArray= getCategorIDArray(catList);
                        
                        /*Getting array of tag names associated with current article*/
                        String [] tagNames= getArticleTagNames(JournalArticle.class.getName(), resourcePK);
                        
                        /*Updating current article asset entries*/
                        updateArticleEntry(resourcePK, userId, groupId, articleId, catIdArray, tagNames);
                        
                        /* Adding default permission to article and  remove user and guest permission*/
                        //addDefaultRole(article,PropsUtil.get("DEFAULT_ROLE_NAME"));
                        
                        /*  Add code to give permissions for USertype category roles and Remove roles if category removed....*/
                        updateRoles(article);
                        
            } catch (PortalException e)
            {
                e.printStackTrace();
            } catch (SystemException e)
            {
                e.printStackTrace();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
    }
    
    /**
     * @param resourcePK
     * @param userId
     * @param groupID
     * @param articleId
     * @param catIds
     * @param tagNames
     */
    public static void updateArticleEntry(long resourcePK, long userId, long groupID, String articleId, long[] catIds, String[] tagNames )
    {
        try
        {
            AssetEntryLocalServiceUtil.updateEntry(userId, groupID ,JournalArticle.class.getName(), resourcePK,
                    catIds, tagNames);
            
            LOGGER.debug("Entry has been updated for article ID:"+ articleId);
            
        } catch (PortalException e)
        {
            LOGGER.error("Error in updating article asset entries");
            e.printStackTrace();
        } catch (SystemException e)
        {
            LOGGER.error("Error in updating article asset entries");
            e.printStackTrace();
        }
    }
    
    /**
     * @param className
     * @param classPK
     * @return
     */
    public static String[] getArticleTagNames(String className, long classPK)
    {
        //code end here of getting tags of community.
        String[] tagNames =null;
        try
        {
            AssetEntry tagEnteryOfDocument = AssetEntryLocalServiceUtil.getEntry(className, classPK );
            
            List<AssetTag> assetTagsListOfDocument = AssetTagLocalServiceUtil.getEntryTags(tagEnteryOfDocument.getEntryId());
            tagNames = new String[assetTagsListOfDocument.size()];
            
            for(int count = 0; count<assetTagsListOfDocument.size() ; count++)
            {
                    tagNames[count] = assetTagsListOfDocument.get(count).getName(); 
            }
        } catch (PortalException e)
        {
            LOGGER.error("Error in getting  article tag names");
            e.printStackTrace();
        } catch (SystemException e)
        {
            LOGGER.error("Error in getting  article tag names");
            e.printStackTrace();
        }
        
        return tagNames;
    }
    
    /**
     * @param article
     * @return
     */
    public static List<AssetCategory> getArticleCategories(long resourcePK)
    {
        List<AssetCategory> articleCatList=null;
        try
        {
            AssetEntry  assetEntryObj= AssetEntryLocalServiceUtil.getEntry(JournalArticle.class.getName(), resourcePK);
            
            articleCatList = assetEntryObj.getCategories();
            
        } catch (PortalException e)
        {
            e.printStackTrace();
        } catch (SystemException e)
        {
            e.printStackTrace();
        }
        return articleCatList;
    }
    
    /**
     * @param article
     * @return list of global categories for group
     */
    public static List<AssetCategory> getArticleCategoriesForInitConf(long resourcePK,  List<AssetCategory> groupCatList)
    {
        List<AssetCategory> catList=new ArrayList<AssetCategory>();
        try
        {
            AssetEntry  assetEntryObj= AssetEntryLocalServiceUtil.getEntry(JournalArticle.class.getName(), resourcePK);
            
            List<AssetCategory> articleCatList = assetEntryObj.getCategories();
            
            for (AssetCategory assetCategory : articleCatList)
            {
                AssetCategory parentCategoryObj=AssetCategoryLocalServiceUtil.getAssetCategory(assetCategory.getParentCategoryId());
                /*It will discard global categories not associated with Group*/
                if(parentCategoryObj.getName().equalsIgnoreCase(PropsUtil.get("IHG_USERTYPE_CATEGORY"))
                        ||parentCategoryObj.getName().equalsIgnoreCase(PropsUtil.get("IHG_REGIONS_CATEGORY"))
                        ||parentCategoryObj.getName().equalsIgnoreCase(PropsUtil.get("IHG_BRANDS_CATEGORY")))
                {
                    if(groupCatList.contains(assetCategory))
                    {
                        catList.add(assetCategory);
                    }
                }else
                {
                    catList.add(assetCategory);
                }
            }
            
        } catch (PortalException e)
        {
            e.printStackTrace();
        } catch (SystemException e)
        {
            e.printStackTrace();
        }
        return catList;
    }
    
    
    /**
     * @param categoryNames
     * @return
     */
    public static List<AssetCategory> addGlobalAssetCategoryList(String[] categoryNames,List<AssetCategory> catList)
    {
        List<AssetCategory> globalCatList= new ArrayList<AssetCategory>(catList) ;
        
        if(Validator.isNotNull(categoryNames) && Validator.isNotNull(GLOBAL_CAT_MAP))
        {
          for (int i = 0; i < categoryNames.length; i++)
          {
              if(!globalCatList.contains(GLOBAL_CAT_MAP.get(categoryNames[i])))
              {
                  globalCatList.add(GLOBAL_CAT_MAP.get(categoryNames[i]));
              }
          }
        }
        
        return globalCatList;
    }
    
    /**
     * @param article
     * @param catMap
     * @return
     */
    public static List<AssetCategory> addAudienceCategoryList(String xmlContent,String articleId, List<AssetCategory> list)
    {
        LOGGER.info("Calling addAudienceCategoryList");
        
        List<AssetCategory> catList= new ArrayList<AssetCategory>(list) ;
        
        AssetCategory assetCategory=null;
        try
        {
        
        Map<String, String> fieldsMap = getXMLDynamicData(xmlContent, SecurityConstants.DYNAMIC_FIELDS);
        
        String selectedAudience= fieldsMap.get(SecurityConstants.AUDIENCE_FIELD);
        
        LOGGER.debug("Selected audiences:" + selectedAudience +" for articleID:"+ articleId);
        
         if(Validator.isNotNull(selectedAudience))
         {
             String [] audienceArray= selectedAudience.split(",");
             
            if(Validator.isNotNull(audienceArray))
            {
                for (int i = 0; i < audienceArray.length; i++)
                {
                    if(audienceArray[i].equalsIgnoreCase(PropsUtil.get("BRAND_ALL_K")))
                    {
                        String brands= PropsUtil.get("BRAND_ALL_V");
                        
                        if(Validator.isNotNull(brands))
                        {
                            String [] brandsArray=brands.split(",");
                            
                            for (int j = 0; j < brandsArray.length; j++)
                            {
                                assetCategory=GLOBAL_CAT_MAP.get(brandsArray[j]);
                                
                               catList=addCategoryToList(catList, assetCategory);
                            }
                        }
                    }
                        else if(audienceArray[i].equalsIgnoreCase(PropsUtil.get("BRAND_CORPORATE_K")))
                        {
                            assetCategory=GLOBAL_CAT_MAP.get(PropsUtil.get("BRAND_CORPORATE_V"));
                            catList=addCategoryToList(catList, assetCategory);
                        }
                        else if(audienceArray[i].equalsIgnoreCase(PropsUtil.get("BRAND_INTERCONT_K")))
                        {
                            assetCategory=GLOBAL_CAT_MAP.get(PropsUtil.get("BRAND_INTERCONT_V"));
                            catList=addCategoryToList(catList, assetCategory);
                        }
                        else if(audienceArray[i].equalsIgnoreCase(PropsUtil.get("BRAND_HUALUXE_K")))
                        {
                            assetCategory=GLOBAL_CAT_MAP.get(PropsUtil.get("BRAND_HUALUXE_V"));
                            catList=addCategoryToList(catList, assetCategory);
                        }
                        else if(audienceArray[i].equalsIgnoreCase(PropsUtil.get("BRAND_CROWNE_PLAZA_K")))
                        {
                            assetCategory=GLOBAL_CAT_MAP.get(PropsUtil.get("BRAND_CROWNE_PLAZA_V"));
                            catList=addCategoryToList(catList, assetCategory);
                        }
                        else if(audienceArray[i].equalsIgnoreCase(PropsUtil.get("BRAND_HOLIDAY_INN_K")))
                        {
                            assetCategory=GLOBAL_CAT_MAP.get(PropsUtil.get("BRAND_HOLIDAY_INN_V"));
                            
                            catList=addCategoryToList(catList, assetCategory);
                        }
                        else if(audienceArray[i].equalsIgnoreCase(PropsUtil.get("BRAND_HOLIDAT_INN_EX_K")))
                        {
                            assetCategory=GLOBAL_CAT_MAP.get(PropsUtil.get("BRAND_HOLIDAT_INN_EX_V"));
                            catList=addCategoryToList(catList, assetCategory);
                        }
                        else if(audienceArray[i].equalsIgnoreCase(PropsUtil.get("BRAND_HOLIDAT_INN_RESORT_K")))
                        {
                            assetCategory=GLOBAL_CAT_MAP.get(PropsUtil.get("BRAND_HOLIDAT_INN_RESORT_V"));
                            catList=addCategoryToList(catList, assetCategory);
                              
                        }
                        else if(audienceArray[i].equalsIgnoreCase(PropsUtil.get("BRAND_HOLIDAT_INN_CV_K")))
                        {
                            assetCategory=GLOBAL_CAT_MAP.get(PropsUtil.get("BRAND_HOLIDAT_INN_CV_V"));
                            catList=addCategoryToList(catList, assetCategory);
                        }
                        else if(audienceArray[i].equalsIgnoreCase(PropsUtil.get("BRAND_STAYBRIDGE_SUITES_K")))
                        {
                            assetCategory=GLOBAL_CAT_MAP.get(PropsUtil.get("BRAND_STAYBRIDGE_SUITES_V")); 
                            catList=addCategoryToList(catList, assetCategory);
                        }
                        else if(audienceArray[i].equalsIgnoreCase(PropsUtil.get("BRAND_CANDLEWOOD_SUITES_K")))
                        {
                            assetCategory=GLOBAL_CAT_MAP.get(PropsUtil.get("BRAND_CANDLEWOOD_SUITES_V"));
                            catList=addCategoryToList(catList, assetCategory);  
                        }
                        else if(audienceArray[i].equalsIgnoreCase(PropsUtil.get("BRAND_IHG_RCLUB_K")))
                        {
                            assetCategory=GLOBAL_CAT_MAP.get(PropsUtil.get("BRAND_IHG_RCLUB_V")); 
                            catList=addCategoryToList(catList, assetCategory);   
                        }
                        else if(audienceArray[i].equalsIgnoreCase(PropsUtil.get("BRAND_AMSDR_K")))
                        {
                            assetCategory=GLOBAL_CAT_MAP.get(PropsUtil.get("BRAND_AMSDR_V"));
                            catList=addCategoryToList(catList, assetCategory);  
                        }
                    }
                   
                }
        }
        }catch(Exception e)
        {
            LOGGER.debug("Error in getting audience category map ", e);
        }
        
        return catList;
    }
    
    /**
     * @param articleId
     * @param catMap
     * @param catList
     * @return
     */
    public static List<AssetCategory> addNewsroomRegionCategories(JournalArticle article, String articleId,  List<AssetCategory> catList)
    {
        List<AssetCategory> newsCatList=catList;
        
        try 
        {
        
            ExpandoBridge expandoBridgeOObj =article.getExpandoBridge();
            
            String regionCategoryObj[]=(String[])expandoBridgeOObj.getAttribute(SecurityConstants.EXPANDO_REGION);
            
            AssetCategory assetCategory=null;
            
            for(int c=0;c<regionCategoryObj.length;c++)
            {
                   LOGGER.info("Region Key "+regionCategoryObj[c]); 
                   
                   if(regionCategoryObj[c].equalsIgnoreCase(PropsUtil.get("REGION_GLOBAL_K")))
                   {
                       assetCategory=GLOBAL_CAT_MAP.get(PropsUtil.get("REGION_GLOBAL_V"));
                       
                   }
                   else if(regionCategoryObj[c].equalsIgnoreCase(PropsUtil.get("REGION_AMER_K")))
                           
                   {
                       assetCategory=GLOBAL_CAT_MAP.get(PropsUtil.get("REGION_AMER_V"));
    
                   }
                   else if(regionCategoryObj[c].equalsIgnoreCase(PropsUtil.get("REGION_EURO_K")))
                   {
                       assetCategory=GLOBAL_CAT_MAP.get(PropsUtil.get("REGION_EURO_V"));
    
                   }
                   else if(regionCategoryObj[c].equalsIgnoreCase(PropsUtil.get("REGION_GC_K")))
                   {
                       assetCategory=GLOBAL_CAT_MAP.get(PropsUtil.get("REGION_GC_V"));
                         
                   }
                   else if(regionCategoryObj[c].equalsIgnoreCase(PropsUtil.get("REGION_AMEA_K")))
                   {
                       assetCategory=GLOBAL_CAT_MAP.get(PropsUtil.get("REGION_AMEA_V"));
                           
                   }
                   
                   newsCatList=addCategoryToList(newsCatList, assetCategory);
            }
        }catch(Exception e)
        {
            LOGGER.error("Error in mapping Newsroom Expando Region to categories ", e);
        }
        
        return newsCatList;
    }
    
    /**
     * @param catList
     * @param assetCategory
     * @return
     */
    public static List<AssetCategory> addCategoryToList( List<AssetCategory> catList, AssetCategory assetCategory)
    {
        if(!catList.contains(assetCategory))
        {
            catList.add(assetCategory);
        }
        return catList;
    }
    
    /**
     * @param xmlContent
     * @param fields
     * @return
     */
    public static Map<String, String> getXMLDynamicData(String xmlContent, String [] fields)
    {
         
        
        Map<String, String> fieldsMap = new HashMap<String, String>();
        
        SAXReader saxReader = new SAXReader();
        
       Document document=null;
        try
        {
            document = saxReader.read(new InputSource(new StringReader(xmlContent)));
            
            for (String string : fields)
            {
                
                List<Node> contentNode = (List<Node>)document.selectNodes(string);
                
                if (contentNode != null)
                {
                    StringBuffer val=new StringBuffer();
                    for (Node node : contentNode)
                    {
                        val.append(node.getText());
                        val.append(',');
                    }
                    String result=val.toString();
                    
                    if(Validator.isNotNull(result))
                    {
                        result=result.substring(0,result.length()-1).trim();
                    }
                    fieldsMap.put(string, result);
                }
            }
        } catch (DocumentException e)
        {
            e.printStackTrace();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return fieldsMap;
    }
    
    /**
    * @return MAP of Global categories
    */
   public static Map<String, AssetCategory> buildGlobalCategoriesMap()
    {
       long st=System.currentTimeMillis();
       
        Map<String, AssetCategory> categoryMap =new HashMap<String, AssetCategory>();
        
        try 
        {
            long globalGroupId = getGlobalGroupId();
            
            AssetVocabulary vocabulary = null;
            try 
            {
                    vocabulary = AssetVocabularyLocalServiceUtil.getGroupVocabulary(globalGroupId, SecurityConstants.VOCABULARY_NAME);
            } catch (Exception e) 
            {
                    vocabulary = null;
            }
            
            List<AssetCategory> categories = null;
            
            if(Validator.isNotNull(vocabulary) && Validator.isNotNull(vocabulary.getName())) 
            {
                    categories = AssetCategoryLocalServiceUtil.getVocabularyRootCategories
                                    (vocabulary.getVocabularyId(), QueryUtil.ALL_POS,QueryUtil.ALL_POS, null);
                    
                    if(Validator.isNotNull(categories)) 
                    {
                            for (AssetCategory category : categories) 
                            {
                                    if(Validator.isNotNull(category)) 
                                    {
                                            String categoryName = category.getName();
                                            if(Validator.isNotNull(categoryName) && 
                                                            (categoryName.equalsIgnoreCase(PropsUtil.get("IHG_USERTYPE_CATEGORY")) ||
                                                                            categoryName.equalsIgnoreCase(PropsUtil.get("IHG_REGIONS_CATEGORY")) || categoryName.equalsIgnoreCase(PropsUtil.get("IHG_BRANDS_CATEGORY")))) 
                                            {
                                                    List<AssetCategory> childCategories = AssetCategoryLocalServiceUtil.getVocabularyCategories(category.getCategoryId(), vocabulary.getVocabularyId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
                                                    
                                                    if(Validator.isNotNull(childCategories)) 
                                                    {
                                                            for(AssetCategory subCategory:childCategories) 
                                                            {
                                                                try
                                                                {
                                                                    String subCatName=subCategory.getName();
                                                                    
                                                                    if(Validator.isNotNull(subCatName))
                                                                    {
                                                                        categoryMap.put(subCatName, subCategory) ;
                                                                    }
                                                                }catch(Exception e)
                                                                {
                                                                    LOGGER.error("Error in building global category map");
                                                                }
                                                                    
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
            }
            
    } catch (Exception e) 
    {
        LOGGER.error(" Exception in NotificationUtil :: getCategoryIdMap() ", e);
            return null;
    }
    
    long et= System.currentTimeMillis();
    
    LOGGER.debug("Time to build category map "+ (et-st) +"ms");
        return categoryMap;
    }
   
   
   
   /**
 * @param into
 * @param merger
 * @return
 */
public static List<AssetCategory> mergeCategories(List<AssetCategory> into, List<AssetCategory> merger)
   {
       for (Iterator iterator = merger.iterator(); iterator.hasNext();)
       {
        AssetCategory assetCategory = (AssetCategory) iterator.next();
        
        if(!into.contains(assetCategory))
        {
            into.add(assetCategory);
        }
        
       }
       
       return into;
   }

    /**
     * @param catList
     * @return
     */
    public static long[] getCategorIDArray (List<AssetCategory> catList)
    {
        long [] catIdArray =null;
        
        if(Validator.isNotNull(catList))
        {
            catIdArray= new long[catList.size()];
            
            for(int i=0;i<catList.size();i++)
            {
                catIdArray[i]= catList.get(i).getCategoryId();
            }
        }
        return catIdArray;
    }
    
    /**
     * @param group
     * @return Global categories associated with Parent 
     */
    public static List<AssetCategory> getInitConfGroupCategoryList(long groupId)
    {
        List<AssetCategory> catList =new ArrayList<AssetCategory>();
        
        try
        {
            Group group = GroupLocalServiceUtil.getGroup(groupId);
            
            AssetEntry  assetEntryCommunity= AssetEntryLocalServiceUtil.getEntry(Group.class.getName(),group.getPrimaryKey());
            
            List<AssetCategory> assetCategoryCommunityList=assetEntryCommunity.getCategories();
            
            for(AssetCategory listObj:assetCategoryCommunityList)
            {
                AssetCategory parentCategoryObj=AssetCategoryLocalServiceUtil.getAssetCategory(listObj.getParentCategoryId());
                
                if(parentCategoryObj.getName().equalsIgnoreCase(PropsUtil.get("IHG_USERTYPE_CATEGORY"))
                        ||parentCategoryObj.getName().equalsIgnoreCase(PropsUtil.get("IHG_REGIONS_CATEGORY"))
                        ||parentCategoryObj.getName().equalsIgnoreCase(PropsUtil.get("IHG_BRANDS_CATEGORY")))
                {
                    catList.add(listObj);
                }
            }
        } catch (PortalException e)
        {
            e.printStackTrace();
        } catch (SystemException e)
        {
            e.printStackTrace();
        }
        return catList;
    }
    
    
    /**
     * @param article
     * @param roleName
     * 
     * It will remove guest and user permission from article and assign "User type corp and temp" role
     * 
     */
    public static void addDefaultRole(JournalArticle article, String roleName)
    {
        try
        {
                Role guestRole=RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), RoleConstants.GUEST); 
                Role userRole=RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), RoleConstants.USER);
                Role defaultRole = null;
                try
                {
                        defaultRole=RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), roleName);
                        
                }catch(Exception e)
                {
                        LOGGER.error("Unable to get the 'User Type Corporate and Temporary Contractors' role details "+e.getMessage());
                }
                if(defaultRole != null)
                {
                        ResourcePermissionLocalServiceUtil.setResourcePermissions(CompanyThreadLocal.getCompanyId(), JournalArticle.class.getName(), 
                                        ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(article.getResourcePrimKey()), defaultRole.getRoleId(), new String[]{ActionKeys.VIEW});
                        ResourcePermissionLocalServiceUtil.removeResourcePermission(CompanyThreadLocal.getCompanyId(), JournalArticle.class.getName(),
                                        ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(article.getResourcePrimKey()), guestRole.getRoleId(), ActionKeys.VIEW);
                        ResourcePermissionLocalServiceUtil.removeResourcePermission(CompanyThreadLocal.getCompanyId(), JournalArticle.class.getName(),
                                        ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(article.getResourcePrimKey()), userRole.getRoleId(), ActionKeys.VIEW);
                }
         }catch(Exception e)
         {
             LOGGER.error("Unable to add default role :"+e.getMessage());
         }
}
    
    /**
     * @param model
     */
    public static void updateRoles(Object model) 
    {

        List<AssetCategory> modelAssociatedCategories = null;
        List<AssetCategory> userTypeCategories = null;
        
        long modelPrimaryKey = 0L;
        String modelClassName= null;
        
        Role role =null;
        
        try 
        {
                //Getting Global UserType Category Information
                
                AssetVocabulary vocabulary =
                        AssetVocabularyLocalServiceUtil.getGroupVocabulary(
                                getGlobalGroupId(), SecurityConstants.VOCABULARY_NAME);

                List<AssetCategory> rootCategories =
                        AssetCategoryLocalServiceUtil.getVocabularyRootCategories(
                                vocabulary.getVocabularyId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
                
                for (AssetCategory rootCategory : rootCategories) 
                {
                        if(SecurityConstants.USER_TYPE_CATEGORY_NAME.equalsIgnoreCase(rootCategory.getName()))
                        {
                                userTypeCategories = AssetCategoryLocalServiceUtil.getChildCategories(rootCategory.getCategoryId());
                                break;
                        }
                }

                //Getting model basic information
                
                if (model instanceof JournalArticle) 
                {
                    JournalArticle articleEntry = (JournalArticle) model;
                        
                        modelPrimaryKey = articleEntry.getResourcePrimKey();
                        modelClassName = JournalArticle.class.getName();
                }
                
                //Getting model associated categories information
                
                modelAssociatedCategories =
                        AssetCategoryLocalServiceUtil.getCategories(modelClassName, modelPrimaryKey);
                
                for(AssetCategory category: userTypeCategories)
                {
                        
                        role = getRoleFormCategoryName(category.getName());
                        
                        if(Validator.isNotNull(role))
                        {
                                
                                //Removing UserType related Categories (This logic is mainly for existing documents)
                                
                            removePermission(modelPrimaryKey, modelClassName, role, ActionKeys.VIEW);
                                
                                //Checking whether GLobal UserType Categories are associated with model; if 'YES', adding the role.
                                
                                if(modelAssociatedCategories.contains(category))
                                {
                                    updateRole(modelPrimaryKey, modelClassName,role, ActionKeys.VIEW);
                                }
                        }
                }
                
                //Removing Guest and User VIEW Permissions
                
                role = RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), RoleConstants.GUEST);
               removePermission(modelPrimaryKey, modelClassName, role, ActionKeys.VIEW);
                
                role = RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), RoleConstants.USER);
                removePermission(modelPrimaryKey, modelClassName, role, ActionKeys.VIEW);
                
        } catch (PortalException e) 
        {
            LOGGER.error("Unable to get updates roles to the model "+modelClassName+", " + e.getMessage());
        } catch (SystemException e) 
        {
            LOGGER.error("Unable to get updates roles to the model "+modelClassName+", " + e.getMessage());
        }

}


/**
 * @param roleName
 * @return
 */
public static Role getRoleFormCategoryName(String roleName) {

        Role role=null;
        String name = null;
        
        if(SecurityConstants.CORPORATE_AND_TEMP_CONTRACTORS_CAT_NAME.equals(roleName))
        {
                name = SecurityConstants.CORPORATE_AND_TEMP_CONTRACTORS_ROLE_NAME;
        }
        else if(SecurityConstants.FRANCHISE_CAT_NAME.equals(roleName))
        {
                name = SecurityConstants.FRANCHISE_ROLE_NAME;
        }else if(SecurityConstants.OWNED_AND_MANAGED_CAT_NAME.equals(roleName))
        {
                name = SecurityConstants.OWNED_AND_MANAGED_ROLE_NAME;
        }else if(SecurityConstants.VENDORS_CAT_NAME.equals(roleName))
        {
                name = SecurityConstants.VENDORS_ROLE_NAME;
        }else if(SecurityConstants.CORPORATE_CAT_NAME.equals(roleName))
        {
                name = SecurityConstants.CORPORATE_ROLE_NAME;
        }       
        
        try 
        {
                role = RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), name);
        }
        catch (PortalException e) 
        {
            LOGGER.error("Unable to get Role information, " + e.getMessage());
        }
        catch (SystemException e) 
        {
            LOGGER.error("Unable to get Role information, " + e.getMessage());
        }
        return role;
}

/**
 * @param modelPrimaryKey
 * @param modelClassName
 * @param role
 * @param acitionKey
 */
public static void updateRole(long modelPrimaryKey, String modelClassName, Role role, String acitionKey) 
{

        try 
        {
                ResourcePermissionLocalServiceUtil.setResourcePermissions(CompanyThreadLocal.getCompanyId(), modelClassName, 
                                ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(modelPrimaryKey), role.getRoleId(), new String[]{acitionKey});
        }
        catch (PortalException e) 
        {
            LOGGER.error("Unable to add "+acitionKey+" permission for model "+modelClassName+", " + e.getMessage());
        }
        catch (SystemException e) 
        {
            LOGGER.error("Unable to add "+acitionKey+" permission for model "+modelClassName+", " + e.getMessage());
        }
        
}


/**
 * @param modelPrimaryKey
 * @param modelClassName
 * @param role
 * @param acitionKey
 */
public static void removePermission(long modelPrimaryKey, String modelClassName, Role role, String acitionKey) 
{
        
        try 
        {
                ResourcePermissionLocalServiceUtil.removeResourcePermission(CompanyThreadLocal.getCompanyId(), modelClassName,
                        ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(modelPrimaryKey), role.getRoleId(), acitionKey);
        }
        catch (PortalException e) 
        {
            LOGGER.error("Unable to delete "+acitionKey+" permission from "+role.getName()+", " + e.getMessage());
        }
        catch (SystemException e) 
        {
            LOGGER.error("Unable to delete "+acitionKey+" permission from "+role.getName()+", " + e.getMessage());
        } 
        
}
/* Get the Global Group Id */
public static long getGlobalGroupId()
{
    long globalGroupId=0;
    long companyId=CompanyThreadLocal.getCompanyId();
     Group groupObj;
           try 
           {
                   groupObj = GroupLocalServiceUtil.getCompanyGroup(companyId);
               LOGGER.info(" Global Group Id : "+groupObj.getGroupId());
               globalGroupId=groupObj.getGroupId();
           } catch (PortalException e) 
           {
                   LOGGER.error("Unable to get the Global Group Id "+e.getMessage());
           } catch (SystemException e) 
           {
                   LOGGER.error("Unable to get the Global Group Id "+e.getMessage());
           }
           
            
    return globalGroupId;
}
            
}
