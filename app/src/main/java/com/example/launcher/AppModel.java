package com.example.launcher;

import android.graphics.drawable.Drawable;

public class AppModel {
    String label;
    String packageName;
    Drawable icon;

    public AppModel(String label, String packageName, Drawable icon) {
        this.label = label;
        this.packageName = packageName;
        this.icon = icon;
    }
}
