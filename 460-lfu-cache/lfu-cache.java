
import java.util.*;

class LFUCache {

    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyList {
        Node head, tail;
        int size;

        DoublyList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        void add(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size == 0) return null;

            Node node = tail.prev;
            remove(node);

            return node;
        }
    }

    HashMap<Integer, Node> map;
    HashMap<Integer, DoublyList> freqMap;

    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;

        map = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        updateFreq(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) return;

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;

            updateFreq(node);
            return;
        }

        if (map.size() == capacity) {

            DoublyList list = freqMap.get(minFreq);

            Node removed = list.removeLast();

            map.remove(removed.key);
        }

        Node node = new Node(key, value);

        map.put(key, node);

        freqMap.putIfAbsent(1, new DoublyList());
        freqMap.get(1).add(node);

        minFreq = 1;
    }

    private void updateFreq(Node node) {

        int freq = node.freq;

        DoublyList oldList = freqMap.get(freq);
        oldList.remove(node);

        if (freq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;

        freqMap.putIfAbsent(node.freq, new DoublyList());
        freqMap.get(node.freq).add(node);
    }
}
