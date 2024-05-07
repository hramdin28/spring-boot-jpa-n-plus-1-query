package com.programmer.advanced.services;

import com.programmer.models.Player;
import java.io.IOException;
import java.util.List;

public interface SoccerService {

    List<Player> findPlayers();

    void importPlayersAndTeamsFromCsvFile(String playerFilePath, String teamFilePath)
          throws IOException;
}
