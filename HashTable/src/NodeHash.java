
public class NodeHash {
    private int data;
    private NodeHash next;

    public NodeHash(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void insert(int newData) {
        if (this.data == -1) {
            this.data = newData;
        } else {
            // Traverse to the end of the linked list
            NodeHash current = this;
            while (current.next != null) {
                current = current.next;
            }
            // Append the new node at the end
            current.next = new NodeHash(newData);
        }
    }

    public boolean search(int searchData) {
        NodeHash current = this;
        while (current != null) {
            if (current.data == searchData) {
                return true; // Data found
            }
            current = current.next; // Move to the next node
        }
        return false; // Data not found in this chain
    }

    public String print() {
        if(next != null) {
            return next.print();
        }
        return "[]";
    }
}
