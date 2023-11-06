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

package com.ihg.brandstandards.db.service;

import com.liferay.portal.service.InvokableLocalService;

/**
 * @author Mummanedi
 * @generated
 */
public class BridgePublishLocalServiceClp implements BridgePublishLocalService {
	public BridgePublishLocalServiceClp(
		InvokableLocalService invokableLocalService) {
		_invokableLocalService = invokableLocalService;

		_methodName0 = "addBridgePublish";

		_methodParameterTypes0 = new String[] {
				"com.ihg.brandstandards.db.model.BridgePublish"
			};

		_methodName1 = "createBridgePublish";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteBridgePublish";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteBridgePublish";

		_methodParameterTypes3 = new String[] {
				"com.ihg.brandstandards.db.model.BridgePublish"
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

		_methodName10 = "fetchBridgePublish";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getBridgePublish";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getBridgePublishs";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getBridgePublishsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateBridgePublish";

		_methodParameterTypes15 = new String[] {
				"com.ihg.brandstandards.db.model.BridgePublish"
			};

		_methodName16 = "getBeanIdentifier";

		_methodParameterTypes16 = new String[] {  };

		_methodName17 = "setBeanIdentifier";

		_methodParameterTypes17 = new String[] { "java.lang.String" };

		_methodName19 = "clearCache";

		_methodParameterTypes19 = new String[] {  };

		_methodName20 = "getByPublish";

		_methodParameterTypes20 = new String[] { "long" };

		_methodName21 = "getByPublishIdAndStdId";

		_methodParameterTypes21 = new String[] { "long", "long" };

		_methodName22 = "getByPublishIdAndRegionId";

		_methodParameterTypes22 = new String[] { "long", "long" };

		_methodName23 = "getByPublishIdRegionIdAndStdId";

		_methodParameterTypes23 = new String[] { "long", "long", "long" };

		_methodName24 = "getStandardIds";

		_methodParameterTypes24 = new String[] { "long" };

		_methodName25 = "getBridgeProgress";

		_methodParameterTypes25 = new String[] {
				"long", "java.lang.String", "java.util.Date", "long", "boolean",
				"java.lang.String"
			};

		_methodName26 = "getOverallProgress";

		_methodParameterTypes26 = new String[] { "long", "long", "boolean" };

		_methodName27 = "getTranslationProgress";

		_methodParameterTypes27 = new String[] { "long", "long", "boolean" };

		_methodName28 = "getIndexTranslationProgress";

		_methodParameterTypes28 = new String[] {
				"long", "java.lang.String", "long", "boolean"
			};

		_methodName29 = "getProgressViewDetailsStandards";

		_methodParameterTypes29 = new String[] {
				"long", "long", "java.lang.String", "java.util.Date",
				"java.lang.String", "java.lang.String"
			};

		_methodName30 = "getUnpublishedDetailsStandards";

		_methodParameterTypes30 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName31 = "getTranslationViewDetailsStandards";

		_methodParameterTypes31 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName32 = "getPublishQueueRecords";

		_methodParameterTypes32 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName33 = "resetBridgePublication";

		_methodParameterTypes33 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String"
			};

		_methodName34 = "updateUnpublishedToPublishedRecords";

		_methodParameterTypes34 = new String[] {
				"long", "java.lang.String", "long", "java.lang.String",
				"java.lang.String"
			};

		_methodName35 = "createDraftPublication";

		_methodParameterTypes35 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName36 = "getMyPublicationByBrand";

		_methodParameterTypes36 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName37 = "getStandardCountForPublication";

		_methodParameterTypes37 = new String[] { "long" };

		_methodName38 = "createOraSequence";

		_methodParameterTypes38 = new String[] {  };

		_methodName39 = "updateBridgePublishAndCountryFromImport";

		_methodParameterTypes39 = new String[] {
				"long", "long", "java.lang.String", "long", "java.lang.String"
			};

		_methodName40 = "getBridgePublishStandardsByParent";

		_methodParameterTypes40 = new String[] { "java.lang.String" };

		_methodName41 = "getBridgePublishStandardsById";

		_methodParameterTypes41 = new String[] { "java.lang.String" };

		_methodName42 = "getStandardDetails";

		_methodParameterTypes42 = new String[] { "java.lang.String" };

		_methodName43 = "getPublishedStandardsCompliance";

		_methodParameterTypes43 = new String[] {
				"java.util.List", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName44 = "getPublishedStandardComplianceDetails";

		_methodParameterTypes44 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName45 = "getBridgeStandardsCompliance";

		_methodParameterTypes45 = new String[] {
				"java.util.List", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName46 = "getBridgeStandardComplianceDetails";

		_methodParameterTypes46 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName47 = "createManuals";

		_methodParameterTypes47 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String"
			};

		_methodName48 = "getMissingReferences";

		_methodParameterTypes48 = new String[] { "long", "long" };

		_methodName49 = "addStdToBridgeForAddById";

		_methodParameterTypes49 = new String[] {
				"long", "long", "java.lang.String", "long", "java.util.List",
				"java.lang.String"
			};

		_methodName50 = "getBridgePublishIdsByStdId";

		_methodParameterTypes50 = new String[] { "long" };

		_methodName51 = "getRegionsByPublishIdAndStdId";

		_methodParameterTypes51 = new String[] { "long", "long" };
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublish addBridgePublish(
		com.ihg.brandstandards.db.model.BridgePublish bridgePublish)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName0,
					_methodParameterTypes0,
					new Object[] { ClpSerializer.translateInput(bridgePublish) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.ihg.brandstandards.db.model.BridgePublish)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublish createBridgePublish(
		long bridgePublishId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName1,
					_methodParameterTypes1, new Object[] { bridgePublishId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.ihg.brandstandards.db.model.BridgePublish)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublish deleteBridgePublish(
		long bridgePublishId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName2,
					_methodParameterTypes2, new Object[] { bridgePublishId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.ihg.brandstandards.db.model.BridgePublish)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublish deleteBridgePublish(
		com.ihg.brandstandards.db.model.BridgePublish bridgePublish)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] { ClpSerializer.translateInput(bridgePublish) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.ihg.brandstandards.db.model.BridgePublish)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName4,
					_methodParameterTypes4, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.dao.orm.DynamicQuery)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] { ClpSerializer.translateInput(dynamicQuery) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] {
						ClpSerializer.translateInput(dynamicQuery),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] {
						ClpSerializer.translateInput(dynamicQuery),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName8,
					_methodParameterTypes8,
					new Object[] { ClpSerializer.translateInput(dynamicQuery) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] {
						ClpSerializer.translateInput(dynamicQuery),
						
					ClpSerializer.translateInput(projection)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublish fetchBridgePublish(
		long bridgePublishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName10,
					_methodParameterTypes10, new Object[] { bridgePublishId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.ihg.brandstandards.db.model.BridgePublish)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublish getBridgePublish(
		long bridgePublishId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName11,
					_methodParameterTypes11, new Object[] { bridgePublishId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.ihg.brandstandards.db.model.BridgePublish)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName12,
					_methodParameterTypes12,
					new Object[] { ClpSerializer.translateInput(primaryKeyObj) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.model.PersistedModel)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublish> getBridgePublishs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName13,
					_methodParameterTypes13, new Object[] { start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.ihg.brandstandards.db.model.BridgePublish>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int getBridgePublishsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName14,
					_methodParameterTypes14, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublish updateBridgePublish(
		com.ihg.brandstandards.db.model.BridgePublish bridgePublish)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName15,
					_methodParameterTypes15,
					new Object[] { ClpSerializer.translateInput(bridgePublish) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.ihg.brandstandards.db.model.BridgePublish)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName16,
					_methodParameterTypes16, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		try {
			_invokableLocalService.invokeMethod(_methodName17,
				_methodParameterTypes17,
				new Object[] { ClpSerializer.translateInput(beanIdentifier) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clearCache() {
		try {
			_invokableLocalService.invokeMethod(_methodName19,
				_methodParameterTypes19, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublish> getByPublish(
		long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName20,
					_methodParameterTypes20, new Object[] { publishId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.ihg.brandstandards.db.model.BridgePublish>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublish> getByPublishIdAndStdId(
		long publishId, long standardId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName21,
					_methodParameterTypes21,
					new Object[] { publishId, standardId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.ihg.brandstandards.db.model.BridgePublish>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublish> getByPublishIdAndRegionId(
		long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName22,
					_methodParameterTypes22,
					new Object[] { publishId, regionId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.ihg.brandstandards.db.model.BridgePublish>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublish getByPublishIdRegionIdAndStdId(
		long publishId, long regionCode, long standardId)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName23,
					_methodParameterTypes23,
					new Object[] { publishId, regionCode, standardId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.ihg.brandstandards.db.NoSuchBridgePublishException) {
				throw (com.ihg.brandstandards.db.NoSuchBridgePublishException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.ihg.brandstandards.db.model.BridgePublish)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<java.lang.Long> getStandardIds(long publishId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName24,
					_methodParameterTypes24, new Object[] { publishId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<java.lang.Long>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.Long> getBridgeProgress(
		long publishId, java.lang.String chainCode, java.util.Date publishDate,
		long regionId, boolean allRegions, java.lang.String progressType)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName25,
					_methodParameterTypes25,
					new Object[] {
						publishId,
						
					ClpSerializer.translateInput(chainCode),
						
					ClpSerializer.translateInput(publishDate),
						
					regionId,
						
					allRegions,
						
					ClpSerializer.translateInput(progressType)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Map<java.lang.String, java.lang.Long>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.Long> getOverallProgress(
		long publishId, long regionId, boolean allRegions) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName26,
					_methodParameterTypes26,
					new Object[] { publishId, regionId, allRegions });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Map<java.lang.String, java.lang.Long>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.Long> getTranslationProgress(
		long publishId, long regionId, boolean allRegions)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName27,
					_methodParameterTypes27,
					new Object[] { publishId, regionId, allRegions });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Map<java.lang.String, java.lang.Long>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.Long> getIndexTranslationProgress(
		long publishId, java.lang.String chainCode, long regionId,
		boolean allRegions)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName28,
					_methodParameterTypes28,
					new Object[] {
						publishId,
						
					ClpSerializer.translateInput(chainCode),
						
					regionId,
						
					allRegions
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Map<java.lang.String, java.lang.Long>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getProgressViewDetailsStandards(
		long publishId, long regionId, java.lang.String chainCode,
		java.util.Date publishDate, java.lang.String localeCode,
		java.lang.String statIndText) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName29,
					_methodParameterTypes29,
					new Object[] {
						publishId,
						
					regionId,
						
					ClpSerializer.translateInput(chainCode),
						
					ClpSerializer.translateInput(publishDate),
						
					ClpSerializer.translateInput(localeCode),
						
					ClpSerializer.translateInput(statIndText)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getUnpublishedDetailsStandards(
		long publishId, long regionId, java.lang.String chainCode,
		java.lang.String regionCode, java.lang.String stdIds) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName30,
					_methodParameterTypes30,
					new Object[] {
						publishId,
						
					regionId,
						
					ClpSerializer.translateInput(chainCode),
						
					ClpSerializer.translateInput(regionCode),
						
					ClpSerializer.translateInput(stdIds)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List getTranslationViewDetailsStandards(long publishId,
		long regionId, java.lang.String localeCode) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName31,
					_methodParameterTypes31,
					new Object[] {
						publishId,
						
					regionId,
						
					ClpSerializer.translateInput(localeCode)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishQueue> getPublishQueueRecords(
		java.lang.String brandCode, java.lang.String environment,
		java.lang.String status) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName32,
					_methodParameterTypes32,
					new Object[] {
						ClpSerializer.translateInput(brandCode),
						
					ClpSerializer.translateInput(environment),
						
					ClpSerializer.translateInput(status)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.ihg.brandstandards.db.model.PublishQueue>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void resetBridgePublication(long bridgePublishId, long regionId,
		java.lang.String chainCode, java.lang.String userScreenName)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName33,
				_methodParameterTypes33,
				new Object[] {
					bridgePublishId,
					
				regionId,
					
				ClpSerializer.translateInput(chainCode),
					
				ClpSerializer.translateInput(userScreenName)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void updateUnpublishedToPublishedRecords(long publishId,
		java.lang.String brandCode, long regionId, java.lang.String screenName,
		java.lang.String stdIds) {
		try {
			_invokableLocalService.invokeMethod(_methodName34,
				_methodParameterTypes34,
				new Object[] {
					publishId,
					
				ClpSerializer.translateInput(brandCode),
					
				regionId,
					
				ClpSerializer.translateInput(screenName),
					
				ClpSerializer.translateInput(stdIds)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void createDraftPublication(long publishId,
		java.lang.String brandCode, java.lang.String screenName) {
		try {
			_invokableLocalService.invokeMethod(_methodName35,
				_methodParameterTypes35,
				new Object[] {
					publishId,
					
				ClpSerializer.translateInput(brandCode),
					
				ClpSerializer.translateInput(screenName)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getMyPublicationByBrand(
		java.lang.String chainCode, java.lang.String regionCode,
		java.lang.String query)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName36,
					_methodParameterTypes36,
					new Object[] {
						ClpSerializer.translateInput(chainCode),
						
					ClpSerializer.translateInput(regionCode),
						
					ClpSerializer.translateInput(query)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public long getStandardCountForPublication(long publishId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName37,
					_methodParameterTypes37, new Object[] { publishId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublish createOraSequence()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName38,
					_methodParameterTypes38, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.ihg.brandstandards.db.model.BridgePublish)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public boolean updateBridgePublishAndCountryFromImport(
		long bridgePublishId, long prodPublishId, java.lang.String brandCode,
		long regionId, java.lang.String screenName)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName39,
					_methodParameterTypes39,
					new Object[] {
						bridgePublishId,
						
					prodPublishId,
						
					ClpSerializer.translateInput(brandCode),
						
					regionId,
						
					ClpSerializer.translateInput(screenName)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public java.util.List<java.lang.Long> getBridgePublishStandardsByParent(
		java.lang.String query)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName40,
					_methodParameterTypes40,
					new Object[] { ClpSerializer.translateInput(query) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<java.lang.Long>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublish getBridgePublishStandardsById(
		java.lang.String query)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName41,
					_methodParameterTypes41,
					new Object[] { ClpSerializer.translateInput(query) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.ihg.brandstandards.db.model.BridgePublish)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.custom.model.Standard> getStandardDetails(
		java.lang.String query) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName42,
					_methodParameterTypes42,
					new Object[] { ClpSerializer.translateInput(query) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.ihg.brandstandards.custom.model.Standard>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getPublishedStandardsCompliance(
		java.util.List<java.lang.Long> stdIds, java.lang.String stdType,
		java.lang.String brandCd, java.lang.String regionCode,
		java.lang.String fromDate, java.lang.String toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName43,
					_methodParameterTypes43,
					new Object[] {
						ClpSerializer.translateInput(stdIds),
						
					ClpSerializer.translateInput(stdType),
						
					ClpSerializer.translateInput(brandCd),
						
					ClpSerializer.translateInput(regionCode),
						
					ClpSerializer.translateInput(fromDate),
						
					ClpSerializer.translateInput(toDate)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getPublishedStandardComplianceDetails(
		long stdId, java.lang.String brandCode, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName44,
					_methodParameterTypes44,
					new Object[] {
						stdId,
						
					ClpSerializer.translateInput(brandCode),
						
					ClpSerializer.translateInput(regionCode)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Map<java.lang.String, java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getBridgeStandardsCompliance(
		java.util.List<java.lang.Long> stdIds, java.lang.String stdType,
		java.lang.String brandCd, java.lang.String regionCode,
		java.lang.String fromDate, java.lang.String toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName45,
					_methodParameterTypes45,
					new Object[] {
						ClpSerializer.translateInput(stdIds),
						
					ClpSerializer.translateInput(stdType),
						
					ClpSerializer.translateInput(brandCd),
						
					ClpSerializer.translateInput(regionCode),
						
					ClpSerializer.translateInput(fromDate),
						
					ClpSerializer.translateInput(toDate)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getBridgeStandardComplianceDetails(
		long stdId, java.lang.String brandCode, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName46,
					_methodParameterTypes46,
					new Object[] {
						stdId,
						
					ClpSerializer.translateInput(brandCode),
						
					ClpSerializer.translateInput(regionCode)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Map<java.lang.String, java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void createManuals(long publishQueueId, long publishId,
		java.lang.String emailAddress, java.lang.String userName) {
		try {
			_invokableLocalService.invokeMethod(_methodName47,
				_methodParameterTypes47,
				new Object[] {
					publishQueueId,
					
				publishId,
					
				ClpSerializer.translateInput(emailAddress),
					
				ClpSerializer.translateInput(userName)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.util.List<java.lang.Long> getMissingReferences(long publishId,
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName48,
					_methodParameterTypes48,
					new Object[] { publishId, regionId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<java.lang.Long>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void addStdToBridgeForAddById(long bridgePublishId,
		long prodPublishId, java.lang.String brandCode, long regionId,
		java.util.List<java.lang.Long> stdIds, java.lang.String screenName) {
		try {
			_invokableLocalService.invokeMethod(_methodName49,
				_methodParameterTypes49,
				new Object[] {
					bridgePublishId,
					
				prodPublishId,
					
				ClpSerializer.translateInput(brandCode),
					
				regionId,
					
				ClpSerializer.translateInput(stdIds),
					
				ClpSerializer.translateInput(screenName)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.util.List<java.lang.Long> getBridgePublishIdsByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName50,
					_methodParameterTypes50, new Object[] { stdId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<java.lang.Long>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<java.lang.Long> getRegionsByPublishIdAndStdId(
		long publishId, long stdId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName51,
					_methodParameterTypes51, new Object[] { publishId, stdId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<java.lang.Long>)ClpSerializer.translateOutput(returnObj);
	}

	private InvokableLocalService _invokableLocalService;
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
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName20;
	private String[] _methodParameterTypes20;
	private String _methodName21;
	private String[] _methodParameterTypes21;
	private String _methodName22;
	private String[] _methodParameterTypes22;
	private String _methodName23;
	private String[] _methodParameterTypes23;
	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName25;
	private String[] _methodParameterTypes25;
	private String _methodName26;
	private String[] _methodParameterTypes26;
	private String _methodName27;
	private String[] _methodParameterTypes27;
	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
	private String _methodName30;
	private String[] _methodParameterTypes30;
	private String _methodName31;
	private String[] _methodParameterTypes31;
	private String _methodName32;
	private String[] _methodParameterTypes32;
	private String _methodName33;
	private String[] _methodParameterTypes33;
	private String _methodName34;
	private String[] _methodParameterTypes34;
	private String _methodName35;
	private String[] _methodParameterTypes35;
	private String _methodName36;
	private String[] _methodParameterTypes36;
	private String _methodName37;
	private String[] _methodParameterTypes37;
	private String _methodName38;
	private String[] _methodParameterTypes38;
	private String _methodName39;
	private String[] _methodParameterTypes39;
	private String _methodName40;
	private String[] _methodParameterTypes40;
	private String _methodName41;
	private String[] _methodParameterTypes41;
	private String _methodName42;
	private String[] _methodParameterTypes42;
	private String _methodName43;
	private String[] _methodParameterTypes43;
	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName45;
	private String[] _methodParameterTypes45;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName51;
	private String[] _methodParameterTypes51;
}