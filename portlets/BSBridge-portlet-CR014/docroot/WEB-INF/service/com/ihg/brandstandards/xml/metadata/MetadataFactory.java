package com.ihg.brandstandards.xml.metadata;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Report Configuration Factory.
 * 
 * @author kryvora
 * 
 */
public class MetadataFactory
{
    /**
     * Create Metadata from string.
     * 
     * @param xmlMetadata xml string
     * @return Metadata
     * @throws JAXBException exception
     */
    public static Metadata createMetadata(String xmlMetadata) throws JAXBException
    {
        InputStream stream = new ByteArrayInputStream(xmlMetadata.getBytes());
        return createMetadata(stream);
    }

    /**
     * Create Metadata from InputStream.
     * 
     * @param stream InputStream
     * @return Metadata
     * @throws JAXBException jaxb exception
     */
    public static Metadata createMetadata(InputStream stream) throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(new Class[] { Metadata.class });
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setEventHandler(new MetadataValidationEventHandler());
        Metadata metadata = (Metadata)unmarshaller.unmarshal(stream);
        return metadata;
    }
}
