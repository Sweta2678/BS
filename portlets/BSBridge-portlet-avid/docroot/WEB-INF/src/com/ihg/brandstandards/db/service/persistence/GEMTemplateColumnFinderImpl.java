package com.ihg.brandstandards.db.service.persistence;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;

import com.ihg.brandstandards.db.model.GEMTemplateColumn;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class GEMTemplateColumnFinderImpl extends BasePersistenceImpl<GEMTemplateColumn> implements  GEMTemplateColumnFinder {
	
	public boolean addConfigurationDetails (long templateId, Iterator<Cell> columns) {
		return false;
	}

}
