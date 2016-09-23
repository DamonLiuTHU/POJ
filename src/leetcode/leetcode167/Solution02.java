package leetcode.leetcode167;

public class Solution02 {
	/*
	 * 1.directly search from number01 to numberx, it takes time n for array of
	 * n. 2.binary search for result. O(n)=log2n TLE so we must use solution2.
	 */
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];

		for (int i = 0; i < numbers.length; i++) {

			int low = i;// cannot reach
			int high = numbers.length;// cannot reach
			int index = i + 1;
			boolean findSolution = false;
			while (true) {
				if (index <=i  || index >= numbers.length || low+1 >= high) {
					break;
				}
				int addResult = numbers[i] + numbers[index];
				if (addResult > target) {
					high = index;
					index = (index + low) / 2;
					continue;
				}
				if (addResult == target) {
					findSolution = true;
					break;
				}
				if (addResult < target) {
					low = index;
					index = (index + high) / 2;
					continue;
				}

			}
			if (findSolution) {
				result[0] = i+1;
				result[1] = index +1;
				System.out.println(result[0]+":"+numbers[result[0]-1]);
				System.out.println(result[1]+":"+numbers[result[1]-1]);
				return result;
			} else {
				continue;
			}
		}

		return result;
	}

	/*
	 * the result is 0 if no index matches the target up param can change
	 */
	public int indexOfPairedNumber(int beginIndex, int up, int numbers[], int target, int upperIndex, int deepth) {
		if (deepth >= upperIndex) {
			return 0;
		}
		if (beginIndex == up) {
			return 0;
		}
		if (up >= upperIndex) {
			return 0;
		}
		int number1 = numbers[beginIndex];
		int number2 = numbers[up];

		if (up == upperIndex - 1 && number1 + number2 < target) {
			return 0;
		}

		if (number1 + number2 == target) {
			return up;
		}
		if (number1 + number2 > target) {
			return indexOfPairedNumber(beginIndex, (beginIndex + up) / 2, numbers, target, upperIndex, ++deepth);
		}
		if (number1 + number2 < target) {
			return indexOfPairedNumber(beginIndex, (upperIndex + up) / 2, numbers, target, upperIndex, ++deepth);
		}

		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * [3,24,50,79,88,150,345] 200
		 * 
		 * [12,13,23,28,43,44,59,60,61,68,70,86,88,92,124,125,136,168,173,173,
		 * 180,199,212,221,227,230,277,282,306,314,316,321,325,328,336,337,363,
		 * 365,368,370,370,371,375,384,387,394,400,404,414,422,422,427,430,435,
		 * 457,493,506,527,531,538,541,546,568,583,585,587,650,652,677,691,730,
		 * 737,740,751,755,764,778,783,785,789,794,803,809,815,847,858,863,863,
		 * 874,887,896,916,920,926,927,930,933,957,981,997] 542
		 */
		int[] inputNums = { 0,0,3,4 };
		new Solution02().twoSum(inputNums, 0);
	}
}
