package Fila;

class Fila {
    private static int primeiro;
    private static int ultimo;
    private static int[] dados;
    private static int MAX;
    static int qElementos;

    Fila(int max) {
        inicializa(max);
    }

    private static void inicializa(int max) {
        MAX = max;
        qElementos = 0;
        primeiro = 0;
        ultimo = 0;
        dados = new int[max];
    }

    static boolean cheia() {
        return qElementos == MAX;
    }

    static boolean vazia() {
        return qElementos  == 0;
    }

    static void insere(int E) {
        if (!cheia()) {
            if (ultimo == 0) {
                dados[ultimo] = E;
                qElementos++;
                ultimo++;
            }else {
                if (ultimo < MAX) {
                    dados[ultimo] = E;
                    ultimo++;
                    qElementos++;
                }
            }
        } else {
            System.out.print("Lista Cheia! Remova para inserir " + E);
            System.out.println(" ");
        }
    }

    static void remove() {
        if (!vazia()) {
            if (primeiro < MAX) {
                System.out.print("Elemento " + dados[primeiro] + " removido!");
                System.out.println(" ");
                dados[primeiro] = dados[primeiro + 1];
            } else {
                primeiro = 0;
                dados[primeiro] = dados[primeiro + 1];
            }
            for (int g = primeiro + 1; g < MAX - 1; g++) {
                dados[g] = dados[g + 1];
            }
            qElementos--;
            primeiro++;
        } else {
            System.out.print("Lista vazia! Não há elementos para remover");
            System.out.println(" ");
        }
    }

    static void imprimir(){
        System.out.print("Fila: ");
        for(int i=0;i<MAX;i++){
            if(i<MAX-1) {
                System.out.print(dados[i] + " <== ");
            }else{
                System.out.print(dados[i]);
            }
        }
        System.out.println(" ");
    }

    int Elemento(int IndexElemento){
        return dados[IndexElemento];
    }

    int QElementos(){
        return qElementos;
    }

//    public static void main(String[] args){
//        inicializa(5);
//        insere(1);
//        insere(2);
//        insere(4);
//        imprimir();
//        insere(3);
//        imprimir();
//        remove();
//        imprimir();
//    }
}
