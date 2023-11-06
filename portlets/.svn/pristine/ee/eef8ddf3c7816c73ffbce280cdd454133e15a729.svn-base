
package com.ihg.grs.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

/**
 * Utility class of XMLUtils.
 */
public final class XMLUtils
{
	private static final Log LOGGER = LogFactoryUtil.getLog(ActionUtil.class);
	public static final String ROOT_XPATH = "//root/dynamic-element[@name='";
	private static final String CONTENT_FIELD = "/dynamic-content";
	
	/**
	 * Define a private constructor.
	 */
	private XMLUtils()
	{
	}

	/**
	 * @param xmlContent passing xmlContent
	 * @param fields passing field name
	 * @return fieldsMap
	 */
	public static Map<String, String> getXMLDynamicData(String xmlContent, String[] fields)
	{
		Map<String, String> fieldsMap = new HashMap<String, String>();
		SAXReader saxReader = new SAXReader();
		org.dom4j.Document document;
		try
		{
			document = saxReader.read(new InputSource(new StringReader(xmlContent)));
			for (String string : fields)
			{
				StringBuffer path = new StringBuffer();
				path.append(ROOT_XPATH);
				path.append(string);
				path.append("']");
				path.append(CONTENT_FIELD);
				org.dom4j.Node contentNode = document.selectSingleNode(path.toString());
				if (contentNode != null)
				{
					String val = contentNode.getText();
					fieldsMap.put(string, val);
				}
			}
		}
		catch (DocumentException e)
		{
			LOGGER.error("Exception thrown from XMLUtils :: getXMLDynamicData()", e);
		}
		return fieldsMap;

	}
}
