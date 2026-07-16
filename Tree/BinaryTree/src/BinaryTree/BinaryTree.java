package BinaryTree;

public class BinaryTree {
    private static Node node;
    private static Node root;

    //Constructor
    private BinaryTree(){
        node = null;
        root = null;
    }

    private Node minimumElement(Node node) {
        Node minimum = null;
        while(node != null) {
            minimum = node;
            node = node.getLeft();
        }
        return minimum;
    }

    //Insert Into
    private static Node insert(int element, Node node){
        if (node == null) {
            node = new Node(element);
        } else {
            if (element >= node.getElement()) {
                node.insertRight(insert(element, node.getRight()));
                //node = node.Direita();
            } else {
                node.insertLeft(insert(element, node.getLeft()));
                //node = node.Esquerda();
            }
        }
        return node;
    }

    private static void insertRoot(int element){
        root = insert(element, new Node());
    }

    //2. Implemente algoritmos para percorrer uma árvore binária nas formas pré-ordem, in-ordem e pós-ordem.
    private static void PreOrdem(Node a){
        //ordem: "RED";
        if(a  != null){
            System.out.println(a.Elemento());
            PreOrdem(a.Esquerda());
            PreOrdem(a.Direita());
        }
    }

    private static void InOrdem(Node a){
        // ordem: "ERD";
        if(a != null){
            InOrdem(a.Esquerda());
            System.out.println(a.Elemento());
            InOrdem(a.Direita());
        }
    }

    private static void PosOrdem(Node a){
        //ordem: "EDR"
        if(a != null){
            PosOrdem(a.Esquerda());
            PosOrdem(a.Direita());
            System.out.println(a.Elemento());
        }
    }

    private static void Ordem(Node a, String ordem){
        switch(ordem){
            case "RED":
                PreOrdem(a);
            case "ERD":
                InOrdem(a);
            case "EDR":
                PosOrdem(a);
        }
    }


    //3. Implemente um algoritmo para remover o maior elemento de uma árvore binária de busca.
    private static Node MaiorElemento_remove(Node a) {
        if (a == null) {
            return null;
        } else {
            if (a.Direita() == null) {
                return a.Esquerda();
            } else {
                Node maior = a.Direita();
                a.InsereDireita(MaiorElemento_remove(maior));
                return a;
            }
        }
    }

    //4. Implemente um algoritmo para remover o menor elemento de uma árvore binária de busca.
    private Node MenorElemento_remove (Node a) {
        if(a == null) {
            return null;
        } else{
            if(a.Esquerda() == null) {
            return a.Direita();
        } else {
            a.InsereEsquerda(MenorElemento_remove(a.Esquerda()));
            return a;
        }
    }
}
    //5. Implemente um algoritmo que remova um determinado elemento com valor N da árvore.
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

//        public static void main(String[] args) {
//            InserirRaiz(12);
//            InserirRaiz(18);
//            InserirRaiz(9);
//            Ordem(raiz, "EDR");
//        }
}
