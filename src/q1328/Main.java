package q1328;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
/*
 * 贪心算法
 */
public class Main {
	
	public static double getDistance(int[] island,double[] p2){
		return Math.pow(((double)island[0]-p2[0])*((double)island[0]-p2[0])+((double)island[1]-p2[1])*((double)island[1]-p2[1]), 0.5);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(true){
			int n = sc.nextInt();//n islands
			int d = sc.nextInt();//the radius of radar
			if(n==d&&n==0){
				break;
			}
			ArrayList<int[]> islands = new ArrayList<int[]>(n);
			for(int i=0;i<n;i++){
				int x = sc.nextInt();
				int y = sc.nextInt();
				int[] temp = {x,y};
				islands.add(temp);
			}
			Collections.sort(islands, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o1[0]-o2[0];
				}
				
			});
			int counter=1;
			int[] cur_island = islands.get(0);
//			int[] nxt_island = islands.get(1);
			int[] nxt_island;
			for(int i =1;i<n;i++){ // just check the first n-1 islands.
//				cur_island = islands.get(i);
				
				if(cur_island[1]>d){
					counter = -1;
					break;
				}
				
				nxt_island = islands.get(i);
				int cur_x = cur_island[0];
				int cur_y = cur_island[1];
				double right_limit = cur_x + Math.pow(d*d - cur_y*cur_y, 0.5);
				double[] right_limit_p = {right_limit,0};
				if(getDistance(nxt_island,right_limit_p )>d){
					//if the next island cannot be included by this radar. new a radar.
					counter++;
//					nxt_island = islands.get(i+1);
					cur_island = nxt_island;
//					continue;
				}else{
//					continue;
				}
				
			}
//			StringBuilder sb = new StringBuilder();
			result.add(counter);
			
		}
		
		
		for(int i = 1 ; i <= result.size() ;i++){
			System.out.println("case "+i+": "+result.get(i-1));
		}
		
	}

}
