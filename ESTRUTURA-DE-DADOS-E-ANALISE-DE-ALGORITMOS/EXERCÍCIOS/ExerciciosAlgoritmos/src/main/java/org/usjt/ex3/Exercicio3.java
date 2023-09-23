package org.usjt.ex3;

public class Exercicio3 {
    public static void main(String[] args){
        //03) Alterar o algoritmo de busca binária para que ele funcione com os elementos do vetor em ordem decrescente.

        int[] vetorDeInteirosDecrescente = {100, 90, 80, 70, 60, 50, 40, 30, 20, 10};
        int indice = 0;
        int chaveDeBusca = 80;

        System.out.println("Busca binaria: "+buscaBinariaDecrescente(
                vetorDeInteirosDecrescente,
                chaveDeBusca
        ));
    }

    public static int buscaBinariaDecrescente(int iVet[], int iK){

        int iBaixo, iAlto, iMeio;

        iBaixo = 0;
        iAlto=iVet.length-1;
        while (iBaixo <= iAlto){
            iMeio=(iBaixo+iAlto)/2;

            System.out.println(iMeio);

            if (iK > iVet[iMeio]) iAlto=iMeio-1;
            else if(iK < iVet[iMeio]) iBaixo=iMeio+1;
            else return iMeio;
        }
        return -1;
    }
}
