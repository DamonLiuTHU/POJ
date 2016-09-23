package POJ.q1006;

import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	public static int calculate(int p ,int e ,int i , int d){
		assert(p>=0&&p<=365);
		assert(e>=0&&e<=365);
		assert(i>=0&&i<=365);
		assert(d>=0&&d<=365);
		int limie_e = e + 21252;
		int limie_p = p + 21252;
		int limit_i = i + 21252;
		while(true){
			if(e - p < 23 && e < limie_e){
				e+= 28;
			}
			if(i-p < 23 && i < limit_i){
				i+= 33;
			}
			if(p < limie_p){
				p+= 23;
			}
			if(p==e && e==i){
				break;
			}
		}
		p -= d;
		while(p <= 0){
			p += 21252;
		}
		while(p > 21252){
			p -= 21252;
		}
		return p;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Vector<String> output_result = new Vector<String>();
		int counter = 0;
		while (true) {
			counter ++;
			int p = sc.nextInt();
			int e = sc.nextInt();
			int i = sc.nextInt();
			int d = sc.nextInt();
			if (p == -1&&e==-1&&i==-1&&d==-1) {
				break;
			}

			int result = Main.calculate(p, e, i, d);
			StringBuilder sb = new StringBuilder("Case "+counter+": the next triple peak occurs in "+result+" days.");
			output_result.add(sb.toString());
		}
		
		for(String tempv : output_result){
			System.out.println(tempv);
		}
	}
}
