package br.com.almacel.incidentes.crud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Create extends SQLiteOpenHelper{


    /*Nome do banco*/
    public static final String NOME_DB = "incidentes.db";

    /*Versão do banco*/
    public static final int VERSAO_DB = 1;

    /*Context*/
    public Context nContext;

    /*Path DB*/
    public static final String PATH_DB = "/data/user/0/br.com.almacel.incidentes/database/incidentes.db";

    /*Instância do Banco de Dados*/
    public SQLiteDatabase db;

    public Create(Context context) {
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

    public boolean createTableAtendente(){
        openDB();
        String createTableAtendente = "CREATE TABLE IF NOT EXISTS " + PostContract.PostEntry.ATENDENTE+ " ("
                + "ID INTEGER,"
                + "NOME TEXT,"
                + "PRIMARY KEY ('ID')"
                + ")";
        try {
            db.execSQL(createTableAtendente);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            db.close();
        }
    }

    public boolean createTableCliente(){
        openDB();
        String createTableCliente = "CREATE TABLE IF NOT EXISTS " + PostContract.PostEntry.CLIENTE+ " ("
                + "ID INTEGER  ,"
                + "NOME TEXT ,"
                + "EMPRESA TEXT,"
                + "PRIMARY KEY ('ID')"
                + ")";
        try {
            db.execSQL(createTableCliente);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            db.close();
        }
    }
    public boolean createTableIncidente(){
        openDB();
        String createTableIncidente = "CREATE TABLE IF NOT EXISTS " + PostContract.PostEntry.INCIDENTE+ " ("
                + "ID INTEGER,"
                + "ATENDENTE INTEGER,"
                + "CLIENTE INTEGER, "
                + "DESCRICAO TEXT,"
                + "STATUS TEXT,"
                + "CREATION_TIME TEXT,"
                + "PRIMARY KEY ('ID'),"
                + "CONSTRAINT `fk_atendente` FOREIGN KEY (`ATENDENTE`) REFERENCES '"+ PostContract.PostEntry.ATENDENTE+"' (`ID`),"
                + "CONSTRAINT `fk_cliente` FOREIGN KEY (`CLIENTE`) REFERENCES '"+ PostContract.PostEntry.CLIENTE+"' (`ID`)"
                + ") ";
        try {
            db.execSQL(createTableIncidente);
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
