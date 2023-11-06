package com.ihg.brandstandards.gem.process;

import java.io.File;

import com.ihg.brandstandards.custom.model.Preferences;
import com.liferay.portal.model.User;

/**
 * 
 * @author AkhaniC
 *
 */
public interface Processor {

	public long processTemplate (File file, String templateType, String title, long publishId, long processTemplate, long regionId, 
			long userId, boolean processValues, int headerColumn);
	
	public boolean deleteConfiguration (String template);
	
	public void addMessageInQueue (String messageType, long publishId, String groupType, 
			String manualType, Preferences preferences, User user);
	
	public String generateMetadata (String brandCode, String regionCode, long regionId,	long publishId, String groupType,
			String manualType, String userName);
}
