package com.liu.Stack;

import java.util.Scanner;

/**
 * @author liuwei
 * @date 2022/4/23
 * @apiNote
 */

public class StackArray {
    private int top;
    private int[] stack;
    private int maxSize;

    public StackArray(int maxSize){
        top = -1;
        this.maxSize =  maxSize;
        stack = new int[this.maxSize];
    }

    //判断栈满
    public boolean isFull(){
        return top == maxSize - 1;
    }
    //判断栈空
    public boolean isEmpty(){
        return top == -1;
    }
    //入栈操作
    public void push(int num){
        if(isFull()){
            throw new RuntimeException("栈已满");
        }
        stack[++top] = num;
    }
    //出栈操作
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈为空");
        }
        int value = stack[top--];
        return value;
    }
    //遍历栈的元素
    public void show(){
        if(isEmpty()){
            throw new RuntimeException("栈为空");
        }
        for(int i = top;i >= 0;i--){
            System.out.printf("stack[%d]=%d\t",i,stack[i]);
        }
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray(5);
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
                    try{
                        int result = stack.pop();
                        System.out.println(result);
                        break;
                    }catch(Exception e){
                        String mes = e.getMessage();
                        System.out.println(mes);
                    }finally {
                        break;
                    }
                case 'h':
                    int b = scanner.nextInt();
                    stack.push(b);
                    break;
                case 's':
                    stack.show();
                    break;
                default:
                    break;
            }
        }
    }
}
