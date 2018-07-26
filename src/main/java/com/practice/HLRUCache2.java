package com.topic.interview;

import com.util.Question;

import java.util.HashMap;
import java.util.Map;

@Question(id = 152, hint = "Double LinkedList + HashMap")
public class HLRUCache2 {

    class Node {
        int key;
        int val;
        Node pre;
        Node post;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private Node head;

    private Node tail;

    private int len;

    private int capacity;

    private Map<Integer, Node> map;

    public HLRUCache2(int capacity){
        len = 0;
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node latest = map.get(key);
            remove(latest);
            addHead(latest);
            return latest.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){ // update if exist
            Node node = map.get(key);
            node.val = value;
            remove(node);
            addHead(node);
        } else {
            Node node = new Node(key, value);
            if(len < capacity){ // direct put
                addHead(node);
                len ++;
                map.put(key, node);
            } else {
                map.remove(tail.pre.key); // remove last then put
                remove(tail.pre);
                addHead(node);
                map.put(key, node);
            }
        }
    }

    public void remove(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            map.remove(key);
            len --;
        }
    }

    public void clear(){
        map.clear();
        head.post = tail;
        tail.pre = head;

    }

    private void addHead(Node node) {

        node.post = head.post;

        head.post = node;

        node.pre = head;

        node.post.pre = node;

    }

    private void remove(Node node) {

        node.pre.post = node.post;

        node.post.pre = node.pre;

        node = null;

    }

    public static void main(String[] args){
        HLRUCache2 lru = new HLRUCache2(6);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        lru.put(4, 4);
        lru.put(5, 5);
        lru.put(6, 6);
        lru.get(4);
        lru.put(7, 7);
        lru.remove(3);
        lru.clear();
        lru.put(6, 6);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(6));

    }

}


