package com.liu.Stack;

/**
 * @author liuwei
 * @date 2022/4/26
 * @apiNote
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 该函数用来将中缀表达式转换成后缀表达式，即逆波兰式
 */
public class PolandExpression2 {

    //将表达式转换为list
    public List<String> expressionToList(String expression){
        List<String> expressionList = new ArrayList<>();
        for(int i = 0;i < expression.length();i++){
            char temp = expression.charAt(i);
            if(isOperation(temp)){
                expressionList.add(temp + "");
            }
            else{
                String str = "" + temp;
                i++;
                while(i < expression.length() && !isOperation(expression.charAt(i))){
                    str = str + expression.charAt(i);
                    i++;
                }
                expressionList.add(str);
                i--;
            }
        }
        return expressionList;
    }
    public boolean isOperation(char a){
        return a == '+' || a == '-' || a == '*' || a == '/' || a == '(' || a == ')';
    }

    //中缀表达式转后缀
    public List<String> Convert(List<String> expression){
        Stack<String> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        for (String item : expression){
            if(!isOperation(item.charAt(0))){
                result.add(item);
            }
            else if(item.equals("(") || stack.isEmpty() || priority(item) > priority(stack.peek())){
                stack.push(item);
            }
            else if(item.equals(")")){
                while(!stack.peek().equals("(")){
                    result.add(stack.pop());
                }
                stack.pop();
            }
            else {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(item)){
                    result.add(stack.pop());
                }
                stack.push(item);
            }
        }
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }

    public int priority(String item) {
        if(item.equals("+") || item.equals("-")){
            return 1;
        }
        else if(item.equals("*") || item.equals("/")){
            return 2;
        }
        return 0;
    }

    public static void main(String[] args) {
        String expression = "1+((2+3)*4)-5";
        PolandExpression2 temp = new PolandExpression2();
        List<String> expression1 = temp.expressionToList(expression);
        System.out.println(temp.Convert(expression1).toString());

    }
}
