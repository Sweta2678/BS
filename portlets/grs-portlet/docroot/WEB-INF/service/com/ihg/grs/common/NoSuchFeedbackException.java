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

package com.ihg.grs.common;

import com.liferay.portal.NoSuchModelException;

/**
 * @author gulam.vora
 */
public class NoSuchFeedbackException extends NoSuchModelException {

	public NoSuchFeedbackException() {
		super();
	}

	public NoSuchFeedbackException(String msg) {
		super(msg);
	}

	public NoSuchFeedbackException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchFeedbackException(Throwable cause) {
		super(cause);
	}

}