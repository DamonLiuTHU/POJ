package q1004;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

	static int INPUT_COUNT = 12;
	static DecimalFormat format = new DecimalFormat("#.00");
	
	public static String shortenNumber(float f){
		return format.format(f);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		float sum = 0.00f;
		for(int i = 0 ; i< INPUT_COUNT ;i++	){
			float f = sc.nextFloat();
			if(f <= 0){
				continue;
			}
			sum += f;
		}
		sum /= INPUT_COUNT;
		
		System.out.println("$"+Main.shortenNumber(sum));
		
	}

}
