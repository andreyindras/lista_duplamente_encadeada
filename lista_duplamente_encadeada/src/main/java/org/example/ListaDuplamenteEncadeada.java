package org.example;

public class ListaDuplamenteEncadeada {
    private No inicio;
    private No fim;

    public void inserir(String id, String nomeLinha, String tipoTransporte, String regiaoAtendida) {
        No novo = new No(id, nomeLinha, tipoTransporte, regiaoAtendida);

        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
    }

    public void exibirListaEmOrdem() {
        No temp = inicio;

        if (temp == null) {
            System.out.println("Nenhuma rota encontrada.");
            return;
        }

        while (temp != null) {
            System.out.println("ID: " + temp.id);
            System.out.println("Linha: " + temp.nomeLinha);
            System.out.println("Tipo: " + temp.tipoTransporte);
            System.out.println("Região: " + temp.regiaoAtendida);
            System.out.println();
            temp = temp.proximo;
        }
    }

    public void exibirListaEmOrdemInversa() {
        No temp = fim;

        if (temp == null) {
            System.out.println("Nenhuma rota encontrada.");
            return;
        }

        while (temp != null) {
            System.out.println("ID: " + temp.id);
            System.out.println("Linha: " + temp.nomeLinha);
            System.out.println("Tipo: " + temp.tipoTransporte);
            System.out.println("Região: " + temp.regiaoAtendida);
            System.out.println();
            temp = temp.anterior;
        }
    }

    public void liberarLista() {
        No temp = inicio;
        while (temp != null) {
            No proximo = temp.proximo;
            temp.anterior = null;
            temp.proximo = null;
            temp = proximo;
        }
        inicio = fim = null;
    }
}