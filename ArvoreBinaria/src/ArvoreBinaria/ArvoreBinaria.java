package ArvoreBinaria;

public class ArvoreBinaria {
    private static Node raiz;

    //Construtor
    private ArvoreBinaria(){
        raiz = null;
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

    //1. Implemente um algoritmo para inserir um elemento em uma árvore binária de busca.
    private static Node inserir(int info, Node a){
        if (a == null) {
            a = new Node(info);
        } else {
            if (info >= a.Elemento()) {
                a.InsereDireita(inserir(info, a.Direita));
                a.Direita();
            } else {
                a.InsereEsquerda(inserir(info, a.Esquerda));
                a.Esquerda();
            }
        }
        return a;
    }

    private static void InserirRaiz(int info){
        raiz = inserir(info, raiz);
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
