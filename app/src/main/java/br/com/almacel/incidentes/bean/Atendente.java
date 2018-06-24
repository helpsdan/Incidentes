package br.com.almacel.incidentes.bean;

public class Atendente {

    public Atendente(){}

    public Atendente(String nome){
        this.nome = nome;
    }

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
