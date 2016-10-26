import java.util.*;
public class linkedlist
{
	int data;
	linkedlist next;
	public void push(int a)
	{
		linkedlist temp = new linkedlist(),nxt = this;
		temp.data = a;
		temp.next = null;
		if( this == null ) return ;
		while( nxt.next != null ) nxt = nxt.next;
		nxt.next = temp;
	}
	void print( linkedlist A )
	{
		while(A != null )
		{
			System.out.print( A.data + " ");
			A = A.next;
		}
	}
	public static void main( String args[] )
	{
		linkedlist A = new linkedlist();
		for( int i = 0 ; i < 5 ; i++ ) A.push( i + 1 );
		A.print( A.next);
		stack a = new stack();
		for(int i=1;i<10;i++)
		{
			a = a.push(i);
		}
		a.show(a);		
	} 
}