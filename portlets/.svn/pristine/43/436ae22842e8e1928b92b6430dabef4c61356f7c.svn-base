
package com.ihg.grs.util;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Group;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.announcements.model.AnnouncementsEntry;
import com.liferay.portlet.announcements.service.AnnouncementsEntryLocalServiceUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Utility class of WhatsHappeningUtil.
 */
public final class WhatsHappeningUtil
{

	private static final Log LOGGER = LogFactoryUtil.getLog(WhatsHappeningUtil.class);

	/**
	 * Define a private constructor.
	 */
	private WhatsHappeningUtil()
	{
	}

	/**
	 * @param groupId
	 *            Site groupid
	 * @param start
	 *            Start
	 * @param end
	 *            End
	 * @return announcementsEntries
	 */
	public static List<AnnouncementsEntry> getAnnouncementsEntries(long groupId, int start, int end)
	{
		List<AnnouncementsEntry> announcementsEntries = null;
		try
		{
			DynamicQuery dynamicQuery = getAnnouncementsEntriesDynamicQuery(groupId);
			announcementsEntries = AnnouncementsEntryLocalServiceUtil.dynamicQuery(dynamicQuery, start, end);
		}
		catch (SystemException e)
		{
			LOGGER.error("Error while fetching announcementsEntries.", e);
		}

		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("No of annoucements: " + (announcementsEntries == null ? 0 : announcementsEntries.size()));
		}

		return announcementsEntries;
	}

	/**
	 * @param groupId
	 *            Site groupId
	 * @return count
	 */
	public static long getAnnouncementsEntriesCount(long groupId)
	{
		long count = 0;
		try
		{
			DynamicQuery dynamicQuery = getAnnouncementsEntriesDynamicQuery(groupId);
			count = AnnouncementsEntryLocalServiceUtil.dynamicQueryCount(dynamicQuery);
		}
		catch (SystemException e)
		{
			LOGGER.error(e.getMessage());
		}

		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Total Annoucements count = " + count);
		}

		return count;
	}

	/**
	 * @param groupId
	 *            Site groupId
	 * @return dynamicQuery
	 */
	private static DynamicQuery getAnnouncementsEntriesDynamicQuery(long groupId)
	{
		long classNameId = GetterUtil.getLong(PortalUtil.getClassNameId(Group.class));
		long classPK = groupId;

		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug(String.format("classNameId=%d, classPK=%d", classNameId, classPK));
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnnouncementsEntry.class);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("classNameId", classNameId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("classPK", classPK));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("displayDate"));

		return dynamicQuery;
	}

	/**
	 * @param date
	 *            passing Date
	 * @return dateString
	 */
	public static String getAnnouncementDate(Date date)
	{
		StringBuilder dateString = new StringBuilder();
		Calendar calendar = new GregorianCalendar();

		// Old logic for date calculation
		Date current = calendar.getTime();
		long diff = current.getTime() - date.getTime();
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);

		/*
		 * New logic for date calculation int daysNow =
		 * calendar.get(Calendar.DAY_OF_YEAR); int hoursNow =
		 * calendar.get(Calendar.HOUR); int minuteNow =
		 * calendar.get(Calendar.MINUTE); calendar.setTime(date); int diffDays =
		 * daysNow - calendar.get(Calendar.DAY_OF_YEAR); int hour =
		 * calendar.get(Calendar.HOUR); int minute =
		 * calendar.get(Calendar.MINUTE); int diffHours = hoursNow - hour; int
		 * diffMinutes = minuteNow - minute;
		 */

		String AM_PM = "";
		switch (calendar.get(Calendar.AM_PM))
		{
		case Calendar.AM:
			AM_PM = "AM";
			break;
		case Calendar.PM:
			AM_PM = "PM";
		}
		if (diffDays < 2)
		{
			if (diffDays < 1)
			{
				if (diffHours < 1)
				{
					if (diffMinutes < 1)
					{
						dateString.append("Just Now");
					}
					else
					{
						dateString.append(diffMinutes).append(StringPool.SPACE).append(diffMinutes == 1 ? "minute" : "minutes").append(" ago");
					}
				}
				else
				{
					dateString.append(diffHours).append(StringPool.SPACE).append(diffHours == 1 ? "hour" : "hours").append(" ago");
				}
			}
			else
			{
				dateString.append("Yesterday");
			}
		}
		else
		{
			dateString.append(diffDays).append(StringPool.SPACE).append(diffDays == 1 ? "day" : "days").append(" ago");
		}
		dateString.append(StringPool.SPACE).append(hour).append(":").append(minute < 10 ? "0" : "").append(minute).append(StringPool.SPACE).append(AM_PM);

		return dateString.toString();
	}
}
