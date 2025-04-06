package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Selecione o critério para filtrar as rotas:");
        System.out.println("(1) - Por tipo de transporte (Ônibus, Metrô, Trem)");
        System.out.println("(2) - Por região atendida (Centro, Zona Sul, etc.)");
        System.out.print("Opção: ");
        int opcaoFiltro = sc.nextInt();
        sc.nextLine();

        String filtro = "";
        if (opcaoFiltro == 1) {
            System.out.println("\nSelecione o tipo de transporte para buscar:");
            System.out.println("(1) - Ônibus");
            System.out.println("(2) - Metrô");
            System.out.println("(3) - Trem");
            System.out.print("Opção: ");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    filtro = "Ônibus";
                    break;
                case 2:
                    filtro = "Metrô";
                    break;
                case 3:
                    filtro = "Trem";
                    break;
                default:
                    System.out.println("Opção inválida!");
                    return;
            }
        } else if (opcaoFiltro == 2) {
            System.out.println("\nSelecione a região para buscar:");
            System.out.println("(1) - Centro");
            System.out.println("(2) - Zona Sul");
            System.out.println("(3) - Zona Norte");
            System.out.println("(4) - Zona Leste");
            System.out.println("(5) - Zona Oeste");
            System.out.print("Opção: ");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    filtro = "Centro";
                    break;
                case 2:
                    filtro = "Zona Sul";
                    break;
                case 3:
                    filtro = "Zona Norte";
                    break;
                case 4:
                    filtro = "Zona Leste";
                    break;
                case 5:
                    filtro = "Zona Oeste";
                    break;
                default:
                    System.out.println("Opção inválida!");
                    return;
            }
        } else {
            System.out.println("Opção inválida!");
            return;
        }

        LeitorArquivo leitor = new LeitorArquivo();

        String tipoFiltro;
        if (opcaoFiltro == 1) {
            tipoFiltro = "Tipo";
        } else {
            tipoFiltro = "Região";
        }
        leitor.carregarRotas(tipoFiltro, filtro);

        System.out.println("\nRotas na ordem normal:\n");
        leitor.lista.exibirListaEmOrdem();

        System.out.println("\nRotas na ordem inversa:\n");
        leitor.lista.exibirListaEmOrdemInversa();

        leitor.lista.liberarLista();

        sc.close();
    }
}