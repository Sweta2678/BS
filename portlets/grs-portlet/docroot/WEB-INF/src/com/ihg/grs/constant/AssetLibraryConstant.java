package com.ihg.grs.constant;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.PropsUtil;

/**
 * Constant class for Asset library portlet.
 * @author nakul.patel
 *
 */
public final class AssetLibraryConstant
{

	/**
	 * private constructor for AssetLibraryConstant.
	 */
	private AssetLibraryConstant()
	{

	}
	
	public static final String IMAGE_FOLDER_NAME = "Images-Logo-Root";
	public static final String DOCUMENT_AND_MANUAL_ROOT = "Document-Manual-Root";
	public static final String CUTSOM_FIELD_RESOURCE_TITLE = "expando/custom_fields/resourcetitle";
    public static final	String[] KEYWORDS_FIELDS = {Field.DESCRIPTION, Field.TITLE};
    public static final String IMAGES_AND_LOGOS = "image";
    public static final String EXTENSION = "extension";
    public static final String IMG = PropsUtil.get("ig.image.extensions");
//    public static final String IMG_EXTENSION = IMG.replaceFirst(".", "").replaceAll(",.", " OR ");
    public static final String DOCUMENT_AND_MANUAL = "document";
    
    public static final int  PER_PAGE = 10;
    public static final String CURRENT_PAGE = "currPage";
    public static final String TOTAL_PAGE = "totalPage";
    public static final String DOWNLOAD_PATH = "/documents/";
    public static final String ALL = "all";
}
