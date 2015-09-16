package hiho1089;

import java.util.Scanner;

public class Main {
	private static Scanner sc;

	/*
	 * 'Floyd'算法,使用数学归纳法，在一步一步放开限制的过程中，将每两个点之间的距离放开。
	 */
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		while(sc.hasNext()){
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] map = new int[N+1][N+1];
			for(int i=1;i<=N;i++){
				for(int j=1;j<=N;j++){
					if(i!=j)
						map[i][j] = Integer.MAX_VALUE;
				}
			}
			for(int inputcount=0;inputcount<M;inputcount++){
				int start = sc.nextInt();
				int end = sc.nextInt();
				int length = sc.nextInt();
				if(map[start][end]>length){
					map[start][end] = length;
					map[end][start] = length;
				}
			}
			
			for(int k = 1 ;k <= N ;k++){
				for (int i = 1;i<=N ;i++){
					for(int j = 1;j <= N;j++){
						if(i!=j&&k!=i&&j!=k){
							int newLength = map[i][k] + map[k][j];
							if(newLength < map[i][j]&&newLength>0){
								map[i][j] = newLength;
							}
						}
					}
				}
			}
			
			for(int i=1;i<=N;i++){
				for(int j=1;j<=N;j++){
					System.out.print(map[i][j]+" ");
				}
				System.out.println("");
			}
		}
	}

}
