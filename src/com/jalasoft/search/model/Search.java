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
import java.util.jar.Pack200;

/**
 *
 * Class to search files given a list of criterias and path
 * @version  1.0
 * @author Alexander Apaza
 */
public class Search {
    private String path;
    private List<Asset> myList;
    private List<Criteria> listCriteria;
    public Search(){
    }
    public void init(List<Criteria> listCriteria, String path){
        this.path = path;
        this.listCriteria = listCriteria;
        myList = new ArrayList<Asset>();
    }
    /**
     * main method that is called to get the results about searching files
     */
    public List<Asset> getResult() {
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
            if(fil.isDirectory()){
                Asset assetToAddress = FactorAsset.createAsset("folder",fil.getAbsolutePath());
                int counter = 0;
                if(searchForCriteria(assetToAddress,listCriteria, counter)){
                    myList.add(new MFolder(fil.getAbsolutePath()));
                }
                path = fil.getAbsolutePath();
                searchFiles();

            }else{
                Asset assetToAddress = FactorAsset.createAsset("file",fil.getAbsolutePath());
                int counter = 0;
                if(searchForCriteria(assetToAddress,listCriteria, counter)){
                    myList.add(new MFile(fil.getAbsolutePath()));
                }
            }
        }
    }
    /**
     * Internal method that maps recursively  according the criterias specified in all files listed inside the path
     */
    public  boolean searchForCriteria(Asset fileToAddress, List<Criteria> listOfCriteria, int counter){
        if(counter < listOfCriteria.size()) {
            System.out.println("WHAT CRITERIA IS IT?:"+listOfCriteria.get(counter).getTypeOfCriteria());
            switch (listOfCriteria.get(counter).getTypeOfCriteria()) {

                case "FILENAME":
                    if (fileToAddress.getName().contains(listOfCriteria.get(counter).getTextToFind())) {
                        return (true && searchForCriteria(fileToAddress, listOfCriteria, counter + 1));
                    } else {
                        return false;
                    }

                case "OWNER":
                    if (fileToAddress.getOwner().contains(listOfCriteria.get(counter).getTextToFind())) {
                        return (true && searchForCriteria(fileToAddress, listOfCriteria, counter + 1));
                    } else {
                        return false;
                    }

                case "CREATION DATE":
                    if (fileToAddress.getCreationDate().contains(listOfCriteria.get(counter).getTextToFind())) {
                        System.out.println("AAAAAAAA:"+fileToAddress.getCreationDate());
                        System.out.println("BBBBB:"+listOfCriteria.get(counter).getTextToFind());


                        return (true && searchForCriteria(fileToAddress, listOfCriteria, counter + 1));
                    } else {
                        return false;
                    }

                case "LAST MODIFY DATE":
                    if (fileToAddress.getLastModifyDate().contains(listOfCriteria.get(counter).getTextToFind())) {
                        return (true && searchForCriteria(fileToAddress, listOfCriteria, counter + 1));
                    } else {
                        return false;
                    }

                case "LAST ACCESS DATE":
                    if (fileToAddress.getLastAccessDate().contains(listOfCriteria.get(counter).getTextToFind())) {
                        return (true && searchForCriteria(fileToAddress, listOfCriteria, counter + 1));
                    } else {
                        return false;
                    }
                case "EXTENSION":
                    if (fileToAddress instanceof  MFile)
                    {
                        MFile mfile = (MFile) fileToAddress;
                        if (mfile.getExtension().contains(listOfCriteria.get(counter).getTextToFind())) {
                            return (true && searchForCriteria(fileToAddress, listOfCriteria, counter + 1));
                        } else {
                            return false;
                        }
                    }else{
                        return false;
                    }
                case "PATH":
                    if (fileToAddress.getName().contains(listOfCriteria.get(counter).getTextToFind())) {
                        return (true && searchForCriteria(fileToAddress, listOfCriteria, counter + 1));
                    } else {
                        return false;
                    }
                case "SIZE":
                    if (fileToAddress.getName().contains(listOfCriteria.get(counter).getTextToFind())) {
                        return (true && searchForCriteria(fileToAddress, listOfCriteria, counter + 1));
                    } else {
                        return false;
                    }
                default:
                    return false;
            }
        }else{
            return true;
        }
    }
}

