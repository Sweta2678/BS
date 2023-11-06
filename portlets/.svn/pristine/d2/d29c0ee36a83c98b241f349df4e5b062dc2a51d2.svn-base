
package com.ihg.grs.util;

import com.ihg.grs.common.model.Directory;

import com.ihg.grs.common.service.DirectoryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;

import java.util.List;

/**
 * Utility class of DirectoryUtil.
 */
public final class DirectoryUtil
{

	private static final Log LOGGER = LogFactoryUtil.getLog(DirectoryUtil.class);

	/**
	 * Define a private constructor.
	 */
	private DirectoryUtil()
	{
	}
	/**
	 * 
	 * @param start Start
	 * @param end End
	 * @param sortBy column name
	 * @param sortOrder asc or desc
	 * @return directories
	 */
	public static List<Directory> getDirectories(int start, int end, String sortBy, String sortOrder)
	{
		List<Directory> directories = null;

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Directory.class, PortletClassLoaderUtil.getClassLoader());

		if ("asc".equalsIgnoreCase(sortOrder))
		{
			dynamicQuery.addOrder(OrderFactoryUtil.asc(sortBy));
		}
		else
		{
			dynamicQuery.addOrder(OrderFactoryUtil.desc(sortBy));
		}

		try
		{
			directories = DirectoryLocalServiceUtil.dynamicQuery(dynamicQuery, start, end);
		}
		catch (SystemException e)
		{
			LOGGER.error("Error while fetching directories.", e);
		}

		return directories;
	}

}
