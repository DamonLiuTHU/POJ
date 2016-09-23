package hihocode.hiho1081;

import java.util.ArrayList;
import java.util.Scanner;

class Main{
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
//			int count = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			int S = sc.nextInt();
			int T = sc.nextInt();
			ArrayList<Integer> pathset = new ArrayList<Integer>(N);
			int Map[][] = new int[N+1][N+1];
			for(int i = 1;i<=M;i++){
				int start = sc.nextInt();
				int end = sc.nextInt();
				int length = sc.nextInt();
				if(Map[start][end]==0||Map[start][end]>length){
					Map[start][end] = length;
					Map[end][start] = length;
				}
			}
			int dist[] = new int[N+1];
			int index = S;
			pathset.add(index);
			int cycleTime = N;
			while(pathset.size()!=N&&cycleTime!=0){
				cycleTime--;
				int min = Integer.MAX_VALUE;
				for(int i=1;i<=N;i++){			
					if(pathset.contains(i)){
						continue;
					}
					if(dist[i]==0) 
						dist[i] = Integer.MAX_VALUE;
					for(int nodes:pathset){
//						count++;
						if(Map[nodes][i]==0) {Map[nodes][i] = Integer.MAX_VALUE;continue;}
						if(Map[nodes][i]==Integer.MAX_VALUE) continue;
						int tmp = Math.min(dist[nodes]+Map[nodes][i],dist[i]);
						if(tmp < dist[i]){
							dist[i] = tmp;
						}
					}
					if(dist[i] < min){
						min = dist[i];
						index = i;
					}
				}
				
				pathset.add(index);
			}
			System.out.println(dist[T]);	
		}	
	}
}
/*
5 7 0 3
0 1 100
0 2 30
0 4 10
2 1 60
2 3 60
3 1 10
4 3 50
70
 */
