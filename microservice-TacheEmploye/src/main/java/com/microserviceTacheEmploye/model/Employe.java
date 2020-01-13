package com.microserviceTacheEmploye.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "validation"})
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String prenom;

    private String nom;

    private String tele;

    private String email;

    private String civilite;

    private Date date_embauche;

    private String status_employe;

    private int idService;

    private String username;

    @JsonIgnore
    @OneToMany(mappedBy = "employe")
    @JsonProperty("validation")
    Set<TacheEmploye> validation;


    public Employe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public Date getDate_embauche() {
        return date_embauche;
    }

    public void setDate_embauche(Date date_embauche) {
        this.date_embauche = date_embauche;
    }

    public String getStatus_employe() {
        return status_employe;
    }

    public void setStatus_employe(String status_employe) {
        this.status_employe = status_employe;
    }

    public Set<TacheEmploye> getValidation() {
        return validation;
    }

    public void setValidation(Set<TacheEmploye> validation) {
        this.validation = validation;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", tele='" + tele + '\'' +
                ", email='" + email + '\'' +
                ", civilite='" + civilite + '\'' +
                ", date_embauche=" + date_embauche +
                ", status_employe='" + status_employe + '\'' +
                ", idService=" + idService +
                ", validation=" + validation +
                ", username=" + username +
                '}';
    }
}
