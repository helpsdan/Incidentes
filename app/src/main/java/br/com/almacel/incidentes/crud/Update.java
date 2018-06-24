package br.com.almacel.incidentes.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.almacel.incidentes.bean.Atendente;
import br.com.almacel.incidentes.bean.Cliente;
import br.com.almacel.incidentes.bean.Incidente;

/**
 * @author Daniel Aguiar
 * Classe que faz a manipulação dos dados no banco de dados (INSERT)
 */
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

    /**
     *  Contrutor publico
     * @param context CONTEXTO da aplicação
     */
    public Update(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
        this.nContext = context;
        db = getWritableDatabase();
    }

    /**
     * Método herdaddo da classe SQLiteOpenHelper
     * @param db instancia do banco de dados.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    /**
     * Método herdaddo da classe SQLiteOpenHelper
     * @param db instancia do banco de dados.
     * @param oldVersion versão anterior do banco de dados.
     * @param newVersion nova versão do banco de dados.
     */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     *
     * @param atendente Atendente que será inserido
     * @return retorno true ou false para determinar se a query foi executada ou não.
     */
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
    /**
     *
     * @param cliente Atendente que será inserido
     * @return retorno true ou false para determinar se a query foi executada ou não.
     */
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

    /**
     *
     * @param incidente Atendente que será inserido
     * @return retorno true ou false para determinar se a query foi executada ou não.
     */
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

    /**
     * Método para abrir o banco de dados, presente em todos os métodos anteriores.
     */
    private void openDB(){
        if (!db.isOpen()){
            db = nContext.openOrCreateDatabase(PATH_DB, SQLiteDatabase.OPEN_READWRITE, null);
        }
    }

}
