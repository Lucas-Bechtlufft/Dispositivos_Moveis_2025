package com.example.random_number;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class Sorteio extends AppCompatActivity {

    private EditText edtMinNum;
    private EditText edtMaxNum;
    private Button btnSortear;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorteio);

        edtMinNum = findViewById(R.id.edtMinNum);
        edtMaxNum = findViewById(R.id.edtMaxNum);
        btnSortear = findViewById(R.id.btnSortear);
        txtResultado = findViewById(R.id.txtResultado);

        btnSortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sorteioNumeros();
            }
        });
    }

    private void sorteioNumeros() {
        String minNumberStr = edtMinNum.getText().toString();
        String maxNumberStr = edtMaxNum.getText().toString();

        if (minNumberStr.isEmpty() || maxNumberStr.isEmpty()) {
            txtResultado.setText("Informe um intervalo válido.");
            return;
        }

        int minNumber = Integer.parseInt(minNumberStr);
        int maxNumber = Integer.parseInt(maxNumberStr);

        if (minNumber >= maxNumber) {
            txtResultado.setText("O valor mínimo deve ser menor que o valor máximo.");
            return;
        }

        Random random = new Random();
        int resultado = random.nextInt((maxNumber - minNumber) + 1) + minNumber;

        txtResultado.setText("Número sorteado: " + resultado);
    }
}