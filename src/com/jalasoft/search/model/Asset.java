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
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 *
 Implement the objects that will handle files, multimedia and folders
 *
 * @version  1.0
 * @author Alexander Apaza
 */
public class Asset {
    String fileUri;
    String name;
    String path;
    private String mDate;
    private String cDate;
    private String lastAccessDate;
    private String owner;

    /**
    * class constructor  that initialize the file URL
    */
    public  Asset(String fileUri){
        this.fileUri = fileUri;
    }
    /**
     * class constructor  without file URL
     */
    public  Asset(){
    }
    /**
     * class constructor  without file URL
     */
    public boolean isDirectory(){
        File file = new File(fileUri);
        return  file.isDirectory();
    }
    /**
     * set the file name from file URL
     */
    public  void settName(){
        name = fileUri.substring( fileUri.lastIndexOf('/')+1, fileUri.length() );
    }
    /**
     * Returns the file name
     */
    public  String getName(){
        return  name;
    }
    /**
     * set the file path from file URL
     */
    public  void  setPath() throws MalformedURLException {
        path = new URL(fileUri).getPath();
    }
    /**
     * get the file path
     */
    public  String  getPath() throws MalformedURLException {
        return path;
    }
    /**
     * set the file owner given file URL
     */
    public  void setOwner() throws IOException {
        Path path = Paths.get(name);
        FileOwnerAttributeView view = Files.getFileAttributeView(path,FileOwnerAttributeView.class);
        UserPrincipal userPrincipal = view.getOwner();
        owner=userPrincipal.getName();
    }
    /**
     * get the file owner given file URL
     */
    public  String getOwner() throws IOException {
        return owner;
    }
    /**
     * set the creation date given file URL
     */
    public  void setCreationDate() throws IOException {
        Path path = Paths.get(name);
        BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
        cDate = attr.creationTime().toString();
    }
    /**
     * get the creation date given file URL
     */
    public  String getCreationDate() throws IOException {
        return  cDate;
    }
    /**
     * set the last modified date given file URL
     */
    public  void setLastModifyDate() throws IOException {
        Path path = Paths.get(name);
        BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
        mDate = attr.lastModifiedTime().toString();
    }
    /**
     * get the last modified date given file URL
     */
    public  String getLastModifyDate() throws IOException {
        return mDate ;
    }
    /**
     * set the last access date given file URL
     */
    public  void setLastAccessDate() throws IOException {
        Path path = Paths.get(name);
        BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
        lastAccessDate = attr.lastAccessTime().toString();
    }
    /**
     * get the last access date given file URL
     */
    public  String getLastAccessDate() throws IOException {
        return lastAccessDate;
    }
    /**
     * set the path file given file URL
     */
    public  void setfilePath(){
        File file = new File(name);
        path = file.getAbsolutePath();
    }
    /**
     * get the path file given file URL
     */
    public  String getfilePath(){
        return path;
    }
}
