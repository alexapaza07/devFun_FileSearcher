/*
 * MFolder.java
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

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 Implement the Folder objects that will know its properties
 *
 * @version  1.0
 * @author Alexander Apaza
 */
public class MFolder extends Asset {
    private  boolean isShared;
    private CLogger logger = CLogger.getInstance();
    public  MFolder(String fileUri){
        super(fileUri);
        setIsShared();
    }
    /**
     * method to set if folder is shared
     */
    private void setIsShared(){}{
        try {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            String hostname = addr.getHostName();

            if (hostname != null) {
                File f = new File("\\\\" + hostname + "\\"+super.getName());
                if (f.exists()) {
                    isShared = true;
                    logger.setLogText("INFO",f.getName()+"- is this shared? : "+isShared);
                }
                else {
                    isShared = false;
                    logger.setLogText("INFO",f.getName()+"- is this shared? : "+isShared);
                }

            }
        }catch (IOException io){
        }
    }
    /**
     * method  to get if folder is shared
     */
    public boolean getIsShared(){
        return isShared;
    }
    /**
     * get the folder size
     */
    private long getFolderSize(File folder) {
        long length = 0;
        File[] files = folder.listFiles();
        if (files == null || files.length == 0){
            return length;
        }
        for (File file : files) {
            if (file.isFile()) {
                length += file.length();
            } else {
                length += getFolderSize(file);
            }
        }
        return length;
    }
}
