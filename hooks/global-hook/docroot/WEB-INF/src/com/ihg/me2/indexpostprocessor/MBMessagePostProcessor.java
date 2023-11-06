/**
 * 
 */
package com.ihg.me2.indexpostprocessor;

import com.ihg.me2.indexpostprocessor.util.CustomIndexerUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexerPostProcessor;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.model.Group;
import com.liferay.portlet.messageboards.model.MBMessage;

/**
 * @author PanchaJa - Jatin Panchal
 *
 */
public class MBMessagePostProcessor extends BaseIndexerPostProcessor {

	private static Log _log = LogFactoryUtil.getLog(MBMessagePostProcessor.class);
	
	@Override
	public void postProcessDocument(Document document, Object obj) throws Exception {
		_log.info("====================== Inside Post Processer Hook =========================");
		MBMessage message = (MBMessage) obj;
		Group group = CustomIndexerUtil.getGroupById(message.getGroupId());
		if(document != null && group.getFriendlyURL().contains("/grs-")){
			long parentMessageId = 0L;
	        try {
	            parentMessageId = message.getParentMessageId();
	            document.addText("parentMessageId", String.valueOf(parentMessageId));
	            _log.info("Indexing meta-data field from post processor for mbmessage ");
	            _log.info("====================== customModified value added for =========== "+  message.getMessageId());
	        } catch (Exception e) {
	        	_log.error("Problem while MBMessage indexer : " + e.getMessage(), e);
	        }	            
		}
		document.addText("customModified_sortable", String.valueOf(message.getModifiedDate().getTime()));
		super.postProcessDocument(document, obj);
	}
	

}
