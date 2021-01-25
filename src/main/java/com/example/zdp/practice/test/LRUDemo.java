package com.example.zdp.practice.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LRUDemo
 * @Author dongping
 * @Date 2021/1/25 11:36
 * @Description LRUDemo
 * @Version 1.0
 */
public class LRUDemo {

    class Node<K, V> {
        K key;
        V value;
        Node<K, V> pre;
        Node<K, V> next;

        public Node() {
            this.pre = this.next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.pre = this.next = null;
        }
    }

    class DoubleLinkedList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.pre = head;
        }

        //添加到队列头
        public void addHead(Node<K, V> node) {
            node.next = head.next;
            node.pre = head;
            //顺序不能反
            head.next.pre = node;
            head.next = node;
        }

        //删除节点
        public void removeNode(Node<K, V> node) {
            node.next.pre = node.pre;
            node.pre.next = node.next;
            node.next = null;
            node.pre = null;
        }

        //获得最后一个节点
        public Node getLast() {
            return tail.pre;
        }

    }

    private int cacheSize;
    Map<Integer, Node<Integer, Integer>> map;
    DoubleLinkedList<Integer, Integer> doubleLinkedList;

    public LRUDemo(int cacheSize) {
        this.cacheSize = cacheSize;
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node<Integer, Integer> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);
        return node.value;
    }

    //save or update
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key, node);
            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        } else {
            //满了
            if (cacheSize == map.size()) {
                Node<Integer,Integer> last = doubleLinkedList.getLast();
                map.remove(last.key);
                doubleLinkedList.removeNode(last);
            }
            Node<Integer, Integer> newNode = new Node<>(key, value);
            doubleLinkedList.addHead(newNode);
            map.put(key, newNode);

        }
    }

    public static void main(String[] args) {
        LRUDemo lruDemo = new LRUDemo(3);
        lruDemo.put(1, 111);
        lruDemo.put(2, 222);
        lruDemo.put(3, 333);
        lruDemo.put(4, 444);
        System.out.println(lruDemo.map.keySet());
    }
}
