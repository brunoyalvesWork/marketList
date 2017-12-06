package com.sato.bruno.marketlist.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.sato.bruno.marketlist.R;
import com.sato.bruno.marketlist.utilities.Preferencias;

public class PrincipalActivity extends AppCompatActivity {

    private Preferencias preferencias;
    private boolean btBackPressed = false;

    private TextView tx1;
    private TextView tx2;
    private TextView tx3;
    private TextView tx4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        preferencias = new Preferencias(PrincipalActivity.this);

        tx1 = findViewById(R.id.textView3);
        tx2 = findViewById(R.id.textView4);
        tx3 = findViewById(R.id.textView5);
        tx4 = findViewById(R.id.textView6);

        tx1.setText(preferencias.getIdUsuarioLogado());
        tx2.setText(preferencias.getEmailUsuarioLogado());
        tx3.setText(preferencias.getNomeUsuarioLogado());
        tx4.setText(preferencias.getEstadoLogin().toString());

    }

    @Override
    public void onBackPressed() {
        if (btBackPressed) {
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Se deseja realmente fechar o aplicativo, clique novamente no botão voltar.", Toast.LENGTH_SHORT).show();
            btBackPressed = true;
        }
    }
}
