package com.programmer.advanced.models;

import com.opencsv.bean.CsvBindByName;

public class PlayerCSV {

    @CsvBindByName
    private String name;

    @CsvBindByName
    private int num;

    @CsvBindByName
    private String position;

    @CsvBindByName
    private String team;

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public String getPosition() {
        return position;
    }

    public String getTeam() {
        return team;
    }


}
