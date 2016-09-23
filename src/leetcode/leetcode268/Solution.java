package leetcode.leetcode268;

/**
 * Created by DamonLiu on 16/9/23.
 */
public class Solution {
    /*
    Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.


     */
    public int missingNumber(int[] nums) {
//        if (nums.length==1){
//            return nums[0];
//        }
//        int max = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
        int min = 0;
        int max = nums.length;
//        for (int i = 0; i < nums.length; i++) {
//            max = nums[i] > max ? nums[i] : max;
//            min = nums[i] < min ? nums[i] : min;
//        }
        boolean[] hitArray = new boolean[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            hitArray[nums[i] - min] = true;
        }
        for (int i = 0; i < hitArray.length; i++) {
            if (!hitArray[i])
                return i;
        }
        return -1;
    }

    public static void main(String args[]){
        int[] input = {0};
        int result = new Solution().missingNumber(input);
        System.out.println(result);
    }
}
