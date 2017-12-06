package com.sato.bruno.marketlist.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.sato.bruno.marketlist.R;
import com.sato.bruno.marketlist.db.ConfiguracaoFirebase;
import com.sato.bruno.marketlist.utilities.Preferencias;

public class PrincipalActivity extends AppCompatActivity {

    private Preferencias preferencias;
    private FirebaseAuth firebaseAuth;
    private boolean btBackPressed = false;

    private TextView tx1;
    private TextView tx2;
    private TextView tx3;
    private TextView tx4;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        preferencias = new Preferencias(PrincipalActivity.this);
        firebaseAuth = ConfiguracaoFirebase.getFirebaseAuth();

        tx1 = findViewById(R.id.textView3);
        tx2 = findViewById(R.id.textView4);
        tx3 = findViewById(R.id.textView5);
        tx4 = findViewById(R.id.textView6);
        btn = findViewById(R.id.button2);

        tx1.setText(preferencias.getIdUsuarioLogado());
        tx2.setText(preferencias.getEmailUsuarioLogado());
        tx3.setText(preferencias.getNomeUsuarioLogado());
        tx4.setText(preferencias.getEstadoLogin().toString());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                preferencias.removeEstadoLogin();
                startActivity(new Intent(PrincipalActivity.this, MainActivity.class));
                finish();
            }
        });

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
