package com.ihg.brandstandards.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ihg.brandstandards.db.model.StandardsHistoricalManual;
import com.ihg.brandstandards.db.service.StandardsHistoricalManualLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Associate/disassociate Historical Manual with a record.
 * 
 * @author KryvorA
 * 
 */
public final class RegionalHistoricalManualReferenceUtil
{
    private static final Log LOG = LogFactoryUtil.getLog(RegionalHistoricalManualReferenceUtil.class);

    /**
     * private constructor.
     */
    private RegionalHistoricalManualReferenceUtil()
    {
    }

    /**
     * Process Associate/disassociate Historical Manual request.
     * 
     * @param request - request
     * @param stdId - record id
     * @param userId - user id
     * @throws PortalException - exception
     * @throws SystemException - exception
     */
    public static void proseccHistoricalManualReferences(final HttpServletRequest request, final long stdId, final long userId)
            throws PortalException, SystemException
    {
        final String manualRef = request.getParameter(RegionalUtil.REQUEST_PARAM_HIDDEN_MANUAL_REFERENCES);
        final String delManualRef = request.getParameter(RegionalUtil.REQUEST_PARAM_HIDDEN_DEL_MANUAL_REFERENCES);
        if (!RegionalUtil.IsNullOrBlank(manualRef) || !RegionalUtil.IsNullOrBlank(delManualRef))
        {
            final List<StandardsHistoricalManual> newReference = getNewReference(manualRef, stdId, userId);
            final List<Long> deleteReference = getDeleteReference(delManualRef);
            persistHistoricalReferences(deleteReference, newReference);
        }
    }

    /**
     * Disassociate Historical Manual from a record.
     * 
     * @param delManualRef - comma separated manual ids
     * @return list of manual ids.
     */
    private static List<Long> getDeleteReference(final String delManualRef)
    {

        final List<Long> deleteRef = new ArrayList<Long>();
        if (!RegionalUtil.IsNullOrBlank(delManualRef))
        {
            final String[] manualArray = delManualRef.split(",");
            for (int i = 0; i < manualArray.length; i++)
            {
                final Long stdManualId = Long.valueOf(manualArray[i]);
                deleteRef.add(stdManualId);
            }
        }
        return deleteRef;
    }

    /**
     * Get StandardsHistoricalManual for new association.
     * 
     * @param manualRef - "~~~id:" separated references.
     * @param stdId - record id
     * @param userId - user id
     * @return list of StandardsHistoricalManual
     */
    private static List<StandardsHistoricalManual> getNewReference(final String manualRef, final long stdId, final long userId)
    {

        final List<StandardsHistoricalManual> newReference = new ArrayList<StandardsHistoricalManual>();
        if (!RegionalUtil.IsNullOrBlank(manualRef))
        {
            final String[] referenceArray = manualRef.split("~~~id:");
            for (int i = 0; i < referenceArray.length; i++)
            {
                getNewSubmittedHistoricalReferences(referenceArray[i], newReference, stdId, userId);
            }
        }
        return newReference;
    }

    /**
     * Get "~~,|~~" separated Historical Manual references.
     * 
     * @param reference - "~~,|~~" separated Historical Manual references.
     * @param newReference - list of new references.
     * @param stdId - record id
     * @param userId - user id
     */
    private static void getNewSubmittedHistoricalReferences(final String reference,
            final List<StandardsHistoricalManual> newReference, final long stdId, final long userId)
    {
        if (!RegionalUtil.IsNullOrBlank(reference))
        {
            final String[] referenceArray = reference.split("~~,|~~");
            if (referenceArray.length == RegionalUtil.HISTORICAL_MANUAL_TOCKENS_NUM)
            {
                final Long stdManualId = Long.valueOf(referenceArray[RegionalUtil.HISTORICAL_MANUAL_STD_ID_INDX]);
                if (stdManualId == 0L)
                {
                    final long histManualId = Long.valueOf(referenceArray[RegionalUtil.HISTORICAL_MANUAL_ID_INDX]);
                    final String changeType = referenceArray[RegionalUtil.HISTORICAL_MANUAL_CHANGE_TYPE_INDX];
                    //   String brand = referenceArray[StandardsUtil.HISTORICAL_MANUAL_BRAND_INDX];
                    //   String region = referenceArray[StandardsUtil.HISTORICAL_MANUAL_REGION_INDX];
                    //   String manualDesc = referenceArray[StandardsUtil.HISTORICAL_MANUAL_DESC_INDX];
                    final String title = referenceArray[RegionalUtil.HISTORICAL_MANUAL_TITLE_INDX];

                    if (!RegionalUtil.IsNullOrBlank(changeType) && !RegionalUtil.IsNullOrBlank(title))
                    {
                        final StandardsHistoricalManual manual = StandardsHistoricalManualLocalServiceUtil
                                .createStandardsHistoricalManual(0L);
                        manual.setChange(changeType);
                        manual.setTitle(title);
                        manual.setStdId(stdId);
                        manual.setHistManualId(histManualId);
                        manual.setCreatorId(String.valueOf(userId));
                        manual.setCreatedDate(new Date());
                        manual.setUpdatedBy(String.valueOf(userId));
                        manual.setUpdatedDate(new Date());
                        newReference.add(manual);
                    }
                }
            }
        }
    }

    /**
     * Persist Historical Manual references.
     * 
     * @param deleteReference - list of references to be deleted
     * @param newReference - list of new references
     * @throws PortalException - exception
     * @throws SystemException - exception
     */
    private static void persistHistoricalReferences(final List<Long> deleteReference,
            final List<StandardsHistoricalManual> newReference) throws PortalException, SystemException
    {

        if (!RegionalUtil.isNullOrBlank(newReference))
        {
            for (StandardsHistoricalManual historicalManual : newReference)
            {
                final long histMnlId = CounterLocalServiceUtil.increment("HistoricalManualStandards");
                historicalManual.setStdMnlId(histMnlId);
                StandardsHistoricalManualLocalServiceUtil.updateStandardsHistoricalManual(historicalManual);
            }
        }

        if (!RegionalUtil.isNullOrBlank(deleteReference))
        {
            for (Long stdManualId : deleteReference)
            {
                StandardsHistoricalManualLocalServiceUtil.deleteStandardsHistoricalManual(stdManualId);
            }
        }
    }
}
