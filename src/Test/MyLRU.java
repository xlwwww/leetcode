package Test;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author cutiewang
 * @date 2020/9/2 23:01
 */
class LRUNode{
    int val;
    LRUNode prev;
    LRUNode next;
    LRUNode(int val){this.val = val;}
}
public class MyLRU {
    //DOUBLE LINKLIST AND HASHMAP
    LinkedList<LRUNode> list;
    HashMap<Integer,LRUNode> map = new HashMap<>();
    int max;
    LRUNode head;
    LRUNode tail;
    int size;
    MyLRU(int capacity){
        this.list =new LinkedList<>();
        head = new LRUNode(-1);
        tail = head;
        this.max = capacity;
        this.size = 0;
    }
    public void put(int val){
        if(size == max){
            remove();
        }
        if(map.containsKey(val)){
            LRUNode tmp = map.get(val);
            LRUNode next = tmp.next;
            LRUNode prev = tmp.prev;
            prev.next =next;
            next.prev = prev;
            tmp.next = head.next;
            tmp.prev = head;
            head.next = tmp;
        }else{
            LRUNode node = new LRUNode(val);
            map.put(val,node);
            tail.next = node;
            node.prev = tail;
            tail = node;
            head.prev = node;
        }
        size++;
    }
    public void remove(){
        //remove tail
        LRUNode prevs = tail.prev;
        prevs.next = head;
        head.prev = prevs;
        tail.next = null;
        tail.prev = null;
    }
}
