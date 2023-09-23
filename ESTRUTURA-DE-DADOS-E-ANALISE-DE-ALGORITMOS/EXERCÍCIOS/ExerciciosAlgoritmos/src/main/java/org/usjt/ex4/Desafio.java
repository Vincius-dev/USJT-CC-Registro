package org.usjt.ex4;

import java.util.Arrays;
import java.util.Random;

public class Desafio {

    //05) Desafio: Tente implementar o método  SectionSort de forma recursiva.

    public static void main(String[] args){

        int[] listaAleatoria = new int[1000];

        preencheAleatorio(listaAleatoria, 300000);

        int[] listaPreenchidaSelecao = Arrays.copyOf(listaAleatoria, listaAleatoria.length);

        long tempoInicialMili = System.currentTimeMillis();
        long tempoInicialNano = System.nanoTime();

        OrdenacaoSelecaoRecursiva(listaPreenchidaSelecao, 0);

        long tempoFinalMili = System.currentTimeMillis();
        long tempoFinalNano= System.nanoTime();
        long tempoDecorridoMili = tempoFinalMili - tempoInicialMili;
        long tempoDecorridoNano = tempoFinalNano - tempoInicialNano;

        System.out.println("Tempo decorrido milisegundos : "+ tempoDecorridoMili);
        System.out.println("Tempo decorrido nanosegundos : "+ tempoDecorridoNano);

        String listaInicial = "Lista: ";
        for (int numero : listaAleatoria) {
            listaInicial = listaInicial + numero + ",";
        }
        System.out.println(listaInicial);

        String listaFinalSelecao = "";
        for (int numero : listaPreenchidaSelecao) {
            listaFinalSelecao = listaFinalSelecao + numero + ",";
        }
        System.out.println("Ordenada Seleção: "+ listaFinalSelecao);
    }

    public static void preencheAleatorio (int []v, int max) {
        Random r = new Random ();
        for (int i = 0; i < v.length; i++)
            v[i] = r.nextInt (max + 1);
    }

    public static void OrdenacaoSelecaoRecursiva(int[] iVet, int iA) {
        if (iA == iVet.length - 1) {
            return;
        }
        int iC = iA;
        for (int iB = iA + 1; iB < iVet.length; iB++) {
            if (iVet[iB] < iVet[iC]) {
                iC = iB;
            }
        }
        int iT = iVet[iA];
        iVet[iA] = iVet[iC];
        iVet[iC] = iT;
        OrdenacaoSelecaoRecursiva(iVet, iA + 1);
    }

}
