package POJ.q2299;

import java.util.Scanner;
/**
 * 线段树，归并排序
 * @author damonliu
 *
 */
public class Main {
	static Scanner sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		while(sc.hasNext()){
			int N = sc.nextInt();   // n is smaller than 500,000.
			if(N==0) break;
			int[] numbers  = new int[N];
			for(int i=0;i<N;i++){
				numbers[i] = sc.nextInt();
			}
			
			int counter= Main.getSwapCount(numbers,N);
			System.out.println(counter);
		}
	}
	private static int getSwapCount(int[] numbers, int N) {
		// TODO Auto-generated method stub
		int counter = 0 ;
		boolean sorted = true;
		int tmp;
		do{
			sorted = true;
			for(int i=0;i<N-1;i++){
				if(numbers[i]>numbers[i+1]){
					sorted = false; 
					tmp = numbers[i]; numbers[i] = numbers[i+1]; numbers[i+1] = tmp;
					counter++;
				}
			}
		}while(!sorted);
		
		return counter;
	}

}
