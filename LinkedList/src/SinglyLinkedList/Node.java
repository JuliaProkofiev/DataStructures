package ListaEncadeada;

public class Node {
    private int elemento;
    private Node proximo;

    public Node(int elemento){
        this.elemento = elemento;
        this.proximo = null;
    }
    public void InsereElemento(int elemento){
        this.elemento = elemento;
    }

    public int Elemento(){
        return elemento;
    }

    public void InsereProximo(Node proximo) {
        this.proximo = proximo;
    }

    public Node Proximo(){
        return proximo;
    }
}
