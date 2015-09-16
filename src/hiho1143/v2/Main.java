package hiho1143.v2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		in = new Scanner(System.in);
		while (in.hasNext()) {
			long N = in.nextLong();
//			long result = fibo(N);
//			long result = 0;
			long[][] tmp = get_a_n(N);
//			long[] res = {tmp[1][0],tmp[1][1]};
			long v = tmp[1][1];
//			System.out.println(Math.floorMod(v, 19999997));
			System.out.println(v%19999997);
		}

	}
	static final long basic[][] ={ {0,1},{1,1} };
	private static Scanner in;
	private static long[][] get_a_n(long n){
		if(n==1){
			return basic;
		}
		if(n%2==1){
			long[][] tmp = get_a_n(n-1);
			long res[][] = {{tmp[1][0],tmp[1][1]},{tmp[0][0]+tmp[1][0],tmp[0][1]+tmp[1][1]}};
			return res;
		}
		
		long[][]  tmp = get_a_n(n/2);
		tmp = matrixOp(tmp,tmp);
//		long[] res = {tmp[1][0],tmp[1][1]};
		return tmp;
	}
	
	private static long[][]	matrixOp(long[][] m1,long[][] m2){
		long[][] tmp = { 
						{m2[0][0]*m1[0][0]+m2[1][0]*m1[0][1],m2[0][1]*m1[0][0]+m2[1][1]*m1[0][1]},
						{m2[0][0]*m1[1][0]+m2[1][0]*m1[1][1],m2[0][1]*m1[1][0]+m2[1][1]*m1[1][1]}
							 };
		
		return tmp;
	}

//	private static long fibo(long n) {
//		// TODO Auto-generated method stub
//		if(n==1||n==2){
//			return n;
//		}else{
//			return fibo(n-1)+fibo(n-2);
//		}
//
//	}

}
