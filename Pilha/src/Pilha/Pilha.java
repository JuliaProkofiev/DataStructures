package Pilha;

public class Pilha {
    private static int MAX;
    private static char[] pilha;
    private static int qExpressoes;

    Pilha(int max){
        MAX = max;
        criarPilha(MAX);
    }

    void criarPilha(int max) {
        qExpressoes = 0;
        pilha = new char[max];
    }

    static char Topo(){
        return pilha[qExpressoes-1];
    }

    static boolean Cheia(){
        return qExpressoes == MAX;
    }

    static boolean Vazia(){
        return pilha.length == 0;
    }

    static void insere (char E) {
        if (!Cheia()) {
            pilha[qExpressoes] = E;
            qExpressoes++;
        } else {
            System.out.print("Pilha Cheia! Remova para inserir" + E);
            System.out.println(" ");
        }

    }

    static void remove() {
        if(!Vazia()) {
            char Char_Pilha = pilha[qExpressoes-1];
            System.out.print("Elemento do topo: " + Char_Pilha  + " foi removido!");
            System.out.println(" ");
            pilha[qExpressoes-1] = '\u0000';
            qExpressoes--;
        } else{
            System.out.print("Lista vazia! Não ha elementos para remover");
            System.out.println(" ");
        }
    }

    static int QExpressoes(){
        System.out.println("Topo: " + pilha[qExpressoes-1]);
        System.out.println("Quantidade de Elementos: " + qExpressoes);
        return qExpressoes;
    }

//    public static void main(String[] args) {
//          new Pilha(5);
//          insere('3');
//          insere('7');
//          insere('D');
//          insere('F');
//          Topo();
//          remove();
//          Topo();
//          QExpressoes();
//    }
}
