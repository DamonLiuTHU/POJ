package POJ.q1664;

import java.util.Scanner;

public class Main {

	/**
	 * 所以状态转移方程为f[i][j]:if(i>=j)f[i][j]=f[i][j-1]+f[i-j][j]

if(i<j)        f[i][j]=f[i][i];
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int t = sc.nextInt(); // number of cases
			for(int i=0;i<t;i++){
				int M = sc.nextInt();
				int N = sc.nextInt();
				System.out.println(Main.putMAppleIntoNPlates(M,N));
			}
		}
	}

	private static int putMAppleIntoNPlates(int m, int n) {
		// TODO Auto-generated method stub
		if(m==0||m==1||n==0||n==1){
			return 1;
		}
		if(m>=n){
			return putMAppleIntoNPlates(m, n-1)+putMAppleIntoNPlates(m-n, n);
		}else{
			return putMAppleIntoNPlates(m, m);
		}
	}

}
