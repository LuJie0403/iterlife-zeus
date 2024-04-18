package com.iterlife.zeus.algo.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 评估逆波兰表达式的值
 *
 * @desc:https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2024/4/18 19:00
 **/
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        // 测试用例
        System.out.println(new EvaluateReversePolishNotationSolution().evalRPN(new String[]{"2", "1", "+"}));
        System.out.println(new EvaluateReversePolishNotationSolution().evalRPN(new String[]{"2", "1", "+", "1", "+"}));
        System.out.println(new EvaluateReversePolishNotationSolution().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(new EvaluateReversePolishNotationSolution().evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(new EvaluateReversePolishNotationSolution().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}


class EvaluateReversePolishNotationSolution {
    /**
     * 评估逆波兰表达式的值
     *
     * @param tokens 逆波兰表达式的字符串数组形式
     * @return 评估结果
     */
    public int evalRPN(String[] tokens) {
        // 使用双端队列存储运算数
        Deque<Integer> queue = new ArrayDeque<Integer>();
        // 遍历逆波兰表达式的每一个元素
        for (String token : tokens) {
            // 获取运算符，并执行相应的计算操作
            Operator operator = Operator.getOperator(token);
            if (operator != null) {
                // 保证有充足的运算数供运算
                Integer param1 = queue.poll();
                Integer param2 = queue.poll();
                if (param2 != null) {
                    // 执行计算并将结果入队
                    queue.push(operator.compute(param1, param2));
                }
            } else {
                // 如果是数字，直接入队
                queue.push(Integer.valueOf(token));
            }
        }
        // 最后队列中即为计算结果
        return queue.poll();
    }
}

/**
 * 运算符基类
 */
class Operator {
    /**
     * 根据运算符代码获取运算符实例
     *
     * @param code 运算符代码
     * @return 对应的运算符实例，如果无对应运算符则返回null
     */
    public static Operator getOperator(String code) {
        if ("+".equals(code)) {
            return new AddOperator();
        }
        if ("-".equals(code)) {
            return new SubtractOperator();
        }
        if ("*".equals(code)) {
            return new MultiplyOperator();
        }
        if ("/".equals(code)) {
            return new DivideOperator();
        }
        return null;
    }

    /**
     * 执行计算操作
     *
     * @param param1 运算数1
     * @param param2 运算数2
     * @return 计算结果
     */
    public Integer compute(Integer param1, Integer param2) {
        return compute(param1, param2);
    }


}

/**
 * 加法运算符
 */
class AddOperator extends Operator {
    @Override
    public Integer compute(Integer param1, Integer param2) {
        return param2 + param1;
    }
}

/**
 * 减法运算符
 */
class SubtractOperator extends Operator {
    @Override
    public Integer compute(Integer param1, Integer param2) {
        return param2 - param1;
    }
}

/**
 * 乘法运算符
 */
class MultiplyOperator extends Operator {
    @Override
    public Integer compute(Integer param1, Integer param2) {
        return param2 * param1;
    }
}

/**
 * 除法运算符
 */
class DivideOperator extends Operator {
    @Override
    public Integer compute(Integer param1, Integer param2) {
        return param2 / param1;
    }
}

