/*
 * Controller.java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.search.controller;
import com.jalasoft.search.model.Criteria;
import com.jalasoft.search.model.MFile;
import com.jalasoft.search.model.Search;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Class to controller the search, it receive criterias and path from Windows (View) and send these values to Search criteria to get results if there is files that satisfy the criterias
 * @version  1.0
 * @author Alexander Apaza
 */
public class Controller {
    private List<Criteria> listCriteria;
    private String path;
    private  boolean isProperPath;
    /**
     * constructor class that gets path and criteria from View class
     */
    public Controller(){
        /**
         * to get list of criteria and path
         */
        // listCriteria = new Window().getListCriteria;
        // path = new Window().getPathToCheck;

        /**
         * harcoding for the moment with criterias and path
         */
        // harcoding some values to search
        listCriteria = new ArrayList<Criteria>();
        path = new File("src\\com\\jalasoft\\search\\common\\testFolder").getAbsolutePath();
        listCriteria.add(new Criteria("mu","FILENAME" ));
        listCriteria.add(new Criteria("sic","FILENAME" ));
        listCriteria.add(new Criteria("mp","EXTENSION" ));
        /*listCriteria.add(new Criteria("jalasoft\\search","PATH" ));
        listCriteria.add(new Criteria("AA","OWNER" ));
        listCriteria.add(new Criteria("archi","FILENAME" ));*/
        isProperPath = new Validator(path).isProperPath();
        sendCriteriaToSearchFiles();
    }
    /**
     * main method that call to Search class to find the files that satisfy the criterias and paths specified
     */
    private   void sendCriteriaToSearchFiles(){
        if(isProperPath){
            Search search = new Search();
            search.init(listCriteria,path);
            List<MFile> files = search.getResult();
            for(MFile fil : files) {
                System.out.println("File found:"+fil.getName());
            }
        }
    }
    public  static void main(String arg[]){
        new Controller();
    }

}
