package com.ihg.brandstandards.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.List;

import com.ihg.brandstandards.db.model.StandardsImages;
import com.ihg.brandstandards.db.service.StandardsImagesLocalServiceUtil;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfStream;
import com.itextpdf.text.pdf.PdfWriter;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

/**
 * Create catalog of Brand Standards images in PDF.
 * 
 * @author KryvorA
 * 
 */
public class ImageCatalogPdfBuilder
{
    private static final Log LOG = LogFactoryUtil.getLog(ImageCatalogPdfBuilder.class);

    /**
     * Default constructor.
     */
    public ImageCatalogPdfBuilder()
    {
    }

    /**
     * Build PDF file with images.
     * 
     * @throws DocumentException exception
     * @throws IOException exception
     */
    public void buildImageCatalog(final OutputStream out) throws DocumentException, IOException
    {
        int totalImages = 0;
        List<StandardsImages> stdImgs = null;
        try
        {
            totalImages = StandardsImagesLocalServiceUtil.getStandardsImagesesCount();
            if (totalImages > 0)
            {
                stdImgs = StandardsImagesLocalServiceUtil.getStandardsImageses(0, totalImages);
            }
            Document document = new Document();

            PdfWriter writer = PdfWriter.getInstance(document, out);
            // best speed, no compression  ??? PdfStream.BEST_SPEED  PdfStream.NO_COMPRESSION
            writer.setCompressionLevel(PdfStream.BEST_SPEED);
            document.open();
            buildTitlePage(document, writer);

            if (!BrandStandardsUtil.isNullOrBlank(stdImgs))
            {
                addImage(document, stdImgs);
            }
            out.flush();
            document.close();
            out.close();
        }
        catch (Exception exc)
        {
            LOG.error("buildCatalog Exception "+exc.getMessage(), exc);
        }
    }

    /**
     * Add Image to the document.
     * 
     * @param document document
     * @throws DocumentException exception
     * @throws BadElementException exception
     * @throws MalformedURLException exception
     * @throws IOException exception
     * @throws SystemException
     * @throws PortalException
     */
    private void addImage(Document document, List<StandardsImages> stdImgs) throws DocumentException, BadElementException,
            MalformedURLException, IOException, PortalException, SystemException
    {
        for (StandardsImages stdImg : stdImgs)
        {
            long uuid = stdImg.getImageId();
            DLFileEntry igImage = null;
			try {
				igImage = DLFileEntryLocalServiceUtil.getDLFileEntry(uuid);
			} catch (Exception e) {
				LOG.error("ImageCatalogPdfBuilder:Failed to get image with UUID:"+uuid, e);
			}
			
			if(igImage != null) {
	            //com.liferay.portal.model.Image lrImage = com.liferay.portal.service.ImageLocalServiceUtil.getImage(igImage.getLargeImageId());
	            //User user = UserLocalServiceUtil.getUser(Long.valueOf(stdImg.getCreatorId()));
	            User user = null;
	            String fullName = "Does not exist";
	            try {
	            	user = UserLocalServiceUtil.getUserById(Long.valueOf(stdImg.getCreatorId()));
	            } catch(Exception e) { }
	            if(user != null) {
	            	fullName = user.getFullName();
	            }
	            PdfPTable table = new PdfPTable(2);
	            table.setTotalWidth(new float[] { 100, 420 });
	            table.setLockedWidth(true);
	            table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
	            table.setHorizontalAlignment(Element.ALIGN_LEFT);
	
	            table.addCell(new Phrase(new Paragraph("Image ID:", new Font(FontFamily.COURIER, 12, Font.BOLD))));
	           /* table.addCell(new Phrase(new Paragraph("" + igImage.getImageId(), new Font(FontFamily.COURIER, 10))));*/
	            table.addCell(new Phrase(new Paragraph("" + igImage.getFileEntryId(), new Font(FontFamily.COURIER, 10))));
	
	            table.addCell(new Phrase(new Paragraph("Title:", new Font(FontFamily.COURIER, 12, Font.BOLD))));
	            table.addCell(new Phrase(new Paragraph(igImage.getName(), new Font(FontFamily.COURIER, 10))));
	
	            table.addCell(new Phrase(new Paragraph("Description:", new Font(FontFamily.COURIER, 12, Font.BOLD))));
	            table.addCell(new Phrase(new Paragraph(igImage.getDescription(), new Font(FontFamily.COURIER, 10))));
	
	            table.addCell(new Phrase(new Paragraph("Author:", new Font(FontFamily.COURIER, 12, Font.BOLD))));
	            table.addCell(new Phrase(new Paragraph(fullName, new Font(FontFamily.COURIER, 10))));
	
	            document.add(table);
	            
	            //Image img = Image.getInstance(lrImage.getTextObj());
	            
	            byte[] dlFileByte = new byte[0];
	            try
	            {
	            	InputStream inputStream = DLFileEntryLocalServiceUtil.getFileAsStream(igImage.getUserId(), igImage.getFileEntryId(), StringPool.BLANK);
	                byte[] buffer = new byte[8192];
	                ByteArrayOutputStream output = new ByteArrayOutputStream();
	                int bytesRead;
	                while ((bytesRead = inputStream.read(buffer)) != -1)
	                {
	                    output.write(buffer, 0, bytesRead);
	                }
	                dlFileByte = output.toByteArray();
	            }
	            catch (Exception e)
	            {
	                LOG.error("Failed to get DLFileEntry as stream with fileEntryId:"+igImage.getFileEntryId(), e);
	            }
	            
	            Image img = Image.getInstance(dlFileByte);
	            img.setAbsolutePosition((PageSize.A4.getWidth() - img.getScaledWidth()) / 2,
	                    (PageSize.A4.getHeight() - img.getScaledHeight()) / 2);
	            Paragraph p = new Paragraph();
	            p.add(Chunk.NEWLINE);
	            p.add(new Chunk(img, 0, 0, true));
	
	            document.add(p);
        	}
        }
    }

    /**
     * Build PDF file Title page.
     * 
     * @param document document
     * @param writer writer of the document
     * @throws BadElementException exception
     * @throws MalformedURLException exception
     * @throws IOException exception
     * @throws DocumentException exception
     */
    private void buildTitlePage(Document document, PdfWriter writer) throws BadElementException, MalformedURLException,
            IOException, DocumentException
    {
        String path = ImageCatalogPdfBuilder.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String imgPath = path.substring(0, path.indexOf("WEB-INF")) + "images/hompage.jpg";

        Image imgTitle = Image.getInstance(imgPath);
        imgTitle.setAbsolutePosition((PageSize.A4.getWidth() - imgTitle.getScaledWidth()) / 2,
                (PageSize.A4.getHeight() - imgTitle.getScaledHeight()) / 2);
        Paragraph imgp = new Paragraph();
        imgp.add(new Chunk(imgTitle, 0, 0, true));
        document.add(imgp);

        document.add(Chunk.NEWLINE);

        Paragraph titlePrg1 = new Paragraph();
        titlePrg1.setAlignment(Element.ALIGN_CENTER);
        titlePrg1.add(new Chunk("Date: " + new Date().toString(), new Font(FontFamily.TIMES_ROMAN, 10)));
        document.add(titlePrg1);

        // Add text on top of the image
        PdfContentByte over = writer.getDirectContent();
        over.saveState();
        //        float sinus = (float)Math.sin(Math.PI / 60);
        //        float cosinus = (float)Math.cos(Math.PI / 60);
        //        BaseFont bf = BaseFont.createFont();
        BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);
        over.beginText();
        over.setTextRenderingMode(PdfContentByte.TEXT_RENDER_MODE_FILL /*TEXT_RENDER_MODE_FILL_STROKE*/);
        over.setLineWidth(1.5f);
        over.setRGBColorStroke(0x00, 0x00, 0x00);
        over.setRGBColorFill(0x00, 0x00, 0x00);
        over.setFontAndSize(bf, 26);
        //        over.setTextMatrix(cosinus, sinus, -sinus, cosinus, 250, 750);
        over.setTextMatrix(220, 750);
        over.showText("Image Catalog");
        over.endText();
        over.restoreState();

        document.add(Chunk.NEXTPAGE);
    }
}
