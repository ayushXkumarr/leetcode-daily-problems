class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void insertAtTail(Node node) {
        Node last = tail.prev;

        last.next = node;
        node.prev = last;

        node.next = tail;
        tail.prev = node;
    }

    public int get(int key) {
        Node node = map.get(key);

        if (node == null)
            return -1;

        remove(node);
        insertAtTail(node);

        return node.val;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {

            Node node = map.get(key);

            remove(node);
            node.val = value;
            insertAtTail(node);

            return;
        }

        if (map.size() == capacity) {

            Node lru = head.next;

            remove(lru);
            map.remove(lru.key);
        }

        Node node = new Node(key, value);

        insertAtTail(node);
        map.put(key, node);
    }
}