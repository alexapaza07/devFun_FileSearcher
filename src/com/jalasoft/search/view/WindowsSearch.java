package com.jalasoft.search.view;
/*
 * WindowSearch.java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
/**
 *
 Class description goes here.
 *
 * @version  5 in progress
 * @author Harry Grajeda
 * @modifier Alexander Apaza
 */
import com.jalasoft.search.common.CLogger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
/**
 *
 Implement the UI interface to capture the final user criteria to search files which interact with Controller class
 *
 * @version  3.0
 * @author Harry Grajeda
 * @modifier Alexander Apaza
 */
public class  WindowsSearch extends JFrame{

// Insert the texts (Jtextfield), the button (Jbutton) and the Jpanel.
    private JTextField textPath, textSearchFile,textSearchFile2,textSearchFile3, lowerSizeField,upperSizeField;
    private JLabel searchLabel, criteriaLabel,criteriaLabel2,criteriaLabel3, resultLabel, hideLabel, fileSizeLabel,fileSizeBeetweenLabel,fileSizeAndLable;
    private JButton browser;
    private JButton buttonSearch;
    private JPanel contentpane;
    private Choice searchCriteria;
    private Choice searchCriteria2;
    private Choice searchCriteria3;
    private Choice hideFile;
    private Choice fileSize;
    private JScrollPane tableScrollPane;
    private JTable tableFiles ;
    private TableColumnModel tableColumns ;
    private DefaultTableModel tableModel;
    private CLogger logger = CLogger.getInstance();
    public WindowsSearch() {
    }
    //we make the window visible (Jframe) and give it coordinates where it appears
    public void init() {
        setBounds(100, 100, 1024, 768);
        setVisible(true);

        contentpane = new JPanel();
        contentpane.setBackground(Color.lightGray); //you can change the color here

        setContentPane(contentpane);
        contentpane.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Assing Text
        textPath = new JTextField();
        textSearchFile = new JTextField();
        textSearchFile2 = new JTextField();
        textSearchFile3 = new JTextField();
        lowerSizeField = new JTextField();
        upperSizeField = new JTextField();

        //Assing Label
        searchLabel = new JLabel();
        resultLabel = new JLabel();
        criteriaLabel = new JLabel();
        criteriaLabel2 = new JLabel();
        criteriaLabel3 = new JLabel();
        hideLabel = new JLabel();
        fileSizeLabel = new JLabel();
        fileSizeBeetweenLabel = new JLabel();
        fileSizeAndLable = new JLabel();

        //Assing Button
        buttonSearch = new JButton();
        browser = new JButton();

        //Assing Result
        textSearchFile.setBounds(440,50, 150,25);
        contentpane.add(textSearchFile);
        textSearchFile2.setBounds(440,80, 150,25);
        contentpane.add(textSearchFile2);
        textSearchFile3.setBounds(440,110, 150,25);
        contentpane.add(textSearchFile3);
        lowerSizeField.setBounds(330, 180, 100, 25);
        contentpane.add(lowerSizeField);
       upperSizeField.setBounds(480, 180, 100, 25);
        contentpane.add(upperSizeField);



        //Assing choice
        searchCriteria = new Choice();
        searchCriteria.addItem("NAME");
        searchCriteria.addItem("OWNER");
        searchCriteria.addItem("EXTENSION");
        searchCriteria.addItem("CREATION DATE");
        searchCriteria.addItem("LAST MODIFY DATE");
        searchCriteria.addItem("LAST ACCESS DATE");


        searchCriteria2 = new Choice();
        searchCriteria2.addItem("NAME");
        searchCriteria2.addItem("OWNER");
        searchCriteria2.addItem("EXTENSION");
        searchCriteria2.addItem("CREATION DATE");
        searchCriteria2.addItem("LAST MODIFY DATE");
        searchCriteria2.addItem("LAST ACCESS DATE");


        searchCriteria3 = new Choice();
        searchCriteria3.addItem("NAME");
        searchCriteria3.addItem("OWNER");
        searchCriteria3.addItem("EXTENSION");
        searchCriteria3.addItem("CREATION DATE");
        searchCriteria3.addItem("LAST MODIFY DATE");
        searchCriteria3.addItem("LAST ACCESS DATE");



        hideFile = new Choice();
        hideFile.addItem("ANY");
        hideFile.addItem("NO");
        hideFile.addItem("YES");

        fileSize = new Choice();
        fileSize.addItem("KB");
        fileSize.addItem("MB");
        fileSize.addItem("GB");



        //insert the texts, we give them coordinates and a text

        textPath.setBounds(250, 10, 160, 25);
        contentpane.add(textPath);
        textPath.setText("");



        searchLabel.setBounds(50,10, 150, 25);
        contentpane.add(searchLabel);
        searchLabel.setText("Enter path");

        resultLabel.setBounds(50,280, 100,25);
        contentpane.add(resultLabel);
        resultLabel.setText("Files found:");

        criteriaLabel.setBounds(50, 50, 130, 25);
        contentpane.add(criteriaLabel);
        criteriaLabel.setText("Criteria 1:");

        criteriaLabel2.setBounds(50, 80, 130, 25);
        contentpane.add(criteriaLabel2);
        criteriaLabel2.setText("Criteria 2:(Optional)");


        criteriaLabel3.setBounds(50, 110, 130, 25);
        contentpane.add(criteriaLabel3);
        criteriaLabel3.setText("Criteria 3:(Optional)");

        hideLabel.setBounds(50, 150, 100,25);
        contentpane.add(hideLabel);
        hideLabel.setText("Is Hide? (Optional)");


        fileSizeLabel.setBounds(50, 180, 100,25);
        contentpane.add(fileSizeLabel);
        fileSizeLabel.setText("File Size (Optional)");


        fileSizeBeetweenLabel.setBounds(250, 180, 80,25);
        contentpane.add(fileSizeBeetweenLabel);
        fileSizeBeetweenLabel.setText("Beetween");

        fileSizeAndLable.setBounds(450, 180, 30,25);
        contentpane.add(fileSizeAndLable);
        fileSizeAndLable.setText("And");

        //insert the button, coordinates and a text
        browser.setBounds(440, 10, 100, 25);
        contentpane.add(browser);
        browser.setText("Browser");
        browser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("Browse the folder to process");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);


                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File workingDirectory = new File(System.getProperty("user.dir"));
                    chooser.setCurrentDirectory(workingDirectory);
                    logger.setLogText("INFO","this is the current folder"+chooser.getCurrentDirectory());
                    textPath.setText(String.valueOf(chooser.getSelectedFile()));
                } else {
                    logger.setLogText("INFO","No file selected");

                }
            }
        });

        buttonSearch.setBounds(50, 250, 160, 25);
        contentpane.add(buttonSearch);
        buttonSearch.setText("Search");

        //insert Result, coordinates and a text
        searchCriteria.setBounds(250, 50, 160,50);
        contentpane.add(searchCriteria);
        searchCriteria2.setBounds(250, 80, 160,25);
        contentpane.add(searchCriteria2);

        searchCriteria3.setBounds(250, 110, 160,25);
        contentpane.add(searchCriteria3);

        hideFile.setBounds(250,150, 100, 25);
        contentpane.add(hideFile);

        fileSize.setBounds(600,180, 100, 25);
        contentpane.add(fileSize);


        tableScrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tableScrollPane.setPreferredSize(new Dimension(900, 200));
        String [] columnNames = new String[] {"Type","Name", "Owner", "extension","Creation Date","Modified Date","Last Access Date"};
        Object[][] data2 = {
                {"", "",  "","",  "","",  ""},
                {"", "",  "","",  "","",  ""},
                {"", "",  "","",  "","",  ""},
                {"", "",  "","",  "","",  ""},
                {"", "",  "","",  "","",  ""},
                {"", "",  "","",  "","",  ""},
                {"", "",  "","",  "","",  ""},
                {"", "",  "","",  "","",  ""},
                {"", "",  "","",  "","",  ""},
                {"", "",  "","",  "","",  ""},
                {"", "",  "","",  "","",  ""},
                {"", "",  "","",  "","",  ""},
                {"", "",  "","",  "","",  ""},
                {"", "",  "","",  "","",  ""},
                {"", "",  "","",  "","",  ""},
                {"", "",  "","",  "","",  ""},
                {"", "",  "","",  "","",  ""},
                {"", "",  "","",  "","",  ""},
                {"", "",  "","",  "","",  ""},
                {"", "",  "","",  "","",  ""}
        };

        tableModel = new DefaultTableModel(data2,columnNames);
        tableFiles  = new JTable(tableModel);
        tableFiles.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        tableColumns  = tableFiles.getColumnModel();
        tableColumns .getColumn(0).setPreferredWidth(30);     //Type
        tableColumns .getColumn(1).setPreferredWidth(250);    //Name
        tableColumns .getColumn(2).setPreferredWidth(10);    //Owner
        tableColumns .getColumn(3).setPreferredWidth(40);   // extension
        tableColumns .getColumn(4).setPreferredWidth(40);  // creation date
        tableColumns .getColumn(5).setPreferredWidth(40);  // modified date
        tableColumns .getColumn(6).setPreferredWidth(40); // last access date

        tableScrollPane.setBounds(50,320, 900, 200);
        tableScrollPane.getViewport().add(tableFiles);
        contentpane.add(tableScrollPane);

    }
    /**
     * The method to get the button from UI and use it on Controller class
     */
    public JButton getSearchButton(){
        logger.setLogText("INFO","returning the Search button");
        return this.buttonSearch;

    }
    /**
     * The method to get the file path from UI and use in Controller class
     */
    public String getPath(){
        logger.setLogText("INFO","returning the Path");
        return  this.textPath.getText();
    }
    /**
     * The method to get the table path from UI and use in Controller class
     */
    public DefaultTableModel getTableModel(){
        logger.setLogText("INFO","returning the table model");
        return this.tableModel;
    }
    /**
     * The method to get the text to find in criteria 1 from UI and use in Controller class
     */
    public String getTextTofind1(){
        logger.setLogText("INFO","returning the text to fine #1");
        return  this.textSearchFile.getText();
    }
    /**
     * The method to get the text to find in criteria 2  from UI and use in Controller class
     */
    public String getTextTofind2(){
        logger.setLogText("INFO","returning the text to find for criteria 2");
        return  this.textSearchFile2.getText();
    }
    /**
     * The method to get the text to find in criteria 3 from UI and use in Controller class
     */
    public String getTextTofind3(){
        logger.setLogText("INFO","returning the text to find for criteria 3");
        return  this.textSearchFile3.getText();
    }
    /**
     * The method to get the type of criteria 1 from UI and use in Controller class
     */
    public String getCriteriaType1(){
        logger.setLogText("INFO","returning criteria type for criteria 1");
        return  this.searchCriteria.getSelectedItem().toString();
    }
    /**
     * The method to get the type of criteria 2 from UI and use in Controller class
     */
    public String getCriteriaType2(){
        logger.setLogText("INFO","returning criteria type for criteria 2");
        return  this.searchCriteria2.getSelectedItem().toString();
    }
    /**
     * The method to get the type of criteria 3 from UI and use in Controller class
     */
    public String getCriteriaType3(){
        logger.setLogText("INFO","returning the criteria type for criteria 3");
        return  this.searchCriteria3.getSelectedItem().toString();
    }
    /**
     * The method to get the hidden criteria from UI and use in Controller class
     */
    public String getHideFile (){
        logger.setLogText("INFO","returning the criteria for hiden files");
        return this.hideFile.getSelectedItem().toString();
    }
    /**
     * The method to get the size criteria from UI and use in Controller class
     */
    public String getFileSize (){
        logger.setLogText("INFO","returning the criteria for file size");
        return this.fileSize.getSelectedItem().toString();
    }
    /**
     * The method to get the lower size value as part of size criteria retrieved from UI and use in Controller class
     */
    public  String getlowerSizeField(){
        logger.setLogText("INFO","returning the lower value for size criteria");
        return lowerSizeField.getText();
    }
    /**
     * The method to get the upper size value as part of size criteria retrieved from UI and use in Controller class
     */
    public  String getupperSizeField(){
        logger.setLogText("INFO","returning the upper value for size criteria");
        return upperSizeField.getText();
    }
    /**
     * The method to get the size unit  as part of size criteria retrieved from UI and use in Controller class
     */
    public  String getSizeUnit(){
        logger.setLogText("INFO","returning the size unit for size criteria");
        return fileSize.getSelectedItem().toString();
    }
}
