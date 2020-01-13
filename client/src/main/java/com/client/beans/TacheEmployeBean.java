package com.client.beans;


public class TacheEmployeBean {
    TacheEmployeKeyBean id;

    TacheBean tache;

    EmployeBean employe;

    private String valide;

    private String etatChef;

    public TacheEmployeBean() {
    }


    public TacheEmployeKeyBean getId() {
        return id;
    }

    public void setId(TacheEmployeKeyBean id) {
        this.id = id;
    }

    public TacheBean getTache() {
        return tache;
    }

    public void setTache(TacheBean tache) {
        this.tache = tache;
    }

    public EmployeBean getEmploye() {
        return employe;
    }

    public void setEmploye(EmployeBean employe) {
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
        return "TacheEmployeBean{" +
                "id=" + id +
                ", tache=" + tache +
                ", employe=" + employe +
                ", valide='" + valide + '\'' +
                ", etatChef='" + etatChef + '\'' +
                '}';
    }

}
