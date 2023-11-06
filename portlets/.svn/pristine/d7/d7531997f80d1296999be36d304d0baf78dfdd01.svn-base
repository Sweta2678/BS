package com.ihg.brandstandards.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;

import com.ihg.brandstandards.util.BSAdminConstants;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * <a href="this.java.html"><b><i>View Source</i></b></a>
 * 
 * @Project Brand Standards
 * @Author Vipul Dave
 */
public class AkamaiFTPDataSource
{
    private static final Log LOG = LogFactoryUtil.getLog(AkamaiFTPDataSource.class);
    private static final String ENV_PROPERTY_NAME = "app.environment.type";
    
    private String ftpServerName;
    private int port;
    private boolean isSecure;
    private String userName;
    private String password;
    private String rootDirPath;
    private String ihgRootDir;
    private String ihgAccessMappingDir;
    private String ihgEnvironmentMappingDir;
    private String ihgStagingMappingDir;
    private String ihgDownloadsDestDir;
    private long fileMaxSize;

    /**
     * Default Constructor
     */
    public AkamaiFTPDataSource()
    {
        //LOG.debug("New object created::this.);
    }

    /**
     * Argument Constructor
     * 
     * @param ftpServerName
     * @param port
     * @param isSecure
     * @param userName
     * @param password
     * @param rootDirPath
     * @param ihgRootDir
     * @param ihgAccessMappingDir
     * @param ihgEnvironmentMappingDir
     * @param ihgDownloadsDestDir
     */
    public AkamaiFTPDataSource(String ftpServerName, int port, boolean isSecure, String userName, String password,
            String rootDirPath, String ihgRootDir, String ihgAccessMappingDir, String ihgEnvironmentMappingDir,
            String ihgStagingMappingDir, String ihgDownloadsDestDir, long fileMaxSize)
    {
        super();
        this.ftpServerName = ftpServerName.trim();
        this.port = port;
        this.isSecure = isSecure;
        this.userName = userName.trim();
        this.password = password.trim();
        this.rootDirPath = rootDirPath.trim();
        this.ihgRootDir = ihgRootDir.trim();
        this.ihgAccessMappingDir = ihgAccessMappingDir.trim();
        this.ihgEnvironmentMappingDir = ihgEnvironmentMappingDir.trim();
        this.ihgStagingMappingDir = ihgStagingMappingDir.trim();
        this.ihgDownloadsDestDir = ihgDownloadsDestDir.trim();
        this.fileMaxSize = fileMaxSize;
    }
    public void initProps()
    {
        this.ftpServerName = PortletProps.get("akamai.ftp.server.name");
        this.port = Integer.valueOf(PortletProps.get("akamai.ftp.server.port"));
        this.isSecure = Boolean.valueOf(PortletProps.get("akamai.ftp.server.secure"));
        this.userName = PortletProps.get("akamai.ftp.server.user.name");
        this.password = PortletProps.get("akamai.ftp.server.password");
        this.rootDirPath = PortletProps.get("akamai.ftp.server.root.dir");
        this.ihgRootDir = PortletProps.get("akamai.ftp.server.ihg.root.dir");
        this.ihgAccessMappingDir = PortletProps.get("akamai.ftp.server.ihg.accessing.mapping.dir");
        String environment = System.getProperty(ENV_PROPERTY_NAME) != null ? System.getProperty(ENV_PROPERTY_NAME).trim() : null;
        
        if (environment.equals("ENVIRONMENT_QA"))
        {
        	this.ihgEnvironmentMappingDir = PortletProps.get("akamai.ftp.server.ihg.qa.mapping.dir");
        } else if(environment.equals("ENVIRONMENT_PROD")) 
        {
        	this.ihgEnvironmentMappingDir = PortletProps.get("akamai.ftp.server.ihg.prod.mapping.dir");
        } else
        {
        	this.ihgEnvironmentMappingDir = PortletProps.get("akamai.ftp.server.ihg.environment.mapping.dir");
        }
        if(LOG.isDebugEnabled()){
            LOG.debug("environment value ::::" +this.ihgEnvironmentMappingDir);
        }
        this.ihgStagingMappingDir = PortletProps.get("akamai.ftp.server.ihg.environment.staging.mapping.dir");
        this.ihgDownloadsDestDir = PortletProps.get("akamai.ftp.server.ihg.downloads.dest.dir");
        this.fileMaxSize = Long.valueOf(PortletProps.get("akamai.ftp.file.max.size"));
    }
    /**
     * This method will add the file to Akamai.
     * 
     * @param ftpAbsoluteFolderPath
     * @param fileName
     * @param file
     */
    public void addFileToAkamai(String ftpAbsoluteFolderPath, String fileName, File file) throws IOException
    {
        uploadToFTP(fileName, file, ftpAbsoluteFolderPath);
    }

    /**
     * This method will delete the file from Akamai.
     * 
     * @param filePathName
     */
    public boolean deleteFileFromAkamai(String filePathName) throws IOException
    {
        return delete(filePathName);
    }

    /**
     * This method will download the file from Akamai.
     * 
     * @param ftpAbsoluteFolderPath
     * @param akamaiFileName
     * @param downloadDestination
     * @throws IOException
     */
    public void downloadFileFromAkamai(String ftpAbsoluteFolderPath, String akamaiFileName, File downloadDestination)
            throws IOException
    {
        download(ftpAbsoluteFolderPath, akamaiFileName, downloadDestination);
    }

    /**
     * This method will return InputStream of the file from Akamai.
     * 
     * @param ftpAbsoluteFolderPath
     * @param akamaiFileName
     * @throws IOException
     */
    public InputStream getFileAsStreamFromAkamai(String ftpAbsoluteFolderPath, String akamaiFileName) throws IOException
    {
        return getFileAsStream(ftpAbsoluteFolderPath, akamaiFileName);
    }

    /**
     * This method will build the Full path of a FTP Directory. Please pass the arguments with "/directory"
     * 
     * @param ihgRootDir
     * @param ihgAccessMappingDir
     * @param environmentPath
     * @param ihgDownloadsDestDir
     * @param environment
     * @param destFolderName
     * @return destFolderName
     */
    public String buildAkamaiDirectoryPath(String ihgRootDir, String ihgAccessMappingDir, String environmentPath,
            String ihgDownloadsDestDir, String environment, String destFolderName)
    {
        StringBuffer dirPath = new StringBuffer();

        if (ihgRootDir != null && !ihgRootDir.trim().isEmpty())
        {
            dirPath.append(ihgRootDir.trim());
        }
        else
        {
            dirPath.append(this.ihgRootDir);
        }

        if (ihgAccessMappingDir != null && !ihgAccessMappingDir.trim().isEmpty())
        {
            if (ihgAccessMappingDir.startsWith("/"))
            {
                dirPath.append(ihgAccessMappingDir.trim());
            }
            else
            {
                dirPath.append("/" + ihgAccessMappingDir.trim());
            }
        }
        else
        {
            dirPath.append(this.ihgAccessMappingDir);
        }

        if (environmentPath != null && !environmentPath.trim().isEmpty())
        {
            if (environmentPath.startsWith("/"))
            {
                dirPath.append(environmentPath.trim());
            }
            else
            {
                dirPath.append("/" + environmentPath.trim());
            }
        }
        else
        {
            dirPath.append(this.ihgEnvironmentMappingDir);
        }

        if (ihgDownloadsDestDir != null && !ihgDownloadsDestDir.trim().isEmpty())
        {
            if (ihgDownloadsDestDir.startsWith("/"))
            {
                dirPath.append(ihgDownloadsDestDir.trim());
            }
            else
            {
                dirPath.append("/" + ihgDownloadsDestDir.trim());
            }
        }
        else
        {
            dirPath.append(this.ihgDownloadsDestDir);
        }

        if (environment != null && !environment.trim().isEmpty())
        {
            if (environment.startsWith(BSAdminConstants.ENVIRONMENT_STAGING))
            {
                dirPath.append(this.ihgStagingMappingDir);
            }
        }

        if (destFolderName != null && !destFolderName.trim().isEmpty())
        {
            if (destFolderName.startsWith("/"))
            {
                dirPath.append(destFolderName.trim());
            }
            else
            {
                dirPath.append("/" + destFolderName.trim());
            }
        }

        return dirPath.toString();
    }

    /**
     * This method will build the Full path of a FTP Directory. Please pass the arguments with "/directory"
     * 
     * @param ihgAccessMappingDir
     * @param environmentPath
     * @param ihgDownloadsDestDir
     * @param environment
     * @param destFolderName
     * @return fileName
     */
    public String buildAkamaiFileDownloadPath(String ihgAccessMappingDir, String environmentPath, String ihgDownloadsDestDir,
            String environment, String destFolderName, String fileName)
    {
        StringBuffer dirPath = new StringBuffer();

        if (ihgAccessMappingDir != null && !ihgAccessMappingDir.equalsIgnoreCase(""))
        {
            if (ihgAccessMappingDir.startsWith("/"))
            {
                dirPath.append(ihgAccessMappingDir.trim());
            }
            else
            {
                dirPath.append("/" + ihgAccessMappingDir.trim());
            }
        }
        else
        {
            dirPath.append(this.ihgAccessMappingDir);
        }

        if (environmentPath != null && !environmentPath.equalsIgnoreCase(""))
        {
            if (environmentPath.startsWith("/"))
            {
                dirPath.append(environmentPath.trim());
            }
            else
            {
                dirPath.append("/" + environmentPath.trim());
            }
        }
        else
        {
            dirPath.append(this.ihgEnvironmentMappingDir);
        }

        if (ihgDownloadsDestDir != null && !ihgDownloadsDestDir.equalsIgnoreCase(""))
        {
            if (ihgDownloadsDestDir.startsWith("/"))
            {
                dirPath.append(ihgDownloadsDestDir.trim());
            }
            else
            {
                dirPath.append("/" + ihgDownloadsDestDir.trim());
            }
        }
        else
        {
            dirPath.append(this.ihgDownloadsDestDir);
        }

        if (environment != null && !environment.trim().isEmpty())
        {
            if (environment.startsWith(BSAdminConstants.ENVIRONMENT_STAGING))
            {
                dirPath.append(this.ihgStagingMappingDir);
            }
        }

        if (destFolderName != null && !destFolderName.isEmpty())
        {
            if (destFolderName.startsWith("/"))
            {
                dirPath.append(destFolderName.trim());
            }
            else
            {
                dirPath.append("/" + destFolderName.trim());
            }
        }

        if (fileName != null && !fileName.equalsIgnoreCase(""))
        {
            if (fileName.startsWith("/"))
            {
                dirPath.append(fileName.trim());
            }
            else
            {
                dirPath.append("/" + fileName.trim());
            }
        }

        return dirPath.toString();
    }

    /**
     * Upload a file to a FTP server. A FTP URL is generated with the following syntax:
     * ftp://user:password@host:port/filePath;type=i.
     * 
     * @param fileName, Destination file name on FTP server, e.g. "myFile.txt".
     * @param source, Source file to upload.
     * @throws IOException on error.
     */
    private void uploadToFTP(String fileName, File source, String ftpAbsoluteFolderPath) throws IOException
    {
        int replyCode = 0;

        if (fileName != null && source != null)
        {
            FTPClient client = createFtpClient();
            FileInputStream fileInputStream = null;
            try
            {
                initFtpClient(client);
                client.changeWorkingDirectory(rootDirPath);
                replyCode = client.getReplyCode();
                if (replyCode != 250)
                { // 250 CWD successful.
                    LOG.error("FTP change to '" + rootDirPath + "' directory failed with code: " + client.getReplyString());
                }
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("FTP change to '" + rootDirPath + "' directory code: " + client.getReplyString());
                }
                //Move the client to root destination directory
                moveToDirectoryStructure(client, ftpAbsoluteFolderPath);

                fileInputStream = new FileInputStream(source);
                if(LOG.isDebugEnabled()){
                    LOG.debug("Start FTP uploading file : " + fileName + " source : " + source + " file size : " + source.length()
                        + " fis : " + fileInputStream);
                }
                client.storeFile(fileName, fileInputStream);
                // 226 Transfer OK
                replyCode = client.getReplyCode();
                if (replyCode != 226)
                {
                    LOG.error("FTP file transfer failed with code: " + client.getReplyString());
                }
                if(LOG.isDebugEnabled()){
                    LOG.debug("FTP reply code is : " + client.getReplyString());
                }
                //Move the client to root directory
                client.changeWorkingDirectory(rootDirPath);
                replyCode = client.getReplyCode();
                if (replyCode != 250)
                {  // 250 CWD successful.
                    LOG.error("createDirectoryStructure: Fail to change FTP directory to : " + rootDirPath + " reply code: "
                            + client.getReplyString());
                    throw new IOException("createDirectoryStructure: Fail to change FTP directory : " + rootDirPath
                            + " reply code: " + client.getReplyString());
                }
                client.logout();
            }
            finally
            {
                if (fileInputStream != null)
                {
                    fileInputStream.close();
                }
                disconnectFtpClient(client);
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("Disconnect FTP client");
                }
            }
        }
        else
        {
            LOG.error("Input not available.");
        }
    }

    /**
     * This method will add the file to Akamai.
     * 
     * @param ftpAbsoluteFolderPath
     * @param fileName
     * @param file
     */
    public String addFileToAkamaiGetPath(String fileName, String ftpAbsoluteFolderPath, File file) throws IOException
    {
        return uploadToFTP(fileName, ftpAbsoluteFolderPath, file);
    }

    /**
     * Upload a file to a FTP server. A FTP URL is generated with the following syntax:
     * ftp://user:password@host:port/filePath;type=i.
     * 
     * @param fileName, Destination file name on FTP server, e.g. "myFile.txt".
     * @param ftpAbsoluteFolderPath file path
     * @param source, Source file to upload.
     * @throws IOException on error.
     */
    public String uploadToFTP(String fileName, String ftpAbsoluteFolderPath, File source) throws IOException
    {
        int replyCode = 0;
        String path = rootDirPath + ihgRootDir + ihgAccessMappingDir + ihgEnvironmentMappingDir + ihgDownloadsDestDir;

        if (fileName != null && source != null)
        {
            FTPClient client = createFtpClient();
            FileInputStream fileInputStream = null;
            try
            {
                initFtpClient(client);
                client.changeWorkingDirectory(path);
                replyCode = client.getReplyCode();
                if (replyCode != 250)
                { // 250 CWD successful.
                    LOG.error("FTP change to '" + path + "' directory failed with code: " + client.getReplyString());
                }
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("FTP change to '" + path + "' directory code: " + client.getReplyString());
                }
                //Move the client to root destination directory
                moveToDirectoryStructure(client, ftpAbsoluteFolderPath);

                fileInputStream = new FileInputStream(source);
                if(LOG.isDebugEnabled()){
                    LOG.debug("Start FTP uploading file : " + fileName + " source : " + source + " file size : " + source.length()
                        + " fis : " + fileInputStream);
                }
                client.storeFile(fileName, fileInputStream);
                // 226 Transfer OK
                replyCode = client.getReplyCode();
                if (replyCode != 226)
                {
                    LOG.error("FTP file transfer failed with code: " + client.getReplyString());
                }
                if(LOG.isDebugEnabled()){
                    LOG.debug("FTP reply code is : " + client.getReplyString());
                }
                //Move the client to root directory
                client.changeWorkingDirectory(path);
                replyCode = client.getReplyCode();
                if (replyCode != 250)
                {  // 250 CWD successful.
                    LOG.error("createDirectoryStructure: Fail to change FTP directory to : " + path + " reply code: "
                            + client.getReplyString());
                    throw new IOException("createDirectoryStructure: Fail to change FTP directory : " + path + " reply code: "
                            + client.getReplyString());
                }
                client.logout();
            }
            finally
            {
                if (fileInputStream != null)
                {
                    fileInputStream.close();
                }
                disconnectFtpClient(client);
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("Disconnect FTP client");
                }
            }
        }
        else
        {
            LOG.error("Input not available.");
        }
        return ihgAccessMappingDir + ihgEnvironmentMappingDir + ihgDownloadsDestDir + "/" + ftpAbsoluteFolderPath + "/"
                + fileName;
    }

    /**
     * This method will move to the directory path provided as argument.
     * 
     * @param client
     * @param ftpAbsoluteFolderPath
     * @throws IOException
     */
    private void moveToDirectoryStructure(FTPClient client, String ftpAbsoluteFolderPath) throws IOException
    {
        int replyCode;
        client.changeWorkingDirectory(ftpAbsoluteFolderPath);
        replyCode = client.getReplyCode();
        if (replyCode != 250)
        { // 250 CWD successful.
            if (ftpAbsoluteFolderPath.contains("/"))
            {
                String[] dirs = ftpAbsoluteFolderPath.split("/");
                for (int i = 0; i < dirs.length; i++)
                {
                    createAndGoToDir(client, dirs[i]);
                }
            }
            else
            {
                createAndGoToDir(client, ftpAbsoluteFolderPath);
            }
        }
    }

    /**
     * This method will move to the directory path provided as argument and if the directory path not exist it will create the
     * directory path and move to it.
     * 
     * @param client
     * @param directory
     * @throws IOException
     */
    private void createAndGoToDir(FTPClient client, String directory) throws IOException
    {
        int replyCode;
        client.mkd(directory);
        replyCode = client.getReplyCode();
        if (replyCode != 257 && replyCode != 550)
        {  // 257 Directory created successfully; 550 Directory already exists
            LOG.error("createAndGoToDir: Fail to create FTP directory : " + directory + " reply code: "
                    + client.getReplyString());
            throw new IOException("createAndGoToDir: Fail to create FTP directory : " + directory + " reply code: "
                    + client.getReplyString());
        }
        if (LOG.isDebugEnabled())
        {
            LOG.debug("createAndGoToDir: FTP create " + directory + " dir reply code is : " + client.getReplyString());
        }
        client.changeWorkingDirectory(directory);
        replyCode = client.getReplyCode();
        if (replyCode != 250)
        {  // 250 CWD successful.
            LOG.error("createAndGoToDir: Fail to change FTP directory to : " + directory + " reply code: "
                    + client.getReplyString());
            throw new IOException("createAndGoToDir: Fail to change FTP directory : " + directory + " reply code: "
                    + client.getReplyString());
        }
        if (LOG.isDebugEnabled())
        {
            LOG.debug("createAndGoToDir: FTP change to " + directory + " dir reply code is : " + client.getReplyString());
        }
    }

    /**
     * This method will download the file from Akamai.
     * 
     * @param ftpAbsoluteFolderPath
     * @param akamaiFileName
     * @param downloadDestination
     * @throws IOException
     */
    public void download(String ftpAbsoluteFolderPath, String akamaiFileName, File downloadDestination) throws IOException
    {
        if (akamaiFileName != null && downloadDestination != null && ftpAbsoluteFolderPath != null)
        {
            FTPClient client = createFtpClient();
            FileOutputStream fos = null;

            try
            {
                initFtpClient(client);
                client.changeWorkingDirectory(rootDirPath);
                //Move the client to root destination directory
                moveToDirectoryStructure(client, ftpAbsoluteFolderPath);
                client.setBufferSize(1024);
                fos = new FileOutputStream(downloadDestination);
                client.retrieveFile(akamaiFileName, fos);
                client.logout();
            }
            finally
            {
                if (fos != null)
                {
                    fos.close();
                }

                disconnectFtpClient(client);
            }
        }
        else
        {
            LOG.error("Input not available");
        }
    }

    /**
     * This method will download the file from Akamai.
     * 
     * @param akamaiFileName
     * @param ftpAbsoluteFolderPath
     * @throws IOException
     */
    public InputStream getFileAsStream(String ftpAbsoluteFolderPath, String akamaiFileName) throws IOException
    {
        InputStream inputStream = null;
        if (akamaiFileName != null && ftpAbsoluteFolderPath != null)
        {
            FTPClient client = createFtpClient();
            try
            {
                initFtpClient(client);
                client.changeWorkingDirectory(rootDirPath);
                //Move the client to root destination directory
                moveToDirectoryStructure(client, ftpAbsoluteFolderPath);
                client.setBufferSize(1024);
                inputStream = client.retrieveFileStream(akamaiFileName);
                client.logout();
            }
            finally
            {
                disconnectFtpClient(client);
            }
        }
        else
        {
            LOG.error("Input not available");
        }
        return inputStream;
    }

    /**
     * This method will delete the file from the Akamai server.
     * 
     * @param filePathName
     * @throws IOException
     */
    public boolean delete(String filePathName) throws IOException
    {
        boolean deleteStatus = false;
        if (filePathName != null)
        {
            String akamaiFilePath = ihgRootDir + filePathName;
            FTPClient client = createFtpClient();
            try
            {
                initFtpClient(client);
                deleteStatus = client.deleteFile(akamaiFilePath);
                
                if(!deleteStatus){
                    LOG.error("File not deleted successfully from Akamai. File Path:"+filePathName);
                }
                client.logout();
            }
            finally
            {
                disconnectFtpClient(client);
            }
        }
        else
        {
            LOG.error("Input not available.");
        }
        return deleteStatus;
    }

    /**
     * This methid will create FTP client.
     * 
     * @return
     */
    private FTPClient createFtpClient()
    {
        FTPClient client;
        if (isSecure)
        {
            client = new FTPSClient();
        }
        else
        {
            client = new FTPClient();
        }
        return client;
    }

    /**
     * This method will connect to FTP Client.
     * 
     * @param client
     * @throws SocketException
     * @throws IOException
     */
    private void initFtpClient(FTPClient client) throws SocketException, IOException
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("FTP server name : " + ftpServerName + " port : " + port + " user name : " + userName + " password : "
                    + password);
        }
        client.setDataTimeout(6000000); // 100 minutes
        client.setConnectTimeout(6000000); // 100 minutes

        if (port > 0)
        {
            client.connect(ftpServerName, port);
        }
        else
        {
            client.connect(ftpServerName);
        }

        int reply = client.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply))
        {
            LOG.error("FTP server refused connection: " + client.getReplyString());
            throw new SocketException("FTP server refused connection: " + client.getReplyString());
        }
        if (!client.login(userName, password))
        {
            client.logout();
            LOG.error("Invalid user name/password : " + userName + " / " + password);
            throw new SocketException("Invalid user name/password");
        }
        reply = client.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply))
        {
            client.logout();
            LOG.error("On Login BAD reply code for user name/password : " + userName + " / " + password + " reply : "
                    + client.getReplyString());
            throw new SocketException("On Login BAD reply code for user name/password : " + userName + " / " + password
                    + " reply : " + client.getReplyString());
        }

        if (LOG.isDebugEnabled())
        {
            LOG.debug("Successfully connected and login into : " + ftpServerName);
        }
        client.setControlKeepAliveTimeout(120); // sends a keepalive every two minutes
        client.setControlEncoding("UTF-8");
        client.setFileType(FTP.BINARY_FILE_TYPE);
        client.setFileTransferMode(FTP.STREAM_TRANSFER_MODE); // default
    }

    /**
     * This method will disconnect FTP Client.
     * 
     * @param client
     */
    private void disconnectFtpClient(FTPClient client)
    {
        if (client.isConnected())
        {
            try
            {
                client.disconnect();
            }
            catch (IOException e)
            {
                LOG.error("Exception on Close:", e);
            }
        }
    }

    /** ============================ Setter & Getters =================================== */

    public String getFtpServerName()
    {
        return ftpServerName;
    }

    public void setFtpServerName(String ftpServerName)
    {
        this.ftpServerName = ftpServerName;
    }

    public int getPort()
    {
        return port;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    public boolean isSecure()
    {
        return isSecure;
    }

    public void setSecure(boolean isSecure)
    {
        this.isSecure = isSecure;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRootDirPath()
    {
        return rootDirPath;
    }

    public void setRootDirPath(String rootDirPath)
    {
        this.rootDirPath = rootDirPath;
    }

    public String getIhgRootDir()
    {
        return ihgRootDir;
    }

    public void setIhgRootDir(String ihgRootDir)
    {
        this.ihgRootDir = ihgRootDir;
    }

    public String getIhgAccessMappingDir()
    {
        return ihgAccessMappingDir;
    }

    public void setIhgAccessMappingDir(String ihgAccessMappingDir)
    {
        this.ihgAccessMappingDir = ihgAccessMappingDir;
    }

    public String getIhgEnvironmentMappingDir()
    {
        return ihgEnvironmentMappingDir;
    }

    public void setIhgEnvironmentMappingDir(String ihgEnvironmentMappingDir)
    {
        this.ihgEnvironmentMappingDir = ihgEnvironmentMappingDir;
    }

    public String getIhgStagingMappingDir()
    {
        return ihgStagingMappingDir;
    }

    public void setIhgStagingMappingDir(String ihgStagingMappingDir)
    {
        this.ihgStagingMappingDir = ihgStagingMappingDir;
    }

    public String getIhgDownloadsDestDir()
    {
        return ihgDownloadsDestDir;
    }

    public void setIhgDownloadsDestDir(String ihgDownloadsDestDir)
    {
        this.ihgDownloadsDestDir = ihgDownloadsDestDir;
    }

    public long getFileMaxSize()
    {
        return fileMaxSize;
    }

    public void setFileMaxSize(long fileMaxSize)
    {
        this.fileMaxSize = fileMaxSize;
    }
    
    public static void main(String args[])
    {
    	
        AkamaiFTPDataSource akamaiClient = new AkamaiFTPDataSource("bstandards.upload.akamai.com", 21, false, "brandstandards",
                "7d9N1l", "/238744", "", "/brandstandards", "/qa", "/stage", "/downloads", Long.valueOf("10737418240"));
       try {
            akamaiClient.addFileToAkamaiGetPath("testFile.txt", "user_files", new File("c:/DryRunTest.txt"));
        } catch (Exception exc)
        {
            LOG.error(exc.getMessage());
        }
    }
}
