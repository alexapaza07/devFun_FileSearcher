package com.jalasoft.search.model;

public abstract class FactorAsset {

    public static Asset createAsset(String type, String fileUrl) {
        if (type.equals("file")){
            return  new MFile(fileUrl);
        }else{
            return  new MFolder(fileUrl);
        }

    }
}
