package com.sato.bruno.marketlist.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.sato.bruno.marketlist.R;
import com.sato.bruno.marketlist.adapter.TabAdapter;
import com.sato.bruno.marketlist.db.ConfiguracaoFirebase;
import com.sato.bruno.marketlist.utilities.Preferencias;
import com.sato.bruno.marketlist.utilities.SlidingTabLayout;

public class PrincipalActivity extends AppCompatActivity {

    private Preferencias preferencias;
    private FirebaseAuth firebaseAuth;
    private boolean btBackPressed = false;
    private String[] tabLabels;
    private ViewPager viewPager;
    private SlidingTabLayout slidingTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        preferencias = new Preferencias(PrincipalActivity.this);
        firebaseAuth = ConfiguracaoFirebase.getFirebaseAuth();

        tabLabels = new String[]{"LISTA", "PRODUTOS", "CONFIGURAÇÕES"};

        Toolbar toolbar = findViewById(R.id.toolbar_principal);
        toolbar.setTitle("Início");
        setSupportActionBar(toolbar);

        slidingTabLayout = findViewById(R.id.stl_tabs);
        viewPager = findViewById(R.id.vp_pagina);

        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setSelectedIndicatorColors(ContextCompat.getColor(this, R.color.colorSecondary));

        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager(), tabLabels);
        viewPager.setAdapter(tabAdapter);

        slidingTabLayout.setViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_sobre:
                startActivity(new Intent(PrincipalActivity.this, SobreActivity.class));
                return true;
            case R.id.item_sair:
                logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void logout() {

        firebaseAuth.signOut();
        preferencias.removeEstadoLogin();
        startActivity(new Intent(PrincipalActivity.this, MainActivity.class));
        finish();
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
