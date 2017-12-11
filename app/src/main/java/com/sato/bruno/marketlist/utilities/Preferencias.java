package com.sato.bruno.marketlist.utilities;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferencias {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private String NOME_ARQUIVO = "mkl_preferences";

    private String CHAVE_ID_USUARIO = "idUsuarioLogado";
    private String CHAVE_NOME_USUARIO = "nomeUsuarioLogado";
    private String CHAVE_EMAIL_USUARIO = "emailUsuarioLogado";
    private String CHAVE_LOGADO = "isLogado";
    private String CHAVE_PRODUTO_POPULADO = "produtosPopulado";
    private String CHAVE_LISTA_SELECIONADA = "listaSelecionada";

    public Preferencias(Context context) {

        this.context = context;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void salvaIdUsuario(String id) {

        editor.putString(CHAVE_ID_USUARIO, id);
        editor.apply();
    }

    public void salvaNomeUsuario(String nome) {

        editor.putString(CHAVE_NOME_USUARIO, nome);
        editor.apply();
    }

    public void salvaEmailUsuario(String email) {

        editor.putString(CHAVE_EMAIL_USUARIO, email);
        editor.apply();
    }

    public void salvaEstadoLogin() {

        editor.putBoolean(CHAVE_LOGADO, true);
        editor.apply();
    }
    public void removeEstadoLogin() {

        editor.putBoolean(CHAVE_LOGADO, false);
        editor.apply();
    }

    public void salvaProdutosPopulado() {

        editor.putBoolean(CHAVE_PRODUTO_POPULADO, true);
        editor.apply();
    }
    public void removeProdutosPopulado() {

        editor.putBoolean(CHAVE_PRODUTO_POPULADO, false);
        editor.apply();
    }

    public void adicionaListaSelecionada(String lista) {

        editor.putString(CHAVE_LISTA_SELECIONADA, lista);
        editor.apply();
    }
    public void removeListaSelecionada() {

        editor.putString(CHAVE_LISTA_SELECIONADA, "");
        editor.apply();
    }

    public String getIdUsuarioLogado() {
        return preferences.getString(CHAVE_ID_USUARIO, null);
    }
    public String getNomeUsuarioLogado() {
        return preferences.getString(CHAVE_NOME_USUARIO, null);
    }
    public String getEmailUsuarioLogado() {
        return preferences.getString(CHAVE_EMAIL_USUARIO, null);
    }
    public Boolean getEstadoLogin() {
        return preferences.getBoolean(CHAVE_LOGADO, false);
    }
    public Boolean getProdutosPopulado() {
        return preferences.getBoolean(CHAVE_PRODUTO_POPULADO, false);
    }
    public String getListaSelecionada() {
        return preferences.getString(CHAVE_LISTA_SELECIONADA, null);
    }
}
