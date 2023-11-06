package com.ihg.portlet.security.document;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import com.ihg.portlet.security.util.SecurityConstants;
import com.ihg.portlet.security.util.SecurityUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Group;

public class ImageCompressionUtil 
{
	private final static Log LOG_4 = LogFactoryUtil.getLog(ImageCompressionUtil.class);
	
 public static final String [] IMAGE_COMPRESSION_COMMUNITY_TAGS  = {SecurityConstants.INITIATIVE_TAG_NAME,SecurityConstants.CONFERENCE_TAG_NAME,SecurityConstants.TEAMSPACE_TAG_NAME};
	 
	 public static final List<String>  IMAGE_COMPRESSION_COMMUNITY_TAGS_LIST= new ArrayList<String>(Arrays.asList(IMAGE_COMPRESSION_COMMUNITY_TAGS));
	
	/**
	 * @param mimeType
	 * @param file
	 * @return
	 */
	public static File compressImageOrVideo(String mimeType, File file)
	{
		if(mimeType.equals("video/mp4"))
		{
			 if(LOG_4.isDebugEnabled())
	         {
	            	LOG_4.debug("Compressing Video ...");
	         }
	        File output = new File(file.getParent(),"processed_"+file.getName());
	        try 
	        {
	            JQTFastStart.process(file, output);
				if(output.length()<=0){
		           	//FastStart detected wrong MP4 Format. Do Nothing just upload original file
		        }else{
		           	//Upload FastStart enabled file
		           	file = output;
		        }
	        } catch(FastStartException ex) 
	        {
	        	LOG_4.error(ex.getMessage());
	        }

		}else if(mimeType.equals("image/jpeg") || mimeType.equals("image/png") || mimeType.equals("image/gif"))
		{
			if(LOG_4.isDebugEnabled())
	        {
	            	LOG_4.debug("Compressing Image ...");
	        }
			file = imagecompress(file);
		}
		
		return file;
	}
	
	
	/**
	 * @param mimeType
	 * @param bytes
	 * @return
	 */
	public static File compressImageOrVideo(String mimeType, byte[] bytes)
	{
		File file = byteToFile(bytes); 
		
		file= compressImageOrVideo(mimeType, file);
		
		return file;
	}
	
	
	/**
	 * @param mimeType
	 * @param is
	 * @return
	 */
	public static File compressImageOrVideo(String mimeType, InputStream is)
	{
		File file = inputStreamToFile(is); 
		
		file= compressImageOrVideo(mimeType, file);
		
		return file;
	}
	
	//Image Compress below
	public static File imagecompress(File filetoCompress)
	{
		
				File compressedImageFile = null;
				try
				{
					BufferedImage image = ImageIO.read(filetoCompress);	 
					String orgFile = filetoCompress.toString();
					if(image != null){
						//Check if there is any Transparent layer
						if( image.getColorModel().getTransparency() != Transparency.OPAQUE) {
						    image = fillTransparentPixels(image, Color.WHITE);
						}
						
						compressedImageFile = new File(orgFile);
						OutputStream os =new FileOutputStream(compressedImageFile);
					
						Iterator<ImageWriter>writers =  ImageIO.getImageWritersByFormatName("jpg");
						ImageWriter writer = (ImageWriter) writers.next();
					
						ImageOutputStream ios = ImageIO.createImageOutputStream(os);
						writer.setOutput(ios);
					
						ImageWriteParam param = writer.getDefaultWriteParam();
					  
						param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
						param.setCompressionQuality(0.6f);
						
						writer.write(null, new IIOImage(image, null, null), param);	
						
					  	os.close();
						ios.close();
						writer.dispose();						
					}else 
					{
						LOG_4.info("*** Throwing document back without processing ***");
						compressedImageFile = filetoCompress;
					}
					
					}catch(IOException ex)
					{
						LOG_4.info("*** Cannot compress this image, please change the colour profile from CMYK to RGB. Uploading uncompressed version!!! ***");
						compressedImageFile = filetoCompress;
					}
					return compressedImageFile;
	}
	//End Image Compress Function
	
	
	/**
	 * @param bytes
	 * @return
	 */
	public static File byteToFile(byte[] bytes)
	{
		File file = null;
		try 
		{
			file = File.createTempFile("tempfile", ".tmp"); 
		} catch (IOException e2) 
		{
			e2.printStackTrace();
		} 
		file.deleteOnExit(); 
	    try 
	    {
	    	FileOutputStream fileOuputStream = new FileOutputStream(file); 
			fileOuputStream.write(bytes);
			fileOuputStream.close();
							
		} catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		return file;
	}
	
	/**
	 * @param is
	 * @return
	 */
	public static File inputStreamToFile(InputStream is)
	{
		File file = null;
		OutputStream os = null;
		try {
			
			file = File.createTempFile("tempfile", ".tmp"); 
			file.deleteOnExit();
			os = new FileOutputStream(file);
			
			int read = 0;
			byte[] bytes = new byte[1024];
	 
			while ((read = is.read(bytes)) != -1) 
			{
				os.write(bytes, 0, read);
			}	 
		} catch (IOException e) 
		{
			e.printStackTrace();
		} finally 
		{
			if (is != null) 
			{
				try 
				{
					is.close();
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
			if (os != null) 
			{
				try 
				{
					// outputStream.flush();
					os.close();
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
	 
			}
		}
		
		return file;
	}
	
	/**
	 * @param file
	 * @return
	 */
	public static byte[] fileToByte(File file)
	{
		
		byte[] bytes = new byte[(int) file.length()];
	    FileInputStream fileInputStream=null;
        try 
        {
            //convert file into array of bytes
	    fileInputStream = new FileInputStream(file);
	    fileInputStream.read(bytes);
	    fileInputStream.close();
 	    
        }catch(Exception e)
        {
        	e.printStackTrace();
        }
		return bytes;
	}
	
	/**
	 * @param BufferedImage
	 * @return
	*/
	public static BufferedImage fillTransparentPixels( BufferedImage image, 
            Color fillColor ) {
		int w = image.getWidth();
		int h = image.getHeight();
		BufferedImage image2 = new BufferedImage(w, h, 
		BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image2.createGraphics();
		g.setColor(fillColor);
		g.fillRect(0,0,w,h);
		g.drawRenderedImage(image, null);
		g.dispose();
		return image2;
	}
	
	/**
	 * @param group
	 * @return
	 */
	public static boolean isOrgOrMerlinCommunity(Group group )
	{
		boolean flag = false;
		
		if(group.isOrganization() || SecurityUtil.isCommunityHavingMerlinTagAndCommunityTag(group, IMAGE_COMPRESSION_COMMUNITY_TAGS_LIST))
		{
			flag = true;
		}
		return flag;
	}
	
	/**
	 * @param mimeType
	 * @return
	 */
	public static boolean isVideoOrImage(String mimeType)
	{
		boolean flag = false;
		
		if(mimeType.equals("image/jpeg") || mimeType.equals("image/png") || mimeType.equals("image/gif") || mimeType.equals("video/mp4"))
		{
			flag=true;
		}
		return flag;
	}
	
}
