package com.example.listaplaneta;

import android.graphics.Bitmap;

public class Planet {
    private String name;
    private Bitmap image;

    public Planet(String name, Bitmap image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public Bitmap getImage() {
        return image;
    }
}
