package org.example;

import java.io.BufferedReader;
import java.io.FileReader;

public class LeitorArquivo {
    ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
    String path = "rotas_de_transportes.txt";

    public void carregarRotas(String tipoFiltro, String filtro) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length >= 4) {
                    String id = partes[0].trim();
                    String nomeLinha = partes[1].trim();
                    String tipoTransporte = partes[2].trim();
                    String regiaoAtendida = partes[3].trim();

                    if (tipoFiltro.equals("Tipo") && tipoTransporte.equals(filtro)) {
                        lista.inserir(id, nomeLinha, tipoTransporte, regiaoAtendida);
                    } else if (tipoFiltro.equals("Região") && regiaoAtendida.equals(filtro)) {
                        lista.inserir(id, nomeLinha, tipoTransporte, regiaoAtendida);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}