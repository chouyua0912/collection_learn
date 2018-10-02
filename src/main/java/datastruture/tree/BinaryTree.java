package datastruture.tree;

public class BinaryTree<K extends Comparable<K>, V> {

    private Node<K, V> root;

    public void insert(K k, V v) {
        // add key and associated value to this BST;
        // error if key is already there
        if (root == null) {
            root = new Node<>(k, v, null, null);
        } else {
            Node<K, V> current = root;
            while (true) {
                int cv = current.key.compareTo(k);
                if (cv == 0) {
                    current.value = v;      // update
                    break;
                } else if (cv < 0) {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = new Node<>(k, v, null, null);
                        break;
                    }
                } else {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new Node<>(k, v, null, null);
                        break;
                    }
                }
            }
        }
    }

    public V get(K k) {
        Node<K, V> current = root;
        while (current != null) {
            int cc = current.key.compareTo(k);
            if (cc == 0)
                return current.value;
            else if (cc < 0)
                current = current.right;
            else
                current = current.left;
        }
        return null;
    }

    public boolean contain(K k) {
        return get(k) != null;
    }

    private static class Node<K extends Comparable<K>, V> implements Comparable<K> {
        private K key;
        private V value;
        private Node<K, V> left;
        private Node<K, V> right;

        Node(K key, V value, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(K k) {
            return this.key.compareTo(k);
        }
    }
}
