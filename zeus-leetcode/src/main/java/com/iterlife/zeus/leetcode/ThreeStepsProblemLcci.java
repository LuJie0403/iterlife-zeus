package com.iterlife.zeus.leetcode;

/**
 * @desc:https://leetcode-cn.com/problems/three-steps-problem-lcci/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/21 23:14
 **/
public class ThreeStepsProblemLcci {
    public static void main(String args[]) {
        System.out.println(String.format("step[%s]=%s", 3, new ThreeStepsProblemIcciSolution().waysToStep(3)));
        System.out.println(String.format("step[%s]=%s", 4, new ThreeStepsProblemIcciSolution().waysToStep(4)));
        System.out.println(String.format("step[%s]=%s", 5, new ThreeStepsProblemIcciSolution().waysToStep(5)));
        System.out.println(String.format("step[%s]=%s", 10, new ThreeStepsProblemIcciSolution().waysToStep(10)));
        System.out.println(String.format("step[%s]=%s", 1000000, new ThreeStepsProblemIcciSolution().waysToStep(1000000)));

    }

}

class ThreeStepsProblemIcciSolution {
    public int waysToStep(int n) {
        int[] stepCounter = new int[]{0, 1, 2, 4};
        int tempStepCounter = 0;
        if (n < 4) {
            return stepCounter[n];
        }
        int stepCounter1 = 1, stepCounter2 = 2, stepCounter3 = 4;
        for (int i = 4; i <= n; i++) {
            tempStepCounter = ((stepCounter3 + stepCounter2) % 1000000007 + stepCounter1) % 1000000007;
            stepCounter1 = stepCounter2;
            stepCounter2 = stepCounter3;
            stepCounter3 = tempStepCounter;
        }
        return tempStepCounter;
    }
}
