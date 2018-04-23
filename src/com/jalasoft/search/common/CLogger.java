package com.jalasoft.search.common;
/*
 * CLogger.java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 Implement the Singleton Logger object to handling logging information in all the needed class
 *
 * @version  1.0
 * @author Alexander Apaza
 */
public class CLogger {
    private static CLogger clogger = null;
    private static Logger logger = Logger.getLogger(CLogger.class.getName());


    private CLogger(){

    }
    /**
     * method to getInstance
     */
    public static CLogger getInstance(){
        if(null == clogger){
            new CLogger();
        }
        return clogger;
    }
    /**
     * method to set the log text
     */
    public static void setLogText(String type, String messageToLog){
        if(type.equals("WARNING")){
            logger.log(Level.WARNING, messageToLog);
        }
        if(type.equals("INFO")){
            logger.log(Level.INFO, messageToLog);
        }
        if(type.equals("SEVERE")){
            logger.log(Level.SEVERE, messageToLog);
        }

    }

}
