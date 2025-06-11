
public class HashTable {
    // Array to store the heads of linked lists (chains) for collision handling
    private NodeHash[] table;
    private int collisionCount; // Counts initial collisions at an index
    private int totalElements;  // Total number of elements inserted into the table

    public HashTable(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Table size must be greater than 0.");
        }
        this.table = new NodeHash[size]; // Initialize the array of NodeHash
        this.collisionCount = 0;
        this.totalElements = 0;
        initializeTable(); // Call the initialization method
    }

    private void initializeTable() {
        for (int i = 0; i < table.length; i++) {
            table[i] = new NodeHash(-1);
        }
    }

    private int _hash(int key) {
        // Ensures the hash is always positive and within bounds of the table array
        return Math.abs(key % table.length);
    }

    public void insert(int key) {
        int hash = _hash(key); // Get the hash index

        // Check if the initial spot at this hash index is already occupied by a real element
        if (table[hash].getData() != -1) {
            collisionCount++; // Increment collision count
        }

        // Delegate the actual insertion (handling chaining) to the NodeHash at that index
        table[hash].insert(key);
        totalElements++; // Increment total elements count
    }

    public void fillTable() {
        int rand;
        // Insert up to 90% of the table's capacity to test collisions
        int maxToInsert = (int) (table.length * 0.9);
        System.out.println("Filling table with " + maxToInsert + " random elements...");
        for (int i = 0; i < maxToInsert; i++) {
            rand = (int) (Math.random() * 1000000); // Generate a random key
            insert(rand);
        }
    }


    public void print() {
        System.out.println("\n--- HashTable Contents ---");
        System.out.println("Index | Data (Chain)");
        System.out.println("--------------------");
        for (int i = 0; i < table.length; i++) {
            // Format output based on whether the bucket's head is the placeholder -1
            if (table[i].getData() == -1) {
                System.out.printf("%-5d | %s%n", i, table[i].getData()); // Print just -1 if empty
            } else {
                System.out.printf("%-5d | %s%n", i, table[i].print()); // Print the full chain
            }
        }
        System.out.println("--------------------");
    }


    public boolean search(int data) {
        int hash = _hash(data); // Get the hash index
        // Delegate the search to the NodeHash chain at that index
        return table[hash].search(data);
    }

    public int getCollisionCount() {
        return collisionCount;
    }

    public int getTotalElements() {
        return totalElements;
    }

    /**
     * Main method for testing the HashTable implementation.
     */
    public static void main(String[] args) {
        // Create a HashTable with a size of 10
        HashTable myHashTable = new HashTable(10);

        // Fill the table with random elements
        myHashTable.fillTable();
        myHashTable.print();

        System.out.println("Total elements inserted: " + myHashTable.getTotalElements());
        System.out.println("Total initial collisions: " + myHashTable.getCollisionCount());
        System.out.println("Load Factor (Elements / Table Size): " +
                (double) myHashTable.getTotalElements() / myHashTable.table.length);

        // --- Test specific insertions ---
        System.out.println("\n--- Testing specific insertions ---");
        System.out.println("Inserting 5 into the table...");
        myHashTable.insert(5); // Should go to index 5 (5 % 10 = 5)
        System.out.println("Inserting 15 into the table...");
        myHashTable.insert(15); // Should also go to index 5 (15 % 10 = 5), causing a collision
        System.out.println("Inserting 25 into the table...");
        myHashTable.insert(25); // Should also go to index 5 (25 % 10 = 5), causing another collision
        myHashTable.print();

        System.out.println("Total elements after specific insertions: " + myHashTable.getTotalElements());
        System.out.println("Total initial collisions after specific insertions: " + myHashTable.getCollisionCount());

        // --- Test search operations ---
        System.out.println("\n--- Testing search operations ---");
        int search1 = 5;
        System.out.println("Searching for " + search1 + ": " + myHashTable.search(search1)); // Should be true

        int search2 = 15;
        System.out.println("Searching for " + search2 + ": " + myHashTable.search(search2)); // Should be true

        int search3 = 99;
        System.out.println("Searching for " + search3 + ": " + myHashTable.search(search3)); // Depends on random fill, possibly true/false

        int search4 = 100;
        System.out.println("Searching for " + search4 + ": " + myHashTable.search(search4)); // Should be false (unless random inserted 100)

        // Find a random element that was inserted (assuming it's still there)
        // Note: For actual testing, you might store the random numbers inserted to ensure a hit.
        // For demonstration, let's pick a number likely to be in the chain at index 5.
        System.out.println("Searching for 25: " + myHashTable.search(25)); // Should be true

        // Let's try searching for a number that definitely wasn't inserted by random fill
        // and doesn't collide with existing specific insertions
        System.out.println("Searching for 99999: " + myHashTable.search(99999)); // Should be false
    }
}
