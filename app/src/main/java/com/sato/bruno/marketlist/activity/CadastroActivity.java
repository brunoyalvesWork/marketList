package com.sato.bruno.marketlist.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.sato.bruno.marketlist.R;

public class CadastroActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView txLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        toolbar = findViewById(R.id.tb_cadastro_usuario);
        txLogin = findViewById(R.id.tx_login);

        toolbar.setTitle("Cadadatro");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        setSupportActionBar(toolbar);

        txLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CadastroActivity.this, LoginActivity.class));
            }
        });
    }
}
