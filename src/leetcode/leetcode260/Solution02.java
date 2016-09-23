package leetcode.leetcode260;


import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.HashMap;

//package leetcode.leetcode260;
public class Solution02 {
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
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
//		boolean[] boolArray = new boolean[max-min+1];
		
		for (int i=0;i<nums.length;i++){
//			max = nums[i]>max?nums[i]:max;
//			min = nums[i]<min?nums[i]:min;
//			nums[i]-=min;
//			boolArray[nums[i]] = !boolArray[nums[i]];
			if (map.get(nums[i]) != null) {
				map.put(nums[i], map.get(nums[i])+1);
				continue;
			} else {
				map.put(nums[i],1);
			}
		}
		int counter = 0;
		ArrayList<Integer> resultlist = new ArrayList<Integer>(2);
		
		for (Entry<Integer, Integer> i : map.entrySet()) {
			if (i.getValue()==1) {
//				result[counter++] = i.getKey();
				System.out.println(i.getKey());
				resultlist.add(i.getKey());
			}
		}
		result[0] = resultlist.get(0);
		result[1] = resultlist.get(1);
		return result;
	}
	
	public static void main(String args[]){
		int input[] = {1,2,1,3,2,5};
		new Solution02().singleNumber(input);
	}
}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
