package hiho1081;
//the default value for int arrays are 0. which is not so good for me~
import java.util.Scanner;

class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int N = sc.nextInt();
			int M = sc.nextInt();
			int S = sc.nextInt();
			int T = sc.nextInt();
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
			@SuppressWarnings("unused")
			int dist[] = new int[N+1];
			int cycleTimes = N-1;
			int index = S;
			while(cycleTimes>0){
				cycleTimes--;
				int min = Integer.MAX_VALUE;
				int tmp_index = index;
				for(int i=1;i<=N;i++){
					if(i==S) continue;
					if(dist[i]==0) dist[i] = Integer.MAX_VALUE;
					if(Map[index][i]==0) {Map[index][i] = Integer.MAX_VALUE;continue;}
					int tmp = Map[index][i];
					if(tmp==Integer.MAX_VALUE) continue;
					dist[i] = Math.min(dist[index]+tmp,dist[i]);
					if(dist[i]<min){
						min = dist[i];
						tmp_index = i;
					}
				}
				index = tmp_index;
			}
			System.out.println(dist[T]);	
		}	
	}
}