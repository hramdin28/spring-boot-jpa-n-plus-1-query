package com.programmer.answers.basic.streams;

import com.programmer.basic.enums.PositionEnum;
import com.programmer.dtos.PlayerDto;
import com.programmer.models.Player;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyStream {

    private static final List<Player> PERSON_LIST = List.of(
          new Player("1", "Messi", 10, PositionEnum.FORWARD, "Barcelona"),
          new Player("2", "Inniesta", 10, PositionEnum.MIDFIELDER, "Barcelona"),
          new Player("3", "Pique", 21, PositionEnum.DEFENDER, "Barcelona"),
          new Player("4", "Salah", 9, PositionEnum.FORWARD, "Liverpool"),
          new Player("5", "Mane", 9, PositionEnum.FORWARD, "Liverpool"),
          new Player("6", "Firmino", 10, PositionEnum.FORWARD, "Liverpool")
    );

    public List<PlayerDto> playerDtos() {
        return PERSON_LIST.stream()
              .map(player ->
                    new PlayerDto(player.getId(), player.getName(), player.getNum(),
                          player.getPosition()))
              .toList();
    }

    public List<PlayerDto> forwardPlayerDtos() {
        return PERSON_LIST.stream()
              .filter(player -> PositionEnum.FORWARD.equals(player.getPosition()))
              .map(player ->
                    new PlayerDto(player.getId(), player.getName(), player.getNum(),
                          player.getPosition()))
              .toList();
    }

    public Map<Integer, List<String>> groupByNumberPlayerDtos() {
        return PERSON_LIST.stream()
              .map(player ->
                    new PlayerDto(player.getId(), player.getName(), player.getNum(),
                          player.getPosition()))
              .collect(
                    Collectors.groupingBy(PlayerDto::getNum,
                          Collectors.mapping(PlayerDto::getName, Collectors.toList())
                    )
              );
    }

}
