package q3468;

import java.util.Scanner;
import java.util.Vector;

public class Main {

	static int[] numbers;
	static int N;
	static int Q;
	static String Tag;
	static int a;
	static int b;
	static int c;
	static int sum;
	static Vector<Integer> result = new Vector<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			N = sc.nextInt();
			Q = sc.nextInt();
			numbers = new int[N];
			for (int i = 0; i < N; i++) {
				numbers[i] = sc.nextInt();
			}
			result.clear();
			for (int j = 0; j < Q; j++) {
				Tag = sc.next();
				a = sc.nextInt();
				b = sc.nextInt();
				if (Tag.compareToIgnoreCase("C") == 0) {
					c = sc.nextInt();
					for(int i = a-1;i<b;i++){
						numbers[i] += c;
					}
				}else{
					sum = 0;
					for (int i=a-1;i<b;i++){
						sum += numbers[i];
					}
					result.add(sum);
				}
			}
			for(int sum : result){
				System.out.println(sum);
			}
		}
	}

}
