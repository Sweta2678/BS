package com.ihg.security.util;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class AudienceXMLUtils
{
	/* Get the Selected Audience  values from XML Content and Apply the Respective Brand Categories */
   /* public static String getXMLDynamicData(Group group,JournalArticle articleEntry,String xmlContent, String [] fields)
    {
    	 
       String audienceValues="";
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
                    for (Node node : contentNode)
                    {
                    Element content = (Element)node;
                  	if(content!=null)
                  	{
                    	if (content.element("option") != null) 
                    	{	
                    		List<Element> optionValues=content.elements();
                    		for(Element optionValue :optionValues )
                    		{
                    		
                    			String audienceValue=optionValue.getText();
                    			LOGGER.info(" audienceValue --------:"+audienceValue);
                    			audienceValues=audienceValue+","+audienceValues;
                    			
	                    	}
                    	}
                  	}
                  	}
                 }
                
                LOGGER.info("Selected Audience Object :"+audienceValues);
                  
         }
        
        } 
        catch (DocumentException e)
        {
      
        	LOGGER.info("Exception raised while getting Dynamic Audience Data "+e.getMessage());
        }
        return audienceValues;
    }
    
     If Community is type App Store then Mapping the Brand Categories to the Selected Audience 
    public static boolean audienceValues(Group group,JournalArticle articleEntry,String audienceCategories)
    {
    	    boolean flag=false;
    	      
    	    final String[] tagNames = {};
  			List<AssetCategory> globalCategoriesList = null;
  			List<AssetCategory> brandglobalCategoriesList = null;
  			List<AssetCategory> childCategoryList=null;
  			long globalGroupId=0;
  			List<AssetCategory> assetCategoryJouranlArticleList=null;
  			long[] brandsubCategoryIds=null;
  			LOGGER.info(" Adding Categories based on Audience Selected Field ");
  	
    	try{
    		    Get the Global Group ID 
    		   globalGroupId=JournalArticleSecurityUtil.getGlobalGroupId();
		
    		
    		   String brandCategoryObj[]=audienceCategories.split(",");
			   String audienceValue[]=new String[brandCategoryObj.length];
			  
			    Get Brands Type Child Categories from Asset Categories 
			  
	 		   brandglobalCategoriesList = JournalArticleSecurityUtil.getChildAssetCategories(globalGroupId, PropsUtil.get("IHG_BRANDS_CATEGORY"));
	 		   
	 		   if(brandglobalCategoriesList.size()>0)
		       {
				childCategoryList=AssetCategoryLocalServiceUtil.getChildCategories(brandglobalCategoriesList.get(0).getCategoryId());
				brandsubCategoryIds = new long[childCategoryList.size()];
				LOGGER.info("childCategoryList "+childCategoryList.size());
				}
	 		  
			   for(int c=0;c<brandCategoryObj.length;c++)
			   {
				   LOGGER.info("Region Key "+brandCategoryObj[c]); 
				  
			  	   if(brandCategoryObj[c].equalsIgnoreCase(PropsUtil.get("BRAND_ALL_K")))
			      {
		 		   
		 			LOGGER.info("Size DATA"+brandglobalCategoriesList.size());
					if(brandglobalCategoriesList.size()>0)
					{
					    for(int m=0;m<childCategoryList.size();m++)
					    {
						brandsubCategoryIds[m]=childCategoryList.get(m).getCategoryId();
					    }
					}
				
				  flag=true;
				  break;
				
			  }
			  else if(brandCategoryObj[c].equalsIgnoreCase(PropsUtil.get("BRAND_CORPORATE_K")))
			  {
				
				  audienceValue[c]=PropsUtil.get("BRAND_CORPORATE_V");
				 
			  }
			  else if(brandCategoryObj[c].equalsIgnoreCase(PropsUtil.get("BRAND_INTERCONT_K")))
			  {
				  audienceValue[c]=PropsUtil.get("BRAND_INTERCONT_V");
				 
			  }
			  else if(brandCategoryObj[c].equalsIgnoreCase(PropsUtil.get("BRAND_HUALUXE_K")))
			  {
				  audienceValue[c]=PropsUtil.get("BRAND_HUALUXE_V");
				 
			  }
			  else if(brandCategoryObj[c].equalsIgnoreCase(PropsUtil.get("BRAND_CROWNE_PLAZA_K")))
			  {
				  audienceValue[c]=PropsUtil.get("BRAND_CROWNE_PLAZA_V");
				
			  }
			  else if(brandCategoryObj[c].equalsIgnoreCase(PropsUtil.get("BRAND_HOLIDAY_INN_K")))
			  {
				  audienceValue[c]=PropsUtil.get("BRAND_HOLIDAY_INN_V");
				  
			  }
			  else if(brandCategoryObj[c].equalsIgnoreCase(PropsUtil.get("BRAND_HOLIDAT_INN_EX_K")))
			  {
				  audienceValue[c]=PropsUtil.get("BRAND_HOLIDAT_INN_EX_V");
				 
			  }
			  else if(brandCategoryObj[c].equalsIgnoreCase(PropsUtil.get("BRAND_HOLIDAT_INN_RESORT_K")))
			  {
				  audienceValue[c]=PropsUtil.get("BRAND_HOLIDAT_INN_RESORT_V");
				
			  }
			  else if(brandCategoryObj[c].equalsIgnoreCase(PropsUtil.get("BRAND_HOLIDAT_INN_CV_K")))
			  {
				  audienceValue[c]=PropsUtil.get("BRAND_HOLIDAT_INN_CV_V");
				 
			  }
			  else if(brandCategoryObj[c].equalsIgnoreCase(PropsUtil.get("BRAND_STAYBRIDGE_SUITES_K")))
			  {
				  audienceValue[c]=PropsUtil.get("BRAND_STAYBRIDGE_SUITES_V"); 
				
			  }
			  else if(brandCategoryObj[c].equalsIgnoreCase(PropsUtil.get("BRAND_CANDLEWOOD_SUITES_K")))
			  {
				  audienceValue[c]=PropsUtil.get("BRAND_CANDLEWOOD_SUITES_V");
				
			  }
			  else if(brandCategoryObj[c].equalsIgnoreCase(PropsUtil.get("BRAND_IHG_RCLUB_K")))
			  {
				  audienceValue[c]=PropsUtil.get("BRAND_IHG_RCLUB_V"); 
				 
			  }
			  else if(brandCategoryObj[c].equalsIgnoreCase(PropsUtil.get("BRAND_AMSDR_K")))
			  {
				  audienceValue[c]=PropsUtil.get("BRAND_AMSDR_V");
				 
			  }
		 	  
			}
			   
			   Get Selected Audince brand Category Id's 
			   long[] brandCategoryIds = new long[childCategoryList.size()];
			  
			   if(Validator.isNotNull(audienceValue)) 
               {
			    for(int n=0;n<audienceValue.length;n++)
				 {
			    	for(int m=0;m<childCategoryList.size();m++)
			    	{
			    	if(childCategoryList.get(m).getName().equalsIgnoreCase(audienceValue[n]))
			    	{
			    	brandCategoryIds[m]=childCategoryList.get(m).getCategoryId();
			    	}
			    	}
			    	
				 }
			    }
			   
			     Get the Default Category from Assest Category 
			     globalCategoriesList=JournalArticleSecurityUtil.getAssetCategories(globalGroupId, PropsUtil.get("DEFAULT_CATEGORY_NAME"));
				
				AssetEntry  assetEntryJournalArtcile= AssetEntryLocalServiceUtil.getEntry(JournalArticle.class.getName(), articleEntry.getResourcePrimKey());
				assetCategoryJouranlArticleList= assetEntryJournalArtcile.getCategories();
				
				long[] globalCategoryIds = new long[assetCategoryJouranlArticleList.size()];
				 if(Validator.isNotNull(globalCategoriesList)&& Validator.isNotNull(assetCategoryJouranlArticleList))
				 {
					if(assetCategoryJouranlArticleList.size() >0)
					{
					    for(int i=0;i<assetCategoryJouranlArticleList.size();i++)
			            {
					    	 AssetCategory AssetCategoryObj=AssetCategoryLocalServiceUtil.getAssetCategory(assetCategoryJouranlArticleList.get(i).getParentCategoryId());
								LOGGER.info("AssetCategoryObj "+AssetCategoryObj.getName());
								if(AssetCategoryObj.getName().equals(PropsUtil.get("IHG_BRANDS_CATEGORY")))
								{
									LOGGER.info("Nothing Can be Added  ");		
								}
								if(AssetCategoryObj.getName().equals(PropsUtil.get("IHG_USERTYPE_CATEGORY"))||AssetCategoryObj.getName().equals(PropsUtil.get("IHG_REGIONS_CATEGORY")))
								{    
								      globalCategoryIds[i]=assetCategoryJouranlArticleList.get(i).getCategoryId();
								}
						}
					}
					
					 Updating the Selected Asset Categories from Audience Field 
					if(!flag)
					{
						long[] assetCategoryIds = new long[globalCategoryIds.length+brandCategoryIds.length];
						for(int m=0;m<brandCategoryIds.length;m++)
						{  
						  if(brandCategoryIds[m]!=0)
							{assetCategoryIds[m]=brandCategoryIds[m];}
						}
						for(int p=0;p<globalCategoryIds.length;p++)
						{
						  if(globalCategoryIds[p]!=0)
					      {assetCategoryIds[p+brandCategoryIds.length]=globalCategoryIds[p];}
						}
						 AssetEntryLocalServiceUtil.updateEntry(group.getCreatorUserId(), group.getGroupId() ,JournalArticle.class.getName(), articleEntry.getResourcePrimKey(),
							  assetCategoryIds, tagNames);
				    }
				
					if(flag)
					{
						long[] assetCategoryIdsALL = new long[globalCategoryIds.length+brandsubCategoryIds.length];
						for(int m=0;m<brandsubCategoryIds.length;m++)
						{
							if(brandsubCategoryIds[m]!=0)
							{	  assetCategoryIdsALL[m]=brandsubCategoryIds[m];}
								
						}
						
						for(int p=0;p<globalCategoryIds.length;p++)
						{
							  if(globalCategoryIds[p]!=0)
							  { assetCategoryIdsALL[p+brandsubCategoryIds.length]=globalCategoryIds[p];}
						}
						
						 AssetEntryLocalServiceUtil.updateEntry(group.getCreatorUserId(), group.getGroupId() ,JournalArticle.class.getName(), articleEntry.getResourcePrimKey(),
								 assetCategoryIdsALL, tagNames);
					}
				    
				 } 
			
			} 
			catch (PortalException e) {
				LOGGER.error("Unable to add categories to Journal Artcile  "+e.getMessage());
				} 
			catch (SystemException e) {
				LOGGER.error("Unable to add categories to Journal Artcile "+e.getMessage());
				}  
		
    	catch (Exception e) {
			// TODO: handle exception
    		LOGGER.info("While Maping the Brand Categories to Application Exception has raised :"+e.getMessage());
		}
			   return flag;
			   
    }
    */
    
}
