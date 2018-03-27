/*
 * Search.java
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
import  java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Class to search files given a list of criterias and path
 * @version  1.0
 * @author Alexander Apaza
 */
public class Search {
    private String path;
    private List<MFile> myList;
    private List<Criteria> listCriteria;
    public Search(List<Criteria> listCriteria, String path){
        this.path = path;
        this.listCriteria = listCriteria;
        myList = new ArrayList<MFile>();
    }
    /**
     * main method that is called to get the results about searching files
     */
    public List<MFile> getResult() {
        searchFiles();
        return  myList;
    }
    /**
     * Internal method list all the files found in path specified
     */
    private void searchFiles() {
        File folder = new File(path);
        File[] files = folder.listFiles();
        for (File fil: files){
            MFile assetToAddress = new MFile(fil.getAbsolutePath());
            if (assetToAddress.isDirectory()){
                path = fil.getAbsolutePath();
                searchFiles();
            }else{
                searchForCriteria(assetToAddress);
            }
        }
    }
    /**
     * Internal method that maps according the criterias specified in all files listed inside the path
     */
    private void searchForCriteria(MFile assetToAddress){
        for(Criteria cri : listCriteria){
         switch (cri.getTypeOfCriteria()) {
             case "FILENAME":
                             if (assetToAddress.getName().contains(cri.getTextToFind())) {
                                 myList.add(assetToAddress);
                             }
                             break;
             case "OWNER":
                             if (assetToAddress.getOwner().contains(cri.getTextToFind())) {
                                 myList.add(assetToAddress);
                             }
                             break;
             case "CREATIONDATE":
                             if (assetToAddress.getCreationDate().contains(cri.getTextToFind())) {
                                 myList.add(assetToAddress);
                             }
                             break;
             case "LASTMODIFYDATE":
                             if (assetToAddress.getLastModifyDate().contains(cri.getTextToFind())) {
                                 myList.add(assetToAddress);
                             }
                             break;
             case "LASTACCESSDATE":
                             if (assetToAddress.getLastModifyDate().contains(cri.getTextToFind())) {
                                 myList.add(assetToAddress);
                             }
                             break;
             case "EXTENSION":
                             if (assetToAddress.getExtension().contains(cri.getTextToFind())) {
                                 myList.add(assetToAddress);
                             }
                             break;
             case "PATH":
                             if (assetToAddress.getPath().contains(cri.getTextToFind())) {
                                 myList.add(assetToAddress);
                             }
                             break;
             default:
                 break;
         }
        }
    }
}

