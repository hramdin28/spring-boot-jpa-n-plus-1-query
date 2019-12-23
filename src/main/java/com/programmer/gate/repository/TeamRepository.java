package com.programmer.gate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.programmer.gate.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>, JpaSpecificationExecutor<Team> {

    Team findByPlayers(long playerId);

    //@EntityGraph(value = "team-entity-graph")
    // @EntityGraph(attributePaths = {"players.team"})
    @Query("SELECT t from Team t")
    List<Team> findAllTeams();
}
