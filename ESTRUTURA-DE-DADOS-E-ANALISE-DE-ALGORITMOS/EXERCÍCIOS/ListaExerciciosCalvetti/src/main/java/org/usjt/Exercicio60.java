package org.usjt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercicio60 {

    //60º) Elaborar um programa, em linguagem Java, capaz de receber, via teclado e em ordem
    //aleatória, o conteúdo de cada um dos elementos de um vetor do tipo int, de tamanho
    //variável, também digitado, executar a ordenação crescente do mesmo e apresentar o vetor
    //ordenado em tela. Utilizar um método de ordenação por trocas.

    public static void main(String[] args) {
        List<Integer> listaDeInteiros = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite inteiros para adicionar à lista (digite '0' para encerrar):");

        while (true) {
            try {
                int numero = sc.nextInt();
                if (numero == 0) {
                    break;
                }
                listaDeInteiros.add(numero);
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                sc.nextLine();
            }
        }

        int[] lista = listaDeInteiros.stream().mapToInt(Integer::intValue).toArray();

        Bubble.BubbleSort(lista);

        System.out.println("Lista não ordenada: " + listaDeInteiros);
        System.out.println("Lista ordenada: " + Arrays.toString(lista));
    }

    public class Bubble {
        public static void BubbleSort(int[] iVet) {
            int iA, iB;
            int iT;

            for (iA=1; iA< iVet.length; iA++){
                for (iB=iVet.length-1; iB >= iA; iB--){
                    if (iVet[iB-1] > iVet[iB]){
                        iT=iVet[iB-1];
                        iVet[iB-1]=iVet[iB];
                        iVet[iB]=iT;
                    }
                }
            }
        }
    }
}
