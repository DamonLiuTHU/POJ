package q1061;

import java.util.Scanner;
/*
 * TLE
 */
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
//			int a = in.nextInt();
//			int b = in.nextInt();
//			System.out.println(a + b);
			int x = in.nextInt();
			int y = in.nextInt();
			int m = in.nextInt();
			int n = in.nextInt();
			int L = in.nextInt();
			for(int i=0;;i++){
				int result = ((x-y)+(m-n)*i)%L;
				if(result == 0){
					System.out.println(i);
					break;
				}
			}
		}

	}

}
