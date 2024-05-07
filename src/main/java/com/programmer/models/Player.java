package com.programmer.models;

import com.programmer.basic.enums.PositionEnum;

public class Player {

    private String id;
    private String name;
    private int num;
    private PositionEnum position;
    private String teamName;

    public Player(String id, String name, int num, PositionEnum position, String teamName) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.position = position;
        this.teamName = teamName;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public PositionEnum getPosition() {
        return position;
    }

    public String getTeamName() {
        return teamName;
    }
}
