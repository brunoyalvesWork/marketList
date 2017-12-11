package com.sato.bruno.marketlist.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.sato.bruno.marketlist.db.DbGateway;
import com.sato.bruno.marketlist.model.om.Lista;

import java.util.ArrayList;
import java.util.List;

public class ListaDAO {

    private String TABLE_LISTA = "lista";
    private DbGateway gw;

    public ListaDAO(Context context) {
        gw = DbGateway.getInstance(context);
    }

    public boolean salvar(String nome, String cod) {
        ContentValues cv = new ContentValues();
        cv.put("nome", nome);
        cv.put("cod", cod);

        return gw.getDatabase().insert(TABLE_LISTA, null, cv) > 0;
    }

    public List<Lista> getListas() {
        List<Lista> listas = new ArrayList<>();
        String query = "SELECT * FROM "+TABLE_LISTA+" ORDER BY id";
        Cursor cursor = gw.getDatabase().rawQuery(query, null);
        cursor.moveToFirst();

        Lista lista;

        while (!cursor.isAfterLast()) {
            lista = new Lista(
                    cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("nome")),
                    cursor.getString(cursor.getColumnIndex("cod"))
            );
            listas.add(lista);
            cursor.moveToNext();
        }

        return listas;
    }
}
