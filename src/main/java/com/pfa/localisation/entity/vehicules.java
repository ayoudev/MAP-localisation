package com.pfa.localisation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class vehicules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private float prix;
    private String image;

private boolean disponible;

    public vehicules(int id, String nom, float p, String image, boolean disponible) {
        this.id = id;
        this.nom = nom;
        this.prix = p;
        this.image = image;
        this.disponible=disponible;
    }

    public vehicules(int id, String nom, float p) {
        this.id = id;
        this.nom = nom;
        this.prix = p;
    }

    public vehicules() {

    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(float p) {
        this.prix = p;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
