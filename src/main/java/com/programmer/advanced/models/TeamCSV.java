package com.programmer.advanced.models;

import com.opencsv.bean.CsvBindByName;

public class TeamCSV {

    @CsvBindByName
    private String name;

    public String getName() {
        return name;
    }
}
