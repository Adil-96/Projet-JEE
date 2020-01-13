package com.client.beans;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ProjetBean {
    private int id;

    private String nom;

    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_debut;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_fin;

    private double budget;

    private String status_projet;

    private int idService;

    public ProjetBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getStatus_projet() {
        return status_projet;
    }

    public void setStatus_projet(String status_projet) {
        this.status_projet = status_projet;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    @Override
    public String toString() {
        return "ProjetBean{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                ", budget=" + budget +
                ", status_projet='" + status_projet + '\'' +
                ", idService=" + idService +
                '}';
    }
}
