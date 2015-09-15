package q3468;

import java.util.Scanner;
import java.util.Vector;
/**
 * http://kenby.iteye.com/blog/962159
 * 线段树，感觉上是为了加快计算速度，用空间换时间效率的方式。 引入辅助数组来减少计算耗时。
 * @author damonliu
 *
 */
public class Main {

	static int[] numbers;
	static int[] delta;
	static int[] deltaMi;
	static int[] sum;
	static int N;
	static int Q;
	static String Tag;
	static int a;
	static int b;
	static int c;
	static Vector<Integer> result = new Vector<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			N = sc.nextInt();
			Q = sc.nextInt();
			numbers = new int[N+1];
			delta = new int[N+1];
			sum = new int[N+1];
			deltaMi = new int[N+1];
			for (int i = 1; i <= N; i++) {
				numbers[i] = sc.nextInt();
				sum[i] = sum[i - 1] + numbers[i];
			}
			result.clear();
			for (int j = 0; j < Q; j++) {
				Tag = sc.next();
				a = sc.nextInt();
//				a--;
				b = sc.nextInt();
				if (Tag.compareToIgnoreCase("C") == 0) {
					c = sc.nextInt();
					updateTree();
				} else {
					result.add(getSum());
				}
			}
			for (int sum : result) {
				System.out.println(sum);
			}
		}
	}

	public static void updateTree() {
		for (int i = a; i <= b; i++) {
			delta[i] += c;
			deltaMi[i] += (a)*c;
		}
//		for (int i = b; i < N; i++) {
//			delta[i] -= c;
//		}
	}

	public static int getSum() {
		return getSum(b)-getSum(a-1);
	}
	
	public static int getSum(int x){
		int ans = sum[x];
		for(int i=0;i<x;i++){
			ans+= (x+1)*delta[i] - deltaMi[i];
		}
		return ans;
	}

}
