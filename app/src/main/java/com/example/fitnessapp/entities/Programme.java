package com.example.fitnessapp.entities;

public class Programme {



    private String categorie;
    private String description;
    private int image;

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Programme(String categorie, String description, int image) {
        this.categorie = categorie;
        this.description = description;
        this.image = image;
    }


    @Override
    public String toString() {
        return "Programme{" +
                "categorie='" + categorie + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                '}';
    }
}


