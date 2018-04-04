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
public class MFile {
    private String fileUri;
    private String name;
    private String mDate;
    private String cDate;
    private String lastAccessDate;
    private String owner;
    private String extension;
    private File file;
    private Path path;
    

    /**
    * class constructor  that initialize the file URL
    */
    public MFile(String fileUri) {
        this.fileUri = fileUri;
        file = new File(fileUri);
        path = Paths.get(fileUri);
        setName();
        setOwner();
        setExtension();
        setCreationDate();
        setLastModifyDate();
        setLastAccessDate();
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
    private  void setExtension(){
        try {
            extension = fileUri.substring(fileUri.lastIndexOf(".") + 1);
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

    /**
     * set the file owner given file URL
     */
    private  void setOwner() {
        try {
            FileOwnerAttributeView view = Files.getFileAttributeView(path, FileOwnerAttributeView.class);
            UserPrincipal userPrincipal = view.getOwner();
            owner = userPrincipal.getName();
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

}

