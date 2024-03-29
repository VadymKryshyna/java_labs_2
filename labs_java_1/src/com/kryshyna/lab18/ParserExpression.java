/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.lab18;

import java.util.LinkedList;

/**
 *
 * @author epam
 */
public class ParserExpression {
    static boolean isDelimeter(char c){
        return c == ' ';
    }
    
    static boolean isOperator(char c){
        return c =='+'||c=='-'||c=='*'||c=='/'||c=='%';
    }
    
    static int priority(char op){
        switch(op){
            case '+':
            case '-':
                return 1;
            case '*':    
            case '/':    
            case '%':
                return 2;
            default:
                return -1;
        }
    }

    static void processOperator(LinkedList<Integer> st, char op){
        int r = st.removeLast();
        int l = st.removeLast();
        switch(op){
            case '+': st.add(l + r); break;
            case '-': st.add(l - r); break;
            case '*': st.add(l * r); break;    
            case '/': st.add(l / r); break;    
            case '%': st.add(l % r); break;
        }
    }
    
    public static int eval(String s){
        LinkedList<Integer> st = new LinkedList();
        LinkedList<Character> op = new LinkedList();
        for (int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if (isDelimeter(c)){
                continue;
            }
            if (c == '('){
                op.add('(');
            }
            else if (c == ')'){
                while (op.getLast()!='('){
                    processOperator(st, op.removeLast());
                }
                op.removeLast();
            }else if (isOperator(c)){
                while(!op.isEmpty() && priority(op.getLast())>=priority(c)){
                    processOperator(st, op.removeLast());
                }
                op.add(c);
            }else{
                String operand = "";
                while (i<s.length() && Character.isDigit(s.charAt(i))){
                    operand += s.charAt(i++);
                }
                --i;
                st.add(Integer.parseInt(operand));
            }
        }
        while(!op.isEmpty()){
            processOperator(st, op.removeLast());
        }
        return st.get(0);
    }
}
