package com.example.imc;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class IMC_Inputs extends AppCompatActivity {

    private EditText nome;

    private EditText idade;

    private EditText altura;

    private EditText peso;

    private Button btnImcDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc_inputs);

        nome = findViewById(R.id.nome);
        idade = findViewById(R.id.idade);
        altura = findViewById(R.id.altura);
        peso = findViewById(R.id.peso);
        btnImcDados = findViewById(R.id.btnImcDados);


        btnImcDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {EnviaDadosImc();}
        });
    }

    private void EnviaDadosImc() {
        String nomeValue = nome.getText().toString();
        String idadeStr = idade.getText().toString();
        String alturaStr = altura.getText().toString();
        String pesoStr = peso.getText().toString();


        if (nomeValue.isEmpty() || idadeStr.isEmpty() || alturaStr.isEmpty() ||     pesoStr.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }



        try {
            int idadeValue = Integer.parseInt(idade.getText().toString());
            float alturaValue = Float.parseFloat(altura.getText().toString());
            float pesoValue = Float.parseFloat(peso.getText().toString());

            if (nomeValue.length() < 3 || verificarApenasLetras(nomeValue) == false) {
                Toast.makeText(this, "Por favor, preencha um nome existente", Toast.LENGTH_SHORT).show();
                return;
            }


            if(idadeValue > 125 || idadeValue == 0){
                Toast.makeText(this, "Por favor, insira uma idade realista", Toast.LENGTH_SHORT).show();
                return;
            }
            if(pesoValue > 300 || pesoValue == 0){
                Toast.makeText(this, "Por favor, insira um peso realista", Toast.LENGTH_SHORT).show();
                return;
            }
            if(alturaValue > 290 || alturaValue < 20){
                Toast.makeText(this, "Por favor, insira uma altura realista", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(this, Dados_IMC.class);

            intent.putExtra("NOME", nomeValue);
            intent.putExtra("IDADE", idadeValue);
            intent.putExtra("ALTURA", alturaValue);
            intent.putExtra("PESO", pesoValue);

            startActivity(intent);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Valores inválidos para nome, idade, altura ou peso", Toast.LENGTH_SHORT).show();

        }
    }

    public static boolean verificarApenasLetras(String str) {
        return str.matches("[a-zA-Z]+");
    }
}