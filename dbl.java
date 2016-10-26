import java.util.*;
class BST
{
	Node root;
	Queue <Node> q;
	class Node
	{
		int data;
		Node left;
		Node right;
		Node(int a)
        		{
            			data = a;
            			left = null;
           			right = null;
        		}
   	 }
	void changeToDouble()
	{
		root = q.element();
		Node head = q.element(), temp =q.element()  ;
		while( true )
		{
			Node t = q.poll();
			t. left = temp ;
			if(q.isEmpty()){
				t.right = head;
				break;
			}
			temp = q.element();
			t.right = temp;
		}
	}
   	 public void push(int a)
   	 {
        		root = push(root,a);
   	 }
    	private Node push(Node n,int a)
    	{
        		if(n == null) return new Node(a);
        		else if(n.data < a) n.right = push(n.right,a);
        		else if(n.data > a) n.left = push(n.left,a);
        		return n;
    	}
	void inOrder()
	{
		q = new LinkedList<Node>();
		inOrder( root ) ;
	}
	void inOrder( Node n )
	{
		if( n == null) return ;
		inOrder( n.left );
		q.add(n);
		inOrder( n.right );
		//System.out.print(n.data+" ");
	}
	void print()
	{
		print(root);
	}
	void print( Node n )
	{
		Node h = n;
		while( true )
		{
			System.out.println(n.data);
			n = n.right;
			if( n == h )
				break;
		}
	}
}
class Solution
{
public static void main(String[] args)
{
	BST b = new BST();
	Scanner s = new Scanner(System.in);
	int t = s.nextInt();
	while( t-- > 0 )
	{
		b.push(s.nextInt());
	}
	b.inOrder();
	b.changeToDouble();
	b.print();
}
}
	 