package com.example.paint;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

public class MainActivity extends AppCompatActivity {

    SimplePaint simplePaint;
    ImageView imgColorPicker;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simplePaint = findViewById(R.id.simplePaint);
        imgColorPicker = findViewById(R.id.imgColorPicker);
        imgColorPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorPickerSelectColor();
            }
        });
    }

    public void colorPickerSelectColor(){
        new ColorPickerDialog.Builder(this)
                .setTitle("ColorPicker Dialog")
                .setPreferenceName("MyColorPickerDialog")
                .setPositiveButton(getString(R.string.confirm),
                        new ColorEnvelopeListener() {
                            @Override
                            public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                                setColor(envelope);
                            }
                        })
                .setNegativeButton(getString(R.string.cancel),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                .attachAlphaSlideBar(true) // the default value is true.
                .attachBrightnessSlideBar(true)  // the default value is true.
                .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
                .show();
    }

    private void setColor(ColorEnvelope envelope) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            simplePaint.setColor(Color.valueOf(envelope.getColor()));
            imgColorPicker.setColorFilter(Color.valueOf(envelope.getColor()).toArgb());
        }
    }
}