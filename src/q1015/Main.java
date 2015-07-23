package q1015;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	
	/*
	 * Best jury has value 6 for prosecution and value 4 for defence: 
 	 *	2 3 
	 */
	public static String[] deal(int[][] info,int n,int m){
		
		
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<String[]> result = new ArrayList<String[]>();
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n==m && n==0){
				break;
			}
			int info[][] = new int[n][4];
			for(int i = 0 ; i< n;i++){
				int pi = sc.nextInt();
				int di = sc.nextInt();
				info[i][0] = pi;
				info[i][1] = di;
				
				int vi = di - pi;
				info[i][2] = vi;
				int si = di + pi;
				info[i][3] = si;
			}
			String[] temp = Main.deal(info, n, m);
			result.add(temp);
		}
		int counter = 0;
		for(String[] a : result){
			counter++;
			System.out.println("Jury #"+counter);
			System.out.println(a[0]);
			System.out.println(a[1]);
			System.out.println();
		}
	}

}
