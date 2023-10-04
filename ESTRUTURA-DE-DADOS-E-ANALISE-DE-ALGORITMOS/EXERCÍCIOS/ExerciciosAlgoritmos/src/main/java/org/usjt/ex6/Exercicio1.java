package org.usjt.ex6;

import java.util.Scanner;

public class Exercicio1 {
    //01) Implemente um método chamado palindroma que receba uma string e use uma pilha para verificar se a string
    // é palíndroma retornando verdadeiro ou falso. Não é necessário postar a classe.
    // Coloque aqui como resposta só o método como public static.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("Informe uma palavra palindroma:");
            String palavra = sc.next();

            Pilha pilha = new Pilha(palavra.length());

            for (char n: palavra.toCharArray()) {
                pilha.push(n);
            }

            StringBuilder palavraInvertida = new StringBuilder();

            while (pilha.top() != '?'){
                palavraInvertida.append(pilha.pop());
            }

            System.out.println(palavraInvertida);

            if (palavraInvertida.toString().equals(palavra)){
                System.out.println("A palavra é um palindroma");
            } else {
                System.out.println("A palavra não é um palindroma");
            }

            System.out.println(pilha);
        }
    }
}
