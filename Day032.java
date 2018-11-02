import java.io.*;
import java.util.*;

public class Day32
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double[][] graph = new double[N][N];
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++)
		{
			String[] inpString = br.readLine().split(" ");
			int x = Integer.parseInt(inpString[0]);
			int y = Integer.parseInt(inpString[1]);
			double w = Double.parseDouble(inpString[2]);

			graph[x][y] = w;
			graph[y][x] = 1.0/w;
		}
		br.close();

		for(int i=0;i<N;i++)
		{
			graph[i][i] = 1;
		}

		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(i!=j) graph[i][j] = -1.0*Math.log(graph[i][j]);
			}
		}

		if(containsNegCycle(graph)) System.out.println("Yes, there is a possibility of arbitage");
		else System.out.println("No, no possibility of arbitage");
	}

	public static boolean containsNegCycle(double[][] graph)
	{
		int V = graph.length;

		for(int k=0;k<V;k++)
		{
			for(int i=0;i<V;i++)
			{
				for(int j=0;j<V;j++)
				{
					if(graph[i][j] > graph[i][k]+graph[k][j]) graph[i][j]=graph[i][k]+graph[k][j];
				}
			}
		}

		for(int i=0;i<V;i++)
		{
			if(graph[i][i] < 0) return true;
		}
		return false;
	}
}