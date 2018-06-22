package br.com.almacel.incidentes.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {

    private SQLiteDatabase db;
    private CriarBanco banco;

    public BancoController(Context context){
        banco = new CriarBanco(context);
    }

    public String insereAtendente(String nome){
        ContentValues valor;

        db = banco.getWritableDatabase();
        valor = new ContentValues();
        valor.put(CriarBanco.NOME_ATENDENTE, nome);

        db.insert(CriarBanco.ATENDENTES, null, valor);
        db.close();

        return "Registro inserido com sucesso";
    }

    public String insereClientes(String nome, String empresa){
        ContentValues valor;

       db = banco.getWritableDatabase();
       valor = new ContentValues();
       valor.put(CriarBanco.NOME_CLIENTE, nome);
       valor.put(CriarBanco.EMPRESA_CLIENTE, empresa);

        return "Registro inserido com sucesso";
    }
}
