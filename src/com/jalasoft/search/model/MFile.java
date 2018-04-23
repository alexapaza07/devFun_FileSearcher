/*
 * MFile.java
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
 Implement the File objects that will know its properties
 *
 * @version  1.0
 * @author Alexander Apaza
 */
public class MFile extends Asset {
    private String extension;
    private CLogger logger = CLogger.getInstance();


    /**
    * class constructor  that initialize the file URL
    */
    public MFile(String fileUri) {
        super(fileUri);
        setExtension();
    }
    /**
     * Set itself the file extension
     */
    private  void setExtension(){
        try {
            extension = super.getFileUri().substring(super.getFileUri().lastIndexOf(".") + 1);
        } catch (Exception e) {
            extension = "";
        }
    }
    /**
     * get the file extension
     */
    public String getExtension(){
        logger.setLogText("INFO","the extension is: "+extension);
        return extension;
    }


}

