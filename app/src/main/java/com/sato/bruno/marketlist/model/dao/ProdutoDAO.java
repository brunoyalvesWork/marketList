package com.sato.bruno.marketlist.model.dao;

import android.content.ContentValues;
import android.content.Context;

import com.sato.bruno.marketlist.db.DbGateway;

public class ProdutoDAO {

    private String TABLE_PRODUTO = "Produto";
    private DbGateway gw;

    public ProdutoDAO(Context context) {
        gw = DbGateway.getInstance(context);
    }

    public boolean salvar(String nome, String categoria) {
        ContentValues cv = new ContentValues();
        cv.put("nome", nome);
        cv.put("categoria", categoria);
        return gw.getDatabase().insert(TABLE_PRODUTO, null, cv) > 0;
    }
}
