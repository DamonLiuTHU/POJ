package hiho1055;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static Scanner in;

	class Node {
		public ArrayList<Node> sons = new ArrayList<Node>();
		public Node father = null;
		public int value;
		public int index;
		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = in.nextInt();
			int M = in.nextInt();
			Node[] ball = new Node[N+1];
			for(int i=1;i<=N;i++){
				ball[i] = m.new Node(i,in.nextInt());
			}
			for(int i=0;i<N-1;i++){
				int begin = in.nextInt();
				int end = in.nextInt();
				ball[begin].sons.add(ball[end]);
				ball[end].father = ball[begin];
			}
			Node root = ball[1];
			int sum = root.value; 
			for(int i=1;i<M;i++){
				//M-1次操作  //贪心算法，有时候是错的。
				Node max_node = root.sons.get(0);
				for(Node n:root.sons){
					if(n.value>max_node.value){
						max_node = n;
					}
				}
//				System.out.println(max_node.father.index+"->"+max_node.index);
				sum += max_node.value;
				root.sons.remove(max_node);
				root.sons.addAll(max_node.sons);
			}
			System.out.println(sum);
		}

	}

}
