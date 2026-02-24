package HashMaps;

public class CustomHashMap<K, V> {

    class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private int capacity = 16;
    private Entry<K, V>[] table;

    public CustomHashMap() {
        table = new Entry[capacity];
    }

    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        table = new Entry[capacity];
    }

    public void put(K key, V value) {
        int index = index(key);
        Entry<K, V> newEntry = new Entry<>(key, value, null);
        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry<K, V> currentNode = table[index];
            while (currentNode.getNext() != null) {
                if (currentNode.getKey().equals(key)) {
                    currentNode.setValue(value);
                    return;
                }
                currentNode = currentNode.getNext();
            }
            currentNode.next = newEntry;
        }
    }

    public V get(K key) {
        int index = index(key);
        Entry<K, V> entry = table[index];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
            entry = entry.getNext();
        }
        return null; // Key not found
    }

    public void remove(K key) {
        int index = index(key);
        Entry<K, V> previous = null;
        Entry<K, V> current = table[index];
        while (current != null) {
            if (current.getKey().equals(key)) {
                if (previous == null) {
                    table[index] = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                return;
            }
            previous = current;
            current = current.getNext();
        }
    }

    public void display() {
        for (int i = 0; i < capacity; i++) {
            Entry<K, V> currentNode = table[i];
            while (currentNode != null) {
                System.out.println("Key: " + currentNode.getKey() + ", Value: " + currentNode.getValue());
                currentNode = currentNode.getNext();
            }
        }
    }

    private int index(K key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode() % capacity);
    }

    public static void main(String[] args) {
        CustomHashMap<Integer, String> map = new CustomHashMap<>();
        System.out.println("Going to add entries in map");
        map.put(1, "ETC");
        map.put(2, "John");
        System.out.println("Displaying all the entries in map");
        map.display();
        System.out.println("Removing the entry with key 2");
        map.remove(2);
        map.display();
        System.out.println("Adding a duplicate key 1 in map");
        map.put(1, "xyz");
        map.display();
    }
}
