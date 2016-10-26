import java.util.*;
class RedBlack
{
	final static boolean Red = true;
	final static boolean Black = false;
	Node root;
	class Node
	{
		int key;
		Node left;
		Node right;
		boolean color;
		Node(int key,boolean color)
		{
			this.key = key;
			this.color = color;
		}
	}
	public void insert(int key)
	{
		root = insert(root,key,Red);
	}
	private Node insert(Node n,int key,boolean color)
	{
		if( n == null ) return new Node(key,color);
		else if( key < n.key ) 
			n.left = insert(n.left,key,color);
		else if ( key > n.key ) 
			n.right = insert(n.right,key,color);
		if(isRed(n.right) && !isRed(n.left))
			n = rotateLeft(n);
		if(isRed(n.left) && isRed(n.left.left))
			n = rotateRight(n);
		if(isRed(n.right) && isRed(n.left))
			flipColor(n);
		return n;
	}
	private void flipColor(Node x)
	{
		x.left.color = !x.left.color;
		x.right.color = !x.right.color;
		x.color = !x.color;
	}
	private boolean isRed(Node x)
	{
		if( x == null ) return false;
			return x.color == Red;
	}
	private Node rotateLeft(Node x)
	{
		Node r = x.right;
		x.right = r.left;
		r.left = x;
		r.color = x.color;
		x.color = Red;
		return r;
	}
	private Node rotateRight(Node x)
	{
		Node r = x.left;
		x.left = r.right;
		r.right = x;
		r.color = x.color;
		x.color = Black;
		return r;
	}
	public int height()
    {
        return height(root);
    }
   private int height(Node x)
    {
        if(x == null) return 0;
        return 1 +  Math.max(height(x.left) , height(x.right));
    }
	void print(Node root,int a)
	{
		if( root == null ) return ;
		if( a == 0)
			System.out.print(root.key+" ");
		else{
			print(root.left,a-1);
			print(root.right,a-1);
		}
	}
	void LevelOrder()
	{
		LevelOrder(root);
	}
	void LevelOrder(Node root)
	{
		int h = height(root); 
		for(int i = 0 ;i < h; i++)
			print(root,i);     
	}

}
class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//Scanner sc = new Scanner(System.in);
		RedBlack tree = new RedBlack();
		tree.insert(6);
		tree.insert(2);
		tree.insert(1);
		tree.insert(4);
		tree.insert(3);
		tree.insert(9);
		tree.insert(5);
		System.out.println(tree.height());
		tree.LevelOrder();
	}
}