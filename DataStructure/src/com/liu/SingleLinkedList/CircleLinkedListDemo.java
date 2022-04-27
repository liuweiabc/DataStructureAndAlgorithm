package com.liu.SingleLinkedList;

/**
 * @author liuwei
 * @date 2022/4/21
 * @apiNote
 */

public class CircleLinkedListDemo {
    public static void main(String[] args) {
        CircleLinkedList list = new CircleLinkedList();
        list.add(5);
        list.show();
        list.count(1,2,5);
    }
}

class CircleLinkedList {
    Node first = null;

    public CircleLinkedList(){
        this.first = new Node(-1);
    }

    public void add(int num){
        if(num < 1){
            return;
        }
        Node currentNode = null;
        for(int i = 1;i <= num;i++){
            Node node = new Node(i);
            if(i == 1){
                first = node;
                currentNode = first;
                currentNode.next = currentNode;
            }
            else{
                currentNode.next = node;
                currentNode = currentNode.next;
                currentNode.next = first;
            }
        }
    }
    public void show(){
        if(first == null){
            System.out.println("链表为空");
            return;
        }
        Node currentNode = first;
        do{
            System.out.printf("%d\n",currentNode.getVal());
            currentNode = currentNode.next;
        }while(currentNode != first);
    }
    public void count(int k,int m,int nums){
        if(first == null || k < 0 || k > nums || m < 1){
            return;
        }
        Node pre = first;
        while(pre.next != first){
            pre = pre.next;
        }
        for(int i = 0;i < k-1;i++) {
            first = first.next;
            pre = pre.next;
        }
        while(pre != first){
            for(int i = 0;i < m -1;i++){
                pre = pre.next;
                first = first.next;
            }
            System.out.println(first.getVal());
            first = first.next;
            pre.next = first;
        }
        System.out.println("最后的小孩编号为" + first.getVal());
    }
}

class Node {
    int val;
    Node next;
    public Node(int val){
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
