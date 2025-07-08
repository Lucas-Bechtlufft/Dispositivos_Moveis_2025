package com.example.listaplaneta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class PlanetAdapter extends ArrayAdapter<Planet> {
    private final LayoutInflater inflater;

    public PlanetAdapter(@NonNull Context context, List<Planet> planets) {
        super(context, 0, planets);
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Planet planet = getItem(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageViewPlanet);
        TextView textView = convertView.findViewById(R.id.textViewPlanet);

        textView.setText(planet.getName());
        imageView.setImageBitmap(planet.getImage());

        return convertView;
    }
}
