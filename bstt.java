import java.util.*;
class Bst
{
	int ar[];
	int i;
    class node
    {
        int data;
        node left;
        node right;
        node(int a)
        {
            data = a;
            left = null;
            right = null;
        }
    }
    node root;
    public void push(int a)
    {
        root = push(root,a);
    }
    private node push(node n,int a)
    {
        if(n == null) return new node(a);
        else if(n.data < a) n.right = push(n.right,a);
        else if(n.data > a) n.left = push(n.left,a);
        return n;
    }

    public boolean search(int a)
    {
	return search(root,a);
     }
     private boolean search(node n,int a)
     {
	if(n==null) return false;
	else if (n.data == a) return true;
	else if(n.data < a) return search(n.right,a);
	else return search(n.left,a);
      }
      private int getmin(node n)
      {
	if(n == null) return -1;
	if(n.left == null ) return n.data;
	else return getmin(n.left);
       }	
       private int getmax(node n)
      {
	if(n == null) return -1;
	if(n.right == null ) return n.data;
	else return getmin(n.right);
       }
        public int getmin()
        {
	return getmin(root);
         }	
         public int getmax()
        {
	return getmax(root);
         }
          private node delmax(node n)
      {
	if(n == null) return n;
	if(n.right == null ) return n.left;
	n.right = delmax(n.right);
	return n;
	
       }
          public void delmax()
        {
	 delmax(root);
         }
	public void preorder()
	{
		ar = new int[10];
		i = 0;
		preorder(root);
	}
	private void preorder(node n)
	{
		if( n== null) return;
		ar[i++] = n.data;
		//System.out.println(n.data);
		preorder(n.left);
		preorder(n.right);
	}
	public void print()
	{
		for(int i =0;i<5;i++)
		{
			System.out.println(ar[i]);
		}
	}
    public static void main(String[] args)
    {
        Bst b = new Bst();
        b.push(5);
        b.push(2);
        b.push(6);
        b.push(3);
        b.push(1);
	b.preorder();
	b.print();
        //System.out.println(b.getmin());
        //System.out.println(b.getmax());
       // b.delmax();
        System.out.println(b.search(6));
    }
}