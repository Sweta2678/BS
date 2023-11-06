
package com.ihg.grs.util;

import com.ihg.grs.constant.ApplicationConstants;

import com.liferay.portal.kernel.util.StringPool;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author PatelHiren
 * Utility class of DateUtil.
 */
public final class DateUtil
{

	/**
	 * Define a private constructor.
	 */
	private DateUtil()
	{
	}
	
	/**
	 * @param date passing date
	 * @param format passsing display date format
	 * @return df.format
	 */
	public static String getFormattedDate(Date date, String format)
	{
		DateFormat df = new SimpleDateFormat(format);
		return  df.format(date);
	}

	/**
	 * @param dateString passing date
	 * @param format passsing display date format
	 * @return df.format
	 * @throws ParseException 
	 */
	public static String getFormattedDate(String dateString, String format) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date =  df.parse(dateString);
		
		return  dateFormat.format(date);
	}
	/**
	 * @param date passing date
	 * @param format passsing display date format
	 * @return dateStr
	 */
	public static String getFormattedDateEST(Date date, String format)
	{
		DateFormat df = new SimpleDateFormat(format);
		df.setTimeZone(TimeZone.getTimeZone(ApplicationConstants.COMMENT_DATE_TIMEZONE));
		String dateStr = df.format(date);
		dateStr = dateStr + StringPool.SPACE + ApplicationConstants.COMMENT_TIMEZONE;
		return dateStr;
	}

}
