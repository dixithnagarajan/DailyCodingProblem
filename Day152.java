import java.io.*;
import java.util.*;

public class Day152
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inpString = br.readLine().trim().split(" ");
		String[] probString = br.readLine().trim().split(" ");
		br.close();
		float[] nums = new float[inpString.length];
		float[] probs = new float[probString.length];
		for(int i=0;i<nums.length;i++)
		{
			nums[i] = Float.parseFloat(inpString[i]);
			probs[i] = Float.parseFloat(probString[i]);
		}

		int result = randomWithProb(nums, probs);
		System.out.println("\n\n"+nums[result]);
		//Use analyseAlgorithm to check the performance;
	}
	public static int randomWithProb(float[] nums, float[] p)
	{
		if(p[p.length-1] != 1.0)
		{
			Pair[] arr = new Pair[nums.length];
			for(int i=0;i<nums.length;i++)
			{
				arr[i] = new Pair(p[i], nums[i]);
			}
			Arrays.sort(arr);
			for(int i=0;i<nums.length;i++)
			{
				nums[i] = arr[i].n;
				p[i] = arr[i].p;
			}
			for(int i=1;i<nums.length;i++)
			{
				p[i] += p[i-1];
			}
		}
		float ru = (float)Math.random();
		int i = 0;
		for(i=0;i<nums.length-1;i++)
		{
			if(ru <= p[i]) break;
		}
		return i;
	}
	private static void analyseAlgorithm(int n, float[] nums, float[] p)
	{
		int[] vector = new int[nums.length];
		for(int i=0;i<n;i++)
		{
			int j = randomWithProb(nums, p);
			vector[j]++;
		}
		for(int i=0;i<nums.length;i++)
		{
			System.out.println(nums[i]+" -> "+vector[i]+" -> "+((vector[i])/(n+0.0)));
		}
	}
}

class Pair implements Comparable<Pair>
{
	float p, n;
	Pair(float a, float b)
	{
		p = a;
		n = b;
	}
	public int compareTo(Pair p1)
	{
		if(this.p == p1.p) return 0;
		if(this.p < p1.p) return 1;
		return -1;
	}
}
