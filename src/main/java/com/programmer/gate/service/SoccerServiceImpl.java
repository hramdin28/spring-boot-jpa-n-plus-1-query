package com.programmer.gate.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.programmer.gate.model.Player;
import com.programmer.gate.model.Team;
import com.programmer.gate.repository.PlayerRepository;
import com.programmer.gate.repository.TeamRepository;

@Service
@Transactional(readOnly = true)
public class SoccerServiceImpl implements SoccerService {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(SoccerServiceImpl.class);

    @Override
    public void findPlayers() {
        LOGGER.info("Find players info  ");

        List<Player> players = playerRepository.findAll();

        for (Player player : players) {
            System.out.println(player.getTeam().getName());
        }
        System.out.println(players.size());
    }

    @Override
    public void getPlayersByTeamName(String teamName) {

        LOGGER.info("Get All Team Players       :");
        List<Player> players = playerRepository.findPlayersByTeamName(teamName);
        for (Player player : players) {
            System.out.println(player.getName());
        }
        System.out.println(players.size());
    }

    @Override
    public void findPlayersCtiteriaBuilder() {
        LOGGER.info("Find players info  ");

        List<Player> players = playerRepository.findAll(findPlayersByTeamSpec());

        for (Player player : players) {
            System.out.println(player.getTeam().getName() + ": " + player.getName());
        }
        System.out.println(players.size());
    }


    private Specification<Player> findPlayersByTeamSpec() {
        return (root, query, criteriaBuilder) -> {

            Join<Player, Team> team = (Join) root.fetch("team", JoinType.INNER);

            List<Predicate> predicates = new ArrayList<>();
            //predicates.add(root.get("team").get("name").in(Arrays.asList("Barcelona", "Liverpool")));
            predicates.add(team.get("name").in(Arrays.asList("Barcelona", "Liverpool")));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    @Override
    public void findTeams() {

        List<Team> teams = teamRepository.findAllTeams();
        for (Team team : teams) {
            System.out.println(team.getName() + ": " + team.getPlayers().get(0).getName() + ": " + team.getPlayers().get(0).getTeam().getName());
        }
        System.out.println(teams.size());
    }

    @Override
    public void addBarcelonaPlayer(String name, String position, int number) {
        LOGGER.info("Add Barcelona Player   :");

        Team barcelona = teamRepository.findOne(1l);
        Player newPlayer = new Player();
        newPlayer.setName(name);
        newPlayer.setPosition(position);
        newPlayer.setNum(number);
        newPlayer.setTeam(barcelona);
        playerRepository.save(newPlayer);
    }


}
