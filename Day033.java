import java.io.*;
import java.util.*;

public class Day33
{
	static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){public int compare(Integer i1, Integer i2){return i1.compareTo(i2);}});
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){public int compare(Integer i1, Integer i2){return -1*i1.compareTo(i2);}});

	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("########################################################");
		System.out.println("Please enter the integers one after another in a line\nand enter an non-integer to end the stream");
		System.out.println("########################################################");
		while(sc.hasNextInt())
		{
			int i = sc.nextInt();
			offer(i);
			reOrder();
			System.out.println(getMedian());
		}
	}
	private static void offer(int i)
	{
		if(maxHeap.size() == 0) maxHeap.offer(i);
		else if(maxHeap.peek() >= i)
		{
			maxHeap.offer(i);
		}
		else minHeap.offer(i);
	}
	private static void reOrder()
	{
		if(minHeap.size() == maxHeap.size()) return;
		if(minHeap.size() > maxHeap.size())
		{
			if((minHeap.size() - maxHeap.size()) >= 2)
			{
				int t = minHeap.poll();
				maxHeap.offer(t);
			}
		}
		else
		{
			if((maxHeap.size() - minHeap.size()) >= 2)
			{
				int t = maxHeap.poll();
				minHeap.offer(t);
			}
		}
	}
	private static double getMedian()
	{
		if(maxHeap.size() > minHeap.size()) return (double)maxHeap.peek();
		else if(minHeap.size() > maxHeap.size()) return (double)minHeap.peek();
		return ((minHeap.peek()+maxHeap.peek())/2.0);
	}
}