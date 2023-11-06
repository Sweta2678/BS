package com.ihg.brandstandards.bsadmin.model;

import java.util.ArrayList;
import java.util.List;

import com.ihg.brandstandards.db.model.HistManualAttachment;
import com.ihg.brandstandards.db.model.HistManualChain;
import com.ihg.brandstandards.db.model.HistManualRegion;
import com.ihg.brandstandards.db.model.HistManuals;

public class ManualView
{

    private HistManuals manual;

    private List<HistManualRegion> manualRegions = new ArrayList<HistManualRegion>();

    private List<HistManualChain> manualChain = new ArrayList<HistManualChain>();

    private HistManualAttachment attachment;

    private boolean hasAccess;

    public HistManuals getManual()
    {
        return manual;
    }

    public void setManual(final HistManuals manual)
    {
        this.manual = manual;
    }

    public List<HistManualRegion> getManualRegions()
    {
        return manualRegions;
    }

    public void setManualRegions(final List<HistManualRegion> manualRegions)
    {
        this.manualRegions = manualRegions;
    }

    public List<HistManualChain> getManualChain()
    {
        return manualChain;
    }

    public void setManualChain(final List<HistManualChain> manualChain)
    {
        this.manualChain = manualChain;
    }

    public HistManualAttachment getAttachment()
    {
        return attachment;
    }

    public void setAttachment(final HistManualAttachment attachment)
    {
        this.attachment = attachment;
    }

    public boolean isHasAccess()
    {
        return hasAccess;
    }

    public void setHasAccess(final boolean hasAccess)
    {
        this.hasAccess = hasAccess;
    }
}
