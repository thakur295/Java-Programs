import java.util.*;
class BST
{
	Node root;
	class Node
	{
		int data;
		int cords;
		Node left;
		Node right;
		Node(int x)
		{
			data = x ;
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
	void enterQ(Node n)
	{
		Queue<Node>q = new LinkedList<Node>();
		Set<Integer> s = new HashSet<>();
		q.add(n);
		n.cords = 0;
		while(!q.isEmpty())
		{
			Node temp = q.poll();
			if(!s.contains(temp.cords))
			{
				System.out.print(temp.data + " ");
				s.add(temp.cords);
			}
			if(temp.left != null)
			{
				q.add(temp.left);
				temp.left.cords = temp.cords - 1 ; 
			}
			if(temp.right != null)
			{
				q.add(temp.right);
				temp.right.cords = temp.cords + 1 ; 
			}
		}
	}
	void topView()
	{
		enterQ(root);
	}
}
class Solution
{
	public static void main(String args[])
	{
		BST b = new BST();
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-- > 0)
		{
			b.push(s.nextInt());
		}
		b.topView();
	}
}