package BinaryTree;

public class Node {
    private int element;
    private Node left;
    private Node right;

    public Node(int element){
        this.element = element;
        right = null;
        left = null;
    }
    public void insertElement(int element){
        this.element = element;
    }

    public int getElement(){
        return this.element;
    }

    public void insertRight(Node right){
        this.right = right;
    }

    public void insertLeft(Node left){
        this.left = left;
    }

    public Node getRight(){
        return this.right;
    }

    public Node getLeft(){
        return this.left;
    }

    public boolean Parents(){
        return this.right == null && this.left == null;
    }

}


