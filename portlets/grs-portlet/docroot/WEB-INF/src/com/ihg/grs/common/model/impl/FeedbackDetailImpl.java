/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.ihg.grs.common.model.impl;

import java.io.File;

/**
 * The extended model implementation for the FeedbackDetail service. Represents
 * a row in the &quot;FEEDBACK_DETAIL&quot; database table, with each column
 * mapped to a property of this class. <p> Helper methods and all application
 * logic should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.ihg.grs.common.model.FeedbackDetail} interface. </p>
 *
 * @author gulam.vora
 */
public class FeedbackDetailImpl extends FeedbackDetailBaseImpl
{

	/*
	 * NOTE FOR DEVELOPERS: Never reference this class directly. All methods
	 * that expect a feedback detail model instance should use the {@link
	 * com.ihg.grs.common.model.FeedbackDetail} interface instead.
	 */
	public FeedbackDetailImpl()
	{
	}

	public File getFeedbackFile()
	{
		return feedbackFile;
	}

	public void setFeedbackFile(File feedbackFile)
	{
		this.feedbackFile = feedbackFile;
	}

	private File feedbackFile;

}
