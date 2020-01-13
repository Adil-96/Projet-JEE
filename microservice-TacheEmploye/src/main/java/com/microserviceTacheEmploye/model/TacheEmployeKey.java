package com.microserviceTacheEmploye.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TacheEmployeKey implements Serializable {
    @Column(name = "id_tache")
    int idTache;

    @Column(name = "id_employe")
    int idEmploye;

    public TacheEmployeKey() {
    }


    public int getIdTache() {
        return idTache;
    }

    public void setIdTache(int idTache) {
        this.idTache = idTache;
    }

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TacheEmployeKey that = (TacheEmployeKey) o;
        return idTache == that.idTache &&
                idEmploye == that.idEmploye;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTache, idEmploye);
    }
}
