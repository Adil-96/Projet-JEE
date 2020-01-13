package com.microserviceTacheEmploye.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class TacheEmploye {
    @EmbeddedId
    TacheEmployeKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_tache")
    @JoinColumn(name = "id_tache")
    Tache tache;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_employe")
    @JoinColumn(name = "id_employe")
    Employe employe;

    private String valide;

    private String etatChef;


    public TacheEmploye() {
    }


    public TacheEmploye(Tache tache, Employe employe, String valide,String etatChef) {
        this.employe = employe;
        this.tache = tache;
        this.valide = valide;
        this.etatChef = etatChef;
    }

    public TacheEmployeKey getId() {
        return id;
    }

    public void setId(TacheEmployeKey id) {
        this.id = id;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public String getValide() {
        return valide;
    }

    public void setValide(String valide) {
        this.valide = valide;
    }

    public String getEtatChef() {
        return etatChef;
    }

    public void setEtatChef(String etatChef) {
        this.etatChef = etatChef;
    }

    @Override
    public String toString() {
        return "TacheEmploye{" +
                "id=" + id +
                ", valide='" + valide + '\'' +
                ", etatChef='" + etatChef + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TacheEmploye that = (TacheEmploye) o;
        return Objects.equals(tache, that.tache) &&
                Objects.equals(employe, that.employe) &&
                Objects.equals(valide, that.valide)&&
                Objects.equals(etatChef, that.etatChef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tache, employe, valide, etatChef);
    }
}
