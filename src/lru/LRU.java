package lru;

import java.util.HashMap;

public class LRU<K, V> {
    private int capacity;
    private int currentSize;
    private Node first;
    private Node last;
    private HashMap<K, Node> caches;


    public LRU(int capacity) {
        this.capacity = capacity;
        this.currentSize=0;
        this.caches = new HashMap<K,Node>(capacity);
    }

    //将热门数据移动到队列头部
    public void moveToHead(Node node){
        if (node==null||node==first){
            return;
        }
        if (node == last){
            last=last.pre;
        }
        if (node.next!=null){
            node.next.pre=node.pre;
        }
        if (node.pre!=null){
            node.pre.next=node.next;
        }
        if (first==null&&last==null){
            first = node;
            last = node;
            return;
        }
        node.next=first;
        node.pre=null;
        first.pre=node;
        first=node;

    }

    public void clear(){
        first=null;
        last=null;
        caches.clear();
    }

    public void removeLast(){
        if (last==null)return;
        last=last.pre;
        if (last==null){
            first=null;//只有一个节点
        }else {
            last.next=null;
        }

    }
    public Object removeKey(K key){
        Node node =caches.get(key);
        if (node==null)return null;
        if (node==first){
            first=first.next;
            first.pre=null;
        }
        if (node==last){
            last=last.pre;
            last.next=null;
        }
        if (node.pre!=null){
            node.pre.next=node.next;
        }
        if (node.next!=null){
            node.next.pre=node.pre;
        }
        return caches.remove(key);
    }
    public Object getKey(K key){
        Node node = caches.get(key);
        if (node==null)return null;
        moveToHead(node);
        return node.val;
    }
    public void put(K k,V value){
        Node node = caches.get(k);
        if (node == null) {
            if (caches.size()>=this.capacity){
                removeKey((K) last.key);
                removeLast();
            }
            node = new Node(k,value);
        }
        currentSize++;
        caches.put(k,node);
        moveToHead(node);
    }
    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Node node = first;
        while (node!=null){
            stringBuffer.append(String.format("%s : %s ",node.key,node.val));
            node= node.next;
        }
        return stringBuffer.toString();
    }
    public static void main(String[] args) {
        LRU<Integer, String> lru = new LRU<Integer, String>(5);
        lru.put(1, "a");
        lru.put(2, "b");
        lru.put(3, "c");
        lru.put(4,"d");
        lru.put(5,"e");
        System.out.println("原始链表为:"+lru.toString());

        lru.getKey(4);
        System.out.println("获取key为4的元素之后的链表:"+lru.toString());

        lru.put(6,"f");
        System.out.println("新添加一个key为6之后的链表:"+lru.toString());

        lru.removeKey(3);
        System.out.println("移除key=3的之后的链表:"+lru.toString());
    }
}

class Node {
    Node pre;
    Node next;
    Object val;
    Object key;

    public Node(Object val, Object key) {
        this.val = val;
        this.key = key;
    }
}
