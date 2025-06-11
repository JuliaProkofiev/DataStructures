package Fila;

public class Merge {
    private static Fila A;
    private static Fila B;
    private static Fila C;
    private static int MAX;
    private int A_length;
    private int B_length;

    //Junção de Lista() e Ordenada(), coloca os elementos do vetor int[] ordenados na Fila C.
    private Fila ListasOrdenadas(Fila A, Fila B) {
        int[] lista = new int[MAX];
        int EL;
        int j = 0;
        int i = 0;
        for (EL = 0; EL < MAX - 1; EL++) {
            if (i < A_length && j < B_length) {
                int A_Ele = A.Elemento(i);
                int B_Ele = B.Elemento(j);
                if (A_Ele < B_Ele) {
                    lista[EL] = B_Ele;
                    lista[EL + 1] = A_Ele;
                    j++;
                    i++;
                } else {
                    lista[EL] = A_Ele;
                    lista[EL + 1] = B_Ele;
                    j++;
                    i++;
                }
            } else {
                int A_Ele = A.Elemento(i);
                int B_Ele = B.Elemento(j);
                if (A_Ele < B_Ele) {
                    lista[EL] = B_Ele;
                    lista[EL + 1] = A_Ele;
                    j++;
                } else {
                    lista[EL] = A_Ele;
                    lista[EL + 1] = B_Ele;
                    i++;
                }
            }
        }
        if (!C.cheia()) {
            for (int c = 0; c < MAX; c++) {
                C.insere(lista[c]);
            }
        }
        return C;
    }

    //Construtor
    private Merge(Fila a, Fila b){
        A = a;
        B = b;
        A_length = A.QElementos();
        B_length = B.QElementos();
        MAX = A.QElementos() + B.QElementos();
        C = new Fila(MAX);
        ListasOrdenadas(A,B);
    }

    public static void main (String[] args){
        A = new Fila(3);
        A.insere(12);
        A.insere(18);
        A.insere(39);
        A.imprimir();

        B = new Fila(3);
        B.insere(41);
        B.insere(58);
        B.insere(64);
        B.imprimir();

        Merge teste = new Merge(A,B);
        C.imprimir();
    }
}
