package q1061.v2;

import java.util.Scanner;
/*
 * 
 */
public class Main {
	
	public static long gcd(long a, long b) {  
	    while(b!=0) {  
	        long r = a % b;  
	        a = b;  
	        b = r;  
	    }  
	    return a;  
	}  

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
//			int a = in.nextInt();
//			int b = in.nextInt();
//			System.out.println(a + b);
			long x = in.nextLong();
			long y = in.nextLong();
			long m = in.nextLong();
			long n = in.nextLong();
			long L = in.nextLong();
			long diff1 = x-y;
			long diff2 = m-n;
			
			if(m==n&&diff1%L!=0){
				System.out.println("Impossible");
			}
			for(int i=0;i<Integer.MAX_VALUE;i++){
				if(	(diff1+diff2*i)%L == 0){
					System.out.println(i);
					break;
				}
			}
		}

	}

}
