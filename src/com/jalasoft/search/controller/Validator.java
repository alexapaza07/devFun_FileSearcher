/*
 * Validator.java
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
import java.io.File;

/**
 *
 * Validate a folder, if it does not exist, or is empty
 * @version  1.0
 * @author Alexander Apaza
 */
public class Validator {
    private boolean isValidPath;
    private String path;
    public Validator(String path){
        isValidPath = false;
        this.path = path;
        isEmptyPath();
    }
    /**
     * main method that return true if the path is properly existing and not empty , otherwise it retuls false
     */
    public boolean isProperPath(){
        return isValidPath;
    }
    /**
     * internal method that makes the folder path validation
     */
    private void isEmptyPath(){
        File file = new File(path);
        if(file.isDirectory()){
            if(file.list().length>0){
                isValidPath =true;
            }else{
                isValidPath = false;
                System.out.println("Directory is empty!");
            }
        }else{
            isValidPath = false;
            System.out.println("This is not a directory or you might not have permission");

        }
    }
}
