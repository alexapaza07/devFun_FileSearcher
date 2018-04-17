package com.jalasoft.search.view;/*
 * Window.java
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
 * @version  0.3 in progress
 * @author Harry Grajeda  ////
 */
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


//create window (Jframe)

public class  WindowsSearch extends JFrame{

// Insert the texts (Jtextfield), the button (Jbutton) and the Jpanel.

    JTextField textPath, textSearchFile,textSearchFile2,textSearchFile3, textFileSize;
    JLabel searchLabel, criteriaLabel,criteriaLabel2,criteriaLabel3, resultLabel, hideLabel, fileSizeLabel;
    JButton browser;
    JButton buttonSearch;
    JPanel contentpane;
    JTable tableResult;


    Choice searchCriteria;
    Choice searchCriteria2;
    Choice searchCriteria3;
    Choice hideFile;
    Choice fileSize;

    public WindowsSearch() {
        //init();
    }

    public void init() {

        //we make the window visible (Jframe) and give it coordinates where it appears

        setBounds(100, 100, 1024, 768);

        setVisible(true);

        //Insert the panel (content panel) and give it background color

        contentpane = new JPanel();
        contentpane.setBackground(Color.lightGray); //you can change the color here

        setContentPane(contentpane);
        contentpane.setLayout(null);
        // criteriaPanel.setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Assing Text

        textPath = new JTextField();
        textSearchFile = new JTextField();
        textSearchFile2 = new JTextField();
        textSearchFile3 = new JTextField();
        textFileSize = new JTextField();

        //Assing Label
        searchLabel = new JLabel();
        resultLabel = new JLabel();
        criteriaLabel = new JLabel();
        criteriaLabel2 = new JLabel();
        criteriaLabel3 = new JLabel();
        hideLabel = new JLabel();
        fileSizeLabel = new JLabel();

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

        String [] columnNames = {"FILENAME", "EXTENSION", "OWNER","test"};
        Object[][] data = {
                {"Kathy", "Smith",  new Integer(5), new Boolean(false)},
                {"John", "Doe",  new Integer(3), new Boolean(true)},
                {"Sue", "Black",  new Integer(2), new Boolean(false)},
                {"Jane", "White",  new Integer(20), new Boolean(true)},
                {"Joe", "Brown",  new Integer(10), new Boolean(false)}
        };
        tableResult = new JTable(data, columnNames);
        tableResult.setPreferredScrollableViewportSize(new Dimension(1000, 100));
        tableResult.setFillsViewportHeight(true);


        //tableResult.setPreferredScrollableViewportSize(new Dimension(100,100));
        JScrollPane scrollpane = new JScrollPane(tableResult);
        add(scrollpane);

        getContentPane().add(scrollpane, BorderLayout.CENTER);




        textFileSize.setBounds(280, 180, 150, 25);
        contentpane.add(textFileSize);



        //Assing choice

        searchCriteria = new Choice();
        searchCriteria.addItem("FILENAME");
        searchCriteria.addItem("OWNER");
        searchCriteria.addItem("EXTENSION");

        searchCriteria.addItem("CREATION DATE");
        searchCriteria.addItem("LAST MODIFY DATE");
        searchCriteria.addItem("LAST ACCESS DATE");
        searchCriteria.addItem("FILE SIZE");

        searchCriteria2 = new Choice();
        searchCriteria2.addItem("FILENAME");
        searchCriteria2.addItem("OWNER");
        searchCriteria2.addItem("EXTENSION");
        searchCriteria2.addItem("CREATION DATE");
        searchCriteria2.addItem("LAST MODIFY DATE");
        searchCriteria2.addItem("LAST ACCESS DATE");
        searchCriteria2.addItem("FILE SIZE");

        searchCriteria3 = new Choice();
        searchCriteria3.addItem("FILENAME");
        searchCriteria3.addItem("OWNER");
        searchCriteria3.addItem("EXTENSION");
        searchCriteria3.addItem("CREATION DATE");
        searchCriteria3.addItem("LAST MODIFY DATE");
        searchCriteria3.addItem("LAST ACCESS DATE");
        searchCriteria3.addItem("FILE SIZE");


        hideFile = new Choice();
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
        hideLabel.setText("HIDE FILE");


        fileSizeLabel.setBounds(50, 180, 100,25);
        contentpane.add(fileSizeLabel);
        fileSizeLabel.setText("FILE SIZE");

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
                    System.out.println("getCurrentDirectory(): "+ chooser.getCurrentDirectory());
                    System.out.println("getSelectedFile() : "+ chooser.getSelectedFile());
                    textPath.setText(String.valueOf(chooser.getSelectedFile()));
                } else {
                    System.out.println("No Selection ");
                }
            }
        });

        buttonSearch.setBounds(50, 250, 160, 25);
        contentpane.add(buttonSearch);
        buttonSearch.setText("Search");



        //insert Result, coordinates and a text


        tableResult.setBounds(50,310, 850,200);
        contentpane.add(tableResult);

        //insert search criteria, coordinates
        searchCriteria.setBounds(250, 50, 160,50);
        contentpane.add(searchCriteria);
        searchCriteria2.setBounds(250, 80, 160,25);
        contentpane.add(searchCriteria2);

        searchCriteria3.setBounds(250, 110, 160,25);
        contentpane.add(searchCriteria3);

        hideFile.setBounds(150,150, 100, 25);
        contentpane.add(hideFile);

        fileSize.setBounds(150,180, 100, 25);
        contentpane.add(fileSize);

    }
    public JButton getSearchButton(){
        return this.buttonSearch;
    }
    public String getPath(){
        return  this.textPath.getText();
    }
    public String getTextTofind1(){
        return  this.textSearchFile.getText();
    }
    public String getTextTofind2(){
        return  this.textSearchFile2.getText();
    }
    public String getCriteriaType1(){
        return  this.searchCriteria.getSelectedItem().toString();
    }
    public String getCriteriaType2(){
        return  this.searchCriteria2.getSelectedItem().toString();
    }

    public String getHideFile (){
        return this.hideFile.getSelectedItem().toString();
    }

    public String getFileSize (){
        return this.fileSize.getSelectedItem().toString();

    }
    /*
     * Method to display files found
     */
    public  void setFilesFound(String filesFound){
        String newline = "\n";
       // this.textResult.append(filesFound +newline);

    }
    /*
     * Method to clean the text are result for a  new search
     */
    public  void cleanTextArea(){
        String newline = "\n";
       // this.textResult.setText("");

    }

}
