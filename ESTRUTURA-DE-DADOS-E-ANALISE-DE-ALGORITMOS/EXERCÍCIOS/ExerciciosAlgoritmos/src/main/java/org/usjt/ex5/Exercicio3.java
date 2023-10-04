package org.usjt.ex5;

import java.util.Arrays;
import java.util.Random;

public class Exercicio3 {
    static int contadorVerifQuick = 0;
    static int contadorVerifMerge = 0;

    public static void main(String[] args) {

        int[] listaQuickSort = new int[50];
        int[] listaMergeSort = new int[50];

        preencheAleatorio(listaQuickSort, 1000);
        preencheAleatorio(listaMergeSort, 1000);

        System.out.println("Quick Sort:");

        System.out.println("Antes:");
        System.out.println(Arrays.toString(listaQuickSort));

        quickSort(listaQuickSort, 0, listaMergeSort.length-1);

        System.out.println("Depois:");
        System.out.println(Arrays.toString(listaQuickSort));
        System.out.println("Numero de atribuições: "+ contadorVerifQuick);

        System.out.println("Merge Sort:");
        System.out.println("Antes:");
        System.out.println(Arrays.toString(listaMergeSort));

        mergeSort(listaMergeSort);

        System.out.println("Depois:");
        System.out.println(Arrays.toString(listaMergeSort));
        System.out.println("Numero de atribuições: "+ contadorVerifMerge);
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
            contadorVerifQuick++;
            while((iVet[iAlto] >= iPivot) && (iBaixo < iAlto)){
                contadorVerifQuick++;
                iAlto--;
            }
            if(iBaixo != iAlto){
                contadorVerifQuick++;
                iVet[iBaixo]=iVet[iAlto];
                iBaixo++;
            }
            while ((iVet[iBaixo] <= iPivot) && (iBaixo < iAlto)){
                contadorVerifQuick++;
                iBaixo++;
            }
            if (iBaixo != iAlto){
                contadorVerifQuick++;
                iVet[iAlto]=iVet[iBaixo];
                iAlto--;
            }
        }
        iVet[iBaixo]=iPivot;
        iP=iBaixo;
        iBaixo=iB;
        iAlto=iA;
        if(iBaixo < iP){
            contadorVerifQuick++;
            quickSort(iVet, iBaixo, iP-1);
        }
        if (iAlto > iP){
            contadorVerifQuick++;
            quickSort(iVet, iP+1, iAlto);
        }
    }

    public static void mergeSort(int v[]){
        if (v.length > 1){
            contadorVerifMerge++;
            int t1 = v.length/2;
            int t2 = v.length-t1;
            int v1[] = new int [t1];
            int v2[] = new int [t2];

            for (int i = 0; i < t1; i++) {
                v1[i] = v[i];
                contadorVerifMerge++;
            }
            for (int i = t1; i < (t1+t2); i++) {
                v2[i-t1] = v[i];
                contadorVerifMerge++;
            }
            mergeSort(v1);
            mergeSort(v2);
            merge(v, v1, v2);
        }
    }

    public static void merge (int w[], int w1[], int w2[]) {
        int i = 0, j = 0, k = 0;

        while (w1.length != j && w2.length != k) {
            contadorVerifMerge++;
            if (w1[j] <= w2[k]) {
                w[i] = w1[j];
                contadorVerifMerge++;
                i++;
                j++;
            } else {
                w[i] = w2[k];
                contadorVerifMerge++;
                i++;
                k++;
            }
        }
        while (w1.length != j) {
            w[i] = w1[j];
            contadorVerifMerge++;
            i++;
            j++;
        }
        while (w2.length != k) {
            w[i] = w2[k];
            contadorVerifMerge++;
            i++;
            k++;
        }
    }
}
