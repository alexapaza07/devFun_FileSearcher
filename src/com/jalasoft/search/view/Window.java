
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
 * @version  0.2 in progress
 * @author Harry Grajeda  ////
 */
import javax.swing.*;
import java.awt.*;

//create window (Jframe)

class window extends JFrame{

// Insert the texts (Jtextfield), the button (Jbutton) and the Jpanel.

    JTextField textSearch;
    JLabel searchLabel;
    JButton buttonSearch;
    JPanel contentpane;

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

        //Assing Label
        searchLabel = new JLabel();

        //Assing Button
        buttonSearch = new JButton();

        //insert the texts, we give them coordinates and a text

        textSearch.setBounds(250, 10, 160, 25);

        contentpane.add(textSearch);

        textSearch.setText("");

        searchLabel.setBounds(50,10, 150, 25);
        contentpane.add(searchLabel);
        searchLabel.setText("Search by file name");


        //insert the button, coordinates and a text

        buttonSearch.setBounds(250, 150, 160, 25);

        contentpane.add(buttonSearch);

        buttonSearch.setText("Search");
    }
    public static void main(String args[]){

        //insert window

        window v = new window();
    }

}

