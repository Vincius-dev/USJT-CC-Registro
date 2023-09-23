package org.usjt.ex4;

import java.util.Arrays;
import java.util.Random;

public class Exercicio3 {

    public static void main(String[] args){
        //03) Usando o mesmo raciocínio do exercício anterior, altere os três métodos de ordenação do exercício B
        // para que eles RETORNEM agora a quantidade de COMPARAÇÕES realizadas com elementos do vetor. Verifique
        // o que acontece em cada um dos casos, aumentando o número de elementos e verificando o número de comparações.
        // Coloque aqui a classe resultante dos seus testes.

        int[] listaAleatoria = new int[1000];

        preencheAleatorio(listaAleatoria, 300000);

        int[] listaPreenchidaSelecao = Arrays.copyOf(listaAleatoria, listaAleatoria.length);
        int[] listaPreenchidaBubble = Arrays.copyOf(listaAleatoria, listaAleatoria.length);
        int[] listaPreenchidaInsercao = Arrays.copyOf(listaAleatoria, listaAleatoria.length);

        Selecao selecao = new Selecao();
        System.out.println("Algoritmo seleção:");
        testarAlgoritmo(listaPreenchidaSelecao, selecao);

        Bubble bubble = new Bubble();
        System.out.println("Algoritmo bubble:");
        testarAlgoritmo(listaPreenchidaBubble, bubble);

        Insercao insercao = new Insercao();
        System.out.println("Algoritmo inserção:");
        testarAlgoritmo(listaPreenchidaInsercao, insercao);

        String listaInicial = "Lista: ";
        for (int numero : listaAleatoria) {
            listaInicial = listaInicial + numero + ",";
        }
        System.out.println(listaInicial);
    }

    public static void preencheAleatorio (int []v, int max) {
        Random r = new Random ();
        for (int i = 0; i < v.length; i++)
            v[i] = r.nextInt (max + 1);
    }

    public static void testarAlgoritmo(int listaNaoOrdenada[], AlgoritmoOrdenacao tipoAlgoritmo){
        long tempoInicialMili = System.currentTimeMillis();
        long tempoInicialNano = System.nanoTime();

        System.out.println("N° de Comparações: "+ tipoAlgoritmo.realizaOrdenacao(listaNaoOrdenada));

        long tempoFinalMili = System.currentTimeMillis();
        long tempoFinalNano= System.nanoTime();
        long tempoDecorridoMili = tempoFinalMili - tempoInicialMili;
        long tempoDecorridoNano = tempoFinalNano - tempoInicialNano;

        System.out.println("Tempo decorrido milisegundos : "+ tempoDecorridoMili);
        System.out.println("Tempo decorrido nanosegundos : "+ tempoDecorridoNano);
    }

    public interface AlgoritmoOrdenacao {
        int realizaOrdenacao(int iVet[]);
    }

    public static class Selecao implements AlgoritmoOrdenacao {
        @Override
        public int realizaOrdenacao(int[] iVet) {
            int iA, iB, iC;
            int iT;
            int contadorDeComparacoes = 0;

            for (iA=0; iA < iVet.length-1; iA++){
                iC=iA;
                iT=iVet[iA];
                for (iB=iA+1; iB < iVet.length; iB++){
                    if (iVet[iB] < iT){
                        iC=iB;
                        iT=iVet[iB];
                        contadorDeComparacoes++;
                    }
                }
                iVet[iC]=iVet[iA];
                iVet[iA]=iT;
            }

            return contadorDeComparacoes;
        }
    }

    public static class Bubble implements AlgoritmoOrdenacao {

        @Override
        public int realizaOrdenacao(int[] iVet) {
            int iA, iB;
            int iT;
            int contadorDeComparacoes = 0;

            for (iA=1; iA < iVet.length; iA++){
                for (iB=iVet.length-1; iB >= iA; iB--){
                    if (iVet[iB-1] > iVet[iB]){
                        iT=iVet[iB-1];
                        iVet[iB-1]=iVet[iB];
                        iVet[iB]=iT;
                        contadorDeComparacoes ++;
                    }
                }
            }
            return contadorDeComparacoes;
        }
    }

    public static class Insercao implements AlgoritmoOrdenacao {

        @Override
        public int realizaOrdenacao(int[] iVet) {
            int iA, iB;
            int iT;
            int contadorDeComparacoes = 0;

            for (iA=1; iA < iVet.length; iA++){
                iT=iVet[iA];
                iB=iA-1;
                while (iB >= 0 && iT < iVet[iB]){
                    iVet[iB+1]=iVet[iB];
                    iB--;
                    contadorDeComparacoes ++;
                }
                iVet[iB+1]=iT;
            }
            return contadorDeComparacoes;
        }
    }
}

