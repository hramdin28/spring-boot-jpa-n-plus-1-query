package com.programmer.gate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.programmer.gate.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>, JpaSpecificationExecutor<Player> {

    //@EntityGraph(value = "player-entity-graph")
    @EntityGraph(attributePaths = {"team"})
    @Query("SELECT p FROM Player p WHERE p.team.name = :teamName")
    List<Player> findPlayersByTeamName(@Param("teamName") String teamName);

}
