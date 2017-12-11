package com.sato.bruno.marketlist.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.sato.bruno.marketlist.R;
import com.sato.bruno.marketlist.model.dao.ListaDAO;
import com.sato.bruno.marketlist.utilities.Preferencias;

import java.util.UUID;

public class CriarListaActivity extends AppCompatActivity {

    private Preferencias preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_lista);

        Toolbar toolbar = findViewById(R.id.tb_criar_lista);
        toolbar.setTitle("Criar lista");
        setSupportActionBar(toolbar);

        final EditText nomeLista = findViewById(R.id.ed_criar_lista);
        Button btnSalvar = findViewById(R.id.bt_salvar_lista);

        preferencias = new Preferencias(CriarListaActivity.this);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!nomeLista.getText().toString().isEmpty()){
                    ListaDAO listaDAO = new ListaDAO(CriarListaActivity.this);
                    UUID uuid = UUID.randomUUID();
                    String myRandom = uuid.toString();
                    listaDAO.salvar(nomeLista.getText().toString(), myRandom);
                    preferencias.adicionaListaSelecionada(nomeLista.getText().toString());
                    startActivity(new Intent(CriarListaActivity.this, PrincipalActivity.class));
                    finish();
                } else {
                    nomeLista.setError("Campo obrigatório!");
                }
            }
        });
    }
}
