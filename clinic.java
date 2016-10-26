import java.util.*;
class City implements Comparable
{
	final int population;
	int clinic;
	Integer avg;
	public City(int pop)
	{
		this.population = pop;
		this.clinic = 1;
		this.avg = pop;
	}
	public int compareTo(Object o)
	{
		City c = (City) o;
		if(this.avg > c.avg) return 1;
		if(this.avg < c.avg) return -1;
		return 0;
	}
	public void add()
	{
	    this.clinic++;
		if(population % clinic == 0)
			this.avg = population / clinic;
		else
			this.avg = (population / clinic) + 1;
	}
}
class Solution
{
	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int i = t;
		int cl = s.nextInt();
		PriorityQueue<City> q = new PriorityQueue<>(t , Collections.reverseOrder());
		while(i-- > 0)
		{
			q.add(new City(s.nextInt()));
		}
		cl = cl - t;
		while(cl-- > 0)
		{
			City temp = q.poll();
			temp.add();
			q.add(temp);
		}
		City cty = q.poll();
		System.out.print(cty.avg + " " + cty.population + " " + cty.clinic);
	}
}