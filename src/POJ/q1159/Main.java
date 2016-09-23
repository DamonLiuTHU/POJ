package POJ.q1159;

import java.util.Scanner;

/**
 * 找回文
 * @author damonliu
 *
 */

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int N = sc.nextInt(); // the length of the string
			String input = sc.next();
			System.out.println(getNumberOfCharsToBePalindrome(input,N));
		}
	}

	private static int getNumberOfCharsToBePalindrome(String s,int N){
		//insert n chars to make s become a 'palindrome'.
		//how to get the LCS (largest common subsequence);
		StringBuilder sb = new StringBuilder(s);
		String reversed_S = sb.reverse().toString();
		return s.length()-getLCSWithSmallerMemoryCost(s, reversed_S, N);
	}
	
//	private static int getLCS(String s1,String s2){
//		int[][] map = new int[s1.length()+1][s2.length()+1];
//		for(int row=1;row<=s1.length();row++){
//			for(int column=1;column<=s2.length();column++){
//				int v1 = map[row][column-1];
//				int v2 = map[row-1][column];
//				int v3 = map[row-1][column-1];
//				if(s1.charAt(row-1)==s2.charAt(column-1)){
//					v3++;
//				}
//				map[row][column] = Math.max(v1, Math.max(v2, v3));
//			}
//		}
//		return map[s1.length()][s2.length()];
//	}
//	
	
	private static int getLCSWithSmallerMemoryCost(String s1,String s2,int N){
		int[][] map = new int[3][N+1];
		for(int row=1;row<=N;row++){
			int tmpRow = (row-1)%2+1;
			int tmpPreviousRow = (row-2)%2+1;
			for(int column=1;column<=N;column++){
				int v1 = map[tmpRow][column-1];
				int v2 = map[tmpPreviousRow][column];
				int v3 = map[tmpPreviousRow][column-1];
				if(s1.charAt(row-1)==s2.charAt(column-1)){
					v3++;
				}
				map[tmpRow][column] = Math.max(v1, Math.max(v2, v3));
			}
		}
		return Math.max(map[1][N],map[2][N]);
	}
}
