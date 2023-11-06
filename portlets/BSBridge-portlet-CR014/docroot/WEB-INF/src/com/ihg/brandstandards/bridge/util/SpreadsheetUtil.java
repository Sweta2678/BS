package com.ihg.brandstandards.bridge.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.util.PortalUtil;

public class SpreadsheetUtil
{
    private static final Log LOG = LogFactoryUtil.getLog(SpreadsheetUtil.class);

    /**
     * Method will process given request, convert file data entry to List<Long>
     * @param actionRequest
     * @return List<Long>
     * @throws InvalidFormatException
     * @throws IOException
     */
    public static List<Long> getStandardsIdList(ActionRequest actionRequest) throws InvalidFormatException, IOException
    {
        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
        File file = uploadRequest.getFile("file");
        List<Long> stdIds = new ArrayList<Long>();
        XlsSheetIterator xlsSheetIterator = new XlsSheetIterator(file);
        List<XlsModelData> xlsModelDataList = xlsSheetIterator.processSpreadsheet();
        if (xlsModelDataList != null)
        {
            for (XlsModelData data : xlsModelDataList)
            {
                if (!data.getId().isEmpty())
                {
                    stdIds.add(Long.parseLong(data.getId()));
                }
            }
        }
        else
        {
            throw new IOException("Please attach Excel sheet with apt values!");
        }

        return stdIds;
    }
}
