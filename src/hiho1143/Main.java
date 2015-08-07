package hiho1143;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = in.nextInt();
			int result = fibo(N);
			System.out.println(result);
		}

	}

	private static int fibo(int n) {
		// TODO Auto-generated method stub
		if(n==1||n==2){
			return n;
		}else{
			return fibo(n-1)+fibo(n-2);
		}

	}

}
