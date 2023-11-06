package com.ihg.brandstandards.bridge.model;

public class UserInfo
{
    private long userId;
    private String userName;
    private String emailAddress;
    private String xlsFileName;
    private String mappingFileName;
    
    public UserInfo(long userId, String userName, String emailAddress)
    {
        super();
        this.userId = userId;
        this.userName = userName;
        this.emailAddress = emailAddress;
    }

    public UserInfo(long userId, String userName, String emailAddress, String xlsFileName, String mappingFileName)
    {
        this(userId, userName, emailAddress);
        this.xlsFileName = xlsFileName;
        this.mappingFileName = mappingFileName;
    }

    public long getUserId()
    {
        return userId;
    }

    public void setUserId(long userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public String getXlsFileName()
    {
        return xlsFileName;
    }

    public void setXlsFileName(String xlsFileName)
    {
        this.xlsFileName = xlsFileName;
    }

    public String getMappingFileName()
    {
        return mappingFileName;
    }

    public void setMappingFileName(String mappingFileName)
    {
        this.mappingFileName = mappingFileName;
    }

    @Override
    public String toString()
    {
        return "UserInfo [userId=" + userId + ", userName=" + userName + ", emailAddress=" + emailAddress + ", xlsFileName="
                + xlsFileName + ", mappingFileName=" + mappingFileName + "]";
    }
}
