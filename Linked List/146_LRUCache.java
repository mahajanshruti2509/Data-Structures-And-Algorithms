/***********************************************
Time Complexity : O(1) both for put and get.
Space Complexity : O(capacity) since the space is used only for a hashmap and double linked list 
with at most capacity + 1 elements.
https://leetcode.com/problems/lru-cache/
***********************************************/

class Node {
    int key;
    int value;
    Node next;
    Node prev;
     
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    
    Node head;
    Node tail;
    HashMap<Integer, Node> map = null;
    int cap = 0;
    
    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap();
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            putOnTop(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            putOnTop(node);
        } else {
            if(map.size() >= cap) {
                map.remove(tail.key);
                removeNode(tail);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            putOnTop(node);
        }
    }
     
    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        
        if(prevNode != null) {
            prevNode.next = nextNode;
        } else {
            head = nextNode;
        }
        
        if(nextNode != null) {
            nextNode.prev = prevNode;
        } else {
            tail = prevNode;
        }
    }
    
    private void putOnTop(Node node) {
        node.next = head;
        node.prev = null;
        if(head != null) {
            head.prev = node;
        }
        head = node;
        if(tail == null) {
            tail = node;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */