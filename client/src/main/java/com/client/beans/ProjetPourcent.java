package com.client.beans;

public class ProjetPourcent {

    private ProjetBean projet;
    private int pouncent;

    public ProjetPourcent(ProjetBean projet, int pouncent) {
        this.projet = projet;
        this.pouncent = pouncent;
    }

    public ProjetBean getProjet() {
        return projet;
    }

    public void setProjet(ProjetBean projet) {
        this.projet = projet;
    }

    public int getPouncent() {
        return pouncent;
    }

    public void setPouncent(int pouncent) {
        this.pouncent = pouncent;
    }

    @Override
    public String toString() {
        return "ProjetPourcent{" +
                "projet=" + projet +
                ", pouncent=" + pouncent +
                '}';
    }
}
