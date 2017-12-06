package com.sato.bruno.marketlist.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sato.bruno.marketlist.R;
import com.sato.bruno.marketlist.utilities.Preferencias;

public class MainActivity extends AppCompatActivity {

    private Button btIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Preferencias preferencias = new Preferencias(MainActivity.this);
        if (preferencias.getEstadoLogin()) {
            startActivity(new Intent(MainActivity.this, PrincipalActivity.class));
            finish();
        }

        setContentView(R.layout.activity_main);

        btIniciar = findViewById(R.id.bt_iniciar);
        btIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CadastroActivity.class));
            }
        });
    }
}
