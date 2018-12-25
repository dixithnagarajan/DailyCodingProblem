import java.io.*;
import java.util.*;

public class Day160
{
	public static void main(String[] args)
	{
		Graph g = new Graph(8);
		g.addEdge(0, 1, 3);
		g.addEdge(0, 2, 5);
		g.addEdge(0, 3, 8);
		g.addEdge(3, 4, 2);
		g.addEdge(3, 5, 4);
		g.addEdge(4, 6, 1);
		g.addEdge(4, 7, 1);

		int[] t1 = g.BFS(0);
		int[] t2 = g.BFS(t1[0]);
		System.out.println("The longest path is between "+t1[0]+" and "+t2[0]+" of length "+t2[1]+".");
	}
}

class Graph
{
	int V;
	int[][] list;
	Graph(int a)
	{
		V = a;
		list = new int[V][V];
	}

	void addEdge(int x, int y, int w)
	{
		list[x][y] = w;
		list[y][x] = w;
	}

	int[] BFS(int u)
	{
		int[] dist = new int[this.V];
		Arrays.fill(dist, -1);
		dist[u] = 0;
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(u);
		while(!q.isEmpty())
		{
			int temp = q.remove();
			for(int i=0;i<V;i++)
			{
				if(list[temp][i] != 0 && dist[i] == -1)
				{
					q.add(i);
					dist[i] = dist[temp]+list[temp][i];
				}
			}
		}
		int maxInd = -1;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<V;i++)
		{
			if(dist[i] > max)
			{
				max = dist[i];
				maxInd = i;
			}
		}
		return new int[]{maxInd, max};
	}
}
