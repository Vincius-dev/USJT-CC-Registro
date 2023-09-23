package org.usjt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercicio66 {

    //66º) Elaborar um programa, em linguagem Java, capaz de receber, em ordem aleatória, o
    //conteúdo de cada elemento de um vetor do tipo double, de tamanho 20, via teclado,
    //executar uma ordenação decrescente do mesmo e apresentar o vetor ordenado em tela.
    //Utilizar um método de ordenação por seleção.

    public static void main(String[] args) {
        List<Double> listaDeInteiros = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite inteiros para adicionar à lista (digite '0' para encerrar):");

        while (true) {
            try {
                Double numero = sc.nextDouble();
                if (numero == 0) {
                    break;
                }
                listaDeInteiros.add(numero);
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                sc.nextLine();
            }
        }

        double[] lista = listaDeInteiros.stream().mapToDouble(Double::doubleValue).toArray();

        Selection.selectionSort(lista);

        System.out.println("Lista não ordenada: " + listaDeInteiros);
        System.out.println("Lista ordenada: " + Arrays.toString(lista));
    }

    public class Selection{
        public static void selectionSort(double[] iVet) {
            int iA, iB, iC;
            double iT;

            for (iA=0; iA < iVet.length-1; iA++){
                iC=iA;
                iT=iVet[iA];
                for (iB=iA+1; iB < iVet.length; iB++){
                    if (iVet[iB] < iT){
                        iC=iB;
                        iT=iVet[iB];
                    }
                }
                iVet[iC]=iVet[iA];
                iVet[iA]=iT;
            }
        }
    }
}
