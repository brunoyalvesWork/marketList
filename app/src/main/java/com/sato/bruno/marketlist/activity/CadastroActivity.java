package com.sato.bruno.marketlist.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.sato.bruno.marketlist.R;
import com.sato.bruno.marketlist.db.ConfiguracaoFirebase;
import com.sato.bruno.marketlist.utilities.DialogHelper;
import com.sato.bruno.marketlist.utilities.Preferencias;
import com.sato.bruno.marketlist.utilities.VerificaConexao;

public class CadastroActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView txLogin;
    private Button btCadastro;
    private EditText nome;
    private EditText email;
    private EditText senha;
    private FirebaseAuth firebaseAuth;
    private ConnectivityManager connectionManager;
    private Preferencias preferencias;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        firebaseAuth = ConfiguracaoFirebase.getFirebaseAuth();
        preferencias = new Preferencias(CadastroActivity.this);

        toolbar = findViewById(R.id.tb_cadastro_usuario);
        txLogin = findViewById(R.id.tx_login);
        btCadastro = findViewById(R.id.bt_cadastro_usuario);
        nome = findViewById(R.id.ed_cadastro_nome);
        email = findViewById(R.id.ed_cadastro_email);
        senha = findViewById(R.id.ed_cadastro_senha);
        connectionManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        toolbar.setTitle("Cadastro");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        setSupportActionBar(toolbar);

        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (VerificaConexao.isConectado(connectionManager)) {
                    if(validaCampos()) {
                        DialogHelper.dialogLoading(CadastroActivity.this);
                        cadastrarUsuario(nome.getText().toString(), email.getText().toString(), senha.getText().toString());
                    } else {
                        Toast.makeText(getApplicationContext(), "Verifique se todos os campos obrigatórios estão preenchidos", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "É necessário estar conectado a internet para se cadastrar no aplicativo.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        txLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CadastroActivity.this, LoginActivity.class));
                finish();
            }
        });
    }

    private boolean validaCampos() {
        boolean cadastrar = true;

        if (nome.getText().toString().isEmpty()) {
            nome.setError("Campo obrigatório");
            cadastrar = false;
        }
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

    private void cadastrarUsuario(final String nome, final String email, String senha) {

        this.nome.setText("");
        this.email.setText("");
        this.senha.setText("");

        firebaseAuth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            final FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

                            UserProfileChangeRequest profileUdates = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(nome)
                                    .build();
                            firebaseUser.updateProfile(profileUdates)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                preferencias.salvaIdUsuario(firebaseUser.getUid());
                                                preferencias.salvaNomeUsuario(firebaseUser.getDisplayName());
                                                preferencias.salvaEmailUsuario(firebaseUser.getEmail());
                                                preferencias.salvaEstadoLogin();
                                                Toast.makeText(getApplicationContext(), "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                                                startActivity(new Intent(CadastroActivity.this, PrincipalActivity.class));
                                                finish();
                                            } else {
                                                String erroExcessao;
                                                try {
                                                    throw task.getException();
                                                } catch (FirebaseAuthWeakPasswordException e) {
                                                    erroExcessao = "Digite uma senha com no mínimo 6 caracteres!";
                                                } catch (FirebaseAuthInvalidCredentialsException e) {
                                                    erroExcessao = "O e-mail digitado é inválido!";
                                                } catch (FirebaseAuthUserCollisionException e) {
                                                    erroExcessao = "Já existe uma conta com esse e-mail!";
                                                } catch (Exception e) {
                                                    erroExcessao = "Erro ao efetuar cadastro!";
                                                    e.printStackTrace();
                                                }
                                                Toast.makeText(CadastroActivity.this, erroExcessao, Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                        } else {

                        }
                        DialogHelper.removeDialogLogin();
                    }
                });
    }
}
