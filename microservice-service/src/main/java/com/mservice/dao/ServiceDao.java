package com.mservice.dao;

import com.mservice.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceDao extends JpaRepository<Service,Integer> {

    @Query("Select s from Service s where s.status_service = :x")
    List<Service> rechercherAllByStatus(@Param("x") String status);
}
