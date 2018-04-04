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
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
//create window (Jframe)

public class  WindowsSearch extends JFrame{

// Insert the texts (Jtextfield), the button (Jbutton) and the Jpanel.

    JTextField textPath, textSearchFile,textSearchFile2;
    JLabel searchLabel, criteriaLabel,criteriaLabel2, resultLabel;
    JButton buttonSearch;
    JPanel contentpane;
    JTextArea textResult;
    Checkbox checkBoxAdvance;
    Choice searchCriteria;
    Choice searchCriteria2;

    public WindowsSearch() {
        //init();
    }

    public void init() {

        //we make the window visible (Jframe) and give it coordinates where it appears

        setBounds(100, 100, 640, 480);

        setVisible(true);

        //Insert the panel (content panel) and give it background color

        contentpane = new JPanel();

        contentpane.setBackground(Color.lightGray); //you can change the color here

        setContentPane(contentpane);

        contentpane.setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Assing Text

        textPath = new JTextField();
        textSearchFile = new JTextField();
        textSearchFile2 = new JTextField();

        //Assing Label
        searchLabel = new JLabel();
        resultLabel = new JLabel();
        criteriaLabel = new JLabel();
        criteriaLabel2 = new JLabel();

        //Assing Button
        buttonSearch = new JButton();

        //Assing Result
        textSearchFile.setBounds(440,50, 150,25);
        contentpane.add(textSearchFile);

        textSearchFile2.setBounds(440,80, 150,25);
        contentpane.add(textSearchFile2);

        textResult = new JTextArea();
        // textResult.setEditable(false);



        //Assing checkbox

        checkBoxAdvance = new Checkbox();

        //Assing choice

        searchCriteria = new Choice();
        searchCriteria.addItem("FILENAME");
        searchCriteria.addItem("OWNER");
        searchCriteria.addItem("EXTENSION");
        searchCriteria.addItem("OWNER");
        searchCriteria.addItem("CREATION DATE");
        searchCriteria.addItem("LAST MODIFY DATE");
        searchCriteria.addItem("LAST ACCESS DATE");
        searchCriteria.addItem("FILE SIZE");

        searchCriteria2 = new Choice();
        searchCriteria2.addItem("FILENAME");
        searchCriteria2.addItem("OWNER");
        searchCriteria2.addItem("EXTENSION");
        searchCriteria2.addItem("OWNER");
        searchCriteria2.addItem("CREATION DATE");
        searchCriteria2.addItem("LAST MODIFY DATE");
        searchCriteria2.addItem("LAST ACCESS DATE");
        searchCriteria2.addItem("FILE SIZE");

        //insert the texts, we give them coordinates and a text

        textPath.setBounds(250, 10, 160, 25);
        contentpane.add(textPath);
        textPath.setText("");



        searchLabel.setBounds(50,10, 150, 25);
        contentpane.add(searchLabel);
        searchLabel.setText("Enter path");

        resultLabel.setBounds(50,120, 100,25);
        contentpane.add(resultLabel);
        resultLabel.setText("Files found:");

        criteriaLabel.setBounds(50, 50, 130, 25);
        contentpane.add(criteriaLabel);
        criteriaLabel.setText("Search by Criteria 1:");

        criteriaLabel2.setBounds(50, 80, 130, 25);
        contentpane.add(criteriaLabel2);
        criteriaLabel2.setText("Search by Criteria 2:");


        //insert the button, coordinates and a text

        buttonSearch.setBounds(250, 100, 160, 25);
        contentpane.add(buttonSearch);
        buttonSearch.setText("Search");

        //insert Result, coordinates and a text
        textResult.setBounds( 50, 150, 400,200);
        contentpane.add(textResult);




        //insert checkbox, coordinates and a text

        checkBoxAdvance.setBounds( 50, 100, 120,25);
        contentpane.add(checkBoxAdvance);
        checkBoxAdvance.setLabel("Advance Search");

        //insert search criteria, coordinates
        searchCriteria.setBounds(250, 50, 160,25);
        contentpane.add(searchCriteria);
        searchCriteria2.setBounds(250, 80, 160,25);
        contentpane.add(searchCriteria2);

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
    /*
    * Method to display files found
    */
    public  void setFilesFound(String filesFound){
        String newline = "\n";
        this.textResult.append(filesFound +newline);

    }
    /*
    * Method to clean the text are result for a  new search
    */
    public  void cleanTextArea(){
        String newline = "\n";
        this.textResult.setText("");

    }

}
