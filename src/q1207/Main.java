package q1207;

import java.util.Scanner;

public class Main {
	static Scanner sc;
	public static void main(String args[]){
		sc = new Scanner(System.in);
		while(sc.hasNext()){
			int begin = sc.nextInt();
			int end = sc.nextInt();
			System.out.println(begin+" "+end+" "+Main.getCycleLength(begin,end));
		}
	}
	private static int getCycleLength(int begin, int end) {
		// TODO Auto-generated method stub
		int MAXLENGTH = 0;
		for(int i=begin;i<=end;i++){
			int counter = Main.getCounter(i);
			if(counter>MAXLENGTH) MAXLENGTH = counter;
		}
		return MAXLENGTH;
	}
	private static int getCounter(int i) {
		// TODO Auto-generated method stub
		int counter = 1;
		int inner_i = i;
		while(inner_i!=1){
			counter++;
			if(inner_i%2!=0){
				inner_i = 3*inner_i+1;
			}else{
				inner_i = inner_i / 2;
			}
		}
		return counter;
	}
}
