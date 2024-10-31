// // import static org.junit.jupiter.api.Assertions.assertEquals;

// // import org.junit.jupiter.api.Test;

// public class Main {
//   public static void main(String[] args) {
//     System.out.println("Hello world!");
//   }

//   // @Test
//   // void addition() {
//   //     assertEquals(2, 1 + 1);
//   // }
// }
import java.util.Scanner;

class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Method to insert a new node with a given value
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.value)
            root.left = insertRec(root.left, value);
        else if (value > root.value)
            root.right = insertRec(root.right, value);
        return root;
    }

    // Method to delete a node with a given value
    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private Node deleteRec(Node root, int value) {
        if (root == null) return root;

        if (value < root.value)
            root.left = deleteRec(root.left, value);
        else if (value > root.value)
            root.right = deleteRec(root.right, value);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.value = minValue(root.right);
            root.right = deleteRec(root.right, root.value);
        }
        return root;
    }

    private int minValue(Node root) {
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }

    // In-order traversal
    public void printInOrder() {
        printInOrderRec(root);
        System.out.println();
    }

    private void printInOrderRec(Node root) {
        if (root != null) {
            printInOrderRec(root.left);
            System.out.print(root.value + " ");
            printInOrderRec(root.right);
        }
    }

    // Pre-order traversal
    public void printPreOrder() {
        printPreOrderRec(root);
        System.out.println();
    }

    private void printPreOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            printPreOrderRec(root.left);
            printPreOrderRec(root.right);
        }
    }

    // Post-order traversal
    public void printPostOrder() {
        printPostOrderRec(root);
        System.out.println();
    }

    private void printPostOrderRec(Node root) {
        if (root != null) {
            printPostOrderRec(root.left);
            printPostOrderRec(root.right);
            System.out.print(root.value + " ");
        }
    }
}

public class BSTApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        boolean running = true;

        while (running) {
            System.out.println("\nBinary Search Tree Menu:");
            System.out.println("1. Create a binary search tree");
            System.out.println("2. Add a node");
            System.out.println("3. Delete a node");
            System.out.println("4. Print nodes by InOrder");
            System.out.println("5. Print nodes by PreOrder");
            System.out.println("6. Print nodes by PostOrder");
            System.out.println("7. Exit program");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Create BST with predefined values
                    bst = new BinarySearchTree();
                    int[] values = {4, 2, 6, 1, 3, 5, 7};
                    for (int value : values) {
                        bst.insert(value);
                    }
                    System.out.println("Binary search tree created with values: 1, 2, 3, 4, 5, 6, 7");
                    break;
                case 2:
                    // Add a node
                    System.out.print("Enter a value to add: ");
                    int addValue = scanner.nextInt();
                    bst.insert(addValue);
                    System.out.println("Value " + addValue + " added to the BST.");
                    break;
                case 3:
                    // Delete a node
                    System.out.print("Enter a value to delete: ");
                    int deleteValue = scanner.nextInt();
                    bst.delete(deleteValue);
                    System.out.println("Value " + deleteValue + " deleted from the BST.");
                    break;
                case 4:
                    // Print nodes by InOrder
                    System.out.print("InOrder traversal: ");
                    bst.printInOrder();
                    break;
                case 5:
                    // Print nodes by PreOrder
                    System.out.print("PreOrder traversal: ");
                    bst.printPreOrder();
                    break;
                case 6:
                    // Print nodes by PostOrder
                    System.out.print("PostOrder traversal: ");
                    bst.printPostOrder();
                    break;
                case 7:
                    // Exit program
                    running = false;
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}