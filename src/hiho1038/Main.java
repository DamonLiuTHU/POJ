package hiho1038;

import java.util.Scanner;

public class Main {
	
	class Item{
		public int need,value;
		public Item(int need,int value){
			this.need = need;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		Main m = new Main();
		Item[] array = new Item[N];
		for(int l=0;l<N;l++){
			int need = sc.nextInt();
			int value = sc.nextInt();
			array[l] = m.new Item(need,value);
		}
		int Ans=-1;
		
		
		System.out.println(Ans);
	}

}
