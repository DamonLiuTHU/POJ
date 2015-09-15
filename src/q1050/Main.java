package q1050;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 思路：递归，对于每一个方块进行四面切割
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int N = sc.nextInt();
			int map[][] = new int[N][N];
			for (int i = 0; i < N * N; i++) {
				map[i / N][i % N] = sc.nextInt();
			}
			int MAX = Main.getMaxSquare(map, N);
			System.out.println(MAX);
		}
	}

	static int CurrentLine = -1;
	static int MAX = Integer.MIN_VALUE;
	private static int getMaxSquare(int[][] map, int length) {
		// TODO Auto-generated method stub
		
		for (int beginLine = 0; beginLine < length; beginLine++) { // start from
																	// line i
			for (int endLine = beginLine + 1; endLine < length; endLine++) {
				int[] preComputedArray = new int[length];
				for (int i = 0; i < length; i++) {
					int tmp = 0;
					for (int lineNo = beginLine; lineNo <= endLine; lineNo++) {
						tmp += map[lineNo][i];
					}
					preComputedArray[i] = tmp;
				}

				getMaxForArray(preComputedArray, length - 1);
			}
		}
		return MAX;
	}

	private static int getMaxForArray(int[] preComputedArray, int index) {
		// TODO Auto-generated method stub
		if (index == 0) {
			return preComputedArray[0];
		}
		int nextMax = getMaxForArray(preComputedArray, index-1);
		MAX = nextMax>MAX?nextMax:MAX;
		return Math.max(nextMax + preComputedArray[index], preComputedArray[index]);
	}
}
