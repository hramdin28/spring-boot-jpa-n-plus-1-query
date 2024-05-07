package com.programmer.basic.streams;

import com.programmer.basic.enums.PositionEnum;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;

/**
 * Les tests sont déjà mis en place. Corrigez la logique du code.
 */
class MyStreamTest {

    private static final MyStream MY_STREAM = new MyStream();

    @Test
    void should_fetchPlayerDtos() {
        Assertions.assertThat(MY_STREAM.playerDtos())
              .extracting("id", "name", "num", "position")
              .containsExactly(
                    Tuple.tuple("1", "Messi", 10, PositionEnum.FORWARD),
                    Tuple.tuple("2", "Inniesta", 10, PositionEnum.MIDFIELDER),
                    Tuple.tuple("3", "Pique", 21, PositionEnum.DEFENDER),
                    Tuple.tuple("4", "Salah", 9, PositionEnum.FORWARD),
                    Tuple.tuple("5", "Mane", 9, PositionEnum.FORWARD),
                    Tuple.tuple("6", "Firmino", 10, PositionEnum.FORWARD)
              );
    }

    @Test
    void sould_fetch_forwardPlayerDtos() {
        Assertions.assertThat(MY_STREAM.forwardPlayerDtos())
              .extracting("id", "name", "num", "position")
              .containsExactly(
                    Tuple.tuple("1", "Messi", 10, PositionEnum.FORWARD),
                    Tuple.tuple("4", "Salah", 9, PositionEnum.FORWARD),
                    Tuple.tuple("5", "Mane", 9, PositionEnum.FORWARD),
                    Tuple.tuple("6", "Firmino", 10, PositionEnum.FORWARD)
              );
    }

    @Test
    void should_fetch_player_names_by_groupBy_their_Numbers() {
        var groupByNumberPlayerDtos = MY_STREAM.groupByNumberPlayerDtos();

        Assertions.assertThat(groupByNumberPlayerDtos).isNotEmpty().hasSize(3);

        Assertions.assertThat(groupByNumberPlayerDtos.get(10))
              .containsExactly(
                    "Messi", "Inniesta", "Firmino"
              );

        Assertions.assertThat(groupByNumberPlayerDtos.get(21))
              .containsExactly(
                    "Pique"
              );

        Assertions.assertThat(groupByNumberPlayerDtos.get(9))
              .containsExactly(
                    "Salah", "Mane"
              );
    }
}
