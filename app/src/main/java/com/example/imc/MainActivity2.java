package com.example.imc;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView txtResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtResultado = findViewById(R.id.txtResultado);
        String message = getIntent().getStringExtra("EXTRA_MESSAGE");
        if(!message.isEmpty()){
            txtResultado.setText(message);
            return;
        }

    }
}