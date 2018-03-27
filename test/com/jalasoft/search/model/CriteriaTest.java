/*
 * ValidatorTest.java
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

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * unit test for Criteria.java
 * Created by Alexander Apaza on 3/27/2018.
 */
public class CriteriaTest {
    /**
     * Verify that given a correct text criteria, it should return true
     */
    @Test
    public void getTextToFind() throws Exception {
        Criteria criteria= new Criteria("file","FILENAME");
        assertTrue(criteria.getTextToFind().equals("file"));
    }
    /**
     * Verify that given a wrong criteria text, it should return false
     */
    @Test
    public void getWrongTextToFind() throws Exception {
        Criteria criteria= new Criteria("fileTest1","FILENAME");
        assertFalse(criteria.getTextToFind().equals("file"));
    }
    /**
     * Verify that given a correct criteria trype, it should return true
     */
    @Test
    public void getTypeOfCriteria() throws Exception {
        Criteria criteria= new Criteria("file","FILENAME");
        assertTrue(criteria.getTypeOfCriteria().equals("FILENAME"));
    }

}