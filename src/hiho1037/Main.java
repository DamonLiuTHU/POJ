package hiho1037;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = in.nextInt();
//			Vector<int[]> input = new Vector<int[]>(2);
			int[][] input = new int[2][];
//			input.add(new Integer[0]);
			for(int i=0;i<=N;i++){
				int[] array = new int[i+2];//for the benefit of simplify code
				int index = i%2;  int temp;
				temp = Math.abs(index-1);
				for(int j=1;j<=i;j++){
					int[] downline = input[temp];
					array[j] = in.nextInt()+Math.max(downline[j-1],downline[j]);
				}
				
				input[index] = array;
			}
			int[] final_result = input[N%2];
			Arrays.sort(final_result);
			System.out.println(final_result[N+1]);
		}
	}
}