package com.sato.bruno.marketlist.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sato.bruno.marketlist.R;
import com.sato.bruno.marketlist.utilities.Preferencias;

public class PerfilActivity extends AppCompatActivity {

    private Preferencias preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        preferencias = new Preferencias(PerfilActivity.this);

        Toolbar toolbar = findViewById(R.id.tb_perfil);
        toolbar.setTitle("Perfil");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        setSupportActionBar(toolbar);

        final EditText nomeUsuario = findViewById(R.id.ed_perfil_nome);
        final EditText emailUsuario = findViewById(R.id.ed_perfil_email);
        Button salvar = findViewById(R.id.bt_salva_perfil);

        nomeUsuario.setText(preferencias.getNomeUsuarioLogado());
        emailUsuario.setText(preferencias.getEmailUsuarioLogado());

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!nomeUsuario.getText().toString().isEmpty() && !emailUsuario.getText().toString().isEmpty()){
                    if (android.util.Patterns.EMAIL_ADDRESS.matcher(emailUsuario.getText().toString()).matches()) {
                        preferencias.salvaNomeUsuario(nomeUsuario.getText().toString());
                        preferencias.salvaEmailUsuario(emailUsuario.getText().toString());
                        Toast.makeText(PerfilActivity.this, "Dados salvos com sucesso", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        emailUsuario.setError("E-mail inválido");
                    }
                } else {
                    nomeUsuario.setError("Campo obrigatório");
                    emailUsuario.setError("Campo obrigatório");
                }
            }
        });
    }
}
