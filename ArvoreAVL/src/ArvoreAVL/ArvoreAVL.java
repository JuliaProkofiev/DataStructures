package ArvoreAVL;

public class ArvoreAVL {
    private static Node raiz;

    //Função Auxiliar: Verifica o Balanceamento da arvore AVL
    private static Boolean Balanceada(Node a){
        Boolean balanceada = false;
        int alturaEsquerda = Altura(a.Esquerda());
        int alturaDireita = Altura(a.Direita());
        int h = alturaEsquerda - alturaDireita;
        if(h == -1 || h == 1){
            balanceada = false;
        }else{
            balanceada = true;
        }
        return balanceada;
    }
    //1. Implemente um algoritmo para inserir um elemento em uma árvore AVL.
    private static Node inserir(int info, Node a){
        if (a == null) {
            a = new Node(info);
        } else {
            if(Balanceada(a)) {
                if (info >= a.Elemento()) {
                    a.InsereDireita(inserir(info, a.Direita));
                    a.Direita();
                } else {
                    a.InsereEsquerda(inserir(info, a.Esquerda));
                    a.Esquerda();
                }
            }
        }
        return a;
    }

    private static void InserirRaiz(int info){
        raiz = inserir(info, raiz);
    }

    //2. Implemente um algoritmo que remova um determinado elemento com valor N da árvore AVL.
    private Node ElementoN_remove (Node a, int elemento) {
        if(a == null) {
            return null;
        }

        if(elemento >= a.Elemento()) {
            a.InsereDireita(ElementoN_remove(a.Direita(), elemento));
        } else {
            a.InsereEsquerda(ElementoN_remove(a.Esquerda(), elemento));
        }

        if(a.Elemento() == elemento) {
            if (a.SemPais()) {
                return null;
            } else if (a.Pais()) {
                Node N = ElementoMinimo(a.Direita());
                ElementoN_remove(a, N.Elemento());
                a.InsereElemento(N.Elemento());
            } else if (a.Esquerda() == null) {
                return a.Direita();
            } else if (a.Direita() == null) {
                return a.Esquerda();
            }
        }
        return a;
    }

    //ElementoMinimo: Função Auxiliar
    private Node ElementoMinimo(Node m) {
        Node minimo = null;
        while(m != null) {
            minimo = m;
            m = m.Esquerda();
        }
        return minimo;
    }

    //3. Implemente um algoritmo que verifica se um determinado elemento com valor N existe na árvore AVL.
    private Node Buscar(int elemento){
        Node NodeActual = raiz;
        while(NodeActual != null && NodeActual.Elemento() != elemento){
            if(NodeActual.Elemento() > elemento){
                NodeActual = NodeActual.Esquerda();
            }else{
                NodeActual = NodeActual.Direita();
            }
        }
        return null;
    }

    // 4. Implemente algoritmos para percorrer uma árvore binária nas formas pré-ordem, in-ordem e pós-ordem.
    private void PreOrdem(Node a){
        //ordem: "RED";
        if(a  != null){
            System.out.println(a.Elemento());
            PreOrdem(a.Esquerda());
            PreOrdem(a.Direita());
        }
    }

    private void InOrdem(Node a){
        // ordem: "ERD";
        if(a != null){
            InOrdem(a.Esquerda());
            System.out.println(a.Elemento());
            InOrdem(a.Direita());
        }
    }

    private void PosOrdem(Node a){
        //ordem: "EDR"
        if(a != null){
            PosOrdem(a.Esquerda());
            PosOrdem(a.Direita());
            System.out.println(a.Elemento());
        }
    }

    private void Ordem(Node a, String ordem){
        switch(ordem){
            case "RED":
                PreOrdem(a);
            case "ERD":
                InOrdem(a);
            case "EDR":
                PosOrdem(a);
        }
    }

    // 5. Implemente um algoritmo que calcula a altura de uma árvore.
    private static int Altura(Node a) {
        if(a == null) {
            return 0;
        } else {
            int Esquerda = Altura(a.Esquerda());
            int Direita = Altura(a.Direita());

            if(Esquerda > Direita) {
                return Esquerda + 1;
            }
            return Direita + 1;
        }
    }
}
