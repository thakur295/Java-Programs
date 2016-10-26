class stack
{
	int data;
	stack next;
	stack()
	{
		data = 0;
		next = null;
	}
	public stack push(int a)
	{
		stack temp = new stack();
		temp.data = a;
		temp.next = this;
		return temp;
	}
	void show(stack head)
	{
		while( head != null ){
			System.out.println(head.data);	
			head = head.next;
			}
	}
	public static void main(String args[])
	{
		stack a = new stack();
		for(int i=1;i<10;i++)
		{
			a.push(i);
		}
		a.show(a);
	}
}