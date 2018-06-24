package br.com.almacel.incidentes.crud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * @author Daniel Aguiar
 * Classe de Contrato responsável por armazenar o nome dos bancos de dados.
 */

public class PostContract {

    /**
     * Construtor público
     */
    private PostContract(){};

    /**
     * Método que armazena o nome dos bancos de dados.
     */
    public static class PostEntry implements BaseColumns{
        /*Tabela Atendente*/
        public static final String ATENDENTE = "ATENDENTE";

        /*Tabela Cliente*/
        public static final String CLIENTE = "CLIENTE";

        /*Tabela Incidente*/
        public static final String INCIDENTE = "INCIDENTE";


    }

}
