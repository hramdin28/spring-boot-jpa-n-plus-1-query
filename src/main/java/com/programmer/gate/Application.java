package com.programmer.gate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.programmer.gate.service.SoccerService;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    SoccerService soccerService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... arg0) {

        //soccerService.findPlayers();

        //soccerService.getPlayersByTeamName("Liverpool");

        //soccerService.findPlayersCtiteriaBuilder();

        soccerService.findTeams();

    }
}