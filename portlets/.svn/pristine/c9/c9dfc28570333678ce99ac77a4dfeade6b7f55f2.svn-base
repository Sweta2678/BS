package com.ihg.brandstandards.scheduler;

import java.io.File;
import java.io.FileOutputStream;

import com.ihg.brandstandards.service.AkamaiFTPDataSource;
import com.ihg.brandstandards.service.ImageCatalogPdfBuilder;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

/**
 * Image Catalog Job.
 * 
 * @author KryvorA
 * 
 */
public class ImageCatalogJob implements MessageListener
{

    private static final Log LOG = LogFactoryUtil.getLog(ImageCatalogJob.class);

    public void receive(Message message) throws MessageListenerException
    {
    	LOG.info("BSAdmin-portlet Image Catalog Generate PDF Job - Started");
    	//String path = System.getProperty("catalina.base")+"/webapps/BSAdmin-portlet/images";
    	String path = ImageCatalogJob.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        path = path.substring(0, path.indexOf("WEB-INF")) + BrandStandardsUtil.BS_IMG_FOLDER;
        LOG.info("BSAdmin-portlet Image Catalog PDF path:"+path+"/"+BrandStandardsUtil.BS_IMG_CATALOG_FILE);
        try
        {
            File catalogPDFFile = new File(path, BrandStandardsUtil.BS_IMG_CATALOG_FILE);
            if (catalogPDFFile.exists())
            {
            	catalogPDFFile.delete();
            }
            catalogPDFFile.createNewFile();
            final ImageCatalogPdfBuilder pdfBuilder = new ImageCatalogPdfBuilder();
            pdfBuilder.buildImageCatalog(new FileOutputStream(catalogPDFFile));
            
            try {
				AkamaiFTPDataSource akamaiClient = new AkamaiFTPDataSource();
				akamaiClient.initProps();
				akamaiClient.addFileToAkamaiGetPath(BrandStandardsUtil.BS_IMG_CATALOG_FILE, "manuals", catalogPDFFile);
			} catch (Exception e) {
				LOG.error("Failed to upload Image Catalog PDF to Akamai", e);
			}
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
        LOG.info("BSAdmin-portlet Image Catalog Generate PDF Job - Completed");
    }

}
