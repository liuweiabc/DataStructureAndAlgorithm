package com.liu.SingleLinkedList;

import java.util.Stack;

/**
 * @author liuwei
 * @date 2022/4/19
 * @apiNote
 */

public class SigleLinkedListDemo2 {
    public static void main(String[] args) {
        //SingleLinkedList1 list = new SingleLinkedList1();
        //list.addByAsc(new StudentNode1(1,"liuwei"));
        //list.addByAsc(new StudentNode1(4,"liuwei1"));
        //list.addByAsc(new StudentNode1(3,"liuwei2"));
        //list.addByAsc(new StudentNode1(2,"liuwei3"));
        //int size = list.size();
        //System.out.println(size);
        //System.out.println(list.getLastIndexNode(1));
        //list.reverse();
        //list.query();
        //list.reversePrint();
        SingleLinkedList1 list1 = new SingleLinkedList1();
        SingleLinkedList1 list2 = new SingleLinkedList1();
        list1.add(new StudentNode1(1,"liuwei"));
        list1.add(new StudentNode1(6,"liuwei1"));
        list1.add(new StudentNode1(8,"liuwei2"));
        list1.add(new StudentNode1(9,"liuwei3"));
        list2.add(new StudentNode1(3,"liuwei"));
        list2.add(new StudentNode1(4,"liuwei"));
        list2.add(new StudentNode1(4,"liuwei"));
        list2.add(new StudentNode1(5,"liuwei"));
        StudentNode1 result = SingleLinkedList1.Merge(list1.head,list2.head);
        while(result != null){
            System.out.println(result);
            result = result.next;
        }
    }
}

class SingleLinkedList1 {
    public StudentNode1 head = new StudentNode1(0,"");

    public void add(StudentNode1 node){
        StudentNode1 temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }
    public void addByAsc(StudentNode1 node){
        StudentNode1 temp = head;
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
            System.out.println("??????????????????????????????");
        }
        else{
            node.next = temp.next;
            temp.next = node;
        }
    }
    public void del(int no){
        StudentNode1 temp = head;
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
            System.out.println("????????????????????????");
        }
        else{
            temp = temp.next.next;
        }
    }
    public void update(StudentNode1 node){
        if(head.next == null){
            System.out.println("????????????");
        }
        else{
            StudentNode1 temp = head;
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
                System.out.println("??????????????????");
            }
            else{
                temp.name = node.name;
            }
        }
    }
    public void query(){
        if(head.next == null){
            System.out.println("????????????");
            return;
        }
        StudentNode1 temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
    //??????????????????????????????????????????
    public int size(){
        StudentNode1 temp = head.next;
        int length = 0;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }
    //??????????????????????????????k?????????
    /*
    * 1???index?????????????????????index?????????
    * 2????????????????????????????????????????????????????????????size
    * 3??????????????????size-index???????????????????????????
    * 4?????????????????????????????????null*/
    public StudentNode1 getLastIndexNode(int index){
        if(head.next == null){
            return null;
        }
        int size = size();
        if(index <= 0 || index > size){
            return null;
        }
        StudentNode1 temp = head.next;
        for(int i = 0;i < (size-index);i++){
            temp = temp.next;
        }
        return temp;
    }
    //???????????????
    /*
    * ???????????????????????????????????????????????????????????????????????????????????????????????????????????????*/
    public void reverse(){
        if(head.next == null || head.next.next == null){
            return;
        }
        StudentNode1 temp = head.next;
        StudentNode1 next = null;
        StudentNode1 reverseHead = new StudentNode1(0,"");
        while(temp != null){
            next = temp.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            temp = next;
        }
        head.next = reverseHead.next;
    }
    //??????????????????
    public void reversePrint(){
        if(head.next == null){
            return;
        }
        Stack<StudentNode1> stack = new Stack<>();
        StudentNode1 temp = head.next;
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        while(stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

    //????????????????????????
    public static StudentNode1 Merge(StudentNode1 head1,StudentNode1 head2){
        if(head1.next == null){
            return head2;
        }
        if(head2.next == null){
            return head1;
        }
        StudentNode1 temp1 = head1.next;
        StudentNode1 next1 = null;
        StudentNode1 temp2 = head2.next;
        StudentNode1 next2 = null;
        StudentNode1 head = new StudentNode1(0,"");
        StudentNode1 temp = head;
        while(temp1 != null && temp2 != null){
            if(temp1.no < temp2.no){
                next1 = temp1.next;
                temp.next = temp1;
                temp = temp.next;
                temp1 = next1;
            }
            else{
                next2 = temp2.next;
                temp.next = temp2;
                temp = temp.next;
                temp2 = next2;
            }
        }
        if(temp1 == null){
            while(temp2 != null){
                temp.next = temp2;
                temp = temp.next;
                temp2 = temp2.next;
            }
        }
        if(temp2 == null){
            while(temp1 != null){
                temp.next = temp1;
                temp = temp.next;
                temp1 = temp1.next;
            }
        }
        return head;
    }
}
class StudentNode1 {
    public int no;
    public String name;
    public StudentNode1 next;
    public int num;

    public StudentNode1(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "StudentNode1{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}
