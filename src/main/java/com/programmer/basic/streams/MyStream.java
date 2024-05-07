package com.programmer.basic.streams;

import com.programmer.basic.enums.PositionEnum;
import com.programmer.dtos.PlayerDto;
import com.programmer.models.Player;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Modifier les méthodes publiques pour implémenter la logique correcte
 */
public class MyStream {

    private static final List<Player> PERSON_LIST = List.of(
          new Player("1", "Messi", 10, PositionEnum.FORWARD, "Barcelona"),
          new Player("2", "Inniesta", 10, PositionEnum.MIDFIELDER, "Barcelona"),
          new Player("3", "Pique", 21, PositionEnum.DEFENDER, "Barcelona"),
          new Player("4", "Salah", 9, PositionEnum.FORWARD, "Liverpool"),
          new Player("5", "Mane", 9, PositionEnum.FORWARD, "Liverpool"),
          new Player("6", "Firmino", 10, PositionEnum.FORWARD, "Liverpool")
    );

    /**
     * Changer PERSON_LIST par une liste de PlayerDto
     *
     * @return List<PlayerDto>
     */
    public List<PlayerDto> playerDtos() {
        return Collections.emptyList();

    }

    /**
     * Changer PERSON_LIST par une liste de PlayerDto et ne retourner que les joueurs FORWARD
     *
     * @return List<PlayerDto>
     */
    public List<PlayerDto> forwardPlayerDtos() {
        return Collections.emptyList();

    }

    /**
     * Regrouper les noms des joueurs par leur numéro
     *
     * @return Map<Integer, List < String>>
     */
    public Map<Integer, List<String>> groupByNumberPlayerDtos() {
        return Collections.emptyMap();
    }

}
