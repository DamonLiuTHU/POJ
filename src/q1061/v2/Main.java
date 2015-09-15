package q1061.v2;

import java.util.Scanner;

/*
 * TL  1000MS
 */
public class Main {

	private static long GCD(long a, long b) {
		while (b != 0) {
			long r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	public static void main(String[] args) {
		System.out.println(GCD(12,16));
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			// int a = in.nextInt();
			// int b = in.nextInt();
			// System.out.println(a + b);
			long x = in.nextLong(); // A's start point
			long y = in.nextLong(); // B's start point
			long m = in.nextLong(); // A's one jump length
			long n = in.nextLong(); // B's one jump length
			long L = in.nextLong(); // the length of the cycle
			long diff1 = x - y;
//			long diff2 = m - n;

			if (m == n && diff1 % L != 0) {
				System.out.println("Impossible");
			} else {
//				for (int i = 0; i < Integer.MAX_VALUE; i++) {
//					if ((diff1 + diff2 * i) % L == 0) {
//						System.out.println(i);
//						break;
//					}
//				}
				System.out.println(getSmallestValue(x,y,m,n,L));
			}
		}

	}

	private static int getSmallestValue(long x, long y, long m, long n, long l) {
		// TODO Auto-generated method stub
		
		
		
		return 0;
	}

}
