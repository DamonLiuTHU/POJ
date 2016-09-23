package leetcode.leetcode343;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by DamonLiu on 16/9/23.
 * <p>
 * Given a positive integer n, break it into the sum of at least two positive integers
 * and maximize the product of those integers. Return the maximum product you can get.
 * <p>
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * <p>
 * Note: You may assume that n is not less than 2 and not larger than 58.
 */
public class Solution {

    HashMap<Integer,Integer> calculatedResults = new HashMap<>();

    public int integerBreak(int n) {

        if (calculatedResults.containsKey(n)){
            return calculatedResults.get(n);
        }
//        if(n==2){
//            return 1;
//        }
//        if(n==3){
//            return 2;
//        }

        // condition 1
//        ArrayList<Integer> resultListForBreakUp = new ArrayList<>();
        int maxValue = 0;
        for (int i=1;i<=n/2;i++){
            int num1 = i;
            int num2 = n - i;
            int condition1Result = 0;

            if (num1 <= 3 && num2 <= 3) {
                condition1Result = num1 * num2;
            } else if (num1 <= 3 && num2 > 3) {
                condition1Result = num1 * integerBreak(num2);
            } else if (num2 <= 3 && num1 > 3) {
                condition1Result = num2 * integerBreak(num1);
            } else {
                condition1Result = integerBreak(num1) * integerBreak(num2);
            }

            maxValue = condition1Result > maxValue ? condition1Result : maxValue;
        }

//        // condition 2
//        num1 = (n - 1) / 2;
//        num2 = n - num1;
//        int condition2Result = 0;
//
//        if (num1 <= 3 && num2 <= 3) {
//            condition2Result = num1 * num2;
//        } else if (num1 <= 3 && num2 > 3) {
//            condition2Result = num1 * integerBreak(num2);
//        } else if (num2 <= 3 && num1 > 3) {
//            condition2Result = num2 * integerBreak(num1);
//        } else {
//            condition2Result = integerBreak(num1) * integerBreak(num2);
//        }
//
//        return Math.max(condition1Result, condition2Result);
        calculatedResults.put(n,maxValue);
        return maxValue;
    }

    public static void main(String args[]) {
        System.out.println(new Solution().integerBreak(31));
    }
}
