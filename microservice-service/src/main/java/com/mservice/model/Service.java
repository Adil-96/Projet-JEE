package com.mservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String libelle_service;

    private String status_service;

    public Service() {
    }

    public Service(String libelle_service, String status_service) {
        this.libelle_service = libelle_service;
        this.status_service = status_service;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle_service() {
        return libelle_service;
    }

    public void setLibelle_service(String libelle_service) {
        this.libelle_service = libelle_service;
    }

    public String getStatus_service() {
        return status_service;
    }

    public void setStatus_service(String status_service) {
        this.status_service = status_service;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", libelle_service='" + libelle_service + '\'' +
                ", status_service='" + status_service + '\'' +
                '}';
    }
}
