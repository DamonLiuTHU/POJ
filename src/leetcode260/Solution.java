package leetcode260;

public class Solution {
	/*
	 * Given an array of numbers nums, in which exactly two elements appear only
	 * once and all the other elements appear exactly twice. Find the two
	 * elements that appear only once.
	 * 
	 * For example:
	 * 
	 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
	 * 
	 * Note: The order of the result is not important. So in the above example,
	 * [5, 3] is also correct. Your algorithm should run in linear runtime
	 * complexity. Could you implement it using only constant space complexity?
	 */
	public int[] singleNumber(int[] nums) {
		int[] result = new int[2];
		int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
		for (int i=0;i<nums.length;i++){
			max = nums[i]>max?nums[i]:max;
			min = nums[i]<min?nums[i]:min;
		}
		
		boolean[] boolArray = new boolean[max-min+1];
		
		for (int i=0;i<nums.length;i++){
//			max = nums[i]>max?nums[i]:max;
//			min = nums[i]<min?nums[i]:min;
			nums[i]-=min;
			boolArray[nums[i]] = !boolArray[nums[i]]; 
		}
		int count= 0;
		for (int i=0;i<boolArray.length;i++){
			if(boolArray[i]){
				result[count++] = i+min;
				System.out.println(i+min);
			}
		}
		return result;
	}
	
	public static void main(String args[]){
		int input[] = {-1139700704,-1653765433};
		new Solution().singleNumber(input);
	}
}