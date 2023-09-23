package org.usjt.ex3;

public class Exercicio4 {

    public static void main(String[] args){
        //04) Alterar o algoritmo de busca linear para ele funcionar com vetores com elementos em ordem crescente
        // otimizando-o para que ele, ao encontrar um elemento maior do que o procurado sem achar o elemento, parar
        // a busca sem necessidade de ir até o final do vetor.

        int[] vetorDeInteirosCrescente = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int indice = 0;
        int chaveDeBusca = 35;

        System.out.println("Busca linear: "+ buscaLinearCrescente(
                vetorDeInteirosCrescente,
                indice,
                chaveDeBusca
        ));
    }

    public static int buscaLinearCrescente(int lista[], int indice, int chaveBusca){

        System.out.println(indice);

        if (chaveBusca < lista[indice]){
            return -1;
        }
        if ((indice <= lista.length-1) && (chaveBusca != lista[indice])){
            return buscaLinearCrescente(lista, indice+1, chaveBusca);
        }

        return indice;
    }
}
