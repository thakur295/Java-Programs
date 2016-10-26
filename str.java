import java.util.*;
class question_mark
{
public static void main(String Args[]){
	char str[];
	str = new char[100];
	Scanner obj = new Scanner(System.in);
	str = obj.next().toCharArray();
	int l = str.length;
	int comb = (int)Math.pow(2,l/2);
	for(int i=0;i<=comb-1;i++)
	{
		int x=l/2;
		for(int j=l/2;j<=l-1;j++)
		{
			int a = 1&(i>>(--x));
			str[j]=(char)(a+'0');
		}
		for(int k=0;k<=l-1;k++){
		     System.out.print(str[k]);
		}
		System.out.println();
	}
	
	}
}