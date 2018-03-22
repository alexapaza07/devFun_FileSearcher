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
/**
 *
 * Class to search file or files in base to some criteria
 * @version  1.0
 * @author Alexander Apaza
 */
public class Search {
    private String path;
    public Search(String path){
        this.path = path;
        listFileByPath(this.path);
    }
    // For Testing purpose
    public void listFileByPath(String path){
        File folder = new File(path);
        File[] files = folder.listFiles();
        for (File fil: files){
            if (fil.isDirectory()){
                listFileByPath(fil.getAbsolutePath());
            }else{
                System.out.println(fil.getName());
            }
        }
    }
    //
    public void listFileByPathWithCriteria(String path,String criteria){
        Asset asset = new com.jalasoft.search.model.File(path);
        if(asset.getName().equals("")){
            System.out.println("There is no any file with that criteria");
        }else{
            System.out.println("File URL Path:"+asset.fileUri);
            System.out.println("File name:"+asset.getName());
            System.out.println("File path:"+asset.getName());
            System.out.println("File mDate:"+asset.getName());
            System.out.println("File cDate:"+asset.getName());
            System.out.println("File lastAccessDate:"+asset.getName());
            System.out.println("File owner:"+asset.getName());
            System.out.println("File type:"+asset.getName());
        }
    }
}
