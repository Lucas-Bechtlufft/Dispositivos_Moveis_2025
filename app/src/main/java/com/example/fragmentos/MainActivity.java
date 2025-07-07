package com.example.fragmentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Fragmento_A fragmentA = new Fragmento_A();
    private Fragmento_B fragmentB = new Fragmento_B();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trocaFragmento(fragmentA);
    }

    private void trocaFragmento(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit();
    }

    public void abreFragmentoB(String message) {
        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        fragmentB.setArguments(bundle);
        trocaFragmento(fragmentB);
    }
}
