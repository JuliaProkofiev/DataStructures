package ListaEncadeada;

public class ListaEncadeada {
        private static Node Lista;
        private static Node No;
        private static Node NodeActual;
        private static Node UltimoNode;

            private ListaEncadeada(){
                Lista = null;
            }

        // vazia(): verifica se a lista está vazia;
        private static boolean vazia(){
            return Lista == null;
        }

        //inserePrimeiro(int info): insere o elemento info como primeiro na Lista;
        private static void inserePrimeiro(int info){
            if (vazia()) {
                Node PrimeiroNode = new Node(info);
                Lista = PrimeiroNode;
            }else{
                Node PrimeiroNode = new Node(info);
                PrimeiroNode.InsereElemento(info);
                PrimeiroNode.InsereProximo(Lista);
                Lista = PrimeiroNode; //se a Lista não está vazia então o nó será ligado ao primeiro elemento dela.
            }
        }

        //insereDepois(Node node, int info): insere o elemento info depois do nó node;
        private static void insereDepois(Node node, int info){
            if(!vazia()){
                No = node;
                No.InsereElemento(info);
                Lista.InsereProximo(No);
                NodeActual = No;
                NodeActual = NodeActual.Proximo();
            }else{
                inserePrimeiro(info);
            }
        }

        //insereUltimo(int info): insere o elemento info como último na Lista;
        private static void insereUltimo(int info){
            if(!vazia()){
                UltimoNode = new Node(info);
                NodeActual.InsereProximo(UltimoNode);
            }else{
                inserePrimeiro(info);
            }
        }

        //Ordenado: função auxiliar
        private static boolean Ordenado() {
            Node Ordem = Lista;
            Node Antes;
            Node Depois;
            while (Ordem.Proximo() != null) {

                Antes = Ordem.Proximo();
                Ordem = Ordem.Proximo();
                Depois = Ordem.Proximo();

                if (Antes.Elemento() > Depois.Elemento()) {
                    return false;
                }
            }
            return true;
        }

        //insereOrdenado(int info): insere o elemento info de maneira ordenada na Lista;
        private static void insereOrdenado(int info){
            if(vazia()){
                inserePrimeiro(info);
            } else {
                if(Ordenado()){
                    NodeActual = Lista;
                    Node NodeAnterior;
                    while(true){
                        NodeAnterior = NodeActual;
                        NodeActual = Lista.Proximo();
                        if (NodeActual.Proximo() == null) {
                            NodeActual.InsereProximo(UltimoNode);
                            break;
                        }else {
                            if(NodeActual.Elemento() >= info && NodeAnterior.Elemento() <= info){
                                Lista.InsereProximo(NodeActual);
                                NodeAnterior.InsereProximo(Lista);
                                break;
                            }
                        }
                    }
                }else {
                    System.out.println("A lista não está ordenada, não é possivel inserir " + info);
                }
            }
        }

        //imprime(): imprime todos os elementos da Lista;
        public static void imprime(){
            System.out.print(Lista);
        }

        //removePrimeiro(): remove o primeiro elemento da Lista, e retorna o node removido.
        public Node removePrimeiro(){
            if(!vazia()){
                Node PrimeiroNode = new Node(Lista.Elemento());
                PrimeiroNode.InsereElemento(Lista.Elemento());
                PrimeiroNode.InsereProximo(Lista.Proximo());
                Lista = Lista.Proximo();
                return PrimeiroNode;
            }
            return null;
        }

        //removeUltimo(): remove o último elemento da Lista, e retorna o node removido.
        public Node removeUltimo(){
            if(!vazia()) return UltimoNode;
            return null;
        }

        //remove (Node no): remove o node da Lista, e retorna o node removido.
        public Node remove(Node no){
            if(!vazia()){
                NodeActual = Lista;
                Node Anterior = NodeActual;

                while (NodeActual != null) {
                    if (NodeActual.Elemento() == no.Elemento()) {
                        Node Removido = new Node(NodeActual.Elemento());
                        Removido.Proximo();

                        if (Anterior == NodeActual) {
                            Lista = Lista.Proximo();
                        }
                        else {
                            Anterior.Proximo();
                        }

                        return Removido;
                    }

                    Anterior = NodeActual;
                    NodeActual = NodeActual.Proximo();
                }
            }

            return null;
        }

        public static void main(String[] args){
            ListaEncadeada Teste = new ListaEncadeada();
            Teste.insereOrdenado(12);
            Teste.insereOrdenado(18);
            Teste.insereOrdenado(39);
            Teste.insereOrdenado(41);
            Teste.insereOrdenado(64);
            Teste.insereOrdenado(58);
            imprime();
        }

}