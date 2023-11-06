package com.ihg.brandstandards.bridge.application;

import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;

import com.ihg.brandstandards.application.CommonApplication;
import com.ihg.brandstandards.custom.model.Standard;
import com.ihg.brandstandards.custom.model.StdImage;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.PublishQueue;

public interface BridgeApplication extends CommonApplication
{

    public Map<String,List<Publication>> getAllPublicationRecords (String brandCode, PortletRequest request);
    
    public List<Standard> getStandardsForProgressViewDetails(Publication publish, long regionId, String viewType, String localeCode, String statIndText);
    
    public List<Standard> getStandardsForTranslationViewDetails(long publishId, long regionId, String localeCode);
    
    public PublishQueue getPublishQueueObject (long publishId, long publishQueueId);
    
    public List<StdImage> getAssociatedImages (long stdId, String locale, String brand, String countryCode);
    
    public Standard getAllsupportingMaterial(long stdId, String locale, String brand, String countryCode);
    
}
