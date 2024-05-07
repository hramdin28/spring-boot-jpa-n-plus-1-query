package com.programmer.answers.advanced.persistence.repository;

import com.programmer.advanced.persistence.models.PlayerJPA;
import java.util.List;
import org.springframework.data.jpa.repository.Query;


public interface PlayerJPARepository /**extends JpaRepository<PlayerJPA, String>,
 JpaSpecificationExecutor<PlayerJPA> **/
{

    /**
     * Pour qu'hibernate ne génère qu'une seule requête sql, nous devons ajouter les mots-clés
     * suivants " left join fetch p.teamJPA"
     *
     * @return
     */
    @Query("SELECT p FROM PlayerJPA p left join fetch p.teamJPA")
    List<PlayerJPA> findPlayers();

}
