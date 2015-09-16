package q2027;

import java.util.Scanner;

public class Main {
	static Scanner sc;
	public static void main(String args[]){
		sc = new Scanner(System.in);
		while(sc.hasNext()){
			int N = sc.nextInt();
			for(int i=0;i<N;i++){
				int eat = sc.nextInt();
				int need = sc.nextInt();
				System.out.println((eat>=need?"MMM ":"NO ") + "BRAINS");
			}
		}
	}
}
