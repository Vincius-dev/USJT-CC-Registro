package org.usjt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercicio69 {

    //69º) Elaborar um programa, em linguagem Java, capaz de receber, em ordem aleatória, o
    //conteúdo de cada elemento de um vetor do tipo char, de tamanho 5, via teclado, executar
    //uma ordenação crescente do mesmo e apresentar o vetor ordenado em tela. Utilizar um
    //método de ordenação por inserção.

    public static void main(String[] args) {
        List<Character> listaDeCaracteres = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite inteiros para adicionar à lista (digite '0' para encerrar):");

        while (true) {
            try {
                System.out.println("Digite um caractere (ou '0' para encerrar):");
                String entrada = sc.next();

                if (entrada.equals("0")) {
                    break;
                }

                if (entrada.length() != 1) {
                    System.out.println("Entrada inválida. Por favor, insira apenas um caractere.");
                } else {
                    char caractere = entrada.charAt(0);
                    listaDeCaracteres.add(caractere);
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um caractere válido.");
                sc.nextLine();
            }
        }

        char[] lista = new char[listaDeCaracteres.size()];
        for (int i = 0; i < listaDeCaracteres.size(); i++) {
            lista[i] = listaDeCaracteres.get(i);
        }

        Insertion.insertionSort(lista);

        System.out.println("Lista não ordenada: " + listaDeCaracteres);
        System.out.println("Lista ordenada: " + Arrays.toString(lista));
    }

    public class Insertion {
        public static void insertionSort(char[] iVet) {
            int iA, iB;
            char iT;

            for (iA=1; iA < iVet.length; iA++){
                iT=iVet[iA];
                iB=iA-1;
                while (iB >= 0 && iT < iVet[iB]){
                    iVet[iB+1]=iVet[iB];
                    iB--;
                }
                iVet[iB+1]=iT;
            }
        }
    }
}
