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

package com.ihg.brandstandards.db.service.base;

import com.ihg.brandstandards.db.service.JobQueueServiceUtil;

import java.util.Arrays;

/**
 * @author Mummanedi
 * @generated
 */
public class JobQueueServiceClpInvoker {
	public JobQueueServiceClpInvoker() {
		_methodName574 = "getBeanIdentifier";

		_methodParameterTypes574 = new String[] {  };

		_methodName575 = "setBeanIdentifier";

		_methodParameterTypes575 = new String[] { "java.lang.String" };

		_methodName580 = "addJobQueue";

		_methodParameterTypes580 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.util.Date",
				"java.util.Date", "java.lang.String", "java.lang.String",
				"java.util.Date", "java.lang.String", "java.util.Date"
			};

		_methodName581 = "updateJobQueue";

		_methodParameterTypes581 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.util.Date", "java.util.Date", "java.lang.String",
				"java.lang.String"
			};

		_methodName582 = "updateJobQueueStatus";

		_methodParameterTypes582 = new String[] {
				"long", "java.lang.String", "java.util.Date", "java.util.Date",
				"java.lang.String"
			};

		_methodName583 = "deleteJobQueue";

		_methodParameterTypes583 = new String[] { "long" };

		_methodName584 = "getAllJobQueues";

		_methodParameterTypes584 = new String[] {  };

		_methodName585 = "getJobQueuesExceptFullManuals";

		_methodParameterTypes585 = new String[] {  };

		_methodName586 = "getJobQueuesByOwnerAndType";

		_methodParameterTypes586 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName587 = "getJobQueuesByOwnerTypeAndStatus";

		_methodParameterTypes587 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName588 = "getJobQueuesByType";

		_methodParameterTypes588 = new String[] { "java.lang.String" };

		_methodName589 = "getJobQueuesByTypeAndStatus";

		_methodParameterTypes589 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName590 = "getJobQueuesByOwner";

		_methodParameterTypes590 = new String[] { "java.lang.String" };

		_methodName591 = "getUniqueJobQueTypes";

		_methodParameterTypes591 = new String[] {  };

		_methodName592 = "getFileAsByteStream";

		_methodParameterTypes592 = new String[] { "long" };

		_methodName593 = "getImageAsByteStream";

		_methodParameterTypes593 = new String[] { "long", "boolean" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName574.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes574, parameterTypes)) {
			return JobQueueServiceUtil.getBeanIdentifier();
		}

		if (_methodName575.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes575, parameterTypes)) {
			JobQueueServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName580.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes580, parameterTypes)) {
			return JobQueueServiceUtil.addJobQueue((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.util.Date)arguments[5], (java.util.Date)arguments[6],
				(java.lang.String)arguments[7], (java.lang.String)arguments[8],
				(java.util.Date)arguments[9], (java.lang.String)arguments[10],
				(java.util.Date)arguments[11]);
		}

		if (_methodName581.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes581, parameterTypes)) {
			return JobQueueServiceUtil.updateJobQueue(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.util.Date)arguments[6],
				(java.util.Date)arguments[7], (java.lang.String)arguments[8],
				(java.lang.String)arguments[9]);
		}

		if (_methodName582.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes582, parameterTypes)) {
			return JobQueueServiceUtil.updateJobQueueStatus(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.util.Date)arguments[2],
				(java.util.Date)arguments[3], (java.lang.String)arguments[4]);
		}

		if (_methodName583.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes583, parameterTypes)) {
			JobQueueServiceUtil.deleteJobQueue(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName584.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes584, parameterTypes)) {
			return JobQueueServiceUtil.getAllJobQueues();
		}

		if (_methodName585.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes585, parameterTypes)) {
			return JobQueueServiceUtil.getJobQueuesExceptFullManuals();
		}

		if (_methodName586.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes586, parameterTypes)) {
			return JobQueueServiceUtil.getJobQueuesByOwnerAndType((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName587.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes587, parameterTypes)) {
			return JobQueueServiceUtil.getJobQueuesByOwnerTypeAndStatus((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName588.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes588, parameterTypes)) {
			return JobQueueServiceUtil.getJobQueuesByType((java.lang.String)arguments[0]);
		}

		if (_methodName589.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes589, parameterTypes)) {
			return JobQueueServiceUtil.getJobQueuesByTypeAndStatus((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName590.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes590, parameterTypes)) {
			return JobQueueServiceUtil.getJobQueuesByOwner((java.lang.String)arguments[0]);
		}

		if (_methodName591.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes591, parameterTypes)) {
			return JobQueueServiceUtil.getUniqueJobQueTypes();
		}

		if (_methodName592.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes592, parameterTypes)) {
			return JobQueueServiceUtil.getFileAsByteStream(((Long)arguments[0]).longValue());
		}

		if (_methodName593.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes593, parameterTypes)) {
			return JobQueueServiceUtil.getImageAsByteStream(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName574;
	private String[] _methodParameterTypes574;
	private String _methodName575;
	private String[] _methodParameterTypes575;
	private String _methodName580;
	private String[] _methodParameterTypes580;
	private String _methodName581;
	private String[] _methodParameterTypes581;
	private String _methodName582;
	private String[] _methodParameterTypes582;
	private String _methodName583;
	private String[] _methodParameterTypes583;
	private String _methodName584;
	private String[] _methodParameterTypes584;
	private String _methodName585;
	private String[] _methodParameterTypes585;
	private String _methodName586;
	private String[] _methodParameterTypes586;
	private String _methodName587;
	private String[] _methodParameterTypes587;
	private String _methodName588;
	private String[] _methodParameterTypes588;
	private String _methodName589;
	private String[] _methodParameterTypes589;
	private String _methodName590;
	private String[] _methodParameterTypes590;
	private String _methodName591;
	private String[] _methodParameterTypes591;
	private String _methodName592;
	private String[] _methodParameterTypes592;
	private String _methodName593;
	private String[] _methodParameterTypes593;
}