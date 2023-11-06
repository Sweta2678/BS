package com.ihg.me2.service.indexer.util;

import com.ihg.me2.service.indexer.GroupIndexer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
/***
 * 
 * @author patelHet
 *
 */
public class CommunityIndexerUtil
{
	private static Log _log = LogFactoryUtil.getLog(CommunityIndexerUtil.class);
		
		
		public static boolean isMerlinTag(String[] assetTagNames, String tagName){
			//AssetEntry entry = AssetEntryLocalServiceUtil.getEntry(className, classPK);
			//List<AssetTag> tagList = AssetTagLocalServiceUtil.getEntryTags(entry.getEntryId());
			for (String tag : assetTagNames){
				if(tag.equalsIgnoreCase(tagName)){
					return true;
				}
			}
			return false;
		}
		
		
		/**
		 * @param groupId
		 * @return
		 */
		public static Group getGroupById(long groupId)
		{
			try 
			{
				return GroupLocalServiceUtil.getGroup( groupId);
				
			} catch (PortalException e) 
			{
				_log.error("Error while get Group : " + e.getMessage(),e);
				
			} catch (SystemException e)
			{
				_log.error("Error from getGroupById : " + e.getMessage(),e);
				
			}
			return null;
		}
		
		/**
		 * @param groupId
		 */
		public static void deleteGroupIndex(long groupId)
		{
			if(Validator.isNotNull(groupId))
			{
				deleteGroupIndex(getGroupById(groupId));
			}
		}
		
		/**
		 * @param group
		 */
		public static void deleteGroupIndex(Group group)
		{
			if(Validator.isNotNull(group))
			{
				_log.debug("Deleting group Indexes for Group Name:-"+ group.getName());
				
				 try 
				 {
					Indexer indexer = getOrRegisterGroupIndexer();
					 
					indexer.delete(group);
					
				 } 
				 catch (SearchException e) 
				 {
					e.printStackTrace();
				 } catch (Exception e) 
				 {
					e.printStackTrace();
				 }
			}
			else
			{
				_log.error("Group is NULL so won't able to delete indexs");
			}
		}
		
		/**
		 * @param group
		 */
		public static void craeteGroupIndex(Group group)
		{
			if(Validator.isNotNull(group))
			{
				_log.debug("Creating indexes for group "+ group.getGroupId());
				try 
				 {
					Indexer indexer = getOrRegisterGroupIndexer();
					 
					indexer.reindex(group);
				 }
				catch (SearchException e) 
				 {
					e.printStackTrace();
				 } catch (Exception e) 
				 {
					e.printStackTrace();
				 }
			}
			else
			{
				_log.error("Group is NULL so won't able to create indexs");
			}
		}
		
		/**
		 * @return
		 */
		public static Indexer getOrRegisterGroupIndexer()
		{
			
			Indexer indexer= IndexerRegistryUtil.getIndexer(Group.class.getName());
			
			_log.info("Indexer class for Group Index :::"+ indexer);
			
			if(Validator.isNull(indexer))
			{
				/* Registering GroupIndexer */
				_log.info("Registering GroupIndexer class ... ");
				
				IndexerRegistryUtil.register(Group.class.getName(), new GroupIndexer());
				
				indexer= IndexerRegistryUtil.getIndexer(Group.class.getName());
			}
			
			return indexer;
		}
		
}
