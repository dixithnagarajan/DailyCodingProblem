import java.io.*;
import java.util.*;

public class Day056
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N][N];
		for(int i=0;i<N;i++)
		{
			String[] inpString = br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				graph[i][j] = Integer.parseInt(inpString[j]);
			}
		}
		int k = Integer.parseInt(br.readLine());
		br.close();
		boolean result = canColour(graph, k);
		System.out.println("\n"+result);
	}
	public static boolean canColour(int[][] graph, int k)
	{
		int[] colours = new int[graph.length];
		return canColour(graph, k, colours, 0);
	}
	private static boolean canColour(int[][] graph, int k, int[] colours, int v)
	{
		if(v == graph.length) return true;
		for(int i=1;i<=k;i++)
		{
			if(isValid(v, graph, colours, i))
			{
				colours[v] = i;
				if(canColour(graph, k, colours, v+1)) return true;
				colours[v] = 0;
			}
		}
		return false;
	}
	private static boolean isValid(int v, int[][] graph, int[] colours, int c)
	{
		for(int i=0;i<graph.length;i++)
		{
			if(graph[v][i] == 1 && c == colours[i]) return false;
		}
		return true;
	}
}