package org.usjt.ex3;

public class Exercicio2 {

    public static void main(String[] args){
        //02) Alterar o algoritmo de busca linear para ele procurar um elemento a partir dos últimos elementos.

        int[] vetorDeInteirosCrescente = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int indice = vetorDeInteirosCrescente.length-1;
        int chaveDeBusca = 10;

        System.out.println("Busca linear: "+ buscaLinearDecrescente(
                vetorDeInteirosCrescente,
                indice,
                chaveDeBusca
        ));
    }

    public static int buscaLinearDecrescente(int lista[], int indice, int chaveBusca){

        System.out.println(indice);

        if ((indice >= 0) && (chaveBusca != lista[indice])){
            return buscaLinearDecrescente(lista, indice-1, chaveBusca);
        }
        return indice;
    }
}
