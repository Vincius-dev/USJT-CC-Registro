package org.usjt.ex6;

import java.util.Scanner;

public class Exercicio2 {
    //02) Construa um método que receba uma string e retorne a string com as palavras invertidas palavra a palavra.
    // Veja o exemplo:
    //Recebe: "Fui para casa"
    //Retorna: "iuF arap asac"

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("Informe uma palavra ou frase para ser invertida:");
            String frase = sc.nextLine();
            String fraseFinal = "";

            String[] palavras = frase.split(" ");

            for (String palavra : palavras) {
                Pilha pilha = new Pilha(palavra.length());
                for (char n: palavra.toCharArray()) {
                    pilha.push(n);
                }

                StringBuilder palavraInvertida = new StringBuilder();

                while (pilha.top() != '?'){
                    palavraInvertida.append(pilha.pop());
                }

                fraseFinal += " "+ palavraInvertida;
            }
            System.out.println("Frase revertida:" + fraseFinal);
        }
    }
}
