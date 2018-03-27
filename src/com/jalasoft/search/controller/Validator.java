package com.jalasoft.search.controller;

import java.io.File;

/**
 * Created by Alexander Apaza on 3/27/2018.
 */
public class Validator {
    private boolean isValidPath;
    private String path;
    public Validator(String path){
        isValidPath = false;
        this.path = path;
        isEmptyPath();
    }
    public boolean isProperPath(){
        return isValidPath;
    }
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
