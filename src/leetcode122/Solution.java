package leetcode122;

//public class Solution {
//

//
//}

public class Solution {

	public int maxProfit(int[] prices) {
		if(prices.length<=1){
			return 0;
		}
		int[] profitChangeArray = new int[prices.length - 1];
		int maxProfit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			profitChangeArray[i] = prices[i + 1] - prices[i];
			if (profitChangeArray[i] > 0) {
				maxProfit += profitChangeArray[i];
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}