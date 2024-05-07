package com.programmer.advanced.services;

import com.programmer.advanced.persistence.repository.PlayerJPARepository;
import com.programmer.advanced.persistence.repository.TeamJPARepository;
import com.programmer.basic.enums.PositionEnum;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;


@SpringBootTest
class SoccerServiceTest {

    @Autowired
    private SoccerService soccerService;
    @Autowired
    private TeamJPARepository teamJPARepository;
    @Autowired
    private PlayerJPARepository playerJPARepository;


    /**
     * Question partie 1: Ce test va générer le LazyInitializationException. Pouvez-vous expliquer
     * pourquoi nous obtenons cette erreur et ce que nous pouvons faire pour l'éviter ?
     * <p>
     * <p>
     * Question partie 2: Que pouvez-vous faire pour améliorer la qualité du code ? Vous pouvez
     * réécrire l'implémentation de la fonction dans le service.
     * <p>
     * <p>
     * Question partie 3: Ce test va générer 3 requêtes SQL par HIBERNATE. Que pouvons-nous faire
     * pour que Hibernate ne génère qu'une seule requête SQL ?
     */
    @Sql(scripts = {"/scripts/data-test.sql"})
    @Test
    void should_find_players() {
        var players = soccerService.findPlayers();

        Assertions.assertThat(players)
              .extracting("id", "name", "num", "position")
              .containsExactly(
                    Tuple.tuple("1", "Messi", 10, PositionEnum.FORWARD),
                    Tuple.tuple("2", "Inniesta", 8, PositionEnum.MIDFIELDER),
                    Tuple.tuple("3", "Pique", 3, PositionEnum.DEFENDER),
                    Tuple.tuple("4", "Salah", 9, PositionEnum.FORWARD),
                    Tuple.tuple("5", "Mane", 10, PositionEnum.FORWARD),
                    Tuple.tuple("6", "Firmino", 11, PositionEnum.FORWARD)
              );
    }

    /**
     * Question partie 1: Cette fonction permet d'importer des données Teams et Players à partir de
     * fichiers CSV. Cependant, il y a une erreur lors de l'importation des données Players. S'il y
     * a des erreurs, rien ne doit être sauvegardé dans la base de données. Que pouvez-vous faire
     * pour résoudre ce problème ?
     * <p>
     * <p>
     * Question partie 2: Que pouvez-vous faire pour améliorer la qualité du code ? Vous pouvez
     * réécrire l'implémentation de la fonction sans modifier sa signature dans le service.
     */
    @Test
    void should_import_players_from_csv_but_there_is_an_error_in_one_player_data_nothing_must_be_saved() {

        try {
            soccerService.importPlayersAndTeamsFromCsvFile(
                  "src/test/resources/csv/players-data-error.csv",
                  "src/test/resources/csv/teams-data.csv");

        } catch (Exception e) {
            System.out.println(e);
        }

        var teams = teamJPARepository.findAll();
        Assertions.assertThat(teams).isEmpty();

        var players = playerJPARepository.findAll();
        Assertions.assertThat(players).isEmpty();

    }

    /**
     * Question: il y a une erreur(Checked Exception) lors de l'importation des données Players.
     * S'il y a des erreurs, rien ne doit être sauvegardé dans la base de données. Que pouvez-vous
     * faire pour résoudre ce problème ?
     */
    @Test
    void should_import_players_from_csv_but_there_is_a_checked_exception_when_reading_players_csv() {

        try {
            soccerService.importPlayersAndTeamsFromCsvFile(
                  "src/test/resources/csv/players-data-valid-xxx.csv",
                  "src/test/resources/csv/teams-data.csv");

        } catch (Exception e) {
            System.out.println(e);
        }

        var teams = teamJPARepository.findAll();
        Assertions.assertThat(teams).isEmpty();

        var players = playerJPARepository.findAll();
        Assertions.assertThat(players).isEmpty();

    }

}
