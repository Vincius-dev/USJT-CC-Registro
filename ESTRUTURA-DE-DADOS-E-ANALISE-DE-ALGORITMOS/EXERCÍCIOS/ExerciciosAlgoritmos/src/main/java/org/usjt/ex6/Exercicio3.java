package org.usjt.ex6;

public class Exercicio3 {
    //03) Implemente uma classe FilaDePrioridade que implemente uma fila de prioridade de três níveis usando três
    // filas para controlar cada prioridade. A classe deve ter um método para incluir elementos na fila de prioridade
    // e outro método para retirar elementos de acordo com a maior prioridade.

    public static class FilaPrior {

        private FilaChar f1, f2, f3;

        FilaPrior(int tamanho){
            f1 = new FilaChar(tamanho);
            f2 = new FilaChar(tamanho);
            f3 = new FilaChar(tamanho);
            // Código para criar as filas f1, f2 e f3 segundo tamanho indicado
        }

        boolean isfull() {
            // Retorna verdadeiro se uma das três filas está cheia
            if (f1.isfull() || f2.isfull() || f3.isfull()){
                return true;
            }
            return false;
        }

        boolean isempty() {
            // Retorna verdadeiro se as três filas estiverem vazias
            if (f1.isempty() && f2.isempty() && f3.isempty()){
                return true;
            }
            return false;
        }

        void inclui(char elem, int prior){
            // Código que inclui o elemento "elem" na fila correta segundo a prioridade informada.
            if (prior == 1){
                f1.store(elem);
            } else if (prior == 2) {
                f2.store(elem);
            } else if (prior == 3) {
                f3.store(elem);
            }
        }

        char retira(){
            // Código que retira o elemento existente de maior prioridade.
            if (!f1.isempty()){
                return f1.retrieve();

            } else if (!f2.isempty()){
                return f2.retrieve();

            } else if (!f3.isempty()) {
                return f3.retrieve();
            }
            return ' ';
        }

        public static void main(String[] args) {
            System.out.println("criando uma fila de Prioridades com 5 elementos em cada prioridade...");
            FilaPrior fp1 = new FilaPrior(5);
            System.out.println("verificando status da fila...");
            System.out.println("esta vazia? "+fp1.isempty());
            System.out.println("esta cheia? "+fp1.isfull());
            System.out.println("incluindo o caractere A na prioridade 2...");
            fp1.inclui('A',2);
            System.out.println("verificando status da fila...");
            System.out.println("esta vazia? "+fp1.isempty());
            System.out.println("esta cheia? "+fp1.isfull());
            System.out.println("incluindo o caractere B na prioridade 1...");
            fp1.inclui('B',1);
            System.out.println("incluindo o caractere C na prioridade 3...");
            fp1.inclui('C',3);
            System.out.println("incluindo o caractere D na prioridade 3...");
            fp1.inclui('D',3);
            System.out.println("incluindo o caractere E na prioridade 1...");
            fp1.inclui('E',1);
            System.out.println("incluindo o caractere F na prioridade 2...");
            fp1.inclui('F',2);
            System.out.println("incluindo o caractere G na prioridade 1...");
            fp1.inclui('G',1);
            System.out.println("realizando  retrieves na sequencia...");
            System.out.println(fp1.retira());
            System.out.println(fp1.retira());
            System.out.println(fp1.retira());
            System.out.println(fp1.retira());
            System.out.println(fp1.retira());
            System.out.println(fp1.retira());
            System.out.println(fp1.retira());
            System.out.println("verificando status da fila...");
            System.out.println("esta vazia? "+fp1.isempty());
            System.out.println("esta cheia? "+fp1.isfull());
        }

    }
}
