import java.io.*;
import java.util.*;

public class Day150
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Point[] pArr = new Point[n];
		for(int i=0;i<n;i++)
		{
			String[] inpString = br.readLine().split(" ");
			pArr[i] = new Point(Integer.parseInt(inpString[0]), Integer.parseInt(inpString[1]));
		}
		String[] inpString = br.readLine().split(" ");
		Point central = new Point(Integer.parseInt(inpString[0]), Integer.parseInt(inpString[1]));
		int k = Integer.parseInt(br.readLine());
		br.close();
		System.out.println("\n\n");
		Point[] result = nearestPoints(pArr, central, k);
		System.out.print("[ ");
		for(Point p: result)
		{
			System.out.print("( ");
			System.out.print(p.toString());
			System.out.print(" ), ");
		}
		System.out.println("]");
	}
	public static Point[] nearestPoints(Point[] pArr, Point c, int k)
	{
		PriorityQueue<PointWrapper> pq = new PriorityQueue<PointWrapper>();
		for(int i=0;i<pArr.length;i++)
		{
			pq.add(new PointWrapper(pArr[i], distance(c, pArr[i])));
		}
		Point[] ret = new Point[k];
		for(int i=0;i<k;i++)
		{
			ret[i] = pq.poll().p;
		}
		return ret;
	}
	private static int distance(Point p1, Point p2) // Considering Hamming distance for integers. Can be changed
	{
		return (int)(Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y));
	}
}

class Point
{
	int x, y;
	Point(int a, int b)
	{
		x = a;
		y = b;
	}

	public int hashCode()
	{
		return ((this.x+this.y)%31);
	}
	public boolean equals(Object obj)
	{
		if(obj == null) return false;
		if(obj == this) return true;

		Point p = (Point)obj;
		return ((this.x == p.x) && (this.y == p.y));
	}
	public String toString()
	{
		return x+", "+y;
	}
}
class PointWrapper implements Comparable<PointWrapper>
{
	Point p;
	int d;
	PointWrapper(Point a, int b)
	{
		p = a;
		d = b;
	}
	public int compareTo(PointWrapper p1)
	{
		if(this.d == p1.d) return 0;
		if(this.d > p1.d) return 1;
		return -1;
	}
}
