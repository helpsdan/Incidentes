package br.com.almacel.incidentes.crud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Delete extends SQLiteOpenHelper{


    /*Nome do banco*/
    public static final String NOME_DB = "incidentes_db";

    /*Versão do banco*/
    public static final int VERSAO_DB = 1;

    /*Path DB*/
    public static final String PATH_DB = "/data/user/0/br.com.almacel.incidentes/database/incidentes_db";

    /*Context*/
    public Context nContext;

    /*Instância do Banco de Dados*/
    public SQLiteDatabase db;

    public Delete(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
        this.nContext = context;
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean deleteTables(){
        openDB();
        String deleteTableAtendente = "DROP TABLE IF EXISTS " + PostContract.PostEntry.ATENDENTE;
        String deleteTableCliente = "DROP TABLE IF EXISTS " + PostContract.PostEntry.CLIENTE;
        String deleteTableIncidente = "DROP TABLE IF EXISTS " + PostContract.PostEntry.INCIDENTE;
        try{
            db.execSQL(deleteTableAtendente);
            db.execSQL(deleteTableCliente);
            db.execSQL(deleteTableIncidente);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            db.close();
        }
    }

    private void openDB(){
        if (!db.isOpen()){
            db = nContext.openOrCreateDatabase(PATH_DB, SQLiteDatabase.OPEN_READWRITE, null);
        }
    }

}
