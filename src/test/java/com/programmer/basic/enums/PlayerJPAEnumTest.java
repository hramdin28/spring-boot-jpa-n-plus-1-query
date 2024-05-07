package com.programmer.basic.enums;

import static org.assertj.core.api.Assertions.assertThat;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;

class PlayerJPAEnumTest {

    /**
     * Corriger ce test
     */
    @Test
    void should_player_details_match() {
        var results = PlayerEnum.values();
        assertThat(results)
              .extracting("age", "pays")
              .containsExactly(
                    Tuple.tuple(32, "Argentine"),
                    Tuple.tuple(34, "Portugal"),
                    Tuple.tuple(37, "Suede"),
                    Tuple.tuple(40, "Angleterre"),
                    Tuple.tuple(45, "France")
              );
    }

}
