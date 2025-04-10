package com.example.layouts;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityTelaProgramatica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Instanciando o LinearLayout com orientação vertical e centralização
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);

        // Definindo LayoutParams para o layout
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        layout.setLayoutParams(params);

        // Criando TextView
        TextView textView = new TextView(this);
        textView.setText("Olá Mundo");

        // Criando Button
        Button botao = new Button(this);
        botao.setText("click aqui");

        // Evento de clique
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityTelaProgramatica.this, "Botão clicado!", Toast.LENGTH_SHORT).show();
            }
        });

        // Adicionando Views ao layout
        layout.addView(textView);
        layout.addView(botao);

        // Definindo o layout como conteúdo da tela
        setContentView(layout);
    }
}