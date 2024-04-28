package ArvoreAVL;

public class Node {
    private int info;
    Node Esquerda;
    Node Direita;

    public Node(int elemento){
        info = elemento;
        Direita = null;
        Esquerda = null;
    }
    public void InsereElemento(int elemento){
        info = elemento;
    }

    public int Elemento(){
        return info;
    }

    public void InsereDireita(Node direita){
        Direita = direita;
    }

    public void InsereEsquerda(Node esquerda){
        Esquerda = esquerda;
    }

    public Node Direita(){
        return Direita;
    }

    public Node Esquerda(){
        return Esquerda;
    }

    public boolean SemPais(){
        return Direita == null && Esquerda == null;
    }

    public boolean Pais(){
        return Direita != null && Esquerda != null;
    }

}
