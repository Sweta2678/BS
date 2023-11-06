package com.ihg.brandstandards.util;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletPreferences;

import com.ihg.brandstandards.db.model.Image;
import com.ihg.brandstandards.db.service.StandardsImagesLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;

public class ImageAdminUtil extends BrandStandardsUtil
{
    private static final Log LOG = LogFactoryUtil.getLog(ImageAdminUtil.class);

    public static final String CMD = "COMMAND";

    public static final String CMD_EDIT_FOLDER = "EDIT_FOLDER";

    public static final String CMD_ADD_FOLDER = "ADD_FOLDER";

    public static final String CMD_ADD_IMAGE = "ADD_IMAGE";

    public static final String CMD_EDIT_IMAGE = "EDIT_IMAGE";

    public static final String CMD_GUEST_SEARCH_IMAGE = "GUEST_SEARCH_IMAGE";

    public static final String CURR_FOLDER = "CURR_FOLDER";

    public static final String FOLDER_ID = "FOLDER_ID";

    public static final String PARENT_FOLDER_ID = "PARENT_FOLDER_ID";

    public static final String IMAGE_ID = "IMAGE_ID";

    public static final String IG_IMAGE_EXTENSIONS = "ig.image.extensions";

    public static final String COMMA = ",";

    public static final String IG_IMAGE_MAX_SIZE = "ig.image.max.size";

    public static final String CMD_DELETE_IMAGE = "DELETE_IMAGE";

    public static final String FOLDER_NAME = "FOLDER_NAME";

    public static final String PRNT_FOLDER_NAME = "PARENT_FOLDER_NAME";

    public static final String CMD_SEARCH_IMAGE = "SEARCH_IMAGE";

    public static final String SEARCH_TXT = "SEARCH_TXT";

    public static final String CMD_SEARCH_TRANS_IMAGE = "GUEST_SEARCH_IMAGE_TRANS";

    
    public static List<DLFileEntry> getImages(long groupId, long folderId)
    {
        List<DLFileEntry> arlImages = new ArrayList<DLFileEntry>();     
        try
        {
            arlImages = DLFileEntryLocalServiceUtil.getFileEntries(groupId, folderId);
        }
        catch (SystemException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }

        return arlImages;
    }

    public static void addSubFolder(User user, long groupId, long parentFolderId, String name, String description, ServiceContext serviceContext)
    {
        try
        {
            serviceContext.setAddGroupPermissions(true);
            serviceContext.setAddGuestPermissions(false);
            DLFolder igFolder = DLFolderLocalServiceUtil.addFolder(user.getUserId(), groupId, groupId, false, parentFolderId, name, description, false, serviceContext);
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
    }

    public static void updateFolder(long folderId, String name, String description,ServiceContext serviceContext)
    {
        try
        {
            DLFolder igFolder = DLFolderLocalServiceUtil.getFolder(folderId);
            igFolder.setName(name);
            igFolder.setDescription(description);
            serviceContext.setAddGroupPermissions(true);
            serviceContext.setAddGuestPermissions(false);
            DLFolderLocalServiceUtil.updateDLFolder(igFolder);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
    }

    public static boolean canDelete(long groupId, String folderId)
    {
        List<DLFileEntry> arlImages = new ArrayList<DLFileEntry>();
        List<DLFolder> arlIGFolders = new ArrayList<DLFolder>();
        try
        {
            arlImages = DLFileEntryLocalServiceUtil.getFileEntries(Long.valueOf(groupId), Long.valueOf(folderId));
            arlIGFolders = DLFolderLocalServiceUtil.getFolders(Long.valueOf(groupId), Long.valueOf(folderId));
            if (!isNullOrBlank(arlImages) || !isNullOrBlank(arlIGFolders))
            {
                return false;
            }
        }
        catch (SystemException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return true;
    }

    public static boolean deleteFolder(String folderId)
    {
        try
        {
            DLFolderLocalServiceUtil.deleteFolder(Long.valueOf(folderId));
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return false;
    }

    public static List<String> getStandardsImagesCount(long imageId)
    {
        List<String> arlCount = new ArrayList();
        try
        {
            arlCount = StandardsImagesLocalServiceUtil.StandardsImagesCount(imageId);
        }
        catch (SystemException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return arlCount;
    }

    public static String merge(Object[] array)
    {
        return merge(array, StringPool.COMMA);
    }

    public static String merge(Object[] array, String delimiter)
    {
        if (array == null)
        {
            return null;
        }

        StringBundler sb = null;

        if (array.length == 0)
        {
            sb = new StringBundler();
        }
        else
        {
            sb = new StringBundler(2 * array.length - 1);
        }

        for (int i = 0; i < array.length; i++)
        {
            sb.append(String.valueOf(array[i]).trim());

            if ((i + 1) != array.length)
            {
                sb.append(delimiter);
            }
        }

        return sb.toString();
    }

    public static PortletPreferences getPreferences() throws SystemException
    {
        return getPreferences(0);
    }

    public static PortletPreferences getPreferences(long companyId) throws SystemException
    {
        long ownerId = companyId;
        int ownerType = PortletKeys.PREFS_OWNER_TYPE_COMPANY;
        long plid = PortletKeys.PREFS_PLID_SHARED;
        String portletId = PortletKeys.LIFERAY_PORTAL;

        return PortletPreferencesLocalServiceUtil.getPreferences(companyId, ownerId, ownerType, plid, portletId);
    }

    public static List<DLFileEntry> getAllSearchImages(long groupId, List<Image> arlImage) //throws PortalException, SystemException
    {
        List<DLFileEntry> arlImages = new ArrayList<DLFileEntry>();

        DLFileEntry igImage = null;
        try
        {
            for (Image img : arlImage)
            {
                igImage = DLFileEntryLocalServiceUtil.getFileEntry(img.getImageId());
                if (!arlImages.contains(igImage))
                {
                    arlImages.add(igImage);
                }
            }
        }
        catch (PortalException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        catch (SystemException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return arlImages;
    }
}
