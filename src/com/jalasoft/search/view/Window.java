
/*
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

//create window (Jframe)

class window extends JFrame{

// Insert the texts (Jtextfield), the button (Jbutton) and the Jpanel.

    JTextField textSearch, textSearchFile;
    JLabel searchLabel, criteriaLabel, resultLabel;
    JButton buttonSearch;
    JPanel contentpane;
    TextArea textResult;
    Checkbox checkBoxAdvance;
    Choice searchCriteria;

    public window() {

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

        textSearch = new JTextField();
        textSearchFile = new JTextField();

        //Assing Label
        searchLabel = new JLabel();
        resultLabel = new JLabel();
        criteriaLabel = new JLabel();

        //Assing Button
        buttonSearch = new JButton();

        //Assing Result

        textResult = new TextArea();

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

        //insert the texts, we give them coordinates and a text

        textSearch.setBounds(250, 10, 160, 25);
        contentpane.add(textSearch);
        textSearch.setText("");

        textSearchFile.setBounds(440,50, 150,25);
        contentpane.add(textSearchFile);


        searchLabel.setBounds(50,10, 150, 25);
        contentpane.add(searchLabel);
        searchLabel.setText("Enter path");

        resultLabel.setBounds(50,120, 100,25);
        contentpane.add(resultLabel);
        resultLabel.setText("Result");

        criteriaLabel.setBounds(50, 50, 100, 25);
        contentpane.add(criteriaLabel);
        criteriaLabel.setText("Search by:");


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

    }
    public static void main(String args[]){

        //insert window

        window v = new window();
    }

}

