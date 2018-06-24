package br.com.almacel.incidentes.bean;

public class Cliente {

    public Cliente(){}

    public Cliente(String nome, String empresa){
        this.nome = nome;
        this.empresa = empresa;
    }

    private int id;
    private String nome;
    private String empresa;


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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
