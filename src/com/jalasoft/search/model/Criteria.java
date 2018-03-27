/*
 * Criteria.java
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
/**
 *
 Implement the Criteria class to handle the search criteria
 *
 * @version  1.0
 * @author Alexander Apaza
 */
public class Criteria {
    private String textToFind;
    private String typeOfCriteria;
    public Criteria(String textToFind,String typeOfCriteria){
        this.textToFind=textToFind;
        this.typeOfCriteria=typeOfCriteria;
    }
    /**
     * return the text to find
     */
    public String getTextToFind(){
        return  textToFind;
    }
    /**
     * return the type of criteria to find
     */
    public String getTypeOfCriteria(){
        return  typeOfCriteria;
    }
}
