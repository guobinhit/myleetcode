package com.hit.basmath.interview.we_meet.alibaba;

/**
 * @author Charies Gavin
 * @github https:github.com/guobinhit
 * @date 2020/3/6,下午8:29
 * @description
 */
public class MyStack<T> {

    private Node<T> root;

    private Node<T> tail;

    static class Node<T> {
        T value;
        Node<T> pre;

        Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            if (this.pre == null) {
                return String.valueOf(this.value);
            }
            return this.pre.toString() + " <- " + this.value;
        }
    }

    public T push(T t) {
        if (root == null) {
            root = new Node<T>(t);
            tail = root;
            return t;
        }
        Node<T> node = new Node<T>(t);
        node.pre = tail;
        tail = node;
        return t;
    }

    public T pop() {
        if (null == root) {
            throw new RuntimeException("stack is empty");
        }

        T lastElement = null;
        if (root == tail) {
            lastElement = root.value;
            root = null;
            tail = null;
            return lastElement;
        }
        lastElement = tail.value;
        tail = tail.pre;
        return lastElement;
    }

    @Override
    public String toString() {
        return tail.toString();
    }

    public static void main(String[] args) {
        MyStack<Integer> s = new MyStack<>();
        s.push(1);
        s.push(2);
        s.push(3);
//        s.pop();
        s.push(4);
        s.push(5);
//        s.pop();
        System.out.println(s);
    }

}