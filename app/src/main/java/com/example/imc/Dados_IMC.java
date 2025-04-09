package com.example.imc;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Dados_IMC extends AppCompatActivity {

    private TextView txtResultadoNome;
    private TextView txtResultadoIdade;
    private TextView txtResultadoPeso;
    private TextView txtResultadoAltura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_imc);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("NOME");
        int idade = intent.getIntExtra("IDADE", 0);
        float altura = intent.getFloatExtra("ALTURA", 0)/100;
        float peso = intent.getFloatExtra("PESO", 0);

        txtResultadoNome = findViewById(R.id.txtResultadoNome);
        txtResultadoIdade = findViewById(R.id.txtResultadoIdade);
        txtResultadoPeso = findViewById(R.id.txtResultadoPeso);
        txtResultadoAltura = findViewById(R.id.txtResultadoAltura);
        TextView txtResultadoIMC = findViewById(R.id.txtResultadoIMC);


        float imc = peso/ (altura * altura);

        String resultado = "";

        if (imc < 18.5) {
            resultado = "Abaixo do peso";
        } else if (imc < 24.9) {
            resultado = "Peso normal";
        } else if (imc < 29.9) {
            resultado = "Sobrepeso";
        } else if (imc < 34.9) {
            resultado = "Obesidade grau 1";
        } else if (imc < 39.9) {
            resultado = "Obesidade grau 2";
        } else {
            resultado = "Obesidade grau 3";
        }

        txtResultadoNome.setText("Nome: " + nome);
        txtResultadoIdade.setText("Idade: " + idade);
        txtResultadoPeso.setText("Peso: " + peso);
        txtResultadoAltura.setText("Altura: " + altura);
        txtResultadoIMC.setText("IMC: " + imc + " - " + resultado);


    }


}