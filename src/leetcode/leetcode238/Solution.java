package leetcode.leetcode238;

public class Solution {

	static int[] local_nums;
	static int[] PL;
	static int[] PR;

	public int[] productExceptSelf(int[] nums) {
		Solution.local_nums = nums;
		int result[] = new int[nums.length];
		// int totalProduct = 1;

//		int[] PL = new int[nums.length];
//		int[] PR = new int[nums.length];
		PL = new int[nums.length];
		PR = new int[nums.length];
		
		fillInPR(PR);
		fillInPL(PL);
		for (int i = 0; i < nums.length; i++) {
			result[i] = PL[i] * PR[i];
		}
//		result = PL;
		return result;
	}

	public void fillInPR(int[] array) {
		calculatePR(array, 0);
	}

	public void fillInPL(int[] array) {
		calculatePL(array, local_nums.length - 1);
	}

	public static void calculatePR(int[] pr, int n) {
		assert (n >= 0 && n < local_nums.length);
//		if (n == local_nums.length - 1) {
//			pr[n] = 1;
//			return 1;
//		}
//		pr[n] = local_nums[n + 1] * calculatePR(pr, n + 1);
//		return pr[n];
		for (int i=local_nums.length-1;i>=0;i--){
			if(i==local_nums.length-1){
				pr[i] = 1;
			} else {
				pr[i] = local_nums[i+1] * pr[i+1];
			}
		}
	}

	public static void calculatePL(int[] pr, int n) {
//		assert (n >= 0 && n < local_nums.length);
//		if (n == 0) {
//			pr[n] = 1;
//			return 1;
//		}
//		pr[n] = local_nums[n - 1] * calculatePL(pr, n - 1);
//		return pr[n];
		for (int i=0;i<local_nums.length;i++){
			if(i==0){
				pr[i] = 1;
			} else {
				pr[i] = local_nums[i-1] * pr[i-1];
			}
		}
	}
	
	
	public static void main(String args[]) {
		int[] input = { 1, 2, 3, 4};
		new Solution().productExceptSelf(input);
	}
}