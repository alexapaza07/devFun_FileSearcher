package com.jalasoft.search;

import com.jalasoft.search.controller.Controller;
import com.jalasoft.search.controller.ControllerOficial;
import com.jalasoft.search.model.Search;
import com.jalasoft.search.view.WindowsSearch;

public class Main {
    public static void main(String arg[]) {
        // new Controller();
        WindowsSearch view = new WindowsSearch();
        Search search = new Search();
        ControllerOficial controller = new ControllerOficial(view, search);
    }
}
