package br.com.almacel.incidentes.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CriarBanco extends SQLiteOpenHelper{

    /*Banco de Dados*/
    private static final String NOME_BANCO = "incidentes.db";

    /*Tabela Atendentes*/
    public static final String ATENDENTES = "atendentes";
    private static final String ID_ATENDENTE = "id";
    public static final String NOME_ATENDENTE = "nome";

    /*Tabela Clientes*/
    private static final String CLIENTES = "clientes";
    private static final String ID_CLIENTE = "id";
    public static final String NOME_CLIENTE = "nome";
    public static final String EMPRESA_CLIENTE = "empresa";

    /*Tabela Incidentes*/
    private static final String INCIDENTES = "incidentes";
    private static final String ID_INCIDENTE = "id";
    private static final String ID_ATENDENTE_INCIDENTE = "atendente";
    private static final String ID_CLIENTE_INCIDENTE = "cliente";
    private static final String DESCRICAO_INCIDENTE = "descricao";
    private static final String STATUS_INCIDENTE = "status";
    private static final String CREATION_TIME_INCIDENTE = "creation times";

    /*Versão*/
    public static final int VERSAO = 1;

    public CriarBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String tbAtendentes = String.format("CREATE TABLE %s(%s integer(11) not null,%s varchar(64) not null,PRIMARY KEY (%s),UNIQUE (%s)null", ATENDENTES, ID_ATENDENTE, NOME_ATENDENTE, ID_ATENDENTE, ID_ATENDENTE);

        /*String alterAtendentes1 = String.format("ALTER TABLE '%s' DISABLE KEYS", ATENDENTES);

        String insertAtendentes = "INSERT INTO '"+ATENDENTES+"' ("
                +ID_ATENDENTE+", "+NOME_ATENDENTE+") VALUES ("
                +"4 , 'Anderson'), ("
                +"5 , 'André'), ("
                +"6 , 'Otavio')";

        String alterAtendentes2 = String.format("ALTER TABLE '%s' ENABLE KEYS", ATENDENTES);*/

        String tbClientes = String.format("CREATE TABLE %s(%s integer(11) not null,%s varchar(64) not null,%s varchar(64) not null,PRIMARY KEY (%s),UNIQUE (%s)null", CLIENTES, ID_CLIENTE, NOME_CLIENTE, EMPRESA_CLIENTE, ID_CLIENTE, ID_CLIENTE);

       /* String alterClientes1 = String.format("ALTER TABLE '%s' DISABLE KEYS", CLIENTES);

        String insertClientes = "INSERT INTO '"+CLIENTES+"' ("
                +ID_CLIENTE+", "
                +NOME_CLIENTE+", "
                +EMPRESA_CLIENTE+") VALUES ("
                    +"1, 'Jefferson', 'Pixel Inc'), ("
                    +"2, 'Máximo', 'York Research'), ("
                    +"3, 'Gabriella', 'Faraday Co')";

        String alterClientes2 = String.format("ALTER TABLE '%s' ENABLE KEYS", CLIENTES);*/

        String tbIncidentes = String.format("CREATE TABLE %s(%s integer(11) not null,%s integer(11) not null,%s integer(11) not null,%s varchar(512) default null,%s varchar(16) default null,%s varchar(16) default null,PRIMARY KEY (%s),UNIQUE KEY 'id_UNIQUE' (%s),KEY 'fk_incidente_atendente_idx' (%s),KEY 'fk_incidente_cliente_idx' (%s),CONSTRAINT 'fk_atendente' FOREIGN KEY (%s) REFERENCES '%s' (%s) on delete no action on update no action,CONSTRAINT 'fk_cliente' FOREIGN KEY (%s) REFERENCES '%s' (%s) on delete no action on update no action)", INCIDENTES, ID_INCIDENTE, ID_ATENDENTE_INCIDENTE, ID_CLIENTE_INCIDENTE, DESCRICAO_INCIDENTE, STATUS_INCIDENTE, CREATION_TIME_INCIDENTE, ID_INCIDENTE, ID_INCIDENTE, ID_ATENDENTE_INCIDENTE, ID_CLIENTE_INCIDENTE, ID_ATENDENTE_INCIDENTE, ATENDENTES, ID_ATENDENTE, ID_CLIENTE_INCIDENTE, CLIENTES, ID_CLIENTE);

        /*String alterIncidentes1 = String.format("ALTER TABLE '%s' DISABLE KEYS", INCIDENTES);

        String insertIncidentes = "INSERT INTO '"+INCIDENTES+"' ("
                +ID_INCIDENTE+", "
                +ID_ATENDENTE_INCIDENTE+", "
                +ID_CLIENTE_INCIDENTE+", "
                +DESCRICAO_INCIDENTE+", "
                +STATUS_INCIDENTE+", "
                +CREATION_TIME_INCIDENTE+") VALUES ("
                    +"1, 4, 2, 'Desc do problema', 'aberto', '2018-06-19 01:12:48')";

        String alterIncidentes2 = String.format("ALTER TABLE '%s' ENABLE KEYS", INCIDENTES);*/

        /*SCRIPT ATENDENTES*/
        db.execSQL(tbAtendentes);
       /* db.execSQL(alterAtendentes1);
        db.execSQL(insertAtendentes);
        db.execSQL(alterAtendentes2);*/

        /*SCRIPT CLIENTES*/
        db.execSQL(tbClientes);
        /*db.execSQL(alterClientes1);
        db.execSQL(insertClientes);
        db.execSQL(alterClientes2);*/

        /*SCRIPT INCIDENTES*/
        db.execSQL(tbIncidentes);
        /*db.execSQL(alterIncidentes1);
        db.execSQL(insertIncidentes);
        db.execSQL(alterIncidentes2);*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ATENDENTES);
        db.execSQL("DROP TABLE IF EXISTS " + CLIENTES);
        db.execSQL("DROP TABLE IF EXISTS " + INCIDENTES);

        onCreate(db);
    }

}
