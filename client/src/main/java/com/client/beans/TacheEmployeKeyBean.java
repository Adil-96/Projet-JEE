package com.client.beans;

import javax.persistence.Column;

public class TacheEmployeKeyBean {
    int idTache;

    int idEmploye;

    public TacheEmployeKeyBean() {
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
    public String toString() {
        return "TacheEmployeKeyBean{" +
                "idTache=" + idTache +
                ", idEmploye=" + idEmploye +
                '}';
    }
}
