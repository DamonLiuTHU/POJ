package hiho1049;

import java.util.Scanner;

public class Main {

	class Node {
		public Node left;
		public Node right;
		public char value;

		public Node(char c) {
			this.value = c;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			// int a = in.nextInt();
			// int b = in.nextInt();
			// System.out.println(a + b);
			Main m = new Main();
			String pre_order = in.next();
			String mid_order = in.next();
			m.root = m.new Node(pre_order.charAt(0));
			m.getPostOrder(pre_order, mid_order);
			System.out.println("");
		}

	}

	Node root;

	private void getPostOrder(String pre_order, String mid_order,node ) {
		// TODO Auto-generated method stub
		char root = pre_order.charAt(0);
		if (mid_order.indexOf(root) == 0) { // there is only one right tree.
			
		} else if (mid_order.indexOf(root) == mid_order.length() - 1) { // only a left tree
			
		} else {
			String[] subTrees = mid_order.split(String.valueOf(root));
			String[] preTrees = new String[subTrees.length];
			int counter = 0;
			int index = 1;
			for (String tree : subTrees) {
				preTrees[counter] = pre_order.substring(index, tree.length());
				index += tree.length();
				counter++;
			}

		}
//		return;
	}

}
