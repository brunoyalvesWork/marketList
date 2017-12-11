package com.sato.bruno.marketlist.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.widget.ListView;

import com.sato.bruno.marketlist.db.DbGateway;
import com.sato.bruno.marketlist.model.om.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private String TABLE_PRODUTO = "Produto";
    private DbGateway gw;

    public ProdutoDAO(Context context) {
        gw = DbGateway.getInstance(context);
    }

    public boolean salvar(String nome, String categoria, String descricao, String icone) {
        ContentValues cv = new ContentValues();
        cv.put("nome", nome);
        cv.put("categoria", categoria);
        cv.put("descricao", descricao);
        cv.put("icone", icone);

        return gw.getDatabase().insert(TABLE_PRODUTO, null, cv) > 0;
    }

    public List<Produto> getProdutos() {

        List<Produto> produtos = new ArrayList<>();
        String query = "SELECT * FROM "+TABLE_PRODUTO+" ORDER BY id";
        Cursor cursor = gw.getDatabase().rawQuery(query, null);
        cursor.moveToFirst();

        Produto produto;

        while (!cursor.isAfterLast()) {
            produto = new Produto(
                    cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("nome")),
                    cursor.getString(cursor.getColumnIndex("categoria")),
                    cursor.getString(cursor.getColumnIndex("descricao")),
                    cursor.getString(cursor.getColumnIndex("icone"))
            );
            produtos.add(produto);
            cursor.moveToNext();
        }

        return produtos;
    }
}
