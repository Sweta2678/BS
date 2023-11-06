package com.ihg.brandstandards.gem.model;


public class FileAttachment extends java.io.File {

    private String _realFileName;
    
    public FileAttachment(String pathname) {
        super(pathname);
    }

    @Override
    public String getName() {
        return _realFileName;
    }

    public void setRealName(String realFileName) {
        _realFileName = realFileName;
    }

    

}