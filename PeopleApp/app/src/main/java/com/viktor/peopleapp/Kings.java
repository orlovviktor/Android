package com.viktor.peopleapp;

import java.util.ArrayList;
import java.util.List;

public class Kings {
    /* second part of the data resource, the class Kings makes King objects available
    creating list objects */
    private List<King> list = new ArrayList<>();

    // our multidimensional array that has our data values
    private static final String[][] data = {
            {"Albert Einstein", "1879", "1955"},
            {"Steve Jobs", "1955", "2011"},
            {"Marilyn Monroe", "1926", "1962"}
    };

    // adding multidimensional array values into the list
    public Kings(){
        for (String[] arr : data)
            list.add(new King(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2])));
    }
    public List<King> getKings(){
        return list;
    }





}