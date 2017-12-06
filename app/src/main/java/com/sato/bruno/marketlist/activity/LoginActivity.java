package com.sato.bruno.marketlist.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sato.bruno.marketlist.R;
import com.sato.bruno.marketlist.db.ConfiguracaoFirebase;
import com.sato.bruno.marketlist.utilities.Preferencias;
import com.sato.bruno.marketlist.utilities.VerificaConexao;

public class LoginActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText email;
    private EditText senha;
    private Button entrar;
    private ConnectivityManager connectionManager;
    private FirebaseAuth firebaseAuth;
    private Preferencias preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        connectionManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        firebaseAuth = ConfiguracaoFirebase.getFirebaseAuth();
        preferencias = new Preferencias(LoginActivity.this);

        toolbar = findViewById(R.id.tb_login);
        email = findViewById(R.id.ed_login_email);
        senha = findViewById(R.id.ed_login_senha);
        entrar = findViewById(R.id.bt_entrar_login);

        toolbar.setTitle("Login");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        setSupportActionBar(toolbar);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (VerificaConexao.isConectado(connectionManager)) {
                    if (validaCampos()) {
                        validarLogin(email.getText().toString(), senha.getText().toString());
                    } else {
                        Toast.makeText(getApplicationContext(), "Verifique se todos os campos obrigatórios estão preenchidos", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "É necessário estar conectado a internet para logar no aplicativo.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validaCampos() {
        boolean cadastrar = true;

        if (email.getText().toString().isEmpty()) {
            email.setError("Campo obrigatório");
            cadastrar = false;
        }
        if (senha.getText().toString().isEmpty()) {
            senha.setError("Campo obrigatório");
            cadastrar = false;
        }
        return cadastrar;
    }

    private void validarLogin(String email, String senha) {
        firebaseAuth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            preferencias.salvaIdUsuario(user.getUid());
                            preferencias.salvaNomeUsuario(user.getDisplayName());
                            preferencias.salvaEmailUsuario(user.getEmail());
                            preferencias.salvaEstadoLogin();
                            startActivity(new Intent(LoginActivity.this, PrincipalActivity.class));
                            finish();
                        } else {
                            String erro;
                            try {
                                throw task.getException();
                            } catch(Exception e) {
                                erro = "Dados inválidos, tente novamente";
                                e.printStackTrace();
                            }
                            Toast.makeText(getApplicationContext(), erro, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
