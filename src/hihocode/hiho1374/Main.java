package hihocode.hiho1374;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<String> expList = new ArrayList<String>();
		while (sc.hasNext()) {
			String exp = sc.nextLine();
			if (exp.compareTo("END") == 0) {
				break;
			}

			expList.add(exp);
		}
		for (String string : expList) {
			calculateResult(string);
		}
	}

	// Only deal with add and sub operation
	public static void calculateResult(String exp) {
		StringBuilder sb = new StringBuilder();
		LinkedList<Integer> numberStack = new LinkedList<Integer>();
		LinkedList<Boolean> opStack = new LinkedList<Boolean>();
		for (int i = 0; i < exp.length(); i++) {
			if (exp.charAt(i) <= '9' && exp.charAt(i) >= '0') {
				sb.append(exp.charAt(i));
			} else {

				int value1 = Integer.parseInt(sb.toString());
				numberStack.add(value1);
				sb = new StringBuilder();
				// if (opStack.isEmpty()) {
				opStack.add(exp.charAt(i) == '+');
				// } else {
				// Boolean isAdd = opStack.pop();
				// int tmp1 = numberStack.pop();
				// int tmp2 = numberStack.pop();

				// if (isAdd) {
				// numberStack.push(tmp1 + tmp2);
				// } else {
				// numberStack.push(tmp2 - tmp1);
				// }
				// }
				// switch (exp.charAt(i)) {
				// case '-':
				//
				// break;
				// case '+':
				//
				// break;
				//
				// default:
				// break;
				// }
			}
		}

		int value1 = Integer.parseInt(sb.toString());
		numberStack.add(value1);

		while (!opStack.isEmpty()) {
			Boolean isAdd = opStack.poll();
			int tmp1 = numberStack.poll();
			int tmp2 = numberStack.poll();
			if (isAdd) {
				numberStack.push(tmp1 + tmp2);
			} else {
				numberStack.push(tmp1 - tmp2);
			}
		}
		// have all the correct values to cal

		// System.out.println("tmp");

		// sb = new StringBuilder();
		//
		// Boolean isAdd = opStack.pop();
		// int tmp1 = numberStack.pop();
		// int tmp2 = numberStack.pop();
		//
		// if (isAdd) {
		// numberStack.push(tmp1 + tmp2);
		// } else {
		// numberStack.push(tmp2 - tmp1);
		// }
		//
		System.out.println(numberStack.pop());
		// assert (numberStack.isEmpty());
	}

}
