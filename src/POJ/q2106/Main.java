package POJ.q2106;

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
	static HashMap<Character, Integer> isp = new HashMap<Character, Integer>(4);
	static HashMap<Character, Integer> osp = new HashMap<Character, Integer>(4);
	static Stack<Character> operator;
	static Stack<Character> values;
	private static Scanner sc;

	public static void main(String[] args) {
		isp.put(')', 20);
		osp.put(')', 1);
		isp.put('!', 12);
		osp.put('!', 13);  //单目运算符比较特别，他的isp要比osp低才可以。
		isp.put('&', 10);
		osp.put('&', 9);
		isp.put('|', 8);
		osp.put('|', 7);
		isp.put('(', 1);
		osp.put('(', 20);
		isp.put('#', 0);
		osp.put('#', 0);
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
			values = new Stack<Character>();
			for (int i = 0; i < expression.length(); i++) {
				char tmp = expression.charAt(i);
				if (tmp == ' ')
					continue;
				if (isOperator(tmp)) {
					int tmpOutPriority = osp.get(tmp);
					int tmpInsidePriority = isp.get(operator.peek());
					if (tmpOutPriority > tmpInsidePriority) {
						operator.push(tmp);
					} else if (tmpOutPriority == tmpInsidePriority) {
						operator.pop();
					} else if (tmpOutPriority < tmpInsidePriority) {
						char op = operator.pop();
						char result = Main.calculate(op);
						values.push(result);
						if (tmp == ')') {
							char insideTop = operator.peek();
							while (insideTop != '(') {
								result = calculate(insideTop);
								values.push(result);
								operator.pop();
								insideTop = operator.peek();
							}
							operator.pop();
						} else {
							op = operator.peek();
							while (osp.get(tmp) < isp.get(op)) {
								values.push(Main.calculate(operator.pop()));
								op = operator.peek();
							}
							operator.push(tmp);
						}
					}
				} else {
					values.push(tmp);
				}
			}
			while (operator.size() > 1) {
				char op = operator.pop();
				values.push(Main.calculate(op));
			}
			System.out.println("Expression " + counter + ": " + values.pop());
			values = null;
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
			o1 = values.pop();
			o2 = values.pop();
			if (o1 == True || o2 == True)
				return True;
			else
				return False;
		case '&':
			o1 = values.pop();
			o2 = values.pop();
			if (o1 == True && o2 == True)
				return True;
			else
				return False;
		case '!':
			o1 = values.pop();
			return o1 == True ? False : True;
		default:
			System.exit(404);
			return '?';
		}

	}

	private static boolean isOperator(char tmp) {
		return isp.keySet().contains(tmp);
	}

}
