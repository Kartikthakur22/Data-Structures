import java.util.LinkedList;

public class SimpleHashMap<K, V> {

    private static final int SIZE = 16;
    private LinkedList<Node<K, V>>[] table;

    public SimpleHashMap() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(K key) {
        return key.hashCode() % SIZE;
    }

    public void put(K key, V value) {
        int index = hash(key);
        for (Node<K, V> node : table[index]) {
            if (node.key.equals(key)) {
                node.value = value;  
                return;
            }
        }
        table[index].add(new Node<>(key, value));  
    }

    public V get(K key) {
        int index = hash(key);
        for (Node<K, V> node : table[index]) {
            if (node.key.equals(key)) {
                return node.value; 
            }
        }
        return null;  
    }

    public void remove(K key) {
        int index = hash(key);
        table[index].removeIf(node -> node.key.equals(key));  
    }

    static class Node<K, V> {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("orange", 3);

        System.out.println(map.get("apple"));  
        System.out.println(map.get("banana")); 

        map.remove("banana");
        System.out.println(map.get("banana")); 
    }
}

