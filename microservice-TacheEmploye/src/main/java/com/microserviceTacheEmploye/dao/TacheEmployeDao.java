package com.microserviceTacheEmploye.dao;

import com.microserviceTacheEmploye.model.TacheEmploye;
import com.microserviceTacheEmploye.model.TacheEmployeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TacheEmployeDao extends JpaRepository<TacheEmploye, TacheEmployeKey>{
    Optional<TacheEmploye> findById_IdTacheAndId_IdEmploye(int idTache, int idEmploye);
    List<TacheEmploye> findAllByTache_Etat(String etat);

    int countTacheEmployeByValideEquals(String valide);
}
