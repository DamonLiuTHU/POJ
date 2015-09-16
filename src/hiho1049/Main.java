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

	static Node root = null;
	private static Scanner in;

	private void getPostOrder(String pre_order, String mid_order, Node node) {
		// TODO Auto-generated method stub
		if(pre_order.length()==1){
			return;
		}
		char root_char = pre_order.charAt(0);
		String[] subTrees = null;
		if(mid_order.indexOf(root_char)!=0){
			subTrees = mid_order.split(String.valueOf(root_char));
		}else{
			subTrees  = new String[1];
			subTrees[0] = mid_order.substring(1);
		}
		
		String[] preTrees = new String[subTrees.length];
		int index = 1;
		for(int i=0;i<subTrees.length;i++){
			preTrees[i] = pre_order.substring(index, index+subTrees[i].length());
			index += subTrees[i].length();
		}
//		boolean has_left = true;
//		boolean has_right = true;
		if (mid_order.indexOf(root_char) == 0) {
			//only right son
			node.right = new Node(preTrees[0].charAt(0)); 
//			has_left = false;
			getPostOrder(preTrees[0], subTrees[0], node.right);
		} else if (mid_order.indexOf(root_char) == mid_order.length() - 1) {
			node.left = new Node(preTrees[0].charAt(0));
//			has_right = false;
			getPostOrder(preTrees[0], subTrees[0], node.left);
		} else {
			char left = preTrees[0].charAt(0);
			char right = preTrees[1].charAt(0);
			node.left = new Node(left);
			node.right = new Node(right);
			getPostOrder(preTrees[0], subTrees[0], node.left);
			getPostOrder(preTrees[1], subTrees[1], node.right);
		}
		
	}
	
	
	public static void print(Node n){
		if(n!=null){
			if(n.left!=null){
				print(n.left);
			}
			if(n.right!=null){
				print(n.right);
			}
			System.out.print(n.value);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		in = new Scanner(System.in);
		while (in.hasNext()) {
			// int a = in.nextInt();
			// int b = in.nextInt();
			// System.out.println(a + b);
			Main m = new Main();
			String pre_order = in.next();
			String mid_order = in.next();
			Main.root = m.new Node(pre_order.charAt(0));
			m.getPostOrder(pre_order, mid_order, root);
//			System.out.println("");
			Main.print(root);
		}

	}

}
