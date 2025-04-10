package com.example.layouts;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityLinearLayout extends AppCompatActivity {

    EditText nome, email;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        nome = findViewById(R.id.editNome);
        email = findViewById(R.id.editEmail);
        radioGroup = findViewById(R.id.radioGroup);
        Button btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idSelecionado = radioGroup.getCheckedRadioButtonId();
                RadioButton radioSelecionado = findViewById(idSelecionado);

                String mensagem = "Nome: " + nome.getText().toString()
                        + "\nEmail: " + email.getText().toString()
                        + "\nCurso: " + radioSelecionado.getText();

                Toast.makeText(ActivityLinearLayout.this, mensagem, Toast.LENGTH_LONG).show();
            }
        });
    }
}
