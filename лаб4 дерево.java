Реализация бинарного дерева на Java
  
java
import java.util.*;

class BinaryTree {
    class Node {
        int key;
        Node left, right;
        
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    
    Node root;
    
    BinaryTree() {
        root = null;
    }
    
    void insert(int key) {
        root = insertRecursive(root, key);
    }
    
    Node insertRecursive(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        
        if (key < root.key) {
            root.left = insertRecursive(root.left, key);
        } else if (key > root.key) {
            root.right = insertRecursive(root.right, key);
        }
        
        return root;
    }
    
    boolean search(int key) {
        return searchRecursive(root, key);
    }
    
    boolean searchRecursive(Node root, int key) {
        if (root == null) {
            return false;
        }
        
        if (root.key == key) {
            return true;
        }
        
        return key < root.key ? searchRecursive(root.left, key) : searchRecursive(root.right, key);
    }
    
    List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        inorderRecursive(root, result);
        return result;
    }
    
    void inorderRecursive(Node root, List<Integer> result) {
        if (root != null) {
            inorderRecursive(root.left, result);
            result.add(root.key);
            inorderRecursive(root.right, result);
        }
    }
    
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] elements = {50, 30, 70, 20, 40, 60, 80};
        
        for (int elem : elements) {
            tree.insert(elem);
        }
        
        System.out.println("Обход дерева: " + tree.inorderTraversal());
        System.out.println("Поиск элемента 40: " + (tree.search(40) ? "Найден" : "Не найден"));
    }
}
