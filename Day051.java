import java.io.*;
import java.util.*;

public class Day051
{
	static int K;
	static Random r = new Random();
	private static int randNum()
	{
		return r.nextInt(K)+1;
	}

	public static void main(String[] args) throws IOException
	{
		int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,
			                  27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52};

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		if(K<=0)
		{
			System.out.println("Not valid input. Exiting...");
		}
		else
		{
			shuffle(arr);
			System.out.println("\nShuffled Array is -");
			for(int i=0;i<52;i++)
			{
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
	}
	public static void shuffle(int[] a)
	{
		for(int i=a.length-1;i>0;i--)
		{
			int j = (neededRand(i+1)-1);
			int temp = a[j];
			a[j] = a[i];
			a[i] = temp;
		}
	}
	private static int neededRand(int i)
	{
		int ret = 0;
		if(K>=i)
		{
			ret = randNum();
			while(ret >= (i+1))
			{
				ret = randNum();
			}
			return ret;
		}
		int a = (int)((Math.log(i))/(Math.log(K)));
		for(int j=a;j>=0;j--)
		{
			ret += (Math.pow(K,j)*(randNum() - 1));
		}
		ret += 1;
		while(ret > ((i/K)*K))
		{
			ret = 0;
			for(int j=a;j>=0;j--)
			{
				ret += (Math.pow(K,j)*(randNum() - 1));
			}
			ret += 1;
		}
		return ret;
	}
}