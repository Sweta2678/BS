package com.ihgtss.portal.events;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.NoSuchTableException;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoColumnConstants;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.portlet.journal.model.JournalArticle;

public class ExpandoCreationAction extends SimpleAction {

	private static final Log LOGGER = LogFactoryUtil.getLog(ExpandoCreationAction.class);
	private static final String ERROR_MESSAGE_ADD = " Error adding default table";
	private static final String ERROR_MESSAGE_ADD_COLUMN_COMPANY = " Error adding column to default table for company ";
	
	/*
	 * (non-Java-doc)
	 * 
	 * @see com.liferay.portal.kernel.events.SimpleAction#SimpleAction()
	 */
	public ExpandoCreationAction() {

		super();
	}

	private long addExpandoTable(long companyId)
			throws PortalException, SystemException {

		ExpandoTable tbl = null;
		CompanyThreadLocal.setCompanyId(companyId);
		try {
			tbl = ExpandoTableLocalServiceUtil.getDefaultTable(companyId, JournalArticle.class.getName());
		} catch (NoSuchTableException e) {
			tbl = ExpandoTableLocalServiceUtil.addDefaultTable(companyId, JournalArticle.class.getName());
		} finally {
			if (tbl == null) {
				throw new SystemException("Could not get/create expando table");
			}
		}
		return tbl.getTableId();
	}
	
	private void addExpandoColumn(long companyId, long tableId, String columnName, int itemType)
			throws PortalException, SystemException {
		
		ExpandoColumn col = null;
		try {
			col = ExpandoColumnLocalServiceUtil.getColumn(tableId, columnName);
		} catch (SystemException e) {
			col = ExpandoColumnLocalServiceUtil.addColumn(tableId,	columnName, itemType);
		} finally {
			if (col == null) {
				throw new SystemException("Could not get/create expando column : "+columnName);
			}
		}
		ExpandoBridge expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(companyId, JournalArticle.class.getName());
		
		/*UnicodeProperties properties = expandoBridge.getAttributeProperties(col.getName());
		properties.setProperty(ExpandoBridgeIndexer.INDEXABLE, Boolean.TRUE.toString());
		col.setTypeSettingsProperties(properties);*/
		UnicodeProperties properties = expandoBridge.getAttributeProperties(col.getName());
		properties.setProperty(ExpandoColumnConstants.INDEX_TYPE, Boolean.TRUE.toString());
		col.setTypeSettingsProperties(properties);
		ExpandoColumnLocalServiceUtil.updateExpandoColumn(col);
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see com.liferay.portal.kernel.events.SimpleAction#run(String[] ids)
	 */
	public void run(String[] ids) throws ActionException {

		long[] companyIds = PortalUtil.getCompanyIds();
		for (long companyId : companyIds) {
			try {
				long tableId = addExpandoTable(companyId);
				addExpandoColumn(companyId, tableId, "averageScore", ExpandoColumnConstants.DOUBLE);
				addExpandoColumn(companyId, tableId, "articleStatus", ExpandoColumnConstants.INTEGER);
			} catch (PortalException e1) {
				LOGGER.error(ERROR_MESSAGE_ADD, e1);
				return;
			} catch (SystemException e2) {
				LOGGER.error(ERROR_MESSAGE_ADD_COLUMN_COMPANY, e2);
				return;
			}
		}
	}
}
