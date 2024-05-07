package com.programmer.advanced.persistence.repository;

import com.programmer.advanced.persistence.models.PlayerJPA;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerJPARepository extends JpaRepository<PlayerJPA, String>,
      JpaSpecificationExecutor<PlayerJPA> {

    @Query("SELECT p FROM PlayerJPA p")
    List<PlayerJPA> findPlayers();

}
