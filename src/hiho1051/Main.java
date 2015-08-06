package hiho1051;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int cases = in.nextInt();
			while(cases-->0){
				int N = in.nextInt();
				int M = in.nextInt();
//				ArrayList<Integer> days = new ArrayList<Integer>(N);
				byte[] days = new byte[100];
				for(int i=0;i<N;i++){
//					days.add(in.nextInt());
					days[in.nextInt()-1] = 1;
				}
				int MAX = getMax(days,M);
				System.out.println(MAX);
			}
		}

	}
	/*
	 * 
	 */
	private static int getMax(byte[] days, int m) {
		//m张卡，最长能练成多少的。
		int MAX = 0;
		for(int i=0;i<days.length;i++){
			
		}
		return MAX;
	}

}
