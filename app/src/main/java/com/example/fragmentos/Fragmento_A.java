package com.example.fragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Fragmento_A extends Fragment {

    public Fragmento_A() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewFragA = inflater.inflate(R.layout.fragment_a, container, false);
        Button buttonEnviar = viewFragA.findViewById(R.id.enviarButton);
        EditText editTextMessage = viewFragA.findViewById(R.id.messageTextBox);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editTextMessage.getText().toString();
                if (!message.isEmpty()) {
                    ((MainActivity) requireActivity()).abreFragmentoB(message);
                } else {
                    // Exibe uma mensagem de erro usando um Toast
                    Toast.makeText(requireContext(), "Por favor, preencha o campo de mensagem.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return viewFragA;
    }
}
