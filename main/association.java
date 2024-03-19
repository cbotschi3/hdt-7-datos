package main;

public class association<K, V> {
    private K key;
    private V value;

    public association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}