package com.microserviceTacheEmploye.dao;

import com.microserviceTacheEmploye.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TacheDao extends JpaRepository<Tache,Integer> {

    List<Tache> findAllByIdProjet(int idProjet);

    @Query("Select count(t) from Tache t where t.etat <> :x and t.idProjet = :y group by t.idProjet")
    Optional<Integer> tacheValideByProjet(@Param("x") String valide, @Param("y") int idPrj);

    @Query("Select t from Tache t group by t.idProjet")
    List<Tache> TachesByProjet();
}
