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

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 *
 Implement the File objects that will know its properties
 *
 * @version  1.0
 * @author Alexander Apaza
 */
public class MFile extends Asset {
    private String extension;


    /**
    * class constructor  that initialize the file URL
    */
    public MFile(String fileUri) {
        super(fileUri);
        setExtension();
    }
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
        return extension;
    }


}

