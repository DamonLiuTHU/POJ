package q1019;

import java.util.Scanner;

public class Main {
	
	static String first80 = "11212312341234512345612345671234567812345678912345678910123456789101112345678910";
	
	public static int getResult(int index){
		if(index <= 80){
			return Integer.parseInt(first80.substring(index-1, index));
		}
		int counter = 0;
		while(true){
			counter++;
			index-=counter;
			if(index<=0){
				index+=counter;
				break;
			}
		}
		
		return index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for(int i=0;i<cases;i++){
			int index = sc.nextInt();  //第index个数字。
			System.out.println(getResult(index));
		}
	}

}
