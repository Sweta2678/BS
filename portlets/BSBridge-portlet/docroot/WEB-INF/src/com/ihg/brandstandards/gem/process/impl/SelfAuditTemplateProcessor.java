package com.ihg.brandstandards.gem.process.impl;

import java.io.File;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class SelfAuditTemplateProcessor extends TemplateProcessor {
	
	private static final Log LOG = LogFactoryUtil.getLog(SelfAuditTemplateProcessor.class);
	
	@Override
	public long processTemplate (File file,
			String templateType, String title, long publishId, long publishDepartmentId,  long regionId,
			long userId, boolean processValues, int headerColumn) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Processing SelfAuditTemplate.");
		}
		//For SA Row 2 is a header row
		return super.processTemplate(file, templateType, title, publishId, publishDepartmentId,
				regionId, userId, processValues, 1);
	}
}
