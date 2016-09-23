package POJ.q1088;

import java.util.Scanner;
/**
 * 滑雪，动态规划　
 * @author damonliu
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		while(sc.hasNext()){
			int R = sc.nextInt();
			int C = sc.nextInt();
			int map[][] = new int[R][C];
			int max[][] = new int[R][C];
			for(int i=0;i<R;i++){
				for(int j= 0;j<C;j++){
					map[i][j] = sc.nextInt();
					max[i][j] = 1;
				}
			}
			int result = Main.getMaxLength(map,max,R,C);
			System.out.println(result);
		}
	}

	/**
	 * 动态规划计算最长下滑路径
	 * @param map
	 * @return
	 */
	//思路：寻找周围最
	private static int getMaxLength(int[][] map,int [][] max,int R, int C) {
		// TODO Auto-generated method stub
		int MAX = 0;
		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++){
				max[i][j] = getMaxFor(i,j,map,max,R,C);
				if(max[i][j]>MAX){
					MAX = max[i][j];
				}
			}
		}
		return MAX;
	}
	
	private static int getMaxFor(int i,int j,int[][] map,int[][] max,int R,int C){
		if(i<0||j<0||i>=R||j>=C){
			return -999;
		}
		int tmpMax = max[i][j];
		if(tmpMax!=1){
			return tmpMax;
		}
		if(lowestPoint(i, j, map,R,C)){
			return tmpMax;
		}
		int leftMax=0,rightMax=0,upMax=0,downMax = 0;
		if(j-1>=0&&map[i][j-1]<map[i][j]){
			leftMax = getMaxFor(i, j-1, map, max,R,C);
		}
		if(j+1 < C&&map[i][j+1]<map[i][j]){
			rightMax = getMaxFor(i, j+1, map, max,R,C);
		}
		if(i-1>=0&&map[i-1][j]<map[i][j]){
			upMax = getMaxFor(i-1, j, map, max,R,C);
		}
		if(i+1<R&&map[i+1][j]<map[i][j]){
			downMax = getMaxFor(i+1, j, map, max,R,C);
		}
		
		tmpMax = Math.max(leftMax, Math.max(rightMax, Math.max(upMax, downMax)));
		return ++tmpMax;
	}
	
	private static boolean lowestPoint(int i,int j,int[][] map,int R,int C){
		boolean isLowest = true;
		if(i-1>=0&&map[i-1][j]<map[i][j]){
			return false;
		}
		if(j-1>=0&&map[i][j-1]<map[i][j]){
			return false;
		}
		if(i+1<R&&map[i+1][j]<map[i][j]){
			return false;
		}
		if(j+1<C&&map[i][j+1]<map[i][j]){
			return false;
		}
		
		return isLowest;
	}

}
