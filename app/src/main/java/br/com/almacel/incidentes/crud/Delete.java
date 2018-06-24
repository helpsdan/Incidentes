package br.com.almacel.incidentes.crud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Daniel Aguiar
 * Classe que faz a manipulação dos dados no banco de dados(DROP)
 */
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

    /**
     * Contrutor publico
     * @param context recebe o contexto da aplicação
     */
    public Delete(Context context) {
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
     * @param db instnacia do banco de dados.
     * @param oldVersion versao anterior do banco de dados.
     * @param newVersion nova versao do banco de dados.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * Método para deletar as tabelas na inicialização do aplicativo para que sejam inseridos novos registros.
     * @return retorno true ou false para saber se a query foi executada com sucesso ou não.
     */
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

    /**
     * Método criado para encerrar os incidentes
     * @return retorno true ou false para saber se a query foi excutada com sucesso ou não.
     */
    public boolean encerrarIncidente(){
        openDB();
        String encerrarIncidente = "UPDATE "+ PostContract.PostEntry.INCIDENTE+" SET STATUS = 'FINALIZADO'";
        try{
            db.execSQL(encerrarIncidente);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            db.close();
        }
    }

    /**
     * Método para abrir a conexão com o banco de dados.
     */
    private void openDB(){
        if (!db.isOpen()){
            db = nContext.openOrCreateDatabase(PATH_DB, SQLiteDatabase.OPEN_READWRITE, null);
        }
    }

}
