package com.liu.SingleLinkedList;

/**
 * @author liuwei
 * @date 2022/4/18
 * @apiNote
 */

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.addByAsc(new StudentNode(1,"liuwei"));
        list.addByAsc(new StudentNode(4,"liuwei1"));
        list.addByAsc(new StudentNode(3,"liuwei2"));
        list.addByAsc(new StudentNode(2,"liuwei3"));
        list.query();
    }
}
class SingleLinkedList {
    StudentNode head = new StudentNode(0,"");

    public void add(StudentNode node){
        StudentNode temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }
    public void addByAsc(StudentNode node){
        StudentNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no > node.no){
                break;
            }
            if(temp.next.no == node.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.println("链表中已经存在该元素");
        }
        else{
            node.next = temp.next;
            temp.next = node;
        }
    }
    public void del(int no){
        StudentNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next.no == no){
                break;
            }
            if(temp.next == null){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag == true){
            System.out.println("链表中没有该元素");
        }
        else{
            temp = temp.next.next;
        }
    }
    public void update(StudentNode node){
        if(head.next == null){
            System.out.println("链表为空");
        }
        else{
            StudentNode temp = head;
            boolean flag = false;
            while(true){
                if(temp.no == node.no){
                    break;
                }
                else if(temp == null){
                    flag = true;
                    break;
                }
            }
            if(flag){
                System.out.println("未找到该节点");
            }
            else{
                temp.name = node.name;
            }
        }
    }
    public void query(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        StudentNode temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
class StudentNode {
    public int no;
    public String name;
    public StudentNode next;

    public StudentNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "StudentNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", " +
                '}';
    }
}
