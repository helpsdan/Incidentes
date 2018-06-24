package br.com.almacel.incidentes.crud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class PostContract {

    private PostContract(){};

    public static class PostEntry implements BaseColumns{
        /*Tabela Atendentes*/
        public static final String ATENDENTE = "ATENDENTE";

        /*Tabela Clientes*/
        public static final String CLIENTE = "CLIENTE";

        /*Tabela Incidentes*/
        public static final String INCIDENTE = "INCIDENTE";


    }

}
