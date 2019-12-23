package com.programmer.gate.service;

public interface SoccerService {
    void getPlayersByTeamName(String name);

    void addBarcelonaPlayer(String name, String position, int number);

    void findPlayers();

    void findPlayersCtiteriaBuilder();

    void findTeams();

}
