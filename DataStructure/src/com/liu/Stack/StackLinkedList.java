package com.liu.Stack;

import java.util.Scanner;

/**
 * @author liuwei
 * @date 2022/4/23
 * @apiNote
 */

public class StackLinkedList {
    private Node top;

    public void push(int num) {
        Node node = new Node(num);
        node.setNext(top);
        top = node;
    }
    public int pop(){
        if(top == null){
            System.out.println("栈为空");
            return -1;
        }
        Node temp = top;
        top = top.getNext();
        temp.setNext(null);
        return temp.getValue();
    }
    public void show(){
        if(top == null){
            System.out.println("栈为空");
            return;
        }
        Node temp = top;
        while(temp != null){
            System.out.println(temp.getValue() + "\t");
            temp = temp.getNext();
        }
    }
    public static void main(String[] args) {
        StackLinkedList list = new StackLinkedList();
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("请输入相应操作:");
            System.out.println("p(pop)代表出栈操作");
            System.out.println("h(push)代表入栈操作");
            System.out.println("s(show)代表遍历栈元素");
            char a = scanner.next().charAt(0);
            switch (a) {
                case 'e':
                    loop = false;
                    break;
                case 'p':
                    int result = list.pop();
                    System.out.println(result);
                    break;
                case 'h':
                    int b = scanner.nextInt();
                    list.push(b);
                    break;
                case 's':
                    list.show();
                    break;
                default:
                    break;
            }
        }
    }
}
class Node{
    private int value;
    private Node next;
    public Node(int value){
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
