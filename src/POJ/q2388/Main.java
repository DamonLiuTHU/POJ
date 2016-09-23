package POJ.q2388;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int N = sc.nextInt();  // the number of cows
			int milks[]= new int[N];
			for(int i=0;i<N;i++){
				milks[i] = sc.nextInt();
			}
			int middleValue = Main.getSortedValueAtIndex(milks,N/2);
			System.out.println(middleValue);
		}
	}

	private static <T> int getSortedValueAtIndex(int[] array,int k) {
		//get the kth biggest value in array
		Arrays.sort(array);
		return array[k];
	}

}
