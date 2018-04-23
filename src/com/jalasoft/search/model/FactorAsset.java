/*
 * FactorAsset.java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.search.model;

import com.jalasoft.search.common.CLogger;
/**
 *
 Implement the FactorAsset class to handle instance of file and folder
 *
 * @version  2.0
 * @author Alexander Apaza
 */
public abstract class FactorAsset {
    private static CLogger logger = CLogger.getInstance();
    /**
     * Metod to return instance of folder or file
     */
    public static Asset createAsset(String type, String fileUrl) {
        if (type.equals("file")){
            logger.setLogText("INFO",FactorAsset.class.getName()+":Instance for File instance");
            return  new MFile(fileUrl);

        }else{
            logger.setLogText("INFO",FactorAsset.class.getName()+":Instance for Folder instance");
            return  new MFolder(fileUrl);
        }

    }
}
