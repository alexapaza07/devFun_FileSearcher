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
package com.jalasoft.search.controller;

import org.junit.Test;
import java.io.File;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 *
 * unit test for Validator.java
 * @version  1.0
 * @author Alexander Apaza
 */
public class ValidatorTest {
    /**
     * Verify that given a correct path, it should return true
     */
    @Test
    public void isProperPath() throws Exception {
        String path = new File("src\\com\\jalasoft\\search\\common\\testFolder").getAbsolutePath();
        Validator validator = new Validator(path);
        assertTrue(validator.isProperPath());
    }
    /**
     * Verify that given a wrong path, it should return false
     */
    @Test
    public void isNotProperPath() throws Exception {
        Validator validator = new Validator("testpath");
        assertFalse(validator.isProperPath());
    }

}