package main;
public class binaryTree<K extends Comparable<K>, V> {
    private K key;
    private V value;
    private binaryTree<K, V> left;
    private binaryTree<K, V> right;

    public binaryTree(K key, V value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void insert(K key, V value) {
        if (key.compareTo(this.key) < 0) {
            if (left == null) {
                left = new binaryTree<>(key, value);
            } else {
                left.insert(key, value);
            }
        } else if (key.compareTo(this.key) > 0) {
            if (right == null) {
                right = new binaryTree<>(key, value);
            } else {
                right.insert(key, value);
            }
        }
    }

    public V search(K key) {
        if (key.equals(this.key)) {
            return this.value;
        } else if (key.compareTo(this.key) < 0 && left != null) {
            return left.search(key);
        } else if (key.compareTo(this.key) > 0 && right != null) {
            return right.search(key);
        } else {
            return null;
        }
    }

    public void inorderTraversal() {
        inorderTraversal(this);
    }

    private void inorderTraversal(binaryTree<K, V> node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.println("(" + node.key + ", " + node.value + ")");
            inorderTraversal(node.right);
        }
    }
}
