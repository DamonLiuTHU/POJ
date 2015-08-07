package hiho1039;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = in.nextInt();
			while(N-->0){
				String s = in.next();
				int MAX=0;
				for(int i=0;i<s.length()+1;i++){
					int tmp = getMax(s,i);
					if(tmp>MAX){
						MAX = tmp;
					}
				}
				System.out.println(MAX);
			}
		}

	}

	private static int getMax(String s, int i) {
		// TODO Auto-generated method stub
		if(i!=0){
			s = s.substring(0,i);	
		}
		int max = 0;
		for(int offset=0;offset<3;offset++){
			String tmp = s + ('A'+offset)+s.substring(offset);	
			int v = getValue(tmp);
			if(v>max){
				max = v;
			}
		}
		return max;
	}
	
	private static int getValue(String s){
		//how many removes can get
		return 0;
	}

}
