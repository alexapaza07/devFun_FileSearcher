/*
 * MFolderTest.java
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
/**
 *
 Implement the unit test for MFolder
 *
 * @version  1.0
 * @author Alexander Apaza
 */
public class MFolderTest {
    /**
     * Verify that the method returns false when we give wrong access year
     */
    @Test
    public void verifyIfFolderIsShared() throws Exception {
        String path = new File("src\\com\\jalasoft\\search\\common\\testFolder\\nestedFile").getAbsolutePath();
        MFolder mfolder = new MFolder(path);
        assertFalse(mfolder.getIsShared());
    }
}