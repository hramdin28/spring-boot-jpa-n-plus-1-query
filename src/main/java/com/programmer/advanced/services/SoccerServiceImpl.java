package com.programmer.advanced.services;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.programmer.advanced.models.PlayerCSV;
import com.programmer.advanced.models.TeamCSV;
import com.programmer.advanced.persistence.models.PlayerJPA;
import com.programmer.advanced.persistence.models.TeamJPA;
import com.programmer.advanced.persistence.repository.PlayerJPARepository;
import com.programmer.advanced.persistence.repository.TeamJPARepository;
import com.programmer.basic.enums.PositionEnum;
import com.programmer.models.Player;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class SoccerServiceImpl implements SoccerService {

    private final PlayerJPARepository playerJPARepository;

    private final TeamJPARepository teamJPARepository;

    @Override
    public List<Player> findPlayers() {
        log.info("Find players  ");

        List<PlayerJPA> playerJPAS = playerJPARepository.findPlayers();

        List<Player> players = new ArrayList<>(playerJPAS.size());

        for (PlayerJPA playerJPA : playerJPAS) {
            var player = new Player(
                  playerJPA.getId(),
                  playerJPA.getName(),
                  playerJPA.getNum(),
                  playerJPA.getPosition(),
                  playerJPA.getTeamJPA().getName());

            players.add(player);
        }
        return players;
    }

    @Override
    public void importPlayersAndTeamsFromCsvFile(String playerFilePath, String teamFilePath)
          throws IOException {
        List<TeamCSV> teams = readAllTeamLines(teamFilePath);
        teams.forEach(teamCSV -> {
            var teamJpa = TeamJPA.builder()
                  .name(teamCSV.getName())
                  .build();
            teamJPARepository.save(teamJpa);
        });

        List<PlayerCSV> players = readAllPlayerLines(playerFilePath);

        players.forEach(player -> {

            var teamJPA = teamJPARepository.findByName(player.getTeam())
                  .orElseThrow(
                        () -> new RuntimeException("Team not found"));

            var playerJPA = PlayerJPA.builder()
                  .name(player.getName())
                  .num(player.getNum())
                  .position(PositionEnum.valueOf(player.getPosition()))
                  .teamJPA(teamJPA)
                  .build();

            playerJPARepository.save(playerJPA);
        });
    }

    private List<PlayerCSV> readAllPlayerLines(String filePath)
          throws IOException {
        var path = Paths.get(filePath);

        try (Reader reader = Files.newBufferedReader(path)) {
            CsvToBean<PlayerCSV> cb = new CsvToBeanBuilder<PlayerCSV>(reader)
                  .withType(PlayerCSV.class)
                  .build();

            return cb.parse();
        }
    }

    private List<TeamCSV> readAllTeamLines(String filePath) throws IOException {
        var path = Paths.get(filePath);

        try (Reader reader = Files.newBufferedReader(path)) {
            CsvToBean<TeamCSV> cb = new CsvToBeanBuilder<TeamCSV>(reader)
                  .withType(TeamCSV.class)
                  .build();

            return cb.parse();
        }
    }

}
