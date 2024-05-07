package com.programmer.answers.advanced.services;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.programmer.advanced.models.PlayerCSV;
import com.programmer.advanced.models.TeamCSV;
import com.programmer.advanced.persistence.models.PlayerJPA;
import com.programmer.advanced.persistence.models.TeamJPA;
import com.programmer.advanced.persistence.repository.PlayerJPARepository;
import com.programmer.advanced.persistence.repository.TeamJPARepository;
import com.programmer.advanced.services.SoccerService;
import com.programmer.basic.enums.PositionEnum;
import com.programmer.models.Player;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
public class SoccerServiceImpl implements SoccerService {

    private final PlayerJPARepository playerJPARepository;
    private final TeamJPARepository teamJPARepository;

    /**
     * Nous pouvons simplifier le code en utilisant stream().map()
     *
     * @return List<Player>
     */
    @Transactional
    @Override
    public List<Player> findPlayers() {
        log.info("Find players  ");

        List<PlayerJPA> playerJPAS = playerJPARepository.findPlayers();

        return playerJPAS.stream()
              .map(this::playerJpaToPlayer)
              .toList();
    }


    /**
     * Nous pouvons simplifier le code en utilisant stream(), les principes SOLID et les génériques
     * <p>
     * Nous voulons un rollback pour toutes les erreurs, y compris les CheckedExceptions.
     *
     * @param playerFilePath le path du fichier csv des players
     * @param teamFilePath   le path du fichier csv des teams
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void importPlayersAndTeamsFromCsvFile(String playerFilePath, String teamFilePath)
          throws IOException {
        importTeamsFromCsvFile(teamFilePath);

        importPlayersFromCsvFile(playerFilePath);
    }

    private void importTeamsFromCsvFile(String filePath) throws IOException {
        List<TeamCSV> teams = readAllLines(filePath, TeamCSV.class);
        var teamJPAS = teams.stream()
              .map(this::teamCsvToTeamJPA)
              .toList();
        teamJPARepository.saveAll(teamJPAS);
    }

    private void importPlayersFromCsvFile(String filePath) throws IOException {
        List<PlayerCSV> players = readAllLines(filePath, PlayerCSV.class);
        var playerJPAS = players.stream()
              .map(this::playerCSVToPlayerJPA)
              .toList();
        playerJPARepository.saveAll(playerJPAS);
    }

    private <T> List<T> readAllLines(String filePath, Class<T> clazz) throws IOException {
        var path = Paths.get(filePath);

        try (Reader reader = Files.newBufferedReader(path)) {
            CsvToBean<T> cb = new CsvToBeanBuilder<T>(reader)
                  .withType(clazz)
                  .build();

            return cb.parse();
        }
    }

    private Player playerJpaToPlayer(PlayerJPA playerJPA) {
        return new Player(
              playerJPA.getId(),
              playerJPA.getName(),
              playerJPA.getNum(),
              playerJPA.getPosition(),
              playerJPA.getTeamJPA().getName());
    }

    private TeamJPA teamCsvToTeamJPA(TeamCSV teamCSV) {
        return TeamJPA.builder()
              .name(teamCSV.getName())
              .build();
    }

    private PlayerJPA playerCSVToPlayerJPA(PlayerCSV playerCSV) {
        return PlayerJPA.builder()
              .name(playerCSV.getName())
              .num(playerCSV.getNum())
              .position(PositionEnum.valueOf(playerCSV.getPosition()))
              .teamJPA(findTeamJPAbyName(playerCSV.getTeam()))
              .build();
    }

    private TeamJPA findTeamJPAbyName(String name) {
        return teamJPARepository.findByName(name)
              .orElseThrow(
                    () -> new RuntimeException("Team not found"));
    }
}
