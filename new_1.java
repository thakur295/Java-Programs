import java.util.*;
abstract class Sort_func
{
	int [] arr ;
	void swap(int [] ar, int i ,int j)
	{
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}
	boolean compare( int a,int b )
	{
		if( a > b )
			return true;
		else
			return false;
	}
}
class Sort extends Sort_func
{
	void b_sort( int [] a,int s ,int n )
	{
		for( int i = 0 ; i < n ; i++ )
		{
			for( int j = 0 ; j < n-1-i ; j++ )
			{
				if(compare( a[j],a[j+1] ) )
					swap(a,j, j+1);
			}
		}
	}
	
	public static void main(String[] args )
	{
		int []  a = {5,7,8,2,0,1,6,4};
		Sort Srt = new Sort();
		Srt.b_sort( a , 0 , a.length ) ;
		for ( int i = 0; i < a.length ;i++)
		{
			System.out.println(a[i]);
		}
	}
}