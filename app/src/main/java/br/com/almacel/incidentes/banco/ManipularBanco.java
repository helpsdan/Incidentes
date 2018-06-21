package br.com.almacel.incidentes.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ManipularBanco extends SQLiteOpenHelper{

    /*Banco de Dados*/
    private static final String NOME_BANCO = "incidentes.db";

    /*Tabela Atendentes*/
    private static final String ATENDENTES = "atendentes";
    private static final String ID_ATENDENTE = "id";
    private static final String NOME_ATENDENTE = "nome";

    /*Tabela Clientes*/
    private static final String CLIENTES = "clientes";
    private static final String ID_CLIENTE = "id";
    private static final String NOME_CLIENTE = "nome";
    private static final String EMPRESA_CLIENTE = "empresa";

    /*Tabela Incidentes*/
    private static final String INCIDENTES = "incidentes";
    private static final String ID_INCIDENTE = "id";
    private static final String ID_ATENDENTE_INCIDENTE = "atendente";
    private static final String ID_CLIENTE_INCIDENTE = "cliente";
    private static final String DESCRICAO_INCIDENTE = "descricao";
    private static final String STATUS_INCIDENTE = "status";
    private static final String CREATION_TIME_INCIDENTE = "creation times";

    /*Versão*/
    private static final int VERSAO = 1;

    public ManipularBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String tbAtendentes = "CREATE TABLE"+ATENDENTES+"("
                +ID_ATENDENTE+"integer(11) not null autoincrement,"
                +NOME_ATENDENTE+"varchar(64) not null,"
                +"PRIMARY KEY ("+ID_ATENDENTE+"),"
                +"UNIQUE KEY 'id_UNIQUE' ("+ID_ATENDENTE+")"
                +") ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8";

        String alterAtendentes1 = String.format("ALTER TABLE '%s' DISABLE KEYS", ATENDENTES);

        String insertAtendentes = "INSERT INTO '"+ATENDENTES+"' ("
                +ID_ATENDENTE+", "+NOME_ATENDENTE+") VALUES ("
                +"4 , 'Anderson'), ("
                +"5 , 'André'), ("
                +"6 , 'Otavio')";

        String alterAtendentes2 = String.format("ALTER TABLE '%s' ENABLE KEYS", ATENDENTES);

        String tbClientes = "CREATE TABELE"+CLIENTES+"("
                +ID_CLIENTE+"integer(11) not null autoincrement,"
                +NOME_CLIENTE+"varchar(64) not null,"
                +EMPRESA_CLIENTE+"varchar(64) not null,"
                +"PRIMARY KEY ("+ID_CLIENTE+"),"
                +"UNIQUE KEY 'id_UNIQUE' ("+ID_CLIENTE+")"
                +") ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8";

        String alterClientes1 = String.format("ALTER TABLE '%s' DISABLE KEYS", CLIENTES);

        String insertClientes = "INSERT INTO '"+CLIENTES+"' ("
                +ID_CLIENTE+", "
                +NOME_CLIENTE+", "
                +EMPRESA_CLIENTE+") VALUES ("
                    +"1, 'Jefferson', 'Pixel Inc'), ("
                    +"2, 'Máximo', 'York Research'), ("
                    +"3, 'Gabriella', 'Faraday Co')";

        String alterClientes2 = String.format("ALTER TABLE '%s' ENABLE KEYS", CLIENTES);

        String tbIncidentes = "CREATE TABLE"+INCIDENTES+"("
                +ID_INCIDENTE+"integer(11) not null autoincrement,"
                +ID_ATENDENTE_INCIDENTE+"integer(11) not null,"
                +ID_CLIENTE_INCIDENTE+"integer(11) not null,"
                +DESCRICAO_INCIDENTE+"varchar(512) default null,"
                +STATUS_INCIDENTE+"varchar(16) default null,"
                +CREATION_TIME_INCIDENTE+"timestamp default null,"
                +"PRIMARY KEY ("+ID_INCIDENTE+"),"
                +"UNIQUE KEY 'id_UNIQUE' ("+ID_INCIDENTE+"),"
                +"KEY 'fk_incidente_atendente_idx' ("+ID_ATENDENTE_INCIDENTE+"),"
                +"KEY 'fk_incidente_cliente_idx' ("+ID_CLIENTE_INCIDENTE+"),"
                +"CONSTRAINT 'fk_atendente' FOREIGN KEY ("+ID_ATENDENTE_INCIDENTE+") REFERENCES '"+ATENDENTES+"' ("+ID_ATENDENTE+") on delete no action on update no action,"
                +"CONSTRAINT 'fk_cliente' FOREIGN KEY ("+ID_CLIENTE_INCIDENTE+") REFERENCES '"+CLIENTES+"' ("+ID_CLIENTE+") on delete no action on update no action"
                +") ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8";

        String alterIncidentes1 = String.format("ALTER TABLE '%s' DISABLE KEYS", INCIDENTES);

        String insertIncidentes = "INSERT INTO '"+INCIDENTES+"' ("
                +ID_INCIDENTE+", "
                +ID_ATENDENTE_INCIDENTE+", "
                +ID_CLIENTE_INCIDENTE+", "
                +DESCRICAO_INCIDENTE+", "
                +STATUS_INCIDENTE+", "
                +CREATION_TIME_INCIDENTE+") VALUES ("
                    +"1, 4, 2, 'Desc do problema', 'aberto', '2018-06-19 01:12:48')";

        String alterIncidentes2 = String.format("ALTER TABLE '%s' ENABLE KEYS", INCIDENTES);

        /*SCRIPT ATENDENTES*/
        db.execSQL(tbAtendentes);
        db.execSQL(alterAtendentes1);
        db.execSQL(insertAtendentes);
        db.execSQL(alterAtendentes2);

        /*SCRIPT CLIENTES*/
        db.execSQL(tbClientes);
        db.execSQL(alterClientes1);
        db.execSQL(insertClientes);
        db.execSQL(alterClientes2);

        /*SCRIPT INCIDENTES*/
        db.execSQL(tbIncidentes);
        db.execSQL(alterIncidentes1);
        db.execSQL(insertIncidentes);
        db.execSQL(alterIncidentes2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ATENDENTES);
        db.execSQL("DROP TABLE IF EXISTS " + CLIENTES);
        db.execSQL("DROP TABLE IF EXISTS " + INCIDENTES);

        onCreate(db);
    }

}
