package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private int selectedPosition = -1; // Variável para armazenar a posição do item selecionado na lista
    private ArrayList<String> tasks;
    private ArrayAdapter<String> adapter;
    private EditText textInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referências aos elementos da interface do usuário
        Button okButton = findViewById(R.id.okButton);
        Button deleteButton = findViewById(R.id.deleteButton);
        ListView taskList = findViewById(R.id.taskList);
        textInput = findViewById(R.id.textInput);

        // Criação de uma lista de tarefas e um adaptador para preencher a ListView
        tasks = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_selectable_list_item,
                android.R.id.text1,
                tasks
        );

        // Configura o ouvinte de clique para a ListView
        taskList.setOnItemClickListener(this);
        taskList.setAdapter(adapter);

        // Configura o botão "OK" para adicionar tarefas à lista
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String task = textInput.getText().toString();
                if (!task.isEmpty()) {
                    tasks.add(task); // Adiciona a tarefa à lista
                    adapter.notifyDataSetChanged(); // Notifica o adaptador sobre a mudança
                    textInput.setText(""); // Limpa o campo de entrada
                } else {
                    // Exibir mensagem de erro se a entrada estiver vazia
                    showErrorDialog("O texto não pode estar vazio.");
                }
            }
        });

        // Configura o botão "Delete" para excluir a tarefa selecionada
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedPosition >= 0 && selectedPosition < tasks.size()) {
                    // Cria um diálogo de confirmação para excluir a tarefa
                    showDeleteConfirmationDialog();
                }
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        selectedPosition = i; // Armazena a posição do item selecionado na lista
    }

    // Exibe um diálogo de confirmação para excluir a tarefa
    private void showDeleteConfirmationDialog() {
        AlertDialog.Builder ab = new AlertDialog.Builder(this);
        ab.setTitle("Delete");
        ab.setMessage("Excluir item " + (selectedPosition + 1) + "?");
        ab.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tasks.remove(selectedPosition); // Remove a tarefa da lista
                adapter.notifyDataSetChanged(); // Notifica o adaptador sobre a mudança
                selectedPosition = -1; // Reseta a posição
            }
        });
        ab.setNegativeButton("Não", null);
        ab.show();
    }

    // Exibe um diálogo de erro com a mensagem fornecida
    private void showErrorDialog(String message) {
        AlertDialog.Builder ab = new AlertDialog.Builder(this);
        ab.setTitle("Erro");
        ab.setMessage(message);
        ab.setPositiveButton("OK", null);
        ab.show();
    }
}
