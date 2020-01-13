package com.client.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

public class TacheBean {
    private int numero;

    private String contenu;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_finale_realisation;

    private int duree;

    private String etat;

    private String commentaire;

    private int idProjet;

    @JsonProperty("validation")
    Set<TacheEmployeBean> validation;

    public TacheBean() {
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

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public Set<TacheEmployeBean> getValidation() {
        return validation;
    }

    public void setValidation(Set<TacheEmployeBean> validation) {
        this.validation = validation;
    }

    @Override
    public String toString() {
        return "TacheBean{" +
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
