package com.jalasoft.search.controller;
/*
 * ControllerOficial.java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
import com.jalasoft.search.common.CLogger;
import com.jalasoft.search.model.*;
import com.jalasoft.search.view.WindowsSearch;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 Implement the UI interface to capture the final user criteria to search files which interact with Controller class
 *
 * @version  3.0
 * @author Alexander Apaza
  */
public class ControllerOficial {
    private WindowsSearch window ;
    private Search search ;
    List<Asset> assets;
    private CLogger logger = CLogger.getInstance();
    /**
     * Constructor method for the class
     */
    public ControllerOficial(WindowsSearch view, Search search){
        this.window = view;
        this.search=search;
        this.window.init();
        this.window.getSearchButton().addActionListener(e ->buildCriteriaAndSearch());
    }
    /**
     * Method to clean the table result
     */
    private void cleanTable(){
        int rowCount = this.window.getTableModel().getRowCount();
//Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            this.window.getTableModel().removeRow(i);
            logger.setLogText("INFO","cleaning result table:"+this.window.getTableModel().getColumnName(i));
        }

    }
    /**
     * The method to build the hidden criteria and send to Search class
     */
    private void buildHiddenCriteria(List<Criteria> listCriteria){
        if(this.window.getHideFile().toString().equals("YES")){
            listCriteria.add(new Criteria("YES","HIDDEN"));
        }if(this.window.getHideFile().toString().equals("NO")){
            listCriteria.add(new Criteria("NO","HIDDEN"));
        }
        logger.setLogText("INFO","building hidden criteria and add to criteria list");
    }
    /**
     * The method to build size criteria and send to Search class
     */
    private boolean buildSizeCriteria(List<Criteria> listCriteria){
        if((this.window.getlowerSizeField().equals("") && !this.window.getupperSizeField().equals("")) ||(!this.window.getlowerSizeField().equals("") && this.window.getupperSizeField().equals("")) ){
            JOptionPane.showMessageDialog(this.window,"Both lower and upper size field should be specified...");
            logger.setLogText("INFO","Both lower and upper size field are not specified...");
            return false;

        }else{
                if(!this.window.getlowerSizeField().equals("") && !this.window.getupperSizeField().equals("")) {
                    try {
                        double lowerSizeValue = Double.parseDouble(this.window.getlowerSizeField());
                        double upperSizeValue = Double.parseDouble(this.window.getupperSizeField());
                        double result = lowerSizeValue + upperSizeValue;
                        String criteriaMerget = this.window.getlowerSizeField() + "&&" + this.window.getupperSizeField() + "&&" + this.window.getSizeUnit();

                        listCriteria.add(new Criteria(criteriaMerget, "SIZE"));
                        logger.setLogText("INFO","size criteria specification done..");
                        return true;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this.window, "Just numeric values are allowed in size fields");
                        logger.setLogText("INFO","You entered wrong values in size fields");
                        return false;
                    }
                }else{
                    return true;
                }


        }
    }
    /**
     * The method to build all criteria and send to Search class
     */
    private  void buildCriteriaAndSearch(){
        cleanTable();
        if(new Validator(this.window.getPath()).isProperPath() ){
            if(!this.window.getTextTofind1().equals("") ){ // && !this.window.getTextTofind2().equals("")){
                List<Criteria> listCriteria =  new ArrayList<Criteria>();
                listCriteria.add(new Criteria(this.window.getTextTofind1(),this.window.getCriteriaType1()));
                listCriteria.add(new Criteria(this.window.getTextTofind2(),this.window.getCriteriaType2()));
                listCriteria.add(new Criteria(this.window.getTextTofind3(),this.window.getCriteriaType3()));
                buildHiddenCriteria(listCriteria);
                if(buildSizeCriteria(listCriteria)) {
                    search.init(listCriteria, this.window.getPath());
                    assets = search.getResult();
                    if (!assets.isEmpty()) {
                        for (Asset asset : assets) {
                            if (asset instanceof MFile) {
                                this.window.getTableModel().addRow(new Object[]{"File",asset.getPath() + "\\" + asset.getName(), asset.getOwner(), ((MFile) asset).getExtension(), asset.getCreationDate(), asset.getLastModifyDate(), asset.getLastModifyDate()});
                                logger.setLogText("INFO","Search criteria for files set properly...");
                            }
                            if (asset instanceof MFolder) {
                                this.window.getTableModel().addRow(new Object[]{"Folder",asset.getPath() + "\\" + asset.getName(), asset.getOwner(), "", asset.getCreationDate(), asset.getLastModifyDate(), asset.getLastModifyDate()});
                                logger.setLogText("INFO","Search criteria for folder set properly...");
                            }
                        }
                    } else {
                        logger.setLogText("INFO","No file was found...");
                        JOptionPane.showMessageDialog(this.window, "No file was found...");
                    }
                }
            }else {
                logger.setLogText("INFO","Specify proper text to search in Criteria 1");
                JOptionPane.showMessageDialog(this.window,"Specify proper text to search in Criteria 1");
            }
        }else {
            logger.setLogText("INFO","Specify a proper folder path");
            JOptionPane.showMessageDialog(this.window,"Specify a proper folder path");
        }
    }
}
