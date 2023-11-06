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

package com.ihg.grs.common.model;

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the fileContent column in FeedbackDetail.
 *
 * @author gulam.vora
 * @see FeedbackDetail
 * @generated
 */
public class FeedbackDetailFileContentBlobModel {
	public FeedbackDetailFileContentBlobModel() {
	}

	public FeedbackDetailFileContentBlobModel(int PORTAL_FEEDBACK_DTL_ID) {
		_PORTAL_FEEDBACK_DTL_ID = PORTAL_FEEDBACK_DTL_ID;
	}

	public FeedbackDetailFileContentBlobModel(int PORTAL_FEEDBACK_DTL_ID,
		Blob fileContentBlob) {
		_PORTAL_FEEDBACK_DTL_ID = PORTAL_FEEDBACK_DTL_ID;
		_fileContentBlob = fileContentBlob;
	}

	public int getPORTAL_FEEDBACK_DTL_ID() {
		return _PORTAL_FEEDBACK_DTL_ID;
	}

	public void setPORTAL_FEEDBACK_DTL_ID(int PORTAL_FEEDBACK_DTL_ID) {
		_PORTAL_FEEDBACK_DTL_ID = PORTAL_FEEDBACK_DTL_ID;
	}

	public Blob getFileContentBlob() {
		return _fileContentBlob;
	}

	public void setFileContentBlob(Blob fileContentBlob) {
		_fileContentBlob = fileContentBlob;
	}

	private int _PORTAL_FEEDBACK_DTL_ID;
	private Blob _fileContentBlob;
}