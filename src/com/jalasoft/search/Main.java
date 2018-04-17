package com.jalasoft.search;

import com.jalasoft.search.controller.ControllerOficial;
import com.jalasoft.search.model.Search;
import com.jalasoft.search.view.WindowsSearch;

public class Main {
    public static void main(String arg[]) {
        WindowsSearch view = new WindowsSearch();
        Search search = new Search();
        ControllerOficial controller = new ControllerOficial(view, search);
    }
}
