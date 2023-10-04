package org.usjt.ex6;

import java.util.Arrays;

public class Pilha {

    private int iTamanho;
    private char iPilha[];
    public int iPosicaoPonteiro;

    public Pilha(int tamanhoDaPilha) {
        iTamanho = tamanhoDaPilha;
        iPosicaoPonteiro = 0;
        iPilha = new char[iTamanho];
    }

    public int size(){
        return iPosicaoPonteiro;
    }

    public char top(){
        if (iPosicaoPonteiro == 0){
            return '?';
        } else {
            return iPilha[iPosicaoPonteiro - 1];
        }
    }

    public char push(char numeroParaAdicionar){
        if ( iPosicaoPonteiro >= iTamanho){
            return '?';
        } else {
            return iPilha[iPosicaoPonteiro++] = numeroParaAdicionar;
        }
    }

    public char pop(){
        if (iPosicaoPonteiro == 0){
            return '?';
        } else {
            return iPilha[--iPosicaoPonteiro];
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(iPilha);
    }
}