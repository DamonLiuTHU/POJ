package hiho1372;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	
	//get the number of x^2 numbers needed to add up to n
	public static int printResult(int n,int deepth){
		if (n==0) {
//			System.out.println(n);
			return deepth + n;
		}
		
		for (int i = 2; i <= n ; i++) {
			if (i * i > n) {
				n -= (i-1)*(i-1);
//				System.out.println(i-1+" ");
				return printResult(n, deepth+1);
			} else {
				
			}
		}
		return deepth+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Main m = new Main();
		Scanner sc = new Scanner(System.in);
		 ArrayList<Integer> list = new ArrayList<Integer>();
		while (sc.hasNext()) {
			int n = sc.nextInt();
			if (n == -1) {
				break;
				// return;
			}
			list.add(n);
		}
		
		for (Integer integer : list) {
//			System.out.println("here is the list =>");
			System.out.println(printResult(integer, 0));
		}
		
		
	}
}
