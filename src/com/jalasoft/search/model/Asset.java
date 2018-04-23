/*
 * Asset.java
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
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 *
 Implement the Asset objects that will know its properties
 *
 * @version  3.0
 * @author Alexander Apaza
 */
public class Asset {
    private String fileUri;
    private String name;
    private String mDate;
    private String cDate;
    private String lastAccessDate;
    private boolean isFolder;
    private String owner;
    private String isHidden;
    private File file;
    private Path path;
    private double fileSize;
    private CLogger logger = CLogger.getInstance();



    /**
     * class constructor  that initialize the file URL
     */
    public Asset(String fileUri) {
        this.fileUri = fileUri;
        file = new File(fileUri);
        path = Paths.get(fileUri);
        setName();
        setOwner();
        setCreationDate();
        setLastModifyDate();
        setIsFolder();
        setLastAccessDate();
        setFileSize();
        setHideFile();
    }
    public  String getFileUri(){
        return this.fileUri;
    }
    public void setIsFolder(){
        File file = new File(fileUri);
        isFolder = file.isDirectory();
        logger.setLogText("INFO",name+":Is this a folder:"+isFolder);
    }
    public boolean getIsFolder(){
        logger.setLogText("INFO",name+":Return folder:"+isFolder);
        return isFolder;
    }

    /**
     * class constructor  without file URL
     */
    public boolean isDirectory(){
        logger.setLogText("INFO",name+":is this a directory? "+file.isDirectory());
        return  file.isDirectory();
    }
    /**
     * set the file name from  URL file
     */
    private  void setName(){
        name = file.getName();
        logger.setLogText("INFO",name+":file name is "+name);


    }
    /**
     * Returns the file name
     */
    public  String getName(){
        return  name;
    }
    /**
     * get the file path
     */
    public  String  getPath()  {
        logger.setLogText("INFO",name+":returning path :"+path.getParent().toString());
        return  path.getParent().toString();

    }

    /**
     * set the file owner given file URL
     */
    private  void setOwner() {
        try {
            FileOwnerAttributeView view = Files.getFileAttributeView(path, FileOwnerAttributeView.class);
            UserPrincipal userPrincipal = view.getOwner();
            owner = userPrincipal.getName();
            logger.setLogText("INFO",name+":it is setting owner :"+owner);

        }catch (IOException ioe){
            logger.setLogText("INFO",ioe.getMessage());
        }
    }
    /**
     * get the file owner
     */
    public  String getOwner()  {
        logger.setLogText("INFO",name+":returning owner :"+owner);
        return owner;
    }
    /**
     * set the file creation date
     */
    private  void setCreationDate()  {
        try {
            BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
            cDate = attr.creationTime().toString();
            logger.setLogText("INFO",name+":it has been set creation date:"+cDate);
        }catch (IOException ioe){
            logger.setLogText("INFO",ioe.getMessage());
        }

    }
    /**
     * get the file creation date
     */
    public  String getCreationDate(){
        logger.setLogText("INFO",name+":returning creation date :"+cDate);
        return  cDate;
    }

    /**
     * set the file last modified date
     */
    private  void setLastModifyDate() {
        try {
            BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
            mDate = attr.lastModifiedTime().toString();
            logger.setLogText("INFO",name+":setting last modify date:"+mDate);
        }catch (IOException ioe){
            logger.setLogText("INFO",ioe.getMessage());
        }
    }
    /**
     * get the file last modified date
     */
    public  String getLastModifyDate() {
        logger.setLogText("INFO",name+":returning last modified date :"+mDate);
        return mDate ;
    }
    /**
     * set the last access date given file URL
     */
    private  void setLastAccessDate() {
        try {
            BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
            lastAccessDate = attr.lastAccessTime().toString();
            logger.setLogText("INFO",name+":setting last access date:"+lastAccessDate);
        }catch (IOException ioe){
            logger.setLogText("INFO",ioe.getMessage());
        }
    }
    /**
     * get the last access date given file URL
     */
    public  String getLastAccessDate(){
        logger.setLogText("INFO",name+":returning last access date :"+lastAccessDate);
        return lastAccessDate;
    }
    /**
     * Set itselft the file size
     */
    public void setFileSize(){
        if(file.exists()){

            double bytes = file.length();
            fileSize = (bytes / 1024);
            logger.setLogText("INFO",name+":setting file size :"+fileSize);
        }else{
            logger.setLogText("INFO",file.getAbsolutePath()+"file does not exist ");
        }
    }
    /**
     * get the file size
     */
    public double getFileSize(){
       return fileSize;
    }
    /**
     * Set itself hide file
     */
    public void setHideFile(){
        if(file.isHidden()){
            isHidden = "YES";
            logger.setLogText("INFO",name+":is hidden:"+isHidden);
        }else{
            logger.setLogText("INFO",name+": is NOT hidden");
            isHidden = "NO";
        }
    }
    /**
     * Get itself hide file
     */
    public String getHideFile(){
       return isHidden;
    }
}

