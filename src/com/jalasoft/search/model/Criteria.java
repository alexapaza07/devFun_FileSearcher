package com.jalasoft.search.model;

public class Criteria {
    private String path;
    private String textToFind;
    private String typeOfCriteria;
    public Criteria(String path,String textToFind,String typeOfCriteria){
        this.path=path;
        this.textToFind=textToFind;
        this.typeOfCriteria=typeOfCriteria;
    }
    public String getPath(){
        return  path;
    }
    public String getTextToFind(){
        return  textToFind;
    }
    public String getTypeOfCriteria(){
        return  typeOfCriteria;
    }
}
