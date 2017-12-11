package com.sato.bruno.marketlist.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "MkList.db";
    private static final int DATABASE_VERSION = 1;
    private final String CREATE_TABLE_PRODUTO = "CREATE TABLE produto (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, categoria TEXT NOT NULL, descricao TEXT, icone TEXT NOT NULL)";
    private final String CREATE_TABLE_LISTA = "CREATE TABLE lista (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, cod TEXT)";
    private final String CREATE_TABLE_LISTAxPRODUTO = "CREATE TABLE listaXproduto (id INTEGER PRIMARY KEY AUTOINCREMENT, id_lista INTEGER NOT NULL, id_produto INTEGER NOT NULL, quantidade FLOAT)";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_LISTA);
        db.execSQL(CREATE_TABLE_PRODUTO);
        db.execSQL(CREATE_TABLE_LISTAxPRODUTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
