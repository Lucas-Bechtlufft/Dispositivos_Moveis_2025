package com.example.imc;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button logButton;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logButton = findViewById(R.id.logButton);
        txtResultado = findViewById(R.id.txtResultado);


        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chamaLog(new LogCallback() {
                    @Override
                    public void onLog(String mensagem) {
                        txtResultado.setText(mensagem);
                    }
                });
            }
        });
    }
    public void goToAnotherPage(View view) {
        // Replace "AnotherActivity" with the actual name of your destination activity
        Intent intent = new Intent(this, MainActivity2.class);
        String message = "Eu vim da primeira tela";
        intent.putExtra("EXTRA_MESSAGE", message);//passando o valor da variavel no obj com o identificador como a chave extra_message


        startActivity(intent);
    }

    public void irParaIMC(View view){

        Intent intent = new Intent(this, IMC_Inputs.class);
        startActivity(intent);
    }



    private void chamaLog(LogCallback callback) {
        String mensagem = "Mensagem Modificavel";

        Log.d("MainActivity", mensagem);

        callback.onLog(mensagem);
    }

    public interface LogCallback {
        void onLog(String mensagem);
    }
}