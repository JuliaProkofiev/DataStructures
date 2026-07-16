package SinglyLinkedList;

public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    private boolean isEmpty() {
        return head == null;
    }

    // insertFirst(int element): Inserts the element at the beginning of the list
    public void insertFirst(int element) {
        Node newNode = new Node(element);
        if (!isEmpty()) {
            newNode.setNext(head);
        }
        head = newNode;
    }

    // insertAfter(Node node, int element): Inserts the element after the given node
    public void insertAfter(Node node, int element) {
        if (!isEmpty()) {
            Node newNode = new Node(element);
            newNode.setNext(node.getNext());
            node.setNext(newNode);
        } else {
            insertFirst(element);
        }
    }

    // insertLast(int element): Inserts the element at the end of the list
    public void insertLast(int element) {
        if (isEmpty()) {
            insertFirst(element);
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Node(element));
        }
    }

    // isSorted(): Helper function to check if the list is sorted
    private boolean isSorted() {
        if (isEmpty() || head.getNext() == null) {
            return true;
        }

        Node current = head;
        while (current.getNext() != null) {
            if (current.getElement() > current.getNext().getElement()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    // insertSorted(int element): Inserts the element in a sorted manner
    public void insertSorted(int element) {
        if (isEmpty()) {
            insertFirst(element);
        } else if (isSorted()) {
            Node current = head;
            Node previous = null;

            while (current != null && current.getElement() < element) {
                previous = current;
                current = current.getNext();
            }

            Node newNode = new Node(element);
            if (previous == null) {
                newNode.setNext(head);
                head = newNode;
            } else {
                newNode.setNext(current);
                previous.setNext(newNode);
            }
        } else {
            System.out.println("The list is not sorted. Cannot insert " + element);
        }
    }

    // print(): Prints all elements in the list
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getElement() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    // removeFirst(): Removes the first element and returns it
    public Node removeFirst() {
        if (!isEmpty()) {
            Node removedNode = head;
            head = head.getNext();
            removedNode.setNext(null);
            return removedNode;
        }
        return null;
    }

    // removeLast(): Removes the last element and returns it
    public Node removeLast() {
        if (isEmpty()) {
            return null;
        }

        if (head.getNext() == null) {
            Node removedNode = head;
            head = null;
            return removedNode;
        }

        Node current = head;
        Node previous = null;

        while (current.getNext() != null) {
            previous = current;
            current = current.getNext();
        }

        previous.setNext(null);
        return current;
    }

    // remove(Node node): Removes the specified node and returns it
    public Node remove(Node node) {
        if (!isEmpty()) {
            Node current = head;
            Node previous = null;

            while (current != null) {
                if (current.getElement() == node.getElement()) {
                    if (previous == null) {
                        head = current.getNext();
                    } else {
                        previous.setNext(current.getNext());
                    }
                    current.setNext(null);
                    return current;
                }
                previous = current;
                current = current.getNext();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertSorted(12);
        list.insertSorted(18);
        list.insertSorted(39);
        list.insertSorted(41);
        list.insertSorted(64);
        list.insertSorted(58);
        list.print();
    }
}