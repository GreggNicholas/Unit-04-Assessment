package com.example.unit_04_assessment.Model;

public class EchinodermModel {

    private String animal;
    private String image;
    private String wiki;

    public EchinodermModel(String animal, String image, String wiki) {
        this.animal = animal;
        this.image = image;
        this.wiki = wiki;
    }


    public String getAnimal() {
        return animal;
    }

    public String getImage() {
        return image;
    }

    public String getWiki() {
        return wiki;
    }
}
