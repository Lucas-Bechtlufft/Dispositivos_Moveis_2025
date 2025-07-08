package com.example.listaplaneta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Planet> planetList = new ArrayList<>();
    private PlanetAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

        unzipAndLoadPlanets();

        adapter = new PlanetAdapter(this, planetList);
        listView.setAdapter(adapter);
    }

    private void unzipAndLoadPlanets() {
        try {
            InputStream is = getAssets().open("planetas.zip");
            ZipInputStream zis = new ZipInputStream(is);
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                String fileName = entry.getName();
                if (fileName.endsWith(".png") || fileName.endsWith(".jpg")) {
                    Bitmap bmp = BitmapFactory.decodeStream(zis);
                    String planetName = fileName.substring(0, fileName.lastIndexOf('.'));
                    planetList.add(new Planet(planetName, bmp));
                }
                zis.closeEntry();
            }

            zis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
