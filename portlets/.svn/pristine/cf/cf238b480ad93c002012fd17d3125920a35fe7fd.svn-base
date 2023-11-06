package com.ihg.brandstandards.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ihg.brandstandards.db.NoSuchBrandTaxonomyException;
import com.ihg.brandstandards.db.model.BrandTaxonomy;
import com.ihg.brandstandards.db.model.BrandTaxonomyTranslate;
import com.ihg.brandstandards.db.model.Taxonomy;
import com.ihg.brandstandards.db.model.TaxonomyTranslate;
import com.ihg.brandstandards.db.model.TreeXML;
import com.ihg.brandstandards.db.service.BrandTaxonomyLocalServiceUtil;
import com.ihg.brandstandards.db.service.BrandTaxonomyTranslateLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocaleLocalServiceUtil;
import com.ihg.brandstandards.db.service.TaxonomyLocalServiceUtil;
import com.ihg.brandstandards.db.service.TaxonomyTranslateLocalServiceUtil;
import com.ihg.brandstandards.db.service.TreeXMLLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;

public class ActionUtil
{
    private static final Log LOG = LogFactoryUtil.getLog(ActionUtil.class);

    public static TreeXML getXMLTreeTaxonomy(final Long id) throws SystemException
    {
        TreeXML xml = null;
        try
        {
            xml = TreeXMLLocalServiceUtil.getTreeXML(id);
        }
        catch (PortalException ex)
        {
            LOG.error(StackTraceUtil.getStackTrace(ex));
        }
        return xml;
    }

    public static Taxonomy renameTaxonomyFromRequest(final ResourceRequest request) throws NumberFormatException,
            PortalException, SystemException
    {
        final long userId = PortalUtil.getUserId(request);
        final Taxonomy taxonomyObj = TaxonomyLocalServiceUtil.getTaxonomy(Long.parseLong(request.getParameter("taxonomyId")));
        taxonomyObj.setTitle(request.getParameter("newName"));
        taxonomyObj.setUpdatedBy(String.valueOf(userId));
        taxonomyObj.setUpdatedDate(new Date());
        return taxonomyObj;
    }

    public static Taxonomy moveTaxonomyFromRequest(final ResourceRequest request) throws NumberFormatException, PortalException,
            SystemException
    {
        final long userId = PortalUtil.getUserId(request);
        final Taxonomy taxonomyObj = TaxonomyLocalServiceUtil.getTaxonomy(Long.parseLong(request.getParameter("taxonomyId")));
        long position = Long.parseLong(request.getParameter("position"));
        taxonomyObj.setPosition(position);
        taxonomyObj.setParentId(Long.parseLong(request.getParameter("referenceId")));
        taxonomyObj.setUpdatedBy(String.valueOf(userId));
        taxonomyObj.setUpdatedDate(new Date());
        return taxonomyObj;
    }

    @SuppressWarnings("unchecked")
    public static void removeTaxonomyFromRequest(final ResourceRequest request) throws NumberFormatException, PortalException,
            SystemException
    {
        String taxonomyId = request.getParameter("taxonomyId");
        Map<String, String> brandList = BrandStandardsUtil.chainCodeMap();
        Map<String, String> activeLanguages = StandardsLocaleLocalServiceUtil.getActiveLanguages(BSAdminConstants.ACTIVE_LANG_QUERY);
        request.setAttribute("activeLanguages", activeLanguages.entrySet());
        if (LOG.isDebugEnabled()) {
            LOG.debug("Remove taxonomy - Active Languages: " + activeLanguages.entrySet());
        }
        for (String brand : brandList.keySet())
        {
            BrandTaxonomy brandTaxonomy = null;
            try
            {
                brandTaxonomy = BrandTaxonomyLocalServiceUtil.getByTaxIdAndChainCd(Long.parseLong(taxonomyId), brand);
            }
            catch (Exception e)
            {
                LOG.error("Exception occured " + e);
            }

            for (String locale : activeLanguages.keySet())
            {
                BrandTaxonomyTranslate brandTaxonomyTranslate = null;

                if (brandTaxonomy != null)
                {
                    brandTaxonomyTranslate = BrandTaxonomyTranslateLocalServiceUtil.getTaxTransByTaxLangId(brandTaxonomy.getId(),
                            locale);

                    if (brandTaxonomyTranslate != null)
                    {
                        BrandTaxonomyTranslateLocalServiceUtil.deleteBrandTaxonomyTranslate(brandTaxonomyTranslate);
                    }
                }
            }
        }

        for (String brand : brandList.keySet())
        {
            BrandTaxonomy brandTaxonomy = null;
            try
            {
                brandTaxonomy = BrandTaxonomyLocalServiceUtil.getByTaxIdAndChainCd(Long.parseLong(taxonomyId), brand);
            }
            catch (Exception e)
            {
                LOG.error("Exception occured " + e);
            }

            if (brandTaxonomy != null)
            {
                BrandTaxonomyLocalServiceUtil.deleteBrandTaxonomy(brandTaxonomy);
            }
        }

        for (String locale : activeLanguages.keySet())
        {
            TaxonomyTranslate taxonomyTranslate = null;
            try
            {
                taxonomyTranslate = TaxonomyTranslateLocalServiceUtil.getTaxTransByTaxLangId(Long.parseLong(taxonomyId), locale);
            }
            catch (Exception e)
            {
                LOG.error("Exception occured " + e);
            }
            if (taxonomyTranslate != null)
            {
                TaxonomyTranslateLocalServiceUtil.deleteTaxonomyTranslate(taxonomyTranslate);
            }
        }

        final Taxonomy taxonomy = TaxonomyLocalServiceUtil.getTaxonomy(Long.parseLong(taxonomyId));
        TaxonomyLocalServiceUtil.deleteTaxonomy(taxonomy);
    }

    @SuppressWarnings("unchecked")
    public static void editTaxonomy(final ResourceRequest request, final ResourceResponse response) throws NumberFormatException,
            PortalException, SystemException
    {
        final long userId = PortalUtil.getUserId(request);
        final User user = UserLocalServiceUtil.getUserById(userId);
        String brandDescription = null;
        Map<String, String> brandList = BrandStandardsUtil.chainCodeMap();
        String brand = null;
        List<String> brandDescs = new ArrayList<String>();
        String taxonomyId = request.getParameter("taxonomyId");
        Taxonomy taxonomy = TaxonomyLocalServiceUtil.getTaxonomy(Long.parseLong(taxonomyId));
        String brandPerspective = request.getParameter("brand");

        if (LOG.isDebugEnabled()) {
            LOG.debug("ActionUtil: Edit Taxonomy - taxonomy ID: " + taxonomyId + ":: brandPerspective: " + brandPerspective
                + "::locale: " + request.getParameter("locale"));
        }
        if (brandPerspective.equals("GL"))
        {
            String locale = request.getParameter("locale");

            if (locale.equals(null) || locale.isEmpty())
            {
                locale = "en_GB";
            }
            String descIC = request.getParameter("brandDescIC");
            String descIR = request.getParameter("brandDescIR");
            String descHI = request.getParameter("brandDescHI");
            String descEX = request.getParameter("brandDescEX");
            String descRS = request.getParameter("brandDescHIR");
            String descCV = request.getParameter("brandDescCV");
            String descCP = request.getParameter("brandDescCP");
            String descCR = request.getParameter("brandDescCR");
            String descUL = request.getParameter("brandDescUX");
            String descIN = request.getParameter("brandDescIN");
            String descVN = request.getParameter("brandDescVN");
            String descSB = request.getParameter("brandDescSB");
            String descCW = request.getParameter("brandDescCW");
            String descVA = request.getParameter("brandDescVA");
            String descKI = request.getParameter("brandDescKI");
            String descRE = request.getParameter("brandDescRE");
            String descVX = request.getParameter("brandDescVX");

            brandDescs.add(descIC);
            brandDescs.add(descIR);
            brandDescs.add(descHI);
            brandDescs.add(descEX);
            brandDescs.add(descRS);
            brandDescs.add(descCV);
            brandDescs.add(descCP);
            brandDescs.add(descCR);
            brandDescs.add(descUL);
            brandDescs.add(descIN);
            brandDescs.add(descVN);
            brandDescs.add(descSB);
            brandDescs.add(descCW);
            brandDescs.add(descVA);
            brandDescs.add(descKI);
            brandDescs.add(descRE);
			brandDescs.add(descVX);
            
            if (locale.equals("en_GB"))
            {
                int i = 0;
                for (Entry<String, String> brandName : brandList.entrySet())
                {
                    brand = brandName.getKey();
                    brandDescription = brandDescs.get(i);
                    BrandTaxonomy brandTaxonomy = null;
                    try
                    {
                        brandTaxonomy = BrandTaxonomyLocalServiceUtil.getByTaxIdAndChainCd(Long.parseLong(taxonomyId), brand);
                    }
                    catch (NoSuchBrandTaxonomyException nb)
                    {
                        LOG.error("No Such Brand Exists " + nb);
                    }
                    catch (NumberFormatException ne)
                    {
                        LOG.error("Number Format Exception " + ne);
                    }
                    catch (Exception e)
                    {
                        LOG.error("Exception occured " + e);
                    }

                    if (brandTaxonomy == null)
                    {
                        BrandTaxonomy newBrandTaxonomy = BrandTaxonomyLocalServiceUtil.createBrandTaxonomy(CounterLocalServiceUtil.increment(BrandTaxonomy.class.getName()));
                        newBrandTaxonomy.setTitle(taxonomy.getTitle());
                        newBrandTaxonomy.setDesc(brandDescription);
                        newBrandTaxonomy.setChain(brand);
                        newBrandTaxonomy.setTaxId(Long.parseLong(taxonomyId));
                        newBrandTaxonomy.setCreatedBy(user.getScreenName());
                        newBrandTaxonomy.setCreatorId(String.valueOf(userId));
                        newBrandTaxonomy.setCreatedDate(new Date());
                        newBrandTaxonomy.setUpdatedBy(String.valueOf(userId));
                        newBrandTaxonomy.setUpdatedDate(new Date());

                        BrandTaxonomyLocalServiceUtil.addBrandTaxonomy(newBrandTaxonomy);
                    }
                    else
                    {
                        brandTaxonomy.setDesc(brandDescription);
                        brandTaxonomy.setUpdatedBy(String.valueOf(userId));
                        brandTaxonomy.setUpdatedDate(new Date());

                        BrandTaxonomyLocalServiceUtil.updateBrandTaxonomy(brandTaxonomy);
                    }
                    i++;
                }
            }
            else
            {
                int i = 0;
                for (Entry<String, String> brandName : brandList.entrySet())
                {
                    brand = brandName.getKey();
                    brandDescription = brandDescs.get(i);
                    BrandTaxonomy brandTaxonomy = null;
                    BrandTaxonomyTranslate brandTaxonomyTranslate = null;
                    try
                    {
                        brandTaxonomy = BrandTaxonomyLocalServiceUtil.getByTaxIdAndChainCd(Long.parseLong(taxonomyId), brand);
                    }
                    catch (NoSuchBrandTaxonomyException nb)
                    {
                        LOG.error("No Such Brand Exists " + nb);
                    }
                    catch (NumberFormatException ne)
                    {
                        LOG.error("Number Format Exception " + ne);
                    }
                    catch (Exception e)
                    {
                        LOG.error("Exception occured " + e);
                    }

                    if (brandTaxonomy == null)
                    {
                        BrandTaxonomy newBrandTaxonomy = BrandTaxonomyLocalServiceUtil.createBrandTaxonomy(CounterLocalServiceUtil.increment(BrandTaxonomy.class.getName()));
                        newBrandTaxonomy.setTitle(taxonomy.getTitle());
                        newBrandTaxonomy.setChain(brand);
                        newBrandTaxonomy.setTaxId(Long.parseLong(taxonomyId));
                        newBrandTaxonomy.setCreatedBy(user.getScreenName());
                        newBrandTaxonomy.setCreatorId(String.valueOf(userId));
                        newBrandTaxonomy.setCreatedDate(new Date());
                        newBrandTaxonomy.setUpdatedBy(String.valueOf(userId));
                        newBrandTaxonomy.setUpdatedDate(new Date());

                        BrandTaxonomyLocalServiceUtil.addBrandTaxonomy(newBrandTaxonomy);
                        brandTaxonomy = newBrandTaxonomy;
                    }
                    try
                    {
                        brandTaxonomyTranslate = BrandTaxonomyTranslateLocalServiceUtil.getTaxTransByTaxLangId(
                                brandTaxonomy.getId(), locale);
                    }
                    catch (Exception e)
                    {
                        LOG.error("Exception occured " + e);
                    }

                    if (brandTaxonomyTranslate == null)
                    {
                        BrandTaxonomyTranslate newBrandTaxonomyTranslate = BrandTaxonomyTranslateLocalServiceUtil.getBrandTaxonomyTranslateObject();
                        newBrandTaxonomyTranslate.setBrandTaxId(brandTaxonomy.getId());
                        newBrandTaxonomyTranslate.setTitle(taxonomy.getTitle());
                        newBrandTaxonomyTranslate.setDesc(brandDescription);
                        newBrandTaxonomyTranslate.setLocaleCd(locale);
                        newBrandTaxonomyTranslate.setCreatorId(String.valueOf(userId));
                        newBrandTaxonomyTranslate.setCreatedDate(new Date());
                        newBrandTaxonomyTranslate.setUpdatedBy(String.valueOf(userId));
                        newBrandTaxonomyTranslate.setUpdatedDate(new Date());

                        BrandTaxonomyTranslateLocalServiceUtil.addBrandTaxonomyTranslate(newBrandTaxonomyTranslate);
                    }
                    else
                    {
                        brandTaxonomyTranslate.setDesc(brandDescription);
                        brandTaxonomyTranslate.setUpdatedBy(String.valueOf(userId));
                        brandTaxonomyTranslate.setUpdatedDate(new Date());

                        BrandTaxonomyTranslateLocalServiceUtil.updateBrandTaxonomyTranslate(brandTaxonomyTranslate);
                    }
                    i++;
                }
            }
        }
        else
        {
            BrandTaxonomy brandTaxonomy = null;
            String description = request.getParameter("description");

            try
            {
                brandTaxonomy = BrandTaxonomyLocalServiceUtil.getByTaxIdAndChainCd(Long.parseLong(taxonomyId), brandPerspective);
            }
            catch (NoSuchBrandTaxonomyException nb)
            {
                LOG.error("No Such Brand Exists " + nb);
            }
            catch (NumberFormatException ne)
            {
                LOG.error("Number Format Exception " + ne);
            }
            catch (Exception e)
            {
                LOG.error("Exception occured " + e);
            }

            if (brandTaxonomy == null)
            {
                BrandTaxonomy newBrandTaxonomy = BrandTaxonomyLocalServiceUtil.createBrandTaxonomy(CounterLocalServiceUtil.increment(BrandTaxonomy.class.getName()));
                newBrandTaxonomy.setTitle(taxonomy.getTitle());
                newBrandTaxonomy.setDesc(description);
                newBrandTaxonomy.setChain(brandPerspective);
                newBrandTaxonomy.setTaxId(Long.parseLong(taxonomyId));
                newBrandTaxonomy.setCreatedBy(user.getScreenName());
                newBrandTaxonomy.setCreatorId(String.valueOf(userId));
                newBrandTaxonomy.setCreatedDate(new Date());
                newBrandTaxonomy.setUpdatedBy(String.valueOf(userId));
                newBrandTaxonomy.setUpdatedDate(new Date());

                BrandTaxonomyLocalServiceUtil.addBrandTaxonomy(newBrandTaxonomy);
            }
            else
            {
                brandTaxonomy.setDesc(description);
                brandTaxonomy.setUpdatedBy(String.valueOf(userId));
                brandTaxonomy.setUpdatedDate(new Date());

                BrandTaxonomyLocalServiceUtil.updateBrandTaxonomy(brandTaxonomy);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static List<String> getBrandDescriptionData(final ResourceRequest request) throws NumberFormatException,
            PortalException, SystemException
    {
        String taxonomyId = request.getParameter("taxonomyId");
        String locale = request.getParameter("locale");

        if (locale.equals(null) || locale.isEmpty())
        {
            locale = "en_GB";
        }
        String brand = null;
        List<String> brandDescs = new ArrayList<String>();
        Map<String, String> brandList = BrandStandardsUtil.chainCodeMap();

        if (locale.equals("en_GB"))
        {
            for (Entry<String, String> brandName : brandList.entrySet())
            {
                brand = brandName.getKey();
                BrandTaxonomy brandTaxonomy = null;
                try
                {
                    brandTaxonomy = BrandTaxonomyLocalServiceUtil.getByTaxIdAndChainCd(Long.parseLong(taxonomyId), brand);
                }
                catch (NoSuchBrandTaxonomyException nb)
                {
                    LOG.error("No Such Brand Exists " + nb);
                }
                catch (NumberFormatException ne)
                {
                    LOG.error("Number Format Exception " + ne);
                }
                catch (Exception e)
                {
                    LOG.error("Exception occured " + e);
                }
                if (brandTaxonomy == null)
                {
                    brandDescs.add("");
                }
                else
                {
                    brandDescs.add(brandTaxonomy.getDesc());
                }
            }
        }
        else
        {
            for (Entry<String, String> brandName : brandList.entrySet())
            {
                brand = brandName.getKey();
                BrandTaxonomy brandTaxonomy = null;
                BrandTaxonomyTranslate brandTaxonomyTranslate = null;
                try
                {
                    brandTaxonomy = BrandTaxonomyLocalServiceUtil.getByTaxIdAndChainCd(Long.parseLong(taxonomyId), brand);
                }
                catch (NoSuchBrandTaxonomyException nb)
                {
                    LOG.error("No Such Brand Exists " + nb);
                }
                catch (NumberFormatException ne)
                {
                    LOG.error("Number Format Exception " + ne);
                }
                catch (Exception e)
                {
                    LOG.error("Exception occured " + e);
                }

                if (brandTaxonomy == null)
                {
                    brandDescs.add("");
                }
                else
                {
                    brandTaxonomyTranslate = BrandTaxonomyTranslateLocalServiceUtil.getTaxTransByTaxLangId(brandTaxonomy.getId(), locale);
                    if (brandTaxonomyTranslate == null)
                    {
                        brandDescs.add("");
                    }
                    else
                    {
                        brandDescs.add(brandTaxonomyTranslate.getDesc());
                    }
                }
            }
        }
        return brandDescs;
    }

    public static String getSingleBrandDescriptionData(final ResourceRequest request) throws NumberFormatException,
            PortalException, SystemException
    {
        String brandDesc = null;
        BrandTaxonomy brandTaxonomy = null;
        String taxonomyId = request.getParameter("taxonomyId");
        String brand = request.getParameter("brand");

        try
        {
            brandTaxonomy = BrandTaxonomyLocalServiceUtil.getByTaxIdAndChainCd(Long.parseLong(taxonomyId), brand);
        }
        catch (NoSuchBrandTaxonomyException nb)
        {
            LOG.error("No Such Brand Exists " + nb);
        }
        catch (NumberFormatException ne)
        {
            LOG.error("Number Format Exception " + ne);
        }
        catch (Exception e)
        {
            LOG.error("Exception occured " + e);
        }
        if (brandTaxonomy != null)
        {
            brandDesc = brandTaxonomy.getDesc();
        }
        return brandDesc;
    }

    public static Taxonomy editFileUrlTaxonomy(final String taxId, final String imageURL, final long userId)
            throws NumberFormatException, PortalException, SystemException
    {
        final Taxonomy taxonomyObj = TaxonomyLocalServiceUtil.getTaxonomy(Long.parseLong(taxId));
        taxonomyObj.setImageLoc(imageURL);
        taxonomyObj.setUpdatedBy(String.valueOf(userId));
        taxonomyObj.setUpdatedDate(new Date());
        return taxonomyObj;
    }

    public static DLFileEntry addOrOverwriteFile(final long realUserId, final long groupId, final long folderId,
            final String fileName, final InputStream uploadedFile, final long size, Taxonomy taxonomyObj) throws SystemException,
            PortalException
    {
        DLFileEntry fileEntry = null;
        FileEntry tempfileEntry = null;
        DLFileEntry fileEntryOld = null;

        ServiceContext serviceContext = new ServiceContext();
        String oldFileName = "";
        String fileExtension = "";
        String fileNameFinal = "";

        try
        {
            int index = fileName.lastIndexOf('.');
            if (index > 0 && index <= fileName.length() - 2)
            {
                String fileNameWthOutExt = fileName.substring(0, index);
                fileExtension = fileName.substring(index, fileName.length());
                fileNameFinal = fileNameWthOutExt + "_" + String.valueOf(taxonomyObj.getTaxId()) + fileExtension;
            }
            if (taxonomyObj.getImageLoc() != null && !(taxonomyObj.getImageLoc()).isEmpty())
            {
                String[] strArr = taxonomyObj.getImageLoc().split("/");
                oldFileName = strArr[strArr.length - 1];
                oldFileName = URLDecoder.decode(oldFileName, "UTF-8");
            }
            serviceContext.setAddGuestPermissions(true);

            fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(groupId, folderId, fileNameFinal);
            
            if (fileEntry == null)
            {
                throw new NoSuchFileEntryException();
            }
            //DLFileEntryLocalServiceUtil.deleteFileEntry(groupId, folderId);
            DLAppLocalServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());
            String mimeType =  MimeTypesUtil.getContentType(fileNameFinal);
            
            /*long fileEntryTypeId = -1L;
            Map<String, Fields> fieldsMap = null;
            
            fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(realUserId, groupId, 
                    groupId, folderId, fileNameFinal, mimeType, "", "", "", 
                    fileEntryTypeId, fieldsMap, null, uploadedFile, size, serviceContext);*/
            tempfileEntry = DLAppLocalServiceUtil.addFileEntry(realUserId, groupId, folderId, fileNameFinal, mimeType, "", "", "", uploadedFile, size, serviceContext);
            fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(tempfileEntry.getFileEntryId());
        }
        catch (NoSuchFileEntryException noSuchFileEntryException)
        {
            String mimeType =  MimeTypesUtil.getContentType(fileNameFinal);
            
           /* long fileEntryTypeId = -1L;
            Map<String, Fields> fieldsMap = null;*/
            if (oldFileName.length() > 0) {
                fileEntryOld = DLFileEntryLocalServiceUtil.getFileEntry(
                        groupId, folderId, oldFileName);
                //DLFileEntryLocalServiceUtil.deleteFileEntry(fileEntryOld);
                DLAppLocalServiceUtil.deleteFileEntry(fileEntryOld.getFileEntryId());
            }
            /*fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(realUserId, groupId, 
                    groupId, folderId, fileNameFinal, mimeType, "", "", "", 
                    fileEntryTypeId, fieldsMap, null, uploadedFile, size, serviceContext);*/
            tempfileEntry	= DLAppLocalServiceUtil.addFileEntry(realUserId, groupId, folderId, fileNameFinal, mimeType, "", "", "", uploadedFile, size, serviceContext);
            fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(tempfileEntry.getFileEntryId());
            // logger.logException(noSuchFileEntryException);
        }
        catch (DuplicateFileException duplicateFileException)
        {
            LOG.error(StackTraceUtil.getStackTrace(duplicateFileException));
        }
        catch (UnsupportedEncodingException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return fileEntry;
    }

    public static DLFileEntry deleteFile(final long groupId, final long folderId, Taxonomy taxonomyObj) throws SystemException,
            PortalException
    {
        DLFileEntry fileEntry = null;
        String oldFileName = "";

        try
        {
            if (taxonomyObj.getImageLoc() != null && !(taxonomyObj.getImageLoc()).isEmpty())
            {
                final String[] strArr = taxonomyObj.getImageLoc().split("/");
                oldFileName = strArr[strArr.length - 1];
                oldFileName = URLDecoder.decode(oldFileName, "UTF-8");
            }
            fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(groupId, folderId, oldFileName);
            if (fileEntry == null)
            {
                throw new NoSuchFileEntryException();
            }

            //DLFileEntryLocalServiceUtil.deleteFileEntry(fileEntry);
            DLAppLocalServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());
        }
        catch (NoSuchFileEntryException noSuchFileEntryException)
        {
            LOG.error(StackTraceUtil.getStackTrace(noSuchFileEntryException));
        }
        catch (DuplicateFileException duplicateFileException)
        {
            LOG.error(StackTraceUtil.getStackTrace(duplicateFileException));
        }
        catch (UnsupportedEncodingException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return fileEntry;
    }

    public static DLFileEntry deleteFileFromBrandTaxonomy(final long groupId, final long folderId, BrandTaxonomy brandTaxonomyObj)
            throws SystemException, PortalException
    {
        DLFileEntry fileEntry = null;
        String oldFileName = "";

        try
        {
            if (brandTaxonomyObj.getImageLoc() != null && !(brandTaxonomyObj.getImageLoc()).isEmpty())
            {
                final String[] strArr = brandTaxonomyObj.getImageLoc().split("/");
                oldFileName = strArr[strArr.length - 1];
                oldFileName = URLDecoder.decode(oldFileName, "UTF-8");
            }
            fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(groupId, folderId, oldFileName);
            if (fileEntry == null)
            {
                throw new NoSuchFileEntryException();
            }

            //DLFileEntryLocalServiceUtil.deleteFileEntry(fileEntry);
            DLAppLocalServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());
        }
        catch (NoSuchFileEntryException noSuchFileEntryException)
        {
            LOG.error(StackTraceUtil.getStackTrace(noSuchFileEntryException));
        }
        catch (DuplicateFileException duplicateFileException)
        {
            LOG.error(StackTraceUtil.getStackTrace(duplicateFileException));
        }
        catch (UnsupportedEncodingException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return fileEntry;
    }

    public static DLFileEntry deleteFileFromTaxonomyTranslate(final long groupId, final long folderId,
            TaxonomyTranslate taxonomyTranslateObj) throws SystemException, PortalException
    {
        DLFileEntry fileEntry = null;
        String oldFileName = "";

        try
        {
            if (taxonomyTranslateObj.getImageLoc() != null && !(taxonomyTranslateObj.getImageLoc()).isEmpty())
            {
                final String[] strArr = taxonomyTranslateObj.getImageLoc().split("/");
                oldFileName = strArr[strArr.length - 1];
                oldFileName = URLDecoder.decode(oldFileName, "UTF-8");
            }
            fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(groupId, folderId, oldFileName);
            if (fileEntry == null)
            {
                throw new NoSuchFileEntryException();
            }

            //DLFileEntryLocalServiceUtil.deleteFileEntry(fileEntry);
            DLAppLocalServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());
        }
        catch (NoSuchFileEntryException noSuchFileEntryException)
        {
            LOG.error(StackTraceUtil.getStackTrace(noSuchFileEntryException));
        }
        catch (DuplicateFileException duplicateFileException)
        {
            LOG.error(StackTraceUtil.getStackTrace(duplicateFileException));
        }
        catch (UnsupportedEncodingException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return fileEntry;
    }

    public static DLFileEntry deleteFileFromBrandTaxonomyTranslate(final long groupId, final long folderId,
            BrandTaxonomyTranslate brandTaxonomyTranslateObj) throws SystemException, PortalException
    {
        DLFileEntry fileEntry = null;
        String oldFileName = "";

        try
        {
            if (brandTaxonomyTranslateObj.getImageLoc() != null && !(brandTaxonomyTranslateObj.getImageLoc()).isEmpty())
            {
                final String[] strArr = brandTaxonomyTranslateObj.getImageLoc().split("/");
                oldFileName = strArr[strArr.length - 1];
                oldFileName = URLDecoder.decode(oldFileName, "UTF-8");
            }
            fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(groupId, folderId, oldFileName);
            if (fileEntry == null)
            {
                throw new NoSuchFileEntryException();
            }

            //DLFileEntryLocalServiceUtil.deleteFileEntry(fileEntry);
            DLAppLocalServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());
        }
        catch (NoSuchFileEntryException noSuchFileEntryException)
        {
            LOG.error(StackTraceUtil.getStackTrace(noSuchFileEntryException));
        }
        catch (DuplicateFileException duplicateFileException)
        {
            LOG.error(StackTraceUtil.getStackTrace(duplicateFileException));
        }
        catch (UnsupportedEncodingException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return fileEntry;
    }

    public static void insertAdminXML(long id)
    {
        try
        {
            TreeXMLLocalServiceUtil.insertAdminTaxonomy(id);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
    }

    public static Workbook xmElxcelExport()
    {
        final Workbook wb = new HSSFWorkbook();
        ArrayList<String> nodePath = new ArrayList<String>();
        try
        {
            CreationHelper createHelper = wb.getCreationHelper();
            Sheet sheet = wb.createSheet("new sheet");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            StringBuffer sb = new StringBuffer();
            TreeXML treeXmlTbl = ActionUtil.getXMLTreeTaxonomy(1L);
            if (treeXmlTbl != null)
            {
                sb.append(treeXmlTbl.getXMLLOB());
            }
            Document document = builder.parse(new ByteArrayInputStream(sb.toString().getBytes()));
            // normalize text representation
            document.getDocumentElement().normalize();
            NodeList flList = document.getElementsByTagName("item");
            Row row = sheet.createRow((short) 0);
            Cell cell = row.createCell(0);
            cell.setCellValue(createHelper.createRichTextString("Index ID"));

            row.createCell(1).setCellValue(createHelper.createRichTextString("Level"));
            row.createCell(2).setCellValue(createHelper.createRichTextString("Heading"));
            row.createCell(2).setCellValue(createHelper.createRichTextString("Description"));
            row.createCell(2).setCellValue(createHelper.createRichTextString("Description Translation"));
            row.createCell(3).setCellValue(createHelper.createRichTextString("Path"));

            for (int s = 0; s < flList.getLength(); s++)
            {
                String ItemId = flList.item(s).getAttributes().getNamedItem("id").getNodeValue();
                String ItemRel = flList.item(s).getAttributes().getNamedItem("rel").getNodeValue();
                String name = "";

                if (!"1".equals(ItemId))
                {
                    Row row1 = sheet.createRow(s);
                    Cell cell1 = row1.createCell(0);

                    Node firstWordNode = flList.item(s);
                    if (firstWordNode.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element firstWordElement = (Element) firstWordNode;

                        NodeList firstWordList = firstWordElement.getElementsByTagName("name");
                        Element firstWDElement = (Element) firstWordList.item(0);

                        NodeList textWDList = firstWDElement.getChildNodes();
                        name = ((Node) textWDList.item(0)).getNodeValue().trim();
                        int itemlevel = Integer.parseInt(ItemRel) - 2;
                        int actsize = nodePath.size();

                        for (int i = actsize - 1; i >= itemlevel; i--)
                        {
                            nodePath.remove(i);
                        }
                        nodePath.add(itemlevel, name);
                    }
                    cell1.setCellValue(Double.parseDouble(ItemId));
                    row1.createCell(1).setCellValue(Double.parseDouble(ItemRel) - 1);
                    row1.createCell(2).setCellValue(createHelper.createRichTextString(name));
                    row1.createCell(3).setCellValue(createHelper.createRichTextString(getStringVal(nodePath)));
                }
            } // end of for loop with s var
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return wb;
    }

    public static String getStringVal(final List<String> array)
    {
        StringBuilder path = new StringBuilder();
        for (int i = 0; i < array.size(); i++)
        {
            if (i == array.size() - 1)
            {
                path.append(array.get(i));
            }
            else
            {
                path.append(array.get(i)).append(" -> ");
            }
        }
        return path.toString();
    }
  
    
public static boolean isSearchedKeywordMatch(String searchCriteria,String title ){
	
	boolean isSearchedKeyword = false;
	//String content = "test22APRIL";
	String strngPattern = ".*"+searchCriteria+".*";
	Pattern pattern = Pattern.compile(strngPattern, Pattern.CASE_INSENSITIVE);
	Matcher matcher = pattern.matcher(title);
	boolean isMatched = matcher.matches();
	if(isMatched){
		isSearchedKeyword = true;
	}
    return isSearchedKeyword;
    }
    
}
