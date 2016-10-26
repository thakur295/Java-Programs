import java.util.*;
class xyz
{
	public static void main(String args[])
	{
		int a[][];
		a=new int[5][];
		for(int i=0;i<=4;i++)
		{
			a[i]=new int[i+1];
			for(int j=0;j<=i;j++)
			{
				Scanner obj=new Scanner(System.in);
				int x=obj.nextInt();
				a[i][j]=x;
			}
		}
		System.out.println("output");
		for(int i=0;i<=4;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
}