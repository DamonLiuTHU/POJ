package hihocode.hiho1097;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		int N = sc.nextInt(); // the number of cities / the number of Nodes in
								// the graph
		int[][] Map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Map[i][j] = sc.nextInt();
			}
		}
		boolean[] selected = new boolean[N];
		int index = 0;
		int selected_villege_count = 1;
		selected[index] = true;
		while (selected_villege_count != N) {
			selected_villege_count++;
			index = getNext(selected, Map);
		}
		System.out.println(distance);

	}

	static int distance = 0;
	private static Scanner sc;
	
	/*
	 * 	0 4 0 0 0 0 0 8 0
        4 0 8 0 0 0 0 11 0
        0 8 0 7 0 4 0 0 2
        0 0 7 0 9 14 0 0 0
        0 0 0 9 10 0 0 0 0
        0 0 4 14 10 0 2 0 0
        0 0 0 0 0 2 0 1 6
        8 11 0 0 0 0 1 0 7
        0 0 2 0 0 0 6 7 0
	 */

	private static int getNext(boolean[] selected, int[][] map) {
		// TODO Auto-generated method stub
		// find the next Node and add distance
		int smallest_distance = Integer.MAX_VALUE;
		int from = -1, to = -1;
		for (int i = 0; i < selected.length; i++) {
			if (selected[i]) {
				for (int j = 0; j < selected.length; j++) {
					if (j!=i&&!selected[j]&&map[i][j]!=0&&map[i][j] < smallest_distance) {
						smallest_distance = map[i][j];
						from = i;
						to = j;
					}else{
						continue;
					}
				}
			}else{
				continue;
			}
		}
		distance += map[from][to];
		map[from][to] = Integer.MAX_VALUE;
		map[to][from] = Integer.MAX_VALUE;
//		System.out.println(from+"->"+to);
		selected[to] = true;
		return to;
	}

}
