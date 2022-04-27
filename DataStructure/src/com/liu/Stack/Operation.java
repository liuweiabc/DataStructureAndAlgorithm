package com.liu.Stack;

import java.lang.management.OperatingSystemMXBean;
import java.util.Scanner;

/**
 * @author liuwei
 * @date 2022/4/24
 * @apiNote
 */

public class Operation {
    private int top;
    private int[] stack;
    private int maxSize;

    public Operation(int maxSize){
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

    public boolean isOper(int val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int priority(int val){
        if(val == '*' || val == '/'){
            return 1;
        }
        else if(val == '+' || val == '-'){
            return 0;
        }
        return -1;
    }

    public int peek(){
        return stack[top];
    }
    public int cal(int num1,int num2,int oper){
        int rel = 0;
        switch(oper){
            case '+':
                rel = num1 + num2;
                break;
            case '-':
                rel = num2 - num1;
                break;
            case '*':
                rel = num1 * num2;
                break;
            case '/':
                rel = num2 / num1;
                break;
            default:
                break;
        }
        return rel;
    }

    public static void main(String[] args) {
        String expression = "788+8*6-98";
        Operation numStack = new Operation(10);
        Operation operStack = new Operation(10);

        for(int i = 0;i < expression.length();i++){
            char a = expression.substring(i,i+1).charAt(0);
            if(numStack.isOper(a)){
                if(operStack.isEmpty()){
                    operStack.push(a);
                }
                else if(operStack.priority(a) > operStack.priority(operStack.peek())){
                    operStack.push(a);
                }
                else{
                    int oper = operStack.pop();
                    int num1 = numStack.pop();
                    int num2 = numStack.pop();
                    numStack.push(numStack.cal(num1,num2,oper));
                    operStack.push(a);
                }
            }else{
                String keepNum = "";
                keepNum = keepNum + a;
                int temp = i + 1;
                if(i == expression.length()-1){
                    numStack.push(a-48);
                }else{
                    while(!operStack.isOper(expression.substring(temp,temp+1).charAt(0))){
                        keepNum = keepNum + expression.substring(temp,temp+1).charAt(0);
                        temp++;
                        if(temp >= expression.length()){
                            break;
                        }
                    }
                    numStack.push(Integer.parseInt(keepNum));
                    i = temp -1;
                }

            }
        }
        while(!operStack.isEmpty()){
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            int oper = operStack.pop();
            numStack.push(numStack.cal(num1,num2,oper));
        }
        System.out.println(expression + "=" + numStack.pop());
    }
}
