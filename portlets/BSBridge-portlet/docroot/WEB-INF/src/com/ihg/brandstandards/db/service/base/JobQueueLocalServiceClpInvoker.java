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

import com.ihg.brandstandards.db.service.JobQueueLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Mummanedi
 * @generated
 */
public class JobQueueLocalServiceClpInvoker {
	public JobQueueLocalServiceClpInvoker() {
		_methodName0 = "addJobQueue";

		_methodParameterTypes0 = new String[] {
				"com.ihg.brandstandards.db.model.JobQueue"
			};

		_methodName1 = "createJobQueue";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteJobQueue";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteJobQueue";

		_methodParameterTypes3 = new String[] {
				"com.ihg.brandstandards.db.model.JobQueue"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchJobQueue";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getJobQueue";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getJobQueues";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getJobQueuesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateJobQueue";

		_methodParameterTypes15 = new String[] {
				"com.ihg.brandstandards.db.model.JobQueue"
			};

		_methodName608 = "getBeanIdentifier";

		_methodParameterTypes608 = new String[] {  };

		_methodName609 = "setBeanIdentifier";

		_methodParameterTypes609 = new String[] { "java.lang.String" };

		_methodName614 = "insertJobQueueUsingOraSequence";

		_methodParameterTypes614 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName615 = "addNewJobRequest";

		_methodParameterTypes615 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName616 = "addJobQueue";

		_methodParameterTypes616 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.util.Date",
				"java.util.Date", "java.lang.String", "java.lang.String",
				"java.util.Date", "java.lang.String", "java.util.Date"
			};

		_methodName617 = "updateJobQueue";

		_methodParameterTypes617 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.util.Date", "java.util.Date", "java.lang.String",
				"java.lang.String"
			};

		_methodName618 = "updateJobQueueStatus";

		_methodParameterTypes618 = new String[] {
				"long", "java.lang.String", "java.util.Date", "java.util.Date",
				"java.lang.String"
			};

		_methodName619 = "getJobQueuesByOwnerAndType";

		_methodParameterTypes619 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName620 = "getJobQueuesByOwnerTypeAndStatus";

		_methodParameterTypes620 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName621 = "getJobQueuesByType";

		_methodParameterTypes621 = new String[] { "java.lang.String" };

		_methodName622 = "getJobQueuesByTypeAndStatus";

		_methodParameterTypes622 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName623 = "getJobQueuesByOwner";

		_methodParameterTypes623 = new String[] { "java.lang.String" };

		_methodName624 = "getJobQueuesByOwnerAndStatus";

		_methodParameterTypes624 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName625 = "getUniqueJobQueTypes";

		_methodParameterTypes625 = new String[] {  };

		_methodName626 = "getFileAsByteStream";

		_methodParameterTypes626 = new String[] { "long" };

		_methodName627 = "getImageAsByteStream";

		_methodParameterTypes627 = new String[] { "long", "boolean" };

		_methodName628 = "isJobQueueExistWithSameMetadata";

		_methodParameterTypes628 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName629 = "isJobQueueExistWithSameMetadata";

		_methodParameterTypes629 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName630 = "getJobQueuesExceptFullManuals";

		_methodParameterTypes630 = new String[] {  };

		_methodName631 = "clearCache";

		_methodParameterTypes631 = new String[] {  };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return JobQueueLocalServiceUtil.addJobQueue((com.ihg.brandstandards.db.model.JobQueue)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return JobQueueLocalServiceUtil.createJobQueue(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return JobQueueLocalServiceUtil.deleteJobQueue(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return JobQueueLocalServiceUtil.deleteJobQueue((com.ihg.brandstandards.db.model.JobQueue)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return JobQueueLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return JobQueueLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return JobQueueLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return JobQueueLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return JobQueueLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return JobQueueLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return JobQueueLocalServiceUtil.fetchJobQueue(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return JobQueueLocalServiceUtil.getJobQueue(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return JobQueueLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return JobQueueLocalServiceUtil.getJobQueues(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return JobQueueLocalServiceUtil.getJobQueuesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return JobQueueLocalServiceUtil.updateJobQueue((com.ihg.brandstandards.db.model.JobQueue)arguments[0]);
		}

		if (_methodName608.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes608, parameterTypes)) {
			return JobQueueLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName609.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes609, parameterTypes)) {
			JobQueueLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName614.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes614, parameterTypes)) {
			return JobQueueLocalServiceUtil.insertJobQueueUsingOraSequence((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5]);
		}

		if (_methodName615.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes615, parameterTypes)) {
			JobQueueLocalServiceUtil.addNewJobRequest((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3]);

			return null;
		}

		if (_methodName616.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes616, parameterTypes)) {
			return JobQueueLocalServiceUtil.addJobQueue((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.util.Date)arguments[5], (java.util.Date)arguments[6],
				(java.lang.String)arguments[7], (java.lang.String)arguments[8],
				(java.util.Date)arguments[9], (java.lang.String)arguments[10],
				(java.util.Date)arguments[11]);
		}

		if (_methodName617.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes617, parameterTypes)) {
			return JobQueueLocalServiceUtil.updateJobQueue(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.util.Date)arguments[6],
				(java.util.Date)arguments[7], (java.lang.String)arguments[8],
				(java.lang.String)arguments[9]);
		}

		if (_methodName618.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes618, parameterTypes)) {
			return JobQueueLocalServiceUtil.updateJobQueueStatus(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.util.Date)arguments[2],
				(java.util.Date)arguments[3], (java.lang.String)arguments[4]);
		}

		if (_methodName619.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes619, parameterTypes)) {
			return JobQueueLocalServiceUtil.getJobQueuesByOwnerAndType((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName620.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes620, parameterTypes)) {
			return JobQueueLocalServiceUtil.getJobQueuesByOwnerTypeAndStatus((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName621.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes621, parameterTypes)) {
			return JobQueueLocalServiceUtil.getJobQueuesByType((java.lang.String)arguments[0]);
		}

		if (_methodName622.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes622, parameterTypes)) {
			return JobQueueLocalServiceUtil.getJobQueuesByTypeAndStatus((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName623.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes623, parameterTypes)) {
			return JobQueueLocalServiceUtil.getJobQueuesByOwner((java.lang.String)arguments[0]);
		}

		if (_methodName624.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes624, parameterTypes)) {
			return JobQueueLocalServiceUtil.getJobQueuesByOwnerAndStatus((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName625.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes625, parameterTypes)) {
			return JobQueueLocalServiceUtil.getUniqueJobQueTypes();
		}

		if (_methodName626.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes626, parameterTypes)) {
			return JobQueueLocalServiceUtil.getFileAsByteStream(((Long)arguments[0]).longValue());
		}

		if (_methodName627.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes627, parameterTypes)) {
			return JobQueueLocalServiceUtil.getImageAsByteStream(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName628.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes628, parameterTypes)) {
			return JobQueueLocalServiceUtil.isJobQueueExistWithSameMetadata((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName629.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes629, parameterTypes)) {
			return JobQueueLocalServiceUtil.isJobQueueExistWithSameMetadata((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3]);
		}

		if (_methodName630.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes630, parameterTypes)) {
			return JobQueueLocalServiceUtil.getJobQueuesExceptFullManuals();
		}

		if (_methodName631.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes631, parameterTypes)) {
			JobQueueLocalServiceUtil.clearCache();

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName608;
	private String[] _methodParameterTypes608;
	private String _methodName609;
	private String[] _methodParameterTypes609;
	private String _methodName614;
	private String[] _methodParameterTypes614;
	private String _methodName615;
	private String[] _methodParameterTypes615;
	private String _methodName616;
	private String[] _methodParameterTypes616;
	private String _methodName617;
	private String[] _methodParameterTypes617;
	private String _methodName618;
	private String[] _methodParameterTypes618;
	private String _methodName619;
	private String[] _methodParameterTypes619;
	private String _methodName620;
	private String[] _methodParameterTypes620;
	private String _methodName621;
	private String[] _methodParameterTypes621;
	private String _methodName622;
	private String[] _methodParameterTypes622;
	private String _methodName623;
	private String[] _methodParameterTypes623;
	private String _methodName624;
	private String[] _methodParameterTypes624;
	private String _methodName625;
	private String[] _methodParameterTypes625;
	private String _methodName626;
	private String[] _methodParameterTypes626;
	private String _methodName627;
	private String[] _methodParameterTypes627;
	private String _methodName628;
	private String[] _methodParameterTypes628;
	private String _methodName629;
	private String[] _methodParameterTypes629;
	private String _methodName630;
	private String[] _methodParameterTypes630;
	private String _methodName631;
	private String[] _methodParameterTypes631;
}