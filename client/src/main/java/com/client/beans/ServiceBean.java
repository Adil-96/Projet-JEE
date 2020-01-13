package com.client.beans;

public class ServiceBean {
    private int id;

    private String libelle_service;

    private String status_service;

    public ServiceBean() {
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
        return "ServiceBean{" +
                "id=" + id +
                ", libelle_service='" + libelle_service + '\'' +
                ", status_service='" + status_service + '\'' +
                '}';
    }
}
