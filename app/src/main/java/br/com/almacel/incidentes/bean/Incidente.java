package br.com.almacel.incidentes.bean;

/**
 * @author Daniel Aguiar
 * Classe que representa o objeto Cliente
 */
public class Incidente {
    /**
     * Contrutor público sem parâmetros.
     */
    public Incidente(){}

    private int id;
    private int atendente;
    private int cliente;
    private String descricao;
    private Status status;
    private String creationTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAtendente() { return atendente; }

    public void setAtendente(int atendente) { this.atendente = atendente; }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}
