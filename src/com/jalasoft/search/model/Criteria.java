package com.jalasoft.search.model;

public class Criteria {
    private String textToFind;
    private String typeOfCriteria;
    public Criteria(String textToFind,String typeOfCriteria){
        this.textToFind=textToFind;
        this.typeOfCriteria=typeOfCriteria;
    }
    public String getTextToFind(){
        return  textToFind;
    }
    public String getTypeOfCriteria(){
        return  typeOfCriteria;
    }
}
