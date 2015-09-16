package q2106;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * 神一样的测试数据 F|(F) !!!!!F (((V))) 这三个过了就OK了。 好厉害！
 * 
 * @author damonliu
 *
 */
public class Main {
	static HashMap<Character, Integer> inStackPriority = new HashMap<Character, Integer>(4);
	static HashMap<Character, Integer> outStackPriority = new HashMap<Character, Integer>(4);
	static Stack<Character> operator;
	static Stack<Character> VF;
	private static Scanner sc;

	public static void main(String[] args) {
		inStackPriority.put(')', 20);
		outStackPriority.put(')', 1);
		inStackPriority.put('!', 12);
		outStackPriority.put('!', 13);
		inStackPriority.put('&', 10);
		outStackPriority.put('&', 9);
		inStackPriority.put('|', 8);
		outStackPriority.put('|', 7);
		inStackPriority.put('(', 1);
		outStackPriority.put('(', 20);
		inStackPriority.put('#', 0);
		outStackPriority.put('#', 0);
		sc = new Scanner(System.in);
		int counter = 0;
		while (sc.hasNext()) {
			String expression = sc.nextLine();
			if (expression.compareToIgnoreCase("") == 0) {
				continue;
			}
			counter++;
			expression = expression.trim();
			// operator.clear();
			// VF.clear();
			operator = new Stack<Character>();
			operator.push('#');
			VF = new Stack<Character>();
			for (int i = 0; i < expression.length(); i++) {
				char tmp = expression.charAt(i);
				if (tmp == ' ')
					continue;
				if (isOperator(tmp)) {
					int tmpOutPriority = outStackPriority.get(tmp);
					int tmpInsidePriority = inStackPriority.get(operator.peek());
					if (tmpOutPriority > tmpInsidePriority) {
						operator.push(tmp);
					} else if (tmpOutPriority == tmpInsidePriority) {
						operator.pop();
					} else if (tmpOutPriority < tmpInsidePriority) {
						char op = operator.pop();
						char result = Main.calculate(op);
						VF.push(result);
						if (tmp == ')') {
							char insideTop = operator.peek();
							while (insideTop != '(') {
								result = calculate(insideTop);
								VF.push(result);
								operator.pop();
								insideTop = operator.peek();
							}
							operator.pop();
						} else {
							op = operator.peek();
							while (outStackPriority.get(tmp) < inStackPriority.get(op)) {
								VF.push(Main.calculate(operator.pop()));
								op = operator.peek();
							}
							operator.push(tmp);
						}
					}
				} else {
					VF.push(tmp);
				}
			}
			while (operator.size() > 1) {
				char op = operator.pop();
				VF.push(Main.calculate(op));
			}
			System.out.println("Expression " + counter + ": " + VF.pop());
			VF = null;
			operator = null;
			System.gc();
		}
	}
	static char True = 'V';
	static char False = 'F';
	
	private static char calculate(char op) {
		char o1, o2;
		switch (op) {
		case '|':
			o1 = VF.pop();
			o2 = VF.pop();
			if (o1 == True || o2 == True)
				return True;
			else
				return False;
		case '&':
			o1 = VF.pop();
			o2 = VF.pop();
			if (o1 == True && o2 == True)
				return True;
			else
				return False;
		case '!':
			o1 = VF.pop();
			return o1 == True ? False : True;
		default:
			System.exit(404);
			return '?';
		}

	}

	private static boolean isOperator(char tmp) {
		return inStackPriority.keySet().contains(tmp);
	}

}
