package com.jalasoft.search.view;

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
 * @version  0.1 in progress
 * @author Harry Grajeda  ////
 */

public class Window extends JFrame {

    private JLabel searchLabel;
    private JButton searchButton;
    private DrwaingPanel drawPanel;


    drawPanel = new DrawingPanel();

    searchLabel = new JLabel("Search by File Name");

    public Window(String title){
        super(tittle);



    }

    public static void main(String[] args) {
        JFrame window = new Window("Search File ver. 0.1");

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(640, 480);
        window.setVisible(true);
    }




}
