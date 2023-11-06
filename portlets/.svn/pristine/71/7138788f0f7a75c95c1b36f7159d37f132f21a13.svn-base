package com.ihg.brandstandards.gem.util;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;



import com.ihg.brandstandards.gem.model.NewUserBean;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.PropsUtil;


public class MailUtil 
{
    public static final String CMD = "COMMAND";
    public static final String FULL_NAME = "FULL_NAME";
    public static final String SCREEN_NAME = "SCREEN_NAME";
    public static final String EMAIL = "EMAIL";
    public static final String ROLES_MAP = "ROLES_MAP";
    public static final String CMD_SUPPORT_FORM_POPUP = "CMD_SUPPORT_FORM_POPUP";
    public static String XMLTemplate="<?xml version=\"1.0\"?>\n<Message>\n\t<MsgData>\n\t\t<Transaction>\n\t\t\t<RC_CASE class=\"R\">\n\t\t\t\t<BUSINESS_UNIT>IHG02</BUSINESS_UNIT>\n\t\t\t\t<PROVIDER_GRP_ID>BRANDSTDS</PROVIDER_GRP_ID>\n\t\t\t\t<RC_STATUS>OPEN</RC_STATUS>\n\t\t\t\t<CASE_SUBTYPE>APPLI</CASE_SUBTYPE>\n\t\t\t\t<DISP_TMPL_ID>RC_HELPDESK</DISP_TMPL_ID>\n\t\t\t\t<CASE_TYPE>GIAMR</CASE_TYPE>\n\t\t\t\t<DEPTID></DEPTID>\n\t\t\t\t<LOCATION></LOCATION>\n\t\t\t\t<RC_SOURCE></RC_SOURCE>\n\t\t\t\t<RC_PRIORITY></RC_PRIORITY>\n\t\t\t\t<RC_SEVERITY></RC_SEVERITY>\n\t\t\t\t<RC_CATEGORY>BRAND</RC_CATEGORY>\n\t\t\t\t<RC_TYPE></RC_TYPE>\n\t\t\t\t<RC_DETAIL></RC_DETAIL>\n\t\t\t\t<RC_SUMMARY>#3#</RC_SUMMARY>\n\t\t\t\t<DESCR254_1></DESCR254_1>\n\t\t\t\t<RC_DESCRLONG>#4#\n\t\t\t\t</RC_DESCRLONG>\n\t\t\t</RC_CASE>\n\t\t\t<RB_WEBFORM_SBR class=\"R\">\n\t\t\t\t<WEBFORM_TEMPL_ID>CREATECASE</WEBFORM_TEMPL_ID>\n\t\t\t\t<FROM_ADDRESS>#5#</FROM_ADDRESS>\n\t\t\t</RB_WEBFORM_SBR>\n\t\t</Transaction>\n\t</MsgData>\n</Message>";
    public static String TO_ADDRESS="MERLINSUPP.ermsrescue@ihg.com";
    public static final String strDelimiter = " - ";
    

    /**
     * sent mail to GTBrandStandards@ihg.com
     * @param request
     * @throws IOException 
     * @throws ResourceNotFoundException 
     * @throws MethodInvocationException 
     * @throws ParseErrorException 
     * @throws AddressException 
     */
    public static void sendEmailToSupportTeam(String userName,String screenName,String to,String from,String message, File attachment, NewUserBean newUserBean,String reqType) throws ParseErrorException, MethodInvocationException, ResourceNotFoundException, IOException, AddressException 
    {
       // MailMessage mailMessage =null;
        MailMessage rescueMessage =null;
        String subject = "";
            if(reqType.equals("user_request"))
            {
                 subject="New User Request Raised By : "+userName;
               //  mailMessage = new MailMessage(new InternetAddress(from),subject ,"", false);
                 rescueMessage = new MailMessage(new InternetAddress(PropsUtil.get("ihg.from.email.address")),subject,"", false);
            }
            else
            {
                subject="Support Request Raised By : "+userName;
               // mailMessage = new MailMessage(new InternetAddress(from),subject,"", false);
                rescueMessage= new MailMessage(new InternetAddress(PropsUtil.get("ihg.from.email.address")),subject,"", false);
            }
            
            String [] recipients = to.split(",");
            InternetAddress[] recipientsAddrs = new InternetAddress[recipients.length];
            int i = 0;
            for(String recipent : recipients)
            {
                recipientsAddrs[i]=new InternetAddress(recipent);
                i++;
            }
            rescueMessage.setTo(recipientsAddrs);
            rescueMessage.setHTMLFormat(false);
            
            
            //mailMessage.setHTMLFormat(true);
           // mailMessage.setFrom(new InternetAddress(from));
          
            
            /*int j = 0;
            for(String recipent : recipients)
            {
                recipientsAddrs[j]=new InternetAddress(recipent);
                j++;
            }
            mailMessage.setTo(recipientsAddrs);
          
            String content = ContentUtil.get("/mailcontent/SupportFormEmail.vm");
            UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter();
            VelocityContext context = new VelocityContext();
            context.put("userName", userName);
            context.put("emailAdress", from);
            context.put("screenName", screenName);*/
            
            if(reqType.equals("user_request"))
            {
               /* context.put("requestType", "New User Request");
                context.put("userMerlinId", newUserBean.getUserMerlinId());
                context.put("userName", newUserBean.getUserFullName());
                context.put("userRegion", newUserBean.getUserRegion());
                context.put("userEmail", newUserBean.getEmailAddress());
                context.put("userRoles", newUserBean.getUserRoles());*/
                rescueMessage.setBody(getRescueMessageXml1("New User Request", newUserBean.getUserMerlinId(),newUserBean.getUserFullName(),newUserBean.getUserRegion(), newUserBean.getEmailAddress(), newUserBean.getUserRoles(), from, subject));
                
            }
            else
            {
                /*context.put("requestType", "Support/ Change Request");
                context.put("message", message);*/
                rescueMessage.setBody(getRescueMessageXml2("Support/ Change Request", message, from, subject));
            }
            //Velocity.evaluate(context, unsyncStringWriter, MailUtil.class.getName(), content);
           // mailMessage.setBody(unsyncStringWriter.toString());
            if(attachment!=null) 
            { 
            //  mailMessage.addAttachment(attachment);
              rescueMessage.addFileAttachment(attachment);
            }
          //  MailServiceUtil.sendEmail(mailMessage);
            MailServiceUtil.sendEmail(rescueMessage);
     }
    
    public static Map<String, String> getRoles()
    {
        final Map<String, String> rolesMap = new LinkedHashMap<String, String>();
      //Gem
        rolesMap.put("BRND_STND_GEM_ADMIN", "GEM Admin");
        rolesMap.put("BRND_STND_GEM_AMER_QL", "GEM Americas Quality Lead");
        rolesMap.put("BRND_STND_GEM_AMEA_QL", "GEM AMEA Quality Leads");
        rolesMap.put("BRND_STND_GEM_EURO_QL", "GEM Europe Quality Leads");
        rolesMap.put("BRND_STND_GEM_GC_QL", "GEM Greater China Quality Leads");
        
        rolesMap.put("BRND_STND_GEM_GLBL_QL", "GEM Global Quality Lead");
        rolesMap.put("BRND_STND_GEM_GLBL_ADMIN", "GEM Global Admin");
        rolesMap.put("BRND_STND_GEM_CATEGORY_ADMIN", "GEM Category Admin");
        
        return rolesMap;
    }

    private static String getRescueMessageXml1(String reqType, String nUserMrlnId,String nUserFullName, String nUserRegn, String nUserEmail,String[] rolesRequested, String txtContactEmail,String subject) 
    {
        String rescueMailBody = XMLTemplate.replaceAll("#3#", "Brand Standards"+strDelimiter+escapeXMLString(subject));
        StringBuffer xml = new StringBuffer("\nRequest Type:\t")
        .append(reqType)
        .append("\nNew User MerlinId:\t")
        .append(nUserMrlnId)
        .append("\nNew User Full Name:\t")
        .append(nUserFullName)
        .append("\nNew User Region:\t")
        .append(nUserRegn)
        .append("\nNew User Email:\t")
        .append(nUserEmail)
        .append("\nRoles Requested:\t");
         for( int i = 0; i < rolesRequested.length; i++)
         {
            String role = rolesRequested[i];
            xml.append("\n"+(i+1)+"-"+role);
         }
        
        rescueMailBody = rescueMailBody.replaceAll("#4#", escapeXMLString(xml.toString()));
        rescueMailBody = rescueMailBody.replaceAll("#5#", escapeXMLString(txtContactEmail));
        return rescueMailBody;
    }
    
    private static String getRescueMessageXml2(String reqType, String message, String txtContactEmail,String subject) 
    {
        String rescueMailBody = XMLTemplate.replaceAll("#3#", "Brand Standards"+strDelimiter+escapeXMLString(subject));
        StringBuffer xml = new StringBuffer("\nRequest Type:\t")
        .append(reqType)
        .append("\nMessage:\t")
        .append(message);
        
        rescueMailBody = rescueMailBody.replaceAll("#4#", escapeXMLString(xml.toString()));
        rescueMailBody = rescueMailBody.replaceAll("#5#", escapeXMLString(txtContactEmail));
        return rescueMailBody;
    }
    
    public static String escapeXMLString(String xmlString) {
        return xmlString.replaceAll("&", "&amp;").replaceAll("'", "&apos;").replaceAll("\"", "&quot;").replaceAll(">",
                "&gt;").replaceAll("<", "&lt;");
    }
    
}
