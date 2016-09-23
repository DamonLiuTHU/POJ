package POJ.q1458;

import java.util.Scanner;

public class Main {
	static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		while(sc.hasNext()){
			String a = sc.next();
			String b = sc.next();
			System.out.println(Main.getLCS(a,b));
		}
	}

	private static int getLCS(String a, String b) {
		// TODO Auto-generated method stub
		int[][] map = new int[a.length()+1][b.length()+1];
		for(int i=1;i<=a.length();i++){
			for(int j=1;j<=b.length();j++){
				int left = map[i][j-1];
				int up = map[i-1][j];
				int leftup = map[i-1][j-1];
				if(a.charAt(i-1)==b.charAt(j-1)){
					leftup++;
				}
				map[i][j] = Math.max(left, Math.max(up, leftup));
			}
		}
		return map[a.length()][b.length()];
	}

}
