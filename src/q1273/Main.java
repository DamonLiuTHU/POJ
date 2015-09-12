package q1273;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
static int[][] originInput;
static int N;
static int M;
static LinkedList<int[]> simplifiedInput;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			N = in.nextInt();
			M = in.nextInt();
			originInput = new int[N][3];
			for (int i = 0; i < N; i++) {
				originInput[i][0] = in.nextInt();
				originInput[i][1] = in.nextInt();
				originInput[i][2] = in.nextInt();
			}

			Arrays.sort(originInput, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					if (o1[0] == o2[0])
						return o1[1] - o2[1];
					return o1[0] - o2[0];

				}

			}); // get this map sourted by the index

			simplifiedInput = new LinkedList<int[]>();  // because of the situation that the flow forms a cycle.
			for(int[] array : originInput){
				if(array[0]==1){
					simplifiedInput.add(array);
				}
			}
			while(M-->0){
				for(int[] array : originInput){
					if(simplifiedInput.contains(array)){
						continue;
					}else{
						LinkedList<int[]> templist = new LinkedList<int[]>();
						for(int[] insidearray : simplifiedInput){
							if(insidearray[1]==array[0]){
								templist.add(array);
							}
						}
						simplifiedInput.addAll(templist);
						templist = null;
					}
				}
			}
			
			
			// the routes in list are those which can lead to index 4. but you need to get the one that can really represedt
			//the route.
			
			int total_speed = 0;
			
			for(int[] start : simplifiedInput){
				if(start[0]==1){
					int nextPathMax = getMAXSPEED(start);
					total_speed += Math.min(nextPathMax, start[2]);
				}else{
					break;
				}
			}
			
			System.out.println(total_speed);
			originInput = null;
			simplifiedInput = null;
			System.gc();
		}
	}
	
	
	private static  int getMAXSPEED(int[] begin){
		if(begin[1]==4){
			return begin[2];
		}
		int SUM = 0;
		for(int[] tmp:originInput){
			if(tmp[0]==begin[1]){
				SUM += Math.min(begin[2], getMAXSPEED(tmp)); 
			}
		}
		return SUM;
	}

}
