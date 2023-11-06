package com.ihg.me2.framework.custom.security.utils;



/**
 * Utility functions.
 * @author SheladG
 *
 */
public class GlobalUtil 
{

	/**
	 * Extract out the code from full value.
	 * @param value
	 * @return
	 */
	public static String getKeyCode(String sValue)
	{
		String value = sValue;
		if (value != null && !"".equals(value))
		{
			int startPos = value.indexOf("[");
			int endPos = value.indexOf("]");
			
			if (startPos != -1 && endPos != -1)
			{
				value = value.substring(startPos + 1, endPos);
				if (value.contains(":"))
				{
					value = value.split(":")[1];
				}
			}
		}
		return value;
	}
}
