import java.io.*;
import java.util.*;

public class Day39
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("##############################################################");
		System.out.println("Please enter the coordinates of live cells in space separated\nlines and then the number of trials in new line");
		System.out.println("##############################################################");
		HashSet<Pair> live = new HashSet<Pair>();
		int T = 0;
		String input;
		while((input = br.readLine()) != null)
		{
			String[] parsedInput = input.split(" ");
			if(parsedInput.length == 1)
			{
				T = Integer.parseInt(parsedInput[0]);
				break;
			}
			else
			{
				Pair p = new Pair(Integer.parseInt(parsedInput[0]), Integer.parseInt(parsedInput[1]));
				live.add(p);
			}
		}
		br.close();
		for(int T_i=0;T_i<T;T_i++)
		{
			live = gameOfLife(live);
			System.out.println(live.toString());
		}
	}

	public static HashSet<Pair> gameOfLife(HashSet<Pair> l)
	{
		int minI = Integer.MAX_VALUE;
		int maxI = Integer.MIN_VALUE;
		int minJ = Integer.MAX_VALUE;
		int maxJ = Integer.MIN_VALUE;

		HashSet<Pair> toLive = new HashSet<Pair>();

		for(Pair p: l)
		{
			if(p.x > maxI) maxI = p.x;
			if(p.x < minI) minI = p.x;
			if(p.y > maxJ) maxJ = p.y;
			if(p.y < minJ) minJ = p.y;
		}

		for(int i=minI-1;i<=maxI+1;i++)
		{
			for(int j=minJ-1;j<=minJ+1;j++)
			{
				Pair coord = new Pair(i,j);
				int alive = 0;
				for(int ii=(i-1);ii<=(i+1);ii++)
				{
					for(int jj=(j-1);jj<=(j+1);jj++)
					{
						if(!(ii==i && jj==j))
						{
							if(l.contains(new Pair(ii,jj))) alive++;
						}
					}
				}
				if(l.contains(coord))
				{
					if((alive == 2) || (alive == 3)) toLive.add(coord);
				}
				else
				{
					if(alive == 3) toLive.add(coord);
				}
			}
		}
		return toLive;
	}
}

class Pair
{
	int x, y;
	Pair(int a, int b)
	{
		x = a;
		y = b;
	}

	public boolean equals(Object p1)
	{
		Pair p = (Pair)p1;
		return ((p.x == this.x) && (p.y == this.y));
	}

	public int hashCode()
	{
        int hash = 5;
        hash = (17*hash)+this.x +this.y;
        return hash;
    }

	public String toString()
	{
		return (x+" "+y);
	}
}