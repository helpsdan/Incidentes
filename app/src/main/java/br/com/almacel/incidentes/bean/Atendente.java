package br.com.almacel.incidentes.bean;

/**
 * @author Daniel Aguiar
 * Classe que representa o objeto Atendente
 */
public class Atendente {

    /**
     * Contrutor público sem parâmetros.
     */
    public Atendente(){}

    private int id;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
