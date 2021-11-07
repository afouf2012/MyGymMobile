package com.example.fitnessapp.entities;

public class Exercice {
    private String Nom ;
    private  int image1 ;
    private  int image2 ;
    private  String description ;

    public Exercice(String nom, int image1, int image2, String description) {
        Nom = nom;
        this.image1 = image1;
        this.image2 = image2;
        this.description = description;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public int getImage2() {
        return image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Exercice{" +
                "Nom='" + Nom + '\'' +
                ", image1=" + image1 +
                ", image2=" + image2 +
                ", description='" + description + '\'' +
                '}';
    }
}
