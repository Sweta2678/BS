package com.ihg.me2.framework.custom.security.cache;

import com.ihg.idm.merlin.common.EDSConstants;
import com.ihg.idm.merlin.util.AbstractUtil;
import com.ihg.me2.utils.session.MerlinCache;
import com.ihg.me2.utils.session.MerlinCacheConstants;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



/**
 * Utility functions.
 * @author Hiren Patel
 *
 */
public class CacheManagerUtil extends MerlinCache
{
	private static Logger _log = LogManager.getLogger(CacheManagerUtil.class);
	private final static String SOURCE_MAPPING = "resources/SecurityAttributes.xml";
	
	/**
	 * Set Security XML Map into Merlin Cache.
	 * 
	 */
	public static void initSecurityAttributes(){
		_log.info("Initilization SecurityAttributes with data and Set into Merlin Cache :::");
		Date startDate = new Date();
		InputStream inputStream = null;
		Map<String, Map<String, Object>> securityAttributesMap = new LinkedHashMap<String, Map<String, Object>>();
		try {   
				JAXBContext context = JAXBContext.newInstance(SecurityAttributes.class);   
				Unmarshaller um = context.createUnmarshaller();   
				ClassLoader classloader = Thread.currentThread().getContextClassLoader();
				inputStream = classloader.getResourceAsStream(SOURCE_MAPPING);
				
				if (inputStream == null) 
				{
					throw new Exception("Security Attributes Mapping XML File Not Found Exception.");
				}
				
				SecurityAttributes securityAttributes = (SecurityAttributes) um.unmarshal(inputStream);      
				   
				for(Attribute attribute : securityAttributes.getAttribute()){
					Map<String, Object> innerMap = new LinkedHashMap<String, Object>();  
					innerMap.put(MerlinCacheConstants.SECURITY_NAME, attribute.getName());    
					innerMap.put(MerlinCacheConstants.SECURITY_SOURCE, attribute.getSource());    
					innerMap.put(MerlinCacheConstants.SECURITY_SOURCE_TYPE, attribute.getSourcetype());   
					innerMap.put(EDSConstants.SECURITY_SOLR_CLASSNAME, attribute.getSolrEntryClassName());   
					Map<String, Object> valuesMap = AbstractUtil.getValuesMap(
							(AbstractUtil) (Class.forName(attribute.getUtilClassName()).newInstance()));
					innerMap.put(MerlinCacheConstants.SECURITY_VALUES, valuesMap); 
					
					securityAttributesMap.put(attribute.getId(), innerMap);   
				}  
					
				MerlinCache.setCacheMap(securityAttributesMap);
			} 
			catch (JAXBException e) {
				_log.error("Error while init Security Attributes:JAXBException::: " + e.getMessage(),e);
			} 
			catch (Exception e) {
				_log.error("Error while init Security Attributes : " + e.getMessage(),e);
			}
			finally {
				try 
				{
					inputStream.close();
				} 
				catch (IOException ioExc) 
				{
					_log.error("Security Attributes Parse IOException:::" + ioExc.getMessage());
				}
			}
			_log.debug("Initilization SecurityAttributes with data and Set into Merlin Cache time : " + (new Date().getTime() - startDate.getTime()));
		}
}
