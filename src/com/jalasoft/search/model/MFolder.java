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

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
/**
 *
 Implement the Folder objects that will know its properties
 *
 * @version  1.0
 * @author Alexander Apaza
 */
public class MFolder extends Asset {
    private  boolean isShared;
    public  MFolder(String fileUri){
        super(fileUri);
        setIsShared();
    }
    private void setIsShared(){}{
        try {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            String hostname = addr.getHostName();

            if (hostname != null) {
                File f = new File("\\\\" + hostname + "\\"+super.getName());
                if (f.exists()) {
                    System.out.println("The DIRECTORY IS SHARED");
                    isShared = true;
                }
                else {
                    isShared = false;
                }

            }
        }catch (IOException io){
            System.out.println("There has been errors" + io.getMessage());
        }
    }
    private boolean getIsShared(){
        return isShared;
    }





}
