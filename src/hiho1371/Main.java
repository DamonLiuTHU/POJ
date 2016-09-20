package hiho1371;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	class Node
    {
        int value;
        Node next;
    }
	
	public static Node getLastPlaceToAddNode(Node n){
//		Node 
		while(n.next!=null){
			n = n.next;
		}
		return n;
	}
	
	public static void printReverseResult(Node root){
		Node tmp = root;
		StringBuilder sb = new StringBuilder();
		while(tmp!=null){
			sb.append(tmp.value);
			tmp = tmp.next;
			sb.append(" ");
		}
		sb.deleteCharAt(sb.length()-1);
		String result = sb.reverse().toString();
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		Scanner sc = new Scanner(System.in);
		ArrayList<Node> list = new ArrayList<Node>();
		while(sc.hasNext()){
			int n = sc.nextInt();
			if (n == -1){
				break;
//				return;
			}
			Node root = null;
			Node current = null;
			for (int i=0;i<n;i++){
				Main.Node node = m.new Node();
				node.value = sc.nextInt();
				
				if (root == null) {
					root = node;
				} else {
//					getLastPlaceToAddNode(root).next = node;
					current.next = node;
				}
				current = node;
			}//finish the link list's initialize operation
			
			list.add(root);
		}
		for (Node node : list) {
			printReverseResult(node); //print reversely
		}
	}

}
