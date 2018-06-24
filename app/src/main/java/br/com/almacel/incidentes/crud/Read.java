package br.com.almacel.incidentes.crud;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.almacel.incidentes.bean.Incidente;
import br.com.almacel.incidentes.bean.Status;

public class Read extends SQLiteOpenHelper{


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

    public Read(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
        this.nContext = context;
        db = getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<Incidente> getIncidente(){
        openDB();
        ArrayList<Incidente> iArray = new ArrayList<>();
        String getIncidentes = "SELECT * FROM " + PostContract.PostEntry.INCIDENTE;
        try{
            Cursor c = db.rawQuery(getIncidentes, null);
            if (c.moveToFirst()){
                do{
                    Incidente incidente = new Incidente();
                    incidente.setId(c.getInt(0));
                    incidente.setAtendente(Integer.parseInt(c.getString(1)));
                    incidente.setCliente(Integer.parseInt(c.getString(2)));
                    incidente.setDescricao(c.getString(3));
                    incidente.setStatus(Status.valueOf(c.getString(4)));
                    incidente.setCreationTime(c.getString(5));
                    iArray.add(incidente);
                }while (c.moveToNext());
                c.close();
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            db.close();
        }
        return iArray;
    }

    private void openDB(){
        if (!db.isOpen()){
            db = nContext.openOrCreateDatabase(PATH_DB, SQLiteDatabase.OPEN_READWRITE, null);
        }
    }

}
