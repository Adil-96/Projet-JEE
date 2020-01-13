package com.microserviceTacheEmploye.dao;

import com.microserviceTacheEmploye.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeDao extends JpaRepository<Employe,Integer> {
    List<Employe> findAllByIdService(int idService);
    Optional<Employe> findByUsername(String username);
}
