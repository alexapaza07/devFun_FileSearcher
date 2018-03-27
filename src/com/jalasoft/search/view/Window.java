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
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

private class Window extends JFrame {

    private JLabel searchLabel;
    private JButton searchButton;
    private TextField resultText;
    
    searchLabel = new JLabel("Search by File Name");

    public Window(String title){
        super(tittle);
        setLayout( new BorderLayout(5,10));
        add(new JLabel("Simple Search:"), BorderLayout.NORTH);
        add(new JButton("Search"), BorderLayout.EAST):
        add(new TextField(), BorderLayout.SOUTH);

    }

    private static void main(String[] args) {
        JFrame window = new Window("Search File ver. 0.1");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(640, 480);
        window.setVisible(true);
    }
}

