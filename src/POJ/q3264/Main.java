package POJ.q3264;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static Scanner sc;
	static int N;
	static int Q;
	static int[] cow;
	static int[][] MAX;
	// static int[][] MIN;
	static int[][] path;
	
	public static int getMinFromMap(int i, int j) {
		if(i<j){
			i = i+j;
			j = i-j;
			i = i-j;
		}
		return MAX[i][j];
	}

	public static void setMinForMap(int i, int j,int value) {
		if(i<j){
			i = i+j;
			j = i-j;
			i = i-j;
		}
		MAX[i][j] = value;
	}

	public static  int getMaxFromMap(int i, int j) {
		if(i>j){
			i = i+j;
			j = i-j;
			i = i-j;
		}
		return MAX[i][j];
	}

	public  static void setMaxForMap(int i, int j,int value) {
		if(i>j){
			i = i+j;
			j = i-j;
			i = i-j;
		}
		MAX[i][j] = value;
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		while (sc.hasNext()) {
			N = sc.nextInt();
			Q = sc.nextInt();
			cow = new int[N];
			MAX = new int[N][N];
//			MIN = new int[N][N];
			path = new int[Q][2];
			for (int i = 0; i < N; i++) {
				cow[i] = sc.nextInt();
			}
			createMap();
			for (int i = 0; i < Q; i++) {
				path[i][0] = sc.nextInt();
				path[i][1] = sc.nextInt();
			}

			ArrayList<Integer> result = Main.getResult();
			for (int i : result) {
				System.out.println(i);
			}

		}
	}

	private static void createMap() {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
//				MAX[i][j] = getMax(i, j);
				setMaxForMap(i, j, getMaxValueForRange(i, j));
//				MIN[i][j] = getMin(i, j);
				setMinForMap(i, j, getMinValueForRange(i, j));
			}
		}
	}

	private static int getMinValueForRange(int i, int j) {
		// TODO Auto-generated method stub
		// return 0;
		if (i == j)
			return cow[i];
		if (i > j) {
			int tmp = i;
			i = j;
			j = tmp;
		}
		if (getMinFromMap(i, j) != 0) {
			return getMinFromMap(i, j);
		}
		if (i + 1 == j) {
			return Math.min(cow[i], cow[j]);
		}
		return Math.min(getMinValueForRange(i, j - 1), getMinValueForRange(j - 1, j));
	}

	private static int getMaxValueForRange(int i, int j) {
		// TODO Auto-generated method stub
		// the biggest diff form i to j;

		if (i == j)
			return cow[i];
		if (i > j) {
			int tmp = i;
			i = j;
			j = tmp;
		}
		if (getMaxFromMap(i, j) != 0) {
			return getMaxFromMap(i, j);
		}
		if (i + 1 == j) {
			return Math.max(cow[i], cow[j]);
		}
		return Math.max(getMaxValueForRange(i, j - 1), getMaxValueForRange(j - 1, j));
	}

	private static ArrayList<Integer> getResult() {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int[] apath : path) {
			int start = apath[0] - 1;
			int end = apath[1] - 1;
			int max = getMaxFromMap(start, end);
			int min = getMinFromMap(start, end);
			list.add(max - min);
		}
		return list;
	}

}
