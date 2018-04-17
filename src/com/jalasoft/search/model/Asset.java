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
 * @version  1.0
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
    private File file;
    private Path path;
    private double fileSize;



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
    }
    public  String getFileUri(){
        return this.fileUri;
    }
    public void setIsFolder(){
        File file = new File(fileUri);
        isFolder = file.isDirectory();
        System.out.println( "IS FOLDER? :" +isFolder);
    }
    public boolean getIsFolder(){
        return isFolder;
    }

    /**
     * class constructor  without file URL
     */
    public boolean isDirectory(){
        return  file.isDirectory();
    }
    /**
     * set the file name from  URL file
     */
    private  void setName(){
        name = file.getName();
        System.out.println("WHAT IS THE FILE NAME?"+name);

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
            System.out.println( "OWNER IS? :" +owner);

        }catch (IOException ioe){
            System.out.println( "Error:" +ioe);
        }
    }
    /**
     * get the file owner
     */
    public  String getOwner()  {
        return owner;
    }
    /**
     * set the file creation date
     */
    private  void setCreationDate()  {
        try {
            BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
            cDate = attr.creationTime().toString();
            System.out.println( "WHAT IS CREATION DATE?:"+cDate);
        }catch (IOException ioe){
            System.out.println( "Error:" +ioe);
        }

    }
    /**
     * get the file creation date
     */
    public  String getCreationDate(){
        return  cDate;
    }

    /**
     * set the file last modified date
     */
    private  void setLastModifyDate() {
        try {
            BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
            mDate = attr.lastModifiedTime().toString();
            System.out.println( "WHAT IS LAST MODIFY DATE? : "+mDate);
        }catch (IOException ioe){
            System.out.println( "Error:" +ioe);
        }
    }
    /**
     * get the file last modified date
     */
    public  String getLastModifyDate() {
        return mDate ;
    }
    /**
     * set the last access date given file URL
     */
    private  void setLastAccessDate() {
        try {
            BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
            lastAccessDate = attr.lastAccessTime().toString();
            System.out.println( "WHAT IS LAST ACCESS DATE"+lastAccessDate);
        }catch (IOException ioe){
            System.out.println( "Error:" +ioe);
        }
    }
    /**
     * get the last access date given file URL
     */
    public  String getLastAccessDate(){
        return lastAccessDate;
    }


    public void setFileSize(){
       // File file =new File(fileUri);

        if(file.exists()){
            double bytes = file.length();
            double kilobytes = (bytes / 1024);
            System.out.println("kilobytes : " + kilobytes);
        }else{
            System.out.println("File does not exists!");
        }
    }

}

