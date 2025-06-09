# 📚 Data Structures & Sorting Algorithms in Java

## Foundations of Efficient Code

Data structures are fundamental building blocks in computer science, serving as specialized formats for organizing and storing data. Their primary purpose is to enable efficient access and modification, directly impacting the performance and scalability of algorithms and applications. Choosing the right data structure for a given problem is crucial for optimizing time and space complexity. This repository explores various data structures and essential sorting algorithms implemented in Java, showcasing their practical application and underlying principles.

---

## Common Data Structures Explained:

Let's dive into some of the most commonly used data structures, which you'll find implemented here:

* **Linked List** (Lista Encadeada)
    * **Description:** A linear collection of elements, called nodes, where each node stores both data and a reference (or link) to the next node in the sequence. Unlike arrays, elements are not stored contiguously in memory, allowing for dynamic size. This structure offers efficient insertions and deletions ($O(1)$ after finding the node).
    * **Use Cases:** Dynamic memory allocation, implementing stacks and queues, managing symbol tables in compilers.

* **Queue** (Fila)
    * **Description:** A linear data structure that adheres to the **First-In, First-Out (FIFO)** principle. Think of a line of people waiting: the first one in is the first one out. Key operations are `enqueue` (add to the rear) and `dequeue` (remove from the front).
    * **Use Cases:** Task scheduling, breadth-first search (BFS), handling shared resources, buffer management.

* **Stack** (Pilha)
    * **Description:** A linear data structure that follows the **Last-In, First-Out (LIFO)** principle. Similar to a stack of plates: you can only add or remove from the top. Operations include `push` (add to top), `pop` (remove from top), and `peek` (view top element).
    * **Use Cases:** Function call management (call stack), undo mechanisms, expression evaluation, backtracking algorithms.

* **Binary Tree** (Árvore Binária)
    * **Description:** A non-linear, hierarchical data structure where each node has at most two children, referred to as the left and right child. This structure is foundational for organizing data in a hierarchical manner, enabling efficient search and traversal operations.
    * **Use Cases:** Representing hierarchical data (e.g., file systems), parsing expressions, implementing sets and maps.

* **AVL Tree** (Árvore AVL)
    * **Description:** A self-balancing **Binary Search Tree (BST)** where for every node, the height difference between its left and right subtrees is at most 1. This strict balancing ensures that search, insertion, and deletion operations maintain an optimal logarithmic time complexity ($O(\log n)$) even in the worst-case scenario, preventing performance degradation common in unbalanced BSTs.
    * **Use Cases:** Databases, file systems, applications requiring fast lookups and guaranteed performance.

---

## Essential Sorting Algorithms:

Sorting algorithms are crucial for organizing data efficiently, which often prefaces more complex operations like searching. This section includes common sorting algorithms with varying performance characteristics:

* **QuickSort**
    * **Description:** A highly efficient, comparison-based sorting algorithm that employs a **divide-and-conquer** strategy. It selects a 'pivot' element from the array and partitions the other elements into two sub-arrays according to whether they are less than or greater than the pivot. The sub-arrays are then recursively sorted. Its average-case time complexity is $O(n \log n)$.
    * **Characteristics:** In-place sorting, generally faster in practice than other $O(n \log n)$ algorithms due to good cache performance.

* **Selection Sort**
    * **Description:** A simple, in-place comparison sorting algorithm. It repeatedly finds the minimum element from the unsorted part of the array and puts it at the beginning. This process continues until the entire array is sorted.
    * **Characteristics:** Straightforward to implement, but its time complexity is $O(n^2)$ in all cases, making it less efficient for large datasets.

* **ShellSort**
    * **Description:** An optimization of insertion sort, invented by Donald Shell. It sorts elements that are far apart, then gradually reduces the gap between elements to be sorted. This technique allows elements to move to their correct positions more quickly than in a simple insertion sort, especially for nearly sorted arrays.
    * **Characteristics:** More efficient than basic insertion sort and selection sort, with a time complexity that varies depending on the gap sequence (typically $O(n (\log n)^2)$ or $O(n^{3/2})$ in worst-case for common gap sequences), making it practical for medium-sized lists.

---

## Search Algorithm:

* **Binary Search** (Busca Binária)
    * **Description:** An efficient algorithm for finding an item from an **ordered list of items**. It works by repeatedly dividing in half the portion of the list that could contain the item, until the possible locations are reduced to just one.
    * **Characteristics:** Requires the data to be sorted. Has a logarithmic time complexity ($O(\log n)$), making it significantly faster than linear search for large datasets.

Understanding and mastering these data structures and algorithms is paramount for any software developer aiming to build high-performance and scalable applications. Explore the Java implementations within this repository to deepen your comprehension.
