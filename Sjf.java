import java.util.*;
class Priority
{
	private int avgTime;
	private int medianTime;
	Priority(int avgTime,int medianTime)
	{
		this.avgTime = avgTime;
		this.medianTime = medianTime;
	}
	public int getAvgtime()
	{
		return this.avgTime;
	}
	public int getMedianTime()
	{
		return this.medianTime;
	}
}
class Process
{
	private String pName;
	private int pNo;
	public Process(String pName,int pNo)
	{
		this.pName = pName;
		this.pNo = pNo;
	}
	public String toString()
	{
		//return this.pName;
		return Integer.toString(pNo);
	}
}
class Median implements Comparator
{
	public int compare(Object o1,Object o2)
	{
		Priority p1 = (Priority)o1;
		Priority p2 = (Priority)o2;
		if(p1.getMedianTime() > p2.getMedianTime() ) return 1;
		if(p1.getMedianTime() < p2.getMedianTime() ) return -1;
		return 0;	
	}
}
class Avg implements Comparator
{
	public int compare(Object o1,Object o2)
	{
		Priority p1 = (Priority)o1;
		Priority p2 = (Priority)o2;
		if(p1.getAvgtime() > p2.getAvgtime() ) return 1;
		if(p1.getAvgtime() < p2.getAvgtime() ) return -1;
		return 0;	
	}
}
class Tree
{
	Node root;
	class Node
	{
		Priority key;
		Process value;
		Node left;
		Node right;
		Node(Priority key,Process value)
		{
			this.key = key;
			this.value = value;
		}
	}
	public void insert(Priority key,Process value,Comparator c)
	{
		root = insert(root,key,value,c);
	}
	private Node insert(Node n,Priority key,Process value,Comparator c)
	{
		if( n == null ) return new Node(key,value);
		else if(c.compare(key,n.key) < 0 ) n.left = insert(n.left,key,value,c);
		else if(c.compare(key,n.key) > 0 ) n.right = insert(n.right,key,value,c);
		else 
			n.value = value;
		return n;
	}
	public void inOrder()
	{
		inOrder(root);
	}
	private void inOrder(Node n)
	{
		if(n == null) return;
		inOrder(n.left);
		System.out.println(n.value);
		inOrder(n.right);
	}
}
class Solution
{
	public static void main(String args[])
	{
		Process p1 = new Process("Process1",1);
		Process p2 = new Process("Process2",2);
		Process p3 = new Process("Process3",3);
		Priority pt1 = new Priority(5,6);
		Priority pt2 = new Priority(3,4);
		Priority pt3 = new Priority(7,3);
		Tree t = new Tree();
		Comparator c = new Median();
		t.insert(pt1,p1,c);
		t.insert(pt2,p2,c);
		t.insert(pt3,p3,c);
		t.inOrder();
	}
}