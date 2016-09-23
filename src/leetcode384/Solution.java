package leetcode384;

import java.util.Random;

public class Solution {
	public int[] local_nums;
	Random random;
	public Solution(int[] nums) {
		local_nums = nums;
		random = new Random();
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return local_nums;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int[] result = new int[local_nums.length];
		System.arraycopy(local_nums, 0, result, 0, local_nums.length);
		for (int i = 0; i < local_nums.length; i++) {
			int j = result[i];
			int ranPosition = random.nextInt(local_nums.length);
			result[i] = result[ranPosition];
			result[ranPosition] = j;
		}
		return result;
	}

	public static void main(String args[]) {
		int[] input = {1,2,3};
		Solution s = new Solution(input);
		for (int i : s.shuffle()) {
			System.out.print(i+" ");
		}
	}
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(nums); int[] param_1 = obj.reset(); int[] param_2 =
 * obj.shuffle();
 */