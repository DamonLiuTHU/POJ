package hiho1038;

import java.util.Scanner;

public class Main {
	/*
	 * 动态规划   内存的节省。
	 */
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
		int N = sc.nextInt();//奖品的数量
		int M = sc.nextInt();//小明有的所有钱
		Main m = new Main();
		Item[] array = new Item[N+1];
		for(int l=1;l<=N;l++){
			int need = sc.nextInt();
			int value = sc.nextInt();
			array[l] = m.new Item(need,value);
		}
		int Ans=-1;
//		int[][] best = new int[N+1][M+1];
//		for(int i=1;i<=N;i++){
//			Item item = array[i];
//			for(int j=1;j<=M;j++){
//				if(j<item.need){
//					best[i][j] = best[i-1][j];
//				}else{
//					best[i][j] = Math.max(best[i-1][j-item.need]+item.value, best[i-1][j]);
//				}
//			}
//		}
		int best[] = new int[M+1];
		for(int i=1;i<N;i++){
			Item item = array[i];
			for(int j=M;j>item.need;j--){
//				if(j<item.need){
//					best[j] = 
//				}else{
					best[j] = Math.max(best[j],best[j-item.need]+item.value);
//				}
			}
		}
		
		System.out.println(best[M]);
	}
	
	
	

}
