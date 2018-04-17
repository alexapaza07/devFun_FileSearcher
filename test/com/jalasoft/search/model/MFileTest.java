/*
 * MFileTest.java
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
import java.io.File;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 *
 * unit test for MFile.java
 * @version  1.0
 * @author Alexander Apaza
 */
public class MFileTest {
    /**
     * Verify that a directory is not, when it is given non existing directory path
     */
    @Test
    public void verifyItIsNotDirectory() throws Exception {
        String path = new File("src\\com\\jalasoft\\search\\common\\testFolder\\file1.txt").getAbsolutePath();
        MFile mfile = new MFile(path);
        assertFalse(mfile.isDirectory());
    }
    /**
     * Verify that a directory is proper one, when it is given a correct directory path
     */
    @Test
    public void verifyItIsDirectory() throws Exception {
        String path = new File("src\\com\\jalasoft\\search\\common\\testFolder").getAbsolutePath();
        MFile mfile = new MFile(path);
        assertTrue(mfile.isDirectory());
    }
    /**
     * Verify that the method returns proper file name give an existing one correct
     */
    @Test
    public void getName() throws Exception {
        String path = new File("src\\com\\jalasoft\\search\\common\\testFolder\\file1.txt").getAbsolutePath();
        MFile mfile = new MFile(path);
        assertTrue(mfile.getName().equals("file1.txt"));
    }
    /**
     * Verify that the method returns proper file path given an corect file path
     */
    @Test
    public void getPath() throws Exception {
        String path = new File("src\\com\\jalasoft\\search\\common\\testFolder\\file1.txt").getAbsolutePath();
        MFile mfile = new MFile(path);
        assertTrue(mfile.getPath().contains("src\\com\\jalasoft\\search\\common\\testFolder"));
    }
    /**
     * Verify that the method returns proper file extension given an correct extension to compare
     */
    @Test
    public void getExtension() throws Exception {
        String path = new File("src\\com\\jalasoft\\search\\common\\testFolder\\file1.txt").getAbsolutePath();
        MFile mfile = new MFile(path);
        assertTrue(mfile.getExtension().contains("txt"));
    }
    /**
     * Verify that the method returns proper file owner given an correct portion of ownername
     */
    @Test
    public void getOwner() throws Exception {
        String path = new File("src\\com\\jalasoft\\search\\common\\testFolder\\file1.txt").getAbsolutePath();
        MFile mfile = new MFile(path);
        assertTrue(mfile.getOwner().contains("Apaza"));
    }
    /**
     * Verify that the method returns false when we give wrong year
     */
    @Test
    public void verifyWhenGivenWrongCreationDate() throws Exception {
        String path = new File("src\\com\\jalasoft\\search\\common\\testFolder\\file1.txt").getAbsolutePath();
        MFile mfile = new MFile(path);
        assertFalse(mfile.getCreationDate().contains("2010"));
    }
    /**
     * Verify that the method returns false when we give wrong year
     */
    @Test
    public void verifyWhenGivenWrongModifyDate() throws Exception {
        String path = new File("src\\com\\jalasoft\\search\\common\\testFolder\\file1.txt").getAbsolutePath();
        MFile mfile = new MFile(path);
        assertFalse(mfile.getLastModifyDate().contains("2010"));
    }
    /**
     * Verify that the method returns false when we give wrong year
     */

}