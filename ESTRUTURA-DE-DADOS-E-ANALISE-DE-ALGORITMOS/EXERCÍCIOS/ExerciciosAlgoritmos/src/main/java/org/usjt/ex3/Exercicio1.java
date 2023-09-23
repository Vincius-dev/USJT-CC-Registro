package org.usjt.ex3;

public class Exercicio1 {

    public static void main(String[] args){
        //01) Apresente a classe em que testou os algoritmos de busca linear e busca binária

        int[] vetorDeInteirosCrescente = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int indice = 0;
        int chaveDeBusca = 80;

        System.out.println("Busca linear: "+ buscaLinearCrescente(
                vetorDeInteirosCrescente,
                indice,
                chaveDeBusca
        ));

        System.out.println("Busca binaria: "+buscaBinariaCrescente(
                vetorDeInteirosCrescente,
                chaveDeBusca
        ));
    }

    public static int buscaBinariaCrescente(int iVet[], int chaveBusca){

        int iBaixo, iAlto, iMeio;

        iBaixo = 0;
        iAlto=iVet.length-1;
        while (iBaixo <= iAlto){
            iMeio=(iBaixo+iAlto)/2;

            System.out.println(iMeio);

            if (chaveBusca < iVet[iMeio]) iAlto=iMeio-1;
            else if(chaveBusca > iVet[iMeio]) iBaixo=iMeio+1;
            else return iMeio;
        }
        return -1;
    }

    public static int buscaLinearCrescente(int lista[], int indice, int chaveBusca){

        System.out.println(indice);

        if ((indice <= lista.length-1) && (chaveBusca != lista[indice])){
            return buscaLinearCrescente(lista, indice+1, chaveBusca);
        }
        return indice;
    }
}
