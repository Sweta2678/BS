package com.ihg.brandstandards.bsadmin.model;

public class NewUserBean { 
   
   private String userMerlinId="";
   private String userFullName="";
   private String userRegion="";
   private String emailAddress="";
   private String[] userRoles=null;
    
   public String getUserMerlinId()
   {
       return userMerlinId;
   }
   public void setUserMerlinId(String userMerlinId)
   {
       this.userMerlinId = userMerlinId;
   }
   public String getUserFullName()
   {
       return userFullName;
   }
   public void setUserFullName(String userFullName)
   {
       this.userFullName = userFullName;
   }
   public String getUserRegion()
   {
       return userRegion;
   }
   public void setUserRegion(String userRegion)
   {
       this.userRegion = userRegion;
   }
   public String getEmailAddress()
   {
       return emailAddress;
   }
   public void setEmailAddress(String emailAddress)
   {
       this.emailAddress = emailAddress;
   }
   public  String[] getUserRoles()
   {
       return userRoles;
   }
   public void setUserRoles( String[] userRoles)
   {
       this.userRoles = userRoles;
   }
}