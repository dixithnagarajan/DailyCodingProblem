import java.io.*;
import java.util.*;

public class Day175
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inpString = br.readLine().trim().split("\\s+");
		String state = inpString[0].trim();
		int num_steps = Integer.parseInt(inpString[1]);
		int n = Integer.parseInt(br.readLine().trim());
		String[][] transitions = new String[n][3];
		for(int i=0;i<n;i++)
		{
			transitions[i] = br.readLine().trim().split("\\s+");
		}

		HashMap<String, Integer> result = markov(state, num_steps, transitions);
		System.out.println("\nOutput of the run is - "+result.toString());
	}
	public static HashMap<String, Integer> markov(String start, int num_steps, String[][] transitions)
	{
		if(start == null || start.length() == 0) return null;
		if(num_steps <= 0) return null;
		if(transitions == null || transitions.length == 0) return null;

		HashSet<String> states = new HashSet<String>();
		HashMap<Integer, String> indices = new HashMap<>();
		HashMap<String, Integer> revIndices = new HashMap<>();
		for(int i=0;i<transitions.length;i++)
		{
			states.add(transitions[i][0]);
			states.add(transitions[i][1]);
		}
		int j = 0;
		for(String s: states)
		{
			indices.put(j, s);
			revIndices.put(s, j);
			j++;
		}
		double[][] transitionMatrix = new double[states.size()][states.size()];
		for(int i=0;i<transitionMatrix.length;i++)
		{
			for(j=0;j<transitionMatrix.length;j++)
			{
				transitionMatrix[i][j] = 0.0;
			}
		}
		for(int i=0;i<transitions.length;i++)
		{
			int a = revIndices.get(transitions[i][0]);
			int b = revIndices.get(transitions[i][1]);
			transitionMatrix[a][b] = Double.parseDouble(transitions[i][2]);
		}
		HashMap<String, Integer> retVal = new HashMap<String, Integer>();
		for(String s: states)
		{
			retVal.put(s, 0);
		}
		retVal.put(start, 1);
		int i = 1;
		String nextState = start;
		while(i<num_steps)
		{
			nextState = getNext(transitionMatrix[revIndices.get(nextState)], indices);
			retVal.put(nextState, retVal.get(nextState)+1);
			i++;
		}
		return retVal;
	}
	public static String getNext(double[] probs, HashMap<Integer, String> inds)
	{
		Pair[] a = new Pair[probs.length];
		for(int i=0;i<a.length;i++)
		{
			a[i] = new Pair(i, probs[i]);
		}
		Arrays.sort(a);
		for(int i=1;i<a.length;i++)
		{
			a[i].val += a[i-1].val;
		}
		double random = Math.random();
		int i;
		for(i=0;i<a.length;i++)
		{
			if(a[i].val > random) break;
		}
		return inds.get(i);
	}
}

class Pair implements Comparable<Pair>
{
	int i;
	double val;
	Pair(int a, double b)
	{
		this.i = a;
		this.val = b;
	}
	public String toString()
	{
		return i+"->"+val;
	}
	public int compareTo(Pair p)
	{
		return Double.compare(p.val, this.val);
	}
}
