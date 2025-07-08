package com.example.sqlite;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    NotaDAO notaDAO;  // ✅ Usando o DAO
    Button buttonInsere;
    EditText editText;
    ListView listView;
    ArrayList<Nota> notas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonInsere = findViewById(R.id.buttonInsere);
        editText = findViewById(R.id.edText);
        listView = findViewById(R.id.listView);

        notaDAO = new NotaDAO(this);  // ✅ Inicializando o DAO

        buttonInsere.setOnClickListener(v -> {
            notaDAO.insereNota(editText.getText().toString());
            carregaNota();
        });

        listView.setOnItemLongClickListener((adapterView, view, i, l) -> {
            Nota n = (Nota) adapterView.getItemAtPosition(i);
            notaDAO.deleteNota(n.id);
            Toast.makeText(getApplicationContext(), Integer.toString(n.id), Toast.LENGTH_LONG).show();
            carregaNota();
            return true;
        });

        carregaNota();
    }

    public void carregaNota() {
        notas = notaDAO.getNotas();  // ✅ Pegando as notas do DAO
        AdapterNota adapter = new AdapterNota(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                notas);
        listView.setAdapter(adapter);
    }
}
