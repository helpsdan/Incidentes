package br.com.almacel.incidentes.crud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Create extends SQLiteOpenHelper{


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

    public boolean createTables(){
        openDB();
        String createTableAtendente = "CREATE TABLE IF NOT EXISTS " + PostContract.PostEntry.ATENDENTE+ " ("
                + "ID INTEGER,"
                + "NOME TEXT,"
                + "PRIMARY KEY ('ID')"
                + ")";
        String createTableCliente = "CREATE TABLE IF NOT EXISTS " + PostContract.PostEntry.CLIENTE+ " ("
                + "ID INTEGER,"
                + "NOME TEXT,"
                + "EMPRESA TEXT,"
                + "PRIMARY KEY ('ID')"
                + ")";
        String createTableIncidente = "CREATE TABLE IF NOT EXISTS " + PostContract.PostEntry.INCIDENTE+ " ("
                + "ID INTEGER,"
                + "ATENDENTE INTEGER,"
                + "CLIENTE INTEGER, "
                + "DESCRICAO TEXT,"
                + "STATUS TEXT,"
                + "CREATION_TIME TEXT,"
                + "PRIMARY KEY ('ID'),"
                + "CONSTRAINT `fk_atendente` FOREIGN KEY (`ATENDENTE`) REFERENCES '"+ PostContract.PostEntry.ATENDENTE+"' (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,"
                + "CONSTRAINT `fk_cliente` FOREIGN KEY (`CLIENTE`) REFERENCES '"+ PostContract.PostEntry.CLIENTE+"' (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION"
                + ") ";
        try {
            db.execSQL(createTableAtendente);
            db.execSQL(createTableCliente);
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