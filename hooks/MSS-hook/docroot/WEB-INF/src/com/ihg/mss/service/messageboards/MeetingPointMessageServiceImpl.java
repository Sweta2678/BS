package com.ihg.mss.service.messageboards;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portlet.messageboards.service.MBMessageLocalService;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceWrapper;


/**
 * Custom Service Wrapper Implementation for 'COMMENTS' to gamify Liferay Commenting Framework
 * Gamified component: 1. 'Web-Content Comments'
 * 
 * @author Jay Patel
 * @deprecated - shifted services to 'MeetingPointMessageboardLocalServiceImpl'
 * 
 */
public class MeetingPointMessageServiceImpl extends MBMessageLocalServiceWrapper
{

	public MeetingPointMessageServiceImpl(MBMessageLocalService mbMessageLocalService) 
	{
		super(mbMessageLocalService);
	}


		
	private static final Log _log = LogFactoryUtil.getLog(MeetingPointMessageServiceImpl.class);
}
