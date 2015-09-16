package q1258;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int N = sc.nextInt();
			int[][] map = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			ArrayList<Integer> Apackage = new ArrayList<Integer>(N);// store the
																	// determined
																	// villeges
			ArrayList<Integer> Bpackage = new ArrayList<Integer>(N);// the
																	// villeges
																	// still not
																	// decided;
			for (int i = 2; i <= N; i++) {
				Bpackage.add(i);
			}
			Apackage.add(1);
			int pathlength = 0;
			while (Apackage.size() < N) {
				int min = Integer.MAX_VALUE;
//				int minIndex = 0;
				Integer minEndIndex = 0;
				for (Integer villageA : Apackage) {
					for (Integer villageB : Bpackage) {
						int distance = map[villageA][villageB];
						if (distance < min) {
							min = distance;
//							minIndex = villageA;
							minEndIndex = villageB;
						}
					}
				}
				pathlength += min;
				Apackage.add(minEndIndex);
				Bpackage.remove(minEndIndex);
			}
			
			System.out.println(pathlength);
		}
	}

}
