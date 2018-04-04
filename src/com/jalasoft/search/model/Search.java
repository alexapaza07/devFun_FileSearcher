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
    public Search(){
    }
    public void init(List<Criteria> listCriteria, String path){
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
                int counter = 0;
                if(searchForCriteria(assetToAddress,listCriteria, counter)){
                    myList.add(assetToAddress);
                }
            }
        }
    }
    /**
     * Internal method that maps recursively  according the criterias specified in all files listed inside the path
     */
    public  boolean searchForCriteria(MFile fileToAddress, List<Criteria> listOfCriteria, int counter){
        if(counter < listOfCriteria.size()) {
            switch (listOfCriteria.get(counter).getTypeOfCriteria()) {
                case "FILENAME":
                    if (fileToAddress.getName().contains(listOfCriteria.get(counter).getTextToFind())) {
                        return (true && searchForCriteria(fileToAddress, listOfCriteria, counter + 1));
                    } else {
                        return false;
                    }

                case "OWNER":
                    if (fileToAddress.getName().contains(listOfCriteria.get(counter).getTextToFind())) {
                        return (true && searchForCriteria(fileToAddress, listOfCriteria, counter + 1));
                    } else {
                        return false;
                    }

                case "CREATIONDATE":
                    if (fileToAddress.getName().contains(listOfCriteria.get(counter).getTextToFind())) {
                        return (true && searchForCriteria(fileToAddress, listOfCriteria, counter + 1));
                    } else {
                        return false;
                    }

                case "LASTMODIFYDATE":
                    if (fileToAddress.getName().contains(listOfCriteria.get(counter).getTextToFind())) {
                        return (true && searchForCriteria(fileToAddress, listOfCriteria, counter + 1));
                    } else {
                        return false;
                    }

                case "LASTACCESSDATE":
                    if (fileToAddress.getName().contains(listOfCriteria.get(counter).getTextToFind())) {
                        return (true && searchForCriteria(fileToAddress, listOfCriteria, counter + 1));
                    } else {
                        return false;
                    }

                case "EXTENSION":
                    if (fileToAddress.getName().contains(listOfCriteria.get(counter).getTextToFind())) {
                        return (true && searchForCriteria(fileToAddress, listOfCriteria, counter + 1));
                    } else {
                        return false;
                    }

                case "PATH":
                    if (fileToAddress.getName().contains(listOfCriteria.get(counter).getTextToFind())) {
                        return (true && searchForCriteria(fileToAddress, listOfCriteria, counter + 1));
                    } else {
                        return false;
                    }
                default:
                    return true;
            }
        }else{
            return true;
        }
    }
}

