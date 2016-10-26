import java.util.*;
class abc
{
public static void main(String args[])
{
   int i;
   Scanner obj=new Scanner(System.in);
   i=obj.nextInt();
   int num,rev=0,rem;
   num=i;
   while(i!=0)
   {
      rem=i%10;
      rev=(rev*10)+rem;
      i=i/10;
   }
   if(num==rev)
   {
       System.out.println("Yes");
   }
   else
   {
      System.out.println("No");
   }
}
}