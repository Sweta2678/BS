package com.ihg.brandstandards.xml.metadata;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.bind.JAXBException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


/**
 * Bean to store Reports configurations.
 * 
 * @author kryvora
 * 
 */
public class MetadataLoader
{
    private static final Log LOG = LogFactoryUtil.getLog(MetadataLoader.class);

    private static Metadata metadata;
    private String xmlMetadata;

    /**
     * Default constructor.
     */
    public MetadataLoader()
    {
    }

    /**
     * Preferred constructor.
     * 
     * @param metadata file name including path
     */
    public MetadataLoader(String xmlMetadata)
    {
        this.xmlMetadata = xmlMetadata;
    }

    /**
     * Load report configurations.
     */
    public void loadMetadata()
    {
        loadMetadata(xmlMetadata);
    }

    /**
     * Load report configurations.
     * 
     * @param fileName file name
     */
    public void loadMetadata(String xmlMetadata)
    {
        InputStream stream = new ByteArrayInputStream(xmlMetadata.getBytes());
        loadMetadata(stream);
    }

    /**
     * Load report configurations.
     * 
     * @param stream input stream
     */
    public synchronized static void loadMetadata(InputStream stream)
    {
        try
        {
            metadata = MetadataFactory.createMetadata(stream);
            LOG.debug("Loaded metadata type: " + metadata.getType());
        }
        catch (JAXBException e)
        {
            LOG.error("Failed to load metadata: ", e);
        }
    }

    /**
     * @return the metadata
     */
    public static Metadata getMetadata()
    {
        return metadata;
    }

    /**
     * @param metadata the metadata to set
     */
    public static void setMetadata(Metadata metadata)
    {
        MetadataLoader.metadata = metadata;
    }
}
