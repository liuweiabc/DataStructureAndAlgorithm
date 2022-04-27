package com.liu.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liuwei
 * @date 2022/4/25
 * @apiNote
 */

public class PolandExpresion {
    public static void main(String[] args) {
        String expression = "4 5 * 8 - 60 + 8 2 / +";
        PolandExpresion temp = new PolandExpresion();
        List<String> list = temp.converTOList(expression);
        System.out.println(temp.cal(list));

    }
    public List<String> converTOList(String expression){
        String[] temp = expression.split(" ");
        List<String> list = new ArrayList<>();
        for(int i = 0;i < temp.length;i++){
            list.add(temp[i]);
        }
        return list;
    }
    public static int cal(List<String> list){
        Stack<String> stack = new Stack<>();
        for(String val : list){
            if(val.matches("\\d+")){
                stack.push(val);
            }
            else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(val.equals("+")){
                    res = num1 + num2;
                }
                else if(val.equals("-")){
                    res = num1 - num2;
                }
                else if(val.equals("*")){
                    res = num1 * num2;
                }
                else if(val.equals("/")){
                    res = num1 / num2;
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
