package com.miprojet.dao;

import com.miprojet.model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

@Repository
public interface ProjetDao extends JpaRepository<Projet,Integer> {
    List<Projet> findAllByIdService(int idService);

    @Query("SELECT SUM(p.budget) FROM Projet p")
    Double totalBudget();

    @Query("Select p.idService, SUM(p.budget) from Projet p GROUP BY p.idService")
    List<List<Object>> serviceBudget();
}
