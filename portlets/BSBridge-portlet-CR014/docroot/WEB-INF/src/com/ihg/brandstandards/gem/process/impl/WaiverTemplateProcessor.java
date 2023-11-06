package com.ihg.brandstandards.gem.process.impl;

import java.io.File;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class WaiverTemplateProcessor extends TemplateProcessor {
	
	private static final Log LOG = LogFactoryUtil.getLog(WaiverTemplateProcessor.class);
	@Override
	public long processTemplate (File file,
			String templateType, String title, long publishId, long publishDepartmentId, long regionId,
			long userId, boolean processValues, int headerColumn) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("It is a waiver template.");
		}
		return super.processTemplate(file, templateType, title, publishId, publishDepartmentId,
				regionId, userId, false, headerColumn);
	}

}
