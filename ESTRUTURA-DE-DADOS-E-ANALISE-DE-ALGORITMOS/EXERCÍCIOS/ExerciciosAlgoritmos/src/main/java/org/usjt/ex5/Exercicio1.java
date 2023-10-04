package org.usjt.ex5;

import java.util.*;

public class Exercicio1 {

    public static void main(String[] args) {

        int[] listaQuickSort = new int[50];
        int[] listaMergeSort = new int[50];

        preencheAleatorio(listaQuickSort, 1000);
        preencheAleatorio(listaMergeSort, 1000);

        System.out.println("Quick Sort:");

        System.out.println("Antes:");
        long tempoInicialNanoQuick = System.nanoTime();
        System.out.println(Arrays.toString(listaQuickSort));

        quickSort(listaQuickSort, 0, listaMergeSort.length-1);

        System.out.println("Depois:");
        long tempoFinalNanoQuick= System.nanoTime();
        System.out.println(Arrays.toString(listaQuickSort));

        System.out.println("Tempo decorrido em nano segundos:");
        System.out.println(tempoFinalNanoQuick - tempoInicialNanoQuick);

        System.out.println("Merge Sort:");
        System.out.println("Antes:");
        long tempoInicialNanoMerge = System.nanoTime();
        System.out.println(Arrays.toString(listaMergeSort));

        mergeSort(listaMergeSort);

        System.out.println("Depois:");
        long tempoFinalNanoMerge= System.nanoTime();
        System.out.println(Arrays.toString(listaMergeSort));

        System.out.println("Tempo decorrido em nano segundos:");
        System.out.println(tempoFinalNanoMerge - tempoInicialNanoMerge);

    }

    public static void preencheAleatorio (int []v, int max) {
        Random r = new Random ();
        for (int i = 0; i < v.length; i++)
            v[i] = r.nextInt (max + 1);
    }

    public static void quickSort(int iVet[], int iBaixo, int iAlto){
        int iP, iB, iA;
        int iPivot;

        iB=iBaixo;
        iA=iAlto;
        iPivot=iVet[iBaixo];
        while (iBaixo < iAlto){
            while((iVet[iAlto] >= iPivot) && (iBaixo < iAlto)){
                iAlto--;
            }
            if(iBaixo != iAlto){
                iVet[iBaixo]=iVet[iAlto];
                iBaixo++;
            }
            while ((iVet[iBaixo] <= iPivot) && (iBaixo < iAlto)){
                iBaixo++;
            }
            if (iBaixo != iAlto){
                iVet[iAlto]=iVet[iBaixo];
                iAlto--;
            }
        }
        iVet[iBaixo]=iPivot;
        iP=iBaixo;
        iBaixo=iB;
        iAlto=iA;
        if(iBaixo < iP){
            quickSort(iVet, iBaixo, iP-1);
        }
        if (iAlto > iP){
            quickSort(iVet, iP+1, iAlto);
        }
    }

    public static void mergeSort(int v[]){
        if (v.length > 1){
            int t1 = v.length/2;
            int t2 = v.length-t1;
            int v1[] = new int [t1];
            int v2[] = new int [t2];

            for (int i = 0; i < t1; i++) {
                v1[i] = v[i];
            }
            for (int i = t1; i < (t1+t2); i++) {
                v2[i-t1] = v[i];
            }
            mergeSort(v1);
            mergeSort(v2);
            merge(v, v1, v2);
        }
    }

    public static void merge (int w[], int w1[], int w2[]) {
        int i = 0, j = 0, k = 0;

        while (w1.length != j && w2.length != k) {
            if (w1[j] <= w2[k]) {
                w[i] = w1[j];
                i++;
                j++;
            } else {
                w[i] = w2[k];
                i++;
                k++;
            }
        }
        while (w1.length != j) {
            w[i] = w1[j];
            i++;
            j++;
        }
        while (w2.length != k) {
            w[i] = w2[k];
            i++;
            k++;
        }
    }
}
