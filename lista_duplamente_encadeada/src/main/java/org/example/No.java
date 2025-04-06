package org.example;

public class No {
    public String id;
    public String nomeLinha;
    public String tipoTransporte;
    public String regiaoAtendida;
    public No anterior;
    public No proximo;

    public No(String id, String nomeLinha, String tipoTransporte, String regiaoAtendida) {
        this.id = id;
        this.nomeLinha = nomeLinha;
        this.tipoTransporte = tipoTransporte;
        this.regiaoAtendida = regiaoAtendida;
        this.anterior = null;
        this.proximo = null;
    }
}