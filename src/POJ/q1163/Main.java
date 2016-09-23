package POJ.q1163;

import java.util.Scanner;
/**
 * 一开始没用max数组来存储之前的计算结果导致超时  很简单的DP
 * @author damonliu
 *
 */
public class Main {
static int N;
static int[][] map = null;  //存储三角数据
static int[][] max = null;  //存储最大值数据，缩短计算时间
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			 N = sc.nextInt();
			map = new int[N][N];
			max = new int[N][N];
			for(int i=0;i<N;i++){
				for(int j=0;j<=i;j++){
					map[i][j] = sc.nextInt();
				}
			}
			int i = getMax();
			map = null;
			max = null;
			System.out.println(i);
		}
	}

	private static int getMax() {
		// TODO Auto-generated method stub
		return getMax(0,0);
	}
	
	private static int getMax(int i,int j){
		if(max[i][j]!=0){
			return max[i][j];
		}
		if(i==N-1){
			max[i][j] = map[i][j];
			return map[i][j];
		}else{
			max[i][j] = map[i][j]+Math.max(getMax(i+1,j), getMax(i+1,j+1));
			return max[i][j];
		}
	}

}
