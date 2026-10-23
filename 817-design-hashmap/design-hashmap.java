
class MyHashMap {

    class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node head;

    public MyHashMap() {
        head = null;
    }

    public void put(int key, int value) {
        Node curr = head;

        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            curr = curr.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = head;
        head = newNode;
    }

    public int get(int key) {
        Node curr = head;

        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }

        return -1;
    }

    public void remove(int key) {
        if (head == null) return;

        if (head.key == key) {
            head = head.next;
            return;
        }

        Node curr = head;

        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
}


// put(): O(N)
// get(): O(N)
// remove(): O(N)
// Space Complexity: O(N)