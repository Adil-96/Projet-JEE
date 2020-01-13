package com.microserviceTacheEmploye.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "validation"})
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;

    private String contenu;

    private Date date_finale_realisation;

    private int duree;

    private String etat;

    private String commentaire;

    private int idProjet;

    @OneToMany(mappedBy = "tache")
    @JsonProperty("validation")
    Set<TacheEmploye> validation;


    public Tache() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDate_finale_realisation() {
        return date_finale_realisation;
    }

    public void setDate_finale_realisation(Date date_finale_realisation) {
        this.date_finale_realisation = date_finale_realisation;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Set<TacheEmploye> getValidation() {
        return validation;
    }

    public void setValidation(Set<TacheEmploye> validation) {
        this.validation = validation;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    @Override
    public String toString() {
        return "Tache{" +
                "numero=" + numero +
                ", contenu='" + contenu + '\'' +
                ", date_finale_realisation=" + date_finale_realisation +
                ", duree=" + duree +
                ", etat='" + etat + '\'' +
                ", commentaire='" + commentaire + '\'' +
                ", idProjet=" + idProjet +
                ", validation=" + validation +
                '}';
    }
}
