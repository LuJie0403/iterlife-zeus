package com.iterlife.zeus.algo.string;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author lujie
 * @version V1.0.0
 * @desc https://leetcode.cn/problems/valid-parentheses/
 * @datetime 2025/6/3 12:00
 **/
public class ValidParentheses {
    public static void main(String args[]) {
        System.out.println(new ValidParentheses().isValid("([])"));
        System.out.println(new ValidParentheses().isValid("()"));
        System.out.println(new ValidParentheses().isValid("()[]{}"));
        System.out.println(new ValidParentheses().isValid("([])"));
        System.out.println(new ValidParentheses().isValid("(]"));
        System.out.println(new ValidParentheses().isValid("([1)"));
        System.out.println(new ValidParentheses().isValid("([1]2)"));
    }
    
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        final HashMap<Character, Character> bracketMap = new HashMap<Character, Character>() {
            {
                put('(', ')');
                put('[', ']');
                put('{', '}');
            }
        };
        
        Stack<Character> bracketStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (bracketMap.containsKey(s.charAt(i))) {
                bracketStack.push(s.charAt(i));
                continue;
            }
            if (bracketMap.containsValue(s.charAt(i))) {
                if (bracketStack.isEmpty()) {
                    return false;
                }
                if (bracketMap.get(bracketStack.peek()).equals(s.charAt(i))) {
                    bracketStack.pop();
                } else {
                    return false;
                }
            }
        }
        return bracketStack.isEmpty();
    }
}