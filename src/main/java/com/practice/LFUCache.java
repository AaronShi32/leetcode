package com.practice;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

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

    private Map<Integer, Node> map = new HashMap<>();

    private int len;

    private int capacity;

    private Node head;

    private Node tail;

    public LFUCache(int capacity) {
        len = 0;
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            addTail(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            remove(node);
            addTail(node);
            return;
        } else {
            Node node = new Node(key, value);
            if(len < capacity){
                map.put(key, node);
                addTail(node);
                len ++;
                return;
            } else {
                map.remove(tail.pre.key);
                remove(tail.pre);
                addTail(node);
                map.put(key, node);
                return;
            }
        }
    }

    private void remove(Node node){
        node.post.pre = node.pre;
        node.pre.post = node.post;
    }

    private void addTail(Node node){
        node.pre = tail.pre;
        tail.pre = node;
        node.post = tail;
        node.pre.post = node;
    }

    public static void main(String[] args){
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.get(3);
        cache.put(4, 4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }
}
