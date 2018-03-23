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
 * Class to search file or files in base to some criteria
 * @version  1.0
 * @author Alexander Apaza
 */
public class Search {
    private String path;
    private List<Asset> myList;
    private Criteria criteria;
    public Search(Criteria criteria){
        this.path = criteria.getPath();
        this.criteria = criteria;
        myList = new ArrayList<Asset>();
    }
    public List<Asset> getResult(){
        searchFiles();
        return  myList;
    }

    private void searchFiles() {
        File folder = new File(path);
        File[] files = folder.listFiles();
        for (File fil: files){
            Asset assetToAddress = new Asset(fil.getAbsolutePath());
            if (assetToAddress.isDirectory()){
                path = fil.getAbsolutePath();
                searchFiles();
            }else{
                 searchForCriteria(assetToAddress,criteria.getTypeOfCriteria(), criteria.getTextToFind());
            }
        }
    }
    private void searchForCriteria(Asset assetToAddress,String typeOfCriteria,String textToFind){

         switch (typeOfCriteria) {
            case "FILENAME": if(assetToAddress.getName().equals(typeOfCriteria)) {
                                 myList.add(assetToAddress);
                             }break;
            case "OWNER": if(assetToAddress.getName().contains(typeOfCriteria)) {
                                 myList.add(assetToAddress);
                              }break;
            case "CREATIONDATE": if(assetToAddress.getName().contains(typeOfCriteria)) {
                                    myList.add(assetToAddress);
                                    }break;
            case "LASTMODIFYDATE": if(assetToAddress.getName().contains(typeOfCriteria)) {
                                    myList.add(assetToAddress);
                                    }break;
            case "LASTACCESSDATE": if(assetToAddress.getName().contains(typeOfCriteria)) {
                                    myList.add(assetToAddress);
                                    }break;
            default:break;
        }

    }
    //
    public static void main(String arg[]){
        Search search = new Search(new Criteria("C:\\testFolder","file","FILENAME" ) );
        List<Asset> files = search.getResult();
        for(Asset  fil : files) {
            System.out.println(fil.getName());
        }
    }

}
