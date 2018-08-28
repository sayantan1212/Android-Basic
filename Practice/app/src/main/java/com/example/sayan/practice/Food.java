package com.example.sayan.practice;

public class Food {
    private String name;
    private String description;
    private int imageID;

    public static final Food[] foods = {
            new Food("Pizza","Thin crust pizza with extra cheese",R.drawable.pizzaone),
            new Food("Burger","veg burger with healthy stuff",R.drawable.burgerone),
            new Food("Sandwitch","whole wheat sandwitch",R.drawable.breadone),
    };

    public Food(String name, String description, int imageID) {
        this.name = name;
        this.description = description;
        this.imageID = imageID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageID() {
        return imageID;
    }

    public String toString() {
        return this.name;
    }
}
