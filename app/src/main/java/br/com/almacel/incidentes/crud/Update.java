package br.com.almacel.incidentes.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.almacel.incidentes.bean.Atendente;
import br.com.almacel.incidentes.bean.Cliente;
import br.com.almacel.incidentes.bean.Incidente;

public class Update extends SQLiteOpenHelper{


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

    public Update(Context context) {
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

    public boolean insertAtendente(Atendente atendente){
        openDB();
        try {
            ContentValues values = new ContentValues();
            values.put("ID", atendente.getId());
            values.put("NOME", atendente.getNome());
            db.insert(PostContract.PostEntry.ATENDENTE, null, values);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            db.close();
        }

    }

    public boolean insertCliente(Cliente cliente){
        openDB();
        try {
            ContentValues values = new ContentValues();
            values.put("ID", cliente.getId());
            values.put("NOME", cliente.getNome());
            values.put("EMPRESA", cliente.getEmpresa());
            db.insert(PostContract.PostEntry.CLIENTE, null, values);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            db.close();
        }

    }


    public boolean insertIncidente(Incidente incidente){
        openDB();
        try {
            ContentValues values = new ContentValues();
            values.put("ID", incidente.getId());
            values.put("ATENDENTE", String.valueOf(incidente.getAtendente()));
            values.put("CLIENTE", String.valueOf(incidente.getCliente()));
            values.put("DESCRICAO", incidente.getDescricao());
            values.put("STATUS", String.valueOf(incidente.getStatus()));
            values.put("CREATION_TIME", incidente.getCreationTime());
            db.insert(PostContract.PostEntry.INCIDENTE, null, values);
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
