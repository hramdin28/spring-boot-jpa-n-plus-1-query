package com.programmer.dtos;

import com.programmer.basic.enums.PositionEnum;

public class PlayerDto {

    private String id;
    private String name;
    private int num;
    private PositionEnum position;

    public PlayerDto(String id, String name, int num, PositionEnum position) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.position = position;
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

}
