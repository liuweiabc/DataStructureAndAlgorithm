package com.liu.ArrayQueue;

import java.util.Scanner;

/**
 * @author liuwei
 * @date 2022/4/16
 * @apiNote
 */

public class CircleQueue {
    private int[] queue;
    private int maxSize;
    //头元素直接指向队列的第一个元素
    private int front;
    //尾元素指向队列最后一个元素的后一个位置
    private int rear;

    //构造函数
    public CircleQueue(int maxSize){
        this.maxSize = maxSize;
        queue = new int[this.maxSize];
        front = 0;
        rear = 0;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }
    //判断队列是否为满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }
    //向队列中添加数据
    public void addqueue(int n){
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        queue[rear] = n;
        rear = (rear + 1) % maxSize;
    }
    //从队列中取出数据
    public int getqueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        int result = queue[front];
        front = (front + 1) % maxSize;
        return result;
    }
    //查看队列头数据
    public int gethead(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return queue[front];
    }
    //显示队列所有数据
    public void getAll(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        for(int i = front + 1;i < (rear + maxSize - front) % maxSize;i++){
            System.out.printf("%d\t",queue[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        CircleQueue queue = new CircleQueue(3);
        while(loop){
            System.out.println("add(a)向队列添加数据");
            System.out.println("get(g)从队列取出数据");
            System.out.println("head(h)查看队列头数据");
            System.out.println("All(A)查看所有数据");
            System.out.println("exit(e)退出循环");
            char a = scanner.next().charAt(0);
            switch(a){
                case 'a':
                    int b = scanner.nextInt();
                    queue.addqueue(b);
                    break;
                case 'g':
                    int c = queue.getqueue();
                    System.out.println("取出数据为" + c);
                    break;
                case 'h':
                    int d = queue.gethead();
                    System.out.println("头元素为:" + d);
                    break;
                case 'A':
                    queue.getAll();
                    break;
                case 'e':
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}
