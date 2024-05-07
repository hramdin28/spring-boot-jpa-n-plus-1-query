package com.programmer.advanced.persistence.repository;

import com.programmer.advanced.persistence.models.TeamJPA;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamJPARepository extends JpaRepository<TeamJPA, String>,
      JpaSpecificationExecutor<TeamJPA> {

    Optional<TeamJPA> findByName(String name);
}
