package com.ihg.brandstandards.portlet;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.UnavailableException;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.portlet.PortletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import com.ihg.brandstandards.bsadmin.model.BadCell;
import com.ihg.brandstandards.bsadmin.model.Record;
import com.ihg.brandstandards.db.NoSuchBrandTaxonomyException;
import com.ihg.brandstandards.db.model.BrandTaxonomy;
import com.ihg.brandstandards.db.model.TaxonomyExt;
import com.ihg.brandstandards.db.model.TaxonomyTranslate;
import com.ihg.brandstandards.db.service.BrandTaxonomyLocalServiceUtil;
import com.ihg.brandstandards.db.service.TaxonomyExtLocalServiceUtil;
import com.ihg.brandstandards.db.service.TaxonomyTranslateLocalServiceUtil;
import com.ihg.brandstandards.spreadsheet.ProcessXlsFile;
import com.ihg.brandstandards.util.IndexTranslationUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.ProgressTracker;
import com.liferay.portal.kernel.util.ProgressTrackerThreadLocal;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.FileSizeException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class IndexTranslationPortlet extends MVCPortlet {
	private static final Log LOG = LogFactoryUtil.getLog(IndexTranslationPortlet.class);

	public void doView(RenderRequest request, RenderResponse renderResponse) throws IOException, PortletException 
	{
		String pageName = viewTemplate;
		final PortletRequestDispatcher reqDisp = getPortletContext().getRequestDispatcher(pageName);
		reqDisp.include(request, renderResponse);
	}
	
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException, PortletException 
	{
		String imageUrl = "";
		boolean error = false;
		resourceResponse.setContentType("text/html;charset=UTF-8");
		
		LOG.info("resource id = " + resourceRequest.getResourceID());
			
		if ("uploadValidateExcel".equals(resourceRequest.getResourceID())) 
		{
			uploadValidateExcelSheet(resourceRequest, resourceResponse);
		} 
		else if ("downloadErrorExcel".equals(resourceRequest.getResourceID()))
		{
			downloadErrorExcelSheet(resourceRequest, resourceResponse);
		} 
		else if ("editTranslation".equals(resourceRequest.getResourceID()))
		{
			editTheTranslation(resourceRequest, resourceResponse);
		}
		else if ("excelExport".equals(resourceRequest.getResourceID()))
		{
			exportTheExcel(resourceRequest, resourceResponse);
		} 
		else if ("uploadTranslationImage".equals(resourceRequest.getResourceID())) 
		{
			uploadTheTranslationImage(resourceRequest,resourceResponse, imageUrl, error);
		} 
        else if ("imagePopup".equals(resourceRequest.getResourceID())) 
        {
            getImageImportPopup(resourceRequest, resourceResponse);
        } 
        else if ("importXlsPopup".equals(resourceRequest.getResourceID())) 
        {
            getXlsImportPopup(resourceRequest, resourceResponse);
        } 
		else 
		{
			defaultOp(resourceRequest, resourceResponse);
		}
	}

    private void getXlsImportPopup(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException
    {
        resourceRequest.setAttribute(IndexTranslationUtil.SELECTED_LOCALE, resourceRequest.getParameter(IndexTranslationUtil.SELECTED_LOCALE));
        String importIdExl = resourceRequest.getParameter(IndexTranslationUtil.IMPORT_ID_EXCEL);
        resourceRequest.getPortletSession().setAttribute(ProgressTracker.PERCENT + importIdExl, 0, PortletSession.APPLICATION_SCOPE);
        resourceRequest.setAttribute(IndexTranslationUtil.IMPORT_ID_EXCEL, importIdExl);
        include("/html/indextranslation/excelUpload.jsp", resourceRequest, resourceResponse);
    }

    private void getImageImportPopup(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException
    {
        String selectedLocale = resourceRequest.getParameter(IndexTranslationUtil.SELECTED_LOCALE);
        String taxId = resourceRequest.getParameter(IndexTranslationUtil.TAXONOMY_ID);
        String importIdImg = resourceRequest.getParameter(IndexTranslationUtil.IMPORT_ID_IMAGE);
        resourceRequest.getPortletSession().setAttribute(ProgressTracker.PERCENT + importIdImg, 0, PortletSession.APPLICATION_SCOPE);
        String transImageUrl = "";
        TaxonomyTranslate taxonomyXlat = null;
        try {
            taxonomyXlat = TaxonomyTranslateLocalServiceUtil.getTaxTransByTaxLangId(Long.parseLong(taxId), selectedLocale);
        } catch (NumberFormatException e) {
            LOG.error(StackTraceUtil.getStackTrace(e));
        } catch (SystemException e) {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        if (taxonomyXlat != null) {
            transImageUrl = taxonomyXlat.getImageLoc();
        }
        resourceRequest.setAttribute("transImageUrl", transImageUrl);
        resourceRequest.setAttribute(IndexTranslationUtil.SELECTED_LOCALE, selectedLocale);
        resourceRequest.setAttribute(IndexTranslationUtil.TAXONOMY_ID, taxId);
        resourceRequest.setAttribute(IndexTranslationUtil.IMPORT_ID_IMAGE, importIdImg);
        include("/html/indextranslation/imageUpload.jsp", resourceRequest, resourceResponse);
    }

	private void defaultOp(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException
	{
		String localeCd = resourceRequest.getParameter("localeCd");
		String brand = resourceRequest.getParameter("chainCd");
		
		if ((localeCd == null)|| (localeCd.equals(""))||localeCd.isEmpty())
		{
			localeCd = IndexTranslationUtil.DEFAULT_LOCALE; // default English UK
		}
		
		if((brand == null)||(brand.equals(""))||brand.isEmpty()||(brand.equals("Select Brand")))
		{
			brand = "No_Brand_Selected";
		}
			
		try {
			
			JSONArray rowjsonArray = null;
			JSONObject cell = null;
			
			JSONObject recordsjsonObject = JSONFactoryUtil.createJSONObject();
			JSONArray recordsjsonArray = JSONFactoryUtil.createJSONArray();
			
				List<TaxonomyExt> objectList = TaxonomyExtLocalServiceUtil.getAllIndexesOdrById();// getTaxonomiesByParentId(3l);//.getAllRecords();
				
				double total_pages = Math.ceil(objectList.size() / 10);
				recordsjsonObject.put("page", "1");
				recordsjsonObject.put("total", String.valueOf(total_pages));
				recordsjsonObject.put("records ", String.valueOf(objectList.size()));
				
				if (!objectList.isEmpty()) 
				{
					for (int i = 0; i < objectList.size(); i++) 
					{
						TaxonomyExt taxonomy = objectList.get(i);
						long taxId = taxonomy.getTaxId();
						
						if ( taxId!= 1) 
						{
							rowjsonArray = JSONFactoryUtil.createJSONArray();
							cell = JSONFactoryUtil.createJSONObject();
							rowjsonArray.put(String.valueOf(taxonomy.getTaxId()));
							rowjsonArray.put(String.valueOf(taxonomy.getTitle()));
							rowjsonArray.put(taxonomy.getPath());

							TaxonomyTranslate taxTransObject = null;
							BrandTaxonomy brandTaxonomy = null;
							String description = null;

							if (localeCd.equalsIgnoreCase(IndexTranslationUtil.DEFAULT_LOCALE)) 
							{
								if(brand.equalsIgnoreCase("No_Brand_Selected"))
								{
									rowjsonArray.put("Not Applicable");
								}else
								{
									try {
										brandTaxonomy = BrandTaxonomyLocalServiceUtil.getByTaxIdAndChainCd(taxId, brand);
								} catch (NoSuchBrandTaxonomyException e) {
									LOG.debug("Brand Exception Occurred: "+e);
								}catch(SystemException ne)
								{
									LOG.debug(" Exception Occurred: "+ne);
								}
								
									if(brandTaxonomy == null)
									{
										rowjsonArray.put("No Description Exists");
									}else
									{
										description = brandTaxonomy.getDesc();
										if(description == null || description.isEmpty())
										{
											rowjsonArray.put("No Description Exists");
										}else
										{
											rowjsonArray.put(String.valueOf(description));
										}
									}
								}
								
								if ((taxonomy.getImageLoc() != null)&& (!taxonomy.getImageLoc().equalsIgnoreCase("")))
								{
									rowjsonArray.put(String.valueOf(taxonomy.getImageLoc()));
								}
								else
								{
									rowjsonArray.put("/BSTheme-theme/images/placeholder_icon.jpg");
								}
							} else 
							{
								taxTransObject = TaxonomyTranslateLocalServiceUtil.getTaxTransByTaxLangId(taxId, localeCd);
								if (taxTransObject != null) 
								{
									rowjsonArray.put(String.valueOf(taxTransObject.getTitle()));

								} else 
								{
									rowjsonArray.put("Enter Translated Heading");
								}
								rowjsonArray.put(localeCd);
								rowjsonArray.put(String.valueOf(taxonomy.getTaxId()));
							}

							cell.put("id", String.valueOf(taxonomy.getTaxId()));
							cell.put("cell", rowjsonArray);
							recordsjsonArray.put(cell);

						}

						recordsjsonObject.put("rows", recordsjsonArray);
					}
				}
				
				resourceResponse.getWriter().print(recordsjsonObject.toString());
		} catch (SystemException e) {
			LOG.debug(" Exception Occurred: " + e);
		}
	}

	private void uploadTheTranslationImage(ResourceRequest resourceRequest, ResourceResponse resourceResponse, String imageUrl, boolean error)
			throws IOException 
	{
		String json;
		final PrintWriter out;
		out = resourceResponse.getWriter();
		ProgressTracker progressTracker = null;
		try {
			HttpServletRequest request = PortalUtil
					.getOriginalServletRequest(PortalUtil
							.getHttpServletRequest(resourceRequest));

			final boolean isMultipart = PortletFileUpload
					.isMultipartContent(new ServletRequestContext(request));
			UploadPortletRequest uploadRequest = null;

			if (isMultipart) {
				uploadRequest = PortalUtil
						.getUploadPortletRequest(resourceRequest);
			}

			String importProgressId = ParamUtil.getString(uploadRequest,
					"importProgressId");
			progressTracker = new ProgressTracker(importProgressId);
			ProgressTrackerThreadLocal.setProgressTracker(progressTracker);
			progressTracker.start(resourceRequest);

			imageUrl = uploadImageTaxonomy(uploadRequest, resourceRequest, resourceResponse, progressTracker);
			LOG.debug("Upload Index translation image URL = " + imageUrl);
		} catch (FileSizeException fe) {
			error = true;
			json = "{" + "\"response\": \"Failure\","
					+ "\"message\": \"Failure - File Size Exception -:"
					+ fe.getMessage() + "\"}";
			out.print(json);
			out.flush();
			out.close();
			LOG.error(StackTraceUtil.getStackTrace(fe));
		} catch (Exception e) {
			error = true;
			json = "{" + "\"response\": \"Failure\","
					+ "\"message\": \"Failure - Exception -:" + e.getMessage()
					+ "\"}";
			out.print(json);
			out.flush();
			out.close();
			LOG.error(StackTraceUtil.getStackTrace(e));
		} finally {
			progressTracker.finish(resourceRequest);
		}
		LOG.debug("Upload Index translation image result: error = " + error);
		if (!error) {
			// json = "{" + "\"response\": \"Success\"," +
			// "\"message\": \"File uploaded successfully.\"}";
			json = "{" + "\"response\": \"Success\","
					+ "\"message\": \"File uploaded successfully.\","
					+ "\"imageUrl\" : \"" + imageUrl + "\"}";
			out.print(json);
			out.flush();
			out.close();
		}
	}

	private void exportTheExcel(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException 
	{
		String json;
		final PrintWriter out;
		try {
			String selectedBrand = resourceRequest.getParameter(IndexTranslationUtil.SELECTED_BRAND);
			String selectedLocale = resourceRequest.getParameter(IndexTranslationUtil.SELECTED_LOCALE);
			
			final Workbook workbook = IndexTranslationUtil.xmlExcelExportLang(selectedLocale, selectedBrand);

			resourceResponse.setContentType("application/vnd.ms-excel");
			// response.addProperty(HttpHeaders.CACHE_CONTROL,
			// "max-age=3600, must-revalidate");
			resourceResponse.addProperty("Content-Disposition",
					"attachment; filename=IndexTree.xls");

			final OutputStream out1 = resourceResponse.getPortletOutputStream();
			workbook.write(out1);
			out1.flush();
			out1.close();
		} catch (Exception e) {
			out = resourceResponse.getWriter();
			json = "{" + "\"response\": \"Failure\","
					+ "\"message\": \"Failure - Exception - Exception\"}";// "+e.getMessage()+"\"}";
			out.print(json);
			out.flush();
			out.close();
		}
	}

	private void editTheTranslation(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException {
		String json;
		final PrintWriter out;
		out = resourceResponse.getWriter();

		try {
			IndexTranslationUtil.addUpdateTaxonomyTranslation(resourceRequest);
			json = "{" + "\"response\": \"Success\","
					+ "\"message\": \"Record Inserted Successfully.\"}";
			out.print(json);
			out.flush();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
			json = "{" + "\"response\": \"Failure\","
					+ "\"message\": \"Failure - Exception - Exception\"}";// "+e.getMessage()+"\"}";
			out.print(json);
			out.flush();
			out.close();

		}
	}

	private void downloadErrorExcelSheet(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException 
	{
		try {
			String excelBuffer = resourceRequest.getParameter("excelBuffer");
			String fileName = resourceRequest.getParameter("fileName");
			String fileType = resourceRequest.getParameter("fileType");

			resourceResponse.setContentType("application/vnd.ms-excel");
			resourceResponse.addProperty("Content-Disposition",
					"attachment; filename=\"" + fileName + "." + fileType
							+ "\"");
			PrintWriter out1 = resourceResponse.getWriter();
			out1.print(excelBuffer);
			out1.close();

		} catch (Exception e) {
			LOG.error("Exception in excelErrorReport : " + e);
		}
	}

	private void uploadValidateExcelSheet(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException 
	{
		String json;
		final PrintWriter out;
		out = resourceResponse.getWriter();
		JSONObject recordsjsonObject = null;
		ProgressTracker progressTracker = null;
		String locale = "";
		try {
			try {
				HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
				final boolean isMultipart = PortletFileUpload.isMultipartContent(new ServletRequestContext(request));
				UploadPortletRequest uploadRequest = null;
				if (isMultipart) {
					uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
				}
				locale = ParamUtil.getString(uploadRequest, "localeCd");
				String importProgressId = ParamUtil.getString(uploadRequest, "importProgressId");
				progressTracker = new ProgressTracker(importProgressId);
				ProgressTrackerThreadLocal.setProgressTracker(progressTracker);
				progressTracker.start(resourceRequest);
				recordsjsonObject = readExcelFile(uploadRequest, resourceRequest, resourceResponse, progressTracker);
			} catch (SystemException e) {
			    LOG.error(StackTraceUtil.getStackTrace(e));
			} finally {
				progressTracker.finish(resourceRequest);
			}
			if ((recordsjsonObject != null) && (recordsjsonObject.length() > 0)) 
			{
				resourceResponse.getWriter().print(recordsjsonObject.toString());

			}// end if
			else {
				json = "{" + "\"response\": \"Success\"," + "\"locale\": \""
						+ locale + "\","
						+ "\"message\": \"Record Inserted Successfully.\"}";
				out.print(json);
				out.flush();
				out.close();
			}
		} catch (IOException iox) {
			json = "{" + "\"response\": \"Failure\","
					+ "\"message\": \"Failure - Exception -:"
					+ iox.getMessage() + "\"}";
			out.print(json);
			out.flush();
			out.close();
		} catch (JAXBException jax) {
			json = "{" + "\"response\": \"Failure\","
					+ "\"message\": \"Failure - Exception - Exception\"}";// "+e.getMessage()+"\"}";
			out.print(json);
			out.flush();
			out.close();
		} catch (InvalidFormatException ifx) {
			json = "{" + "\"response\": \"Failure\","
					+ "\"message\": \"Failure - Exception - Exception\"}";// "+e.getMessage()+"\"}";
			out.print(json);
			out.flush();
			out.close();
		}
	}

	public JSONObject readExcelFile(UploadPortletRequest uploadRequest, ResourceRequest resourceRequest, ResourceResponse response,
			ProgressTracker progressTracker) throws IOException, PortletException, InvalidFormatException, JAXBException, SystemException 
	{
		final List<TaxonomyExt> indexes = TaxonomyExtLocalServiceUtil.getAllIndexes();
		JSONObject recordsjsonObject = null;
		String localeCd = "";
		localeCd = ParamUtil.getString(uploadRequest, "localeCd");
		String fileName = uploadRequest.getFileName("file");
		if ((fileName == null) || fileName.equals("")) {
			throw new IOException("No File is selected.Please browse file again!");
		}
		String description = ParamUtil.getString(uploadRequest, "description", fileName);

		File file = uploadRequest.getFile("file");

		LOG.debug(" filename " + fileName + " description " + description + " file " + file);

		ProcessXlsFile processXlsFile = new ProcessXlsFile();
		List<Record> records = processXlsFile.processXls(file, progressTracker, IndexTranslationUtil.taxonomyIds(indexes));
		List<Record> badRecords = null;
		badRecords = processXlsFile.getBadRows(records);
		if (badRecords.size() > 0) {
			// return it in GUI
			recordsjsonObject = JSONFactoryUtil.createJSONObject();
			int percentage = 50;
			int oldPercentage = 50;
			JSONArray rowjsonObject = null;
			JSONObject cell = null;
			JSONArray recordsjsonArray = JSONFactoryUtil.createJSONArray();
			recordsjsonObject.put("page", "1");
			double total_pages = Math.ceil(badRecords.size() / 10);
			recordsjsonObject.put("total", String.valueOf(total_pages));
			recordsjsonObject.put("records ", String.valueOf(badRecords.size()));
			if (!badRecords.isEmpty()) {
				for (int i = 0; i < badRecords.size(); i++) {

					Record record = badRecords.get(i);
					rowjsonObject = JSONFactoryUtil.createJSONArray();
					cell = JSONFactoryUtil.createJSONObject();
					rowjsonObject.put(String.valueOf((record.getId())));
					List<BadCell> cells = record.getBadCell();
					for (BadCell cell1 : cells) {
						LOG.debug("Row=" + cell1.getRow()
								+ "' column name='" + cell1.getColumnName()
								+ "' worksheet='" + cell1.getWorksheet()
								+ "' error message='" + cell1.getErrorMessage()
								+ "' value='" + cell1.getValue() + "'");
						rowjsonObject.put(String.valueOf(cell1.getRow()));
						rowjsonObject.put(String.valueOf(cell1.getColumnName()));
						rowjsonObject.put(String.valueOf(cell1.getValue()));
						rowjsonObject.put(String.valueOf(cell1.getErrorMessage()));
					}

					cell.put("id", String.valueOf(record.getId()));
					cell.put("cell", rowjsonObject);
					recordsjsonArray.put(cell);
					percentage = Math.min(50 + (i * 100) / badRecords.size(), 100);
					if (!(oldPercentage == percentage))
						progressTracker.setPercent(percentage);
					oldPercentage = percentage;
				}
				recordsjsonObject.put("rows", recordsjsonArray);
			}
		} else {
			IndexTranslationUtil.addUpdateExcelTaxonomyTranslations(resourceRequest, records, localeCd, progressTracker);
		}

		return recordsjsonObject;
	}

	public String uploadImageTaxonomy(UploadPortletRequest uploadRequest, ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ProgressTracker progressTracker) throws IOException, NumberFormatException, PortalException, SystemException, FileUploadException 
	{
		String imageUrl = "";
		String fileUrl = "";
		String localeCd = "";
		final ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		final long realUserId = themeDisplay.getRealUserId();

		final PortletPreferences prefs = resourceRequest.getPreferences();
		localeCd = ParamUtil.getString(uploadRequest, "localeCd");

		long groupId = themeDisplay.getScopeGroupId();
		final long folderId = Long.parseLong((String) prefs.getValue("Image_Folder", "0"));
		String fileName = uploadRequest.getFileName("file");
		String taxId = ParamUtil.getString(uploadRequest, "taxId");

		File file = uploadRequest.getFile("file");
		if (fileName == null || fileName.equals("")) {
			throw new IOException("No Image is selected.Please browse image again!");
		}
		TaxonomyTranslate taxTransObj = TaxonomyTranslateLocalServiceUtil.getTaxTransByTaxLangId((long) Double.parseDouble(taxId), localeCd);
		progressTracker.setPercent(10);
		final DLFileEntry fileEntry = IndexTranslationUtil.addOrOverwriteFile( realUserId, groupId, folderId, fileName, file, taxTransObj,
				localeCd, (long) Double.parseDouble(taxId), progressTracker);
		progressTracker.setPercent(90);
		if (fileEntry != null) {
			final String title = fileEntry.getTitle();

			fileUrl = themeDisplay.getPortalURL()
					+ themeDisplay.getPathContext() + "/documents/"
					+ themeDisplay.getScopeGroupId() + "/" + folderId + "/"
					+ HttpUtil.encodeURL(HtmlUtil.unescape(title));
		}

		if (fileUrl != null) {
			final long userId = PortalUtil.getUserId(resourceRequest);
			IndexTranslationUtil.updateUrlTaxTranslation(taxId, localeCd, fileUrl, userId);
			imageUrl = fileUrl;
		}

		return imageUrl;
	}

	@ProcessAction(name = "SavePrefs")
	public void SavePrefs(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException 
	{
		PortletPreferences portletPreferences = actionRequest.getPreferences();
		if (Validator.isNotNull(actionRequest.getParameter("Image_Folder"))) {
			portletPreferences.setValue("Image_Folder", actionRequest.getParameter("Image_Folder"));
		}
		portletPreferences.store();
	}

	public void doEdit(final RenderRequest rRequest, final RenderResponse rResponse) throws PortletException, IOException, UnavailableException 
	{
		rResponse.setContentType("text/html");
		final PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/html/indextranslation/edit.jsp");
		prd.include(rRequest, rResponse);
	}

	@ProcessAction(name = "Cancel")
	public void Cancel(final ActionRequest actionRequest, final ActionResponse actionResponse) throws IOException, PortletException 
	{
		actionResponse.setPortletMode(PortletMode.VIEW);
	}

}
