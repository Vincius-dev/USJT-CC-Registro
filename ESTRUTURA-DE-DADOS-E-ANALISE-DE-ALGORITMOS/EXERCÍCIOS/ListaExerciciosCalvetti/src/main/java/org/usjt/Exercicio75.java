package org.usjt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercicio75 {

    //75º) Elaborar um programa, em linguagem Java, capaz de receber, via teclado e em ordem
    //aleatória, o conteúdo de cada um dos elementos de um vetor do tipo int, de tamanho
    //variável, também digitado, executar a ordenação crescente do mesmo e apresentar o vetor
    //ordenado em tela. Utilizar um método de ordenação Quick-Sort.

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

        Quicksort.quickSort(lista, 0, lista.length - 1);

        System.out.println("Lista não ordenada: " + listaDeInteiros);
        System.out.println("Lista ordenada: " + Arrays.toString(lista));
    }

    class Quicksort {

        static int partition(int array[], int low, int high) {
            int pivot = array[high];
            int i = (low - 1);

            for (int j = low; j < high; j++) {
                if (array[j] <= pivot) {
                    i++;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

            int temp = array[i + 1];
            array[i + 1] = array[high];
            array[high] = temp;

            return (i + 1);
        }

        static void quickSort(int array[], int low, int high) {
            if (low < high) {
                int pi = partition(array, low, high);
                quickSort(array, low, pi - 1);
                quickSort(array, pi + 1, high);
            }
        }
    }
}
