package com.jalasoft.search.controller;
import com.jalasoft.search.model.Criteria;
import com.jalasoft.search.model.MFile;
import com.jalasoft.search.model.Search;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander Apaza on 3/27/2018.
 */
public class Controller {
    private List<Criteria> listCriteria;
    private String path;
    public Controller(){
        // listCriteria = new View().getListCriteria;
        // path = new View().getPathToCheck;

        // harcoding some values to search
        listCriteria = new ArrayList<Criteria>();
        path = new File("src\\com\\jalasoft\\search\\common\\testFolder").getAbsolutePath();
         listCriteria.add(new Criteria("txt","FILENAME" ));
        /*listCriteria.add(new Criteria("mp4","EXTENSION" ));
        listCriteria.add(new Criteria("jalasoft\\search","PATH" ));
        listCriteria.add(new Criteria("AA","OWNER" ));
        listCriteria.add(new Criteria("archi","FILENAME" ));*/

        sendCriteriaToSearchFiles();
    }
    private   void sendCriteriaToSearchFiles(){
        Search search = new Search(listCriteria,path);
        List<MFile> files = search.getResult();
        for(MFile fil : files) {
            System.out.println("File found:"+fil.getName());
        }
    }
}
