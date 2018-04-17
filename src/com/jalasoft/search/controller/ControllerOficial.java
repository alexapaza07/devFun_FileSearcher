package com.jalasoft.search.controller;

import com.jalasoft.search.model.*;
import com.jalasoft.search.view.WindowsSearch;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerOficial {
    private WindowsSearch window ;
    private Search search ;
    List<Asset> assets;

    public ControllerOficial(WindowsSearch view, Search search){
        this.window = view;
        this.search=search;
        this.window.init();
        this.window.getSearchButton().addActionListener(e ->buildCriteriaAndSearch());
    }
    private  void buildCriteriaAndSearch(){
        System.out.println("click");
        System.out.println(this.window.getCriteriaType1());
        this.window.cleanTextArea();
        if(new Validator(this.window.getPath()).isProperPath() ){
            if(!this.window.getTextTofind1().equals("") ){ // && !this.window.getTextTofind2().equals("")){
                List<Criteria> listCriteria =  new ArrayList<Criteria>();
                listCriteria.add(new Criteria(this.window.getTextTofind1(),this.window.getCriteriaType1()));
                //listCriteria.add(new Criteria(this.window.getTextTofind2(),this.window.getCriteriaType2()));
                search.init(listCriteria,this.window.getPath());
                assets = search.getResult();
                if(!assets.isEmpty() ) {
                    for (Asset asset : assets) {
                       if (asset instanceof  MFile){
                            this.window.setFilesFound(asset.getPath() + "\\" + asset.getName() +"********File type");
                       }if(asset instanceof MFolder){
                            this.window.setFilesFound(asset.getPath() + "\\" + asset.getName() +"********Folder type" );
                        }


                    }
                }else {
                    JOptionPane.showMessageDialog(this.window,"No file was found?");
                }
            }else {
                JOptionPane.showMessageDialog(this.window,"Specify proper text to search");
            }
        }else {
            JOptionPane.showMessageDialog(this.window,"Specify a proper folder path");
        }

    }

}
