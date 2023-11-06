package com.ihg.me2.search;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.TermQuery;
import com.liferay.portal.kernel.search.TermQueryFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author vijaykumar.singh
 *
 */
public class HotelSearchUtil
{
	private static final Log _log = LogFactoryUtil.getLog(HotelSearchUtil.class);
	
	/**
	 * Partial search by keyword for autocomplete. The specified keyword is
	 * searched for holidex and hotel name.
	 * 
	 * @param searchContext
	 * @return List<Hotel>
	 * @throws SearchException
	 * @throws ParseException 
	 */
	public static List<Hotel> searchByKeyword(String keyword)
		throws SearchException, ParseException
	{
		SearchContext searchContext = new SearchContext();
		BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
		fullQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, HotelSearchConstants.ENTRY_CLASS_NAME);
		
		// Filter location type code
		TermQuery locationTypeCode = TermQueryFactoryUtil.create(searchContext, HotelSolrField.LOCATION_TYPE_CODE, HotelSearchConstants.LOCATION_TYPE_CODE);
		fullQuery.add(locationTypeCode, BooleanClauseOccur.MUST);
		
		// Filter location status codes
		BooleanQuery locationStatusQuery = BooleanQueryFactoryUtil.create(searchContext);
		for(String locationStatusCode : HotelSearchConstants.HOTEL_STATUS_CODES){
			locationStatusQuery.addTerm(HotelSolrField.LOCATION_STATUS, locationStatusCode);
		}
		fullQuery.add(locationStatusQuery, BooleanClauseOccur.MUST);
		
		// Filter holidex
		TermQuery holidex = TermQueryFactoryUtil.create(searchContext, HotelSolrField.UID, StringUtil.toUpperCase(keyword) + "*");
		fullQuery.add(holidex, BooleanClauseOccur.MUST);

		Hits hits = SearchEngineUtil.search(searchContext, fullQuery);
		
		if(_log.isDebugEnabled()){
			_log.debug("Query: " + hits.getQuery().toString());
			_log.debug("Total number of records found: " + hits.getLength());
		}

		return processHits(hits);
	}
	
	protected static List<Hotel> processHits(Hits hits)
	{
		List<Hotel> hotelInfoList = new ArrayList<Hotel>();
		List<Document> documents = hits.toList();
		for (Document document : documents)
		{
			Hotel hotelInfo = new Hotel();
			Map<String, Field> fields = document.getFields();

			if (Validator.isNotNull(fields.get(HotelSolrField.UID)))
			{
				hotelInfo.setHolidex(fields.get(HotelSolrField.UID).getValue());
			}

			if (Validator.isNotNull(fields.get(HotelSolrField.FACILITY_ID)))
			{
				hotelInfo.setFacilityId(fields.get(HotelSolrField.FACILITY_ID).getValue());
			}

			if (Validator.isNotNull(fields.get(HotelSolrField.BRAND_NAME)))
			{
				hotelInfo.setBrandName(fields.get(HotelSolrField.BRAND_NAME).getValue());
			}

			if (Validator.isNotNull(fields.get(HotelSolrField.MANAGEMENT_TYPE)))
			{
				hotelInfo.setManagementTypeCode(fields.get(HotelSolrField.MANAGEMENT_TYPE).getValue());
			}

			if (Validator.isNotNull(fields.get(HotelSolrField.CHAIN_CODE)))
			{
				hotelInfo.setChainCode(fields.get(HotelSolrField.CHAIN_CODE).getValue());
			}

			if (Validator.isNotNull(fields.get(HotelSolrField.BRAND_CODE)))
			{
				hotelInfo.setBrandCode(fields.get(HotelSolrField.BRAND_CODE).getValue());
			}

			if (Validator.isNotNull(fields.get(HotelSolrField.LOCATION_STATUS)))
			{
				hotelInfo.setLocationStatus(fields.get(HotelSolrField.LOCATION_STATUS).getValue());
			}

			if (Validator.isNotNull(fields.get(HotelSolrField.ADDRESS1)))
			{
				hotelInfo.setAddress1(fields.get(HotelSolrField.ADDRESS1).getValue());
			}

			if (Validator.isNotNull(fields.get(HotelSolrField.ADDRESS2)))
			{
				hotelInfo.setAddress2(fields.get(HotelSolrField.ADDRESS2).getValue());
			}

			if (Validator.isNotNull(fields.get(HotelSolrField.CITY)))
			{
				hotelInfo.setCity(fields.get(HotelSolrField.CITY).getValue());
			}

			if (Validator.isNotNull(fields.get(HotelSolrField.STATE_CODE)))
			{
				hotelInfo.setStateCode(fields.get(HotelSolrField.STATE_CODE).getValue());
			}

			if (Validator.isNotNull(fields.get(HotelSolrField.POSTAL_CODE)))
			{
				hotelInfo.setPostalCode(fields.get(HotelSolrField.POSTAL_CODE).getValue());
			}

			if (Validator.isNotNull(fields.get(HotelSolrField.COUNTRY)))
			{
				hotelInfo.setCountry(fields.get(HotelSolrField.COUNTRY).getValue());
			}

			if (Validator.isNotNull(fields.get(HotelSolrField.COUNTRY_CODE)))
			{
				hotelInfo.setCountryCode(fields.get(HotelSolrField.COUNTRY_CODE).getValue());
			}

			if (Validator.isNotNull(fields.get(HotelSolrField.REGION_CODE)))
			{
				hotelInfo.setRegion(fields.get(HotelSolrField.REGION_CODE).getValue());
			}

			if (Validator.isNotNull(fields.get(HotelSolrField.PHONE_NUMBER)))
			{
				hotelInfo.setPhoneNumber(fields.get(HotelSolrField.PHONE_NUMBER).getValue());
			}

			if (Validator.isNotNull(fields.get(HotelSolrField.STATE_NAME)))
			{
				hotelInfo.setStateName(fields.get(HotelSolrField.STATE_NAME).getValue());
			}

			if (Validator.isNotNull(fields.get(HotelSolrField.GEOLOC)))
			{
				hotelInfo.setGeoloc(fields.get(HotelSolrField.GEOLOC).getValue());
			}

			if (Validator.isNotNull(fields.get(HotelSolrField.LOCATION_TYPE_CODE)))
			{
				hotelInfo.setLocationTypeCode(fields.get(HotelSolrField.LOCATION_TYPE_CODE).getValue());
			}

			hotelInfoList.add(hotelInfo);
		}
		return hotelInfoList;
	}

}
