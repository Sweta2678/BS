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

package com.ihg.brandstandards.db.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Mummanedi
 * @generated
 */
public class BridgeProgressDiscrepancyPK implements Comparable<BridgeProgressDiscrepancyPK>,
	Serializable {
	public long progressCategoryId;
	public long progressSubCategoryId;
	public long publishId;
	public long regionId;

	public BridgeProgressDiscrepancyPK() {
	}

	public BridgeProgressDiscrepancyPK(long progressCategoryId,
		long progressSubCategoryId, long publishId, long regionId) {
		this.progressCategoryId = progressCategoryId;
		this.progressSubCategoryId = progressSubCategoryId;
		this.publishId = publishId;
		this.regionId = regionId;
	}

	public long getProgressCategoryId() {
		return progressCategoryId;
	}

	public void setProgressCategoryId(long progressCategoryId) {
		this.progressCategoryId = progressCategoryId;
	}

	public long getProgressSubCategoryId() {
		return progressSubCategoryId;
	}

	public void setProgressSubCategoryId(long progressSubCategoryId) {
		this.progressSubCategoryId = progressSubCategoryId;
	}

	public long getPublishId() {
		return publishId;
	}

	public void setPublishId(long publishId) {
		this.publishId = publishId;
	}

	public long getRegionId() {
		return regionId;
	}

	public void setRegionId(long regionId) {
		this.regionId = regionId;
	}

	@Override
	public int compareTo(BridgeProgressDiscrepancyPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (progressCategoryId < pk.progressCategoryId) {
			value = -1;
		}
		else if (progressCategoryId > pk.progressCategoryId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (progressSubCategoryId < pk.progressSubCategoryId) {
			value = -1;
		}
		else if (progressSubCategoryId > pk.progressSubCategoryId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (publishId < pk.publishId) {
			value = -1;
		}
		else if (publishId > pk.publishId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (regionId < pk.regionId) {
			value = -1;
		}
		else if (regionId > pk.regionId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BridgeProgressDiscrepancyPK)) {
			return false;
		}

		BridgeProgressDiscrepancyPK pk = (BridgeProgressDiscrepancyPK)obj;

		if ((progressCategoryId == pk.progressCategoryId) &&
				(progressSubCategoryId == pk.progressSubCategoryId) &&
				(publishId == pk.publishId) && (regionId == pk.regionId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(progressCategoryId) +
		String.valueOf(progressSubCategoryId) + String.valueOf(publishId) +
		String.valueOf(regionId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(20);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("progressCategoryId");
		sb.append(StringPool.EQUAL);
		sb.append(progressCategoryId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("progressSubCategoryId");
		sb.append(StringPool.EQUAL);
		sb.append(progressSubCategoryId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("publishId");
		sb.append(StringPool.EQUAL);
		sb.append(publishId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("regionId");
		sb.append(StringPool.EQUAL);
		sb.append(regionId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}