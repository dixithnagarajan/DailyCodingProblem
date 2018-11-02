import java.io.*;
import java.util.*;

public class Day079
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inpString = br.readLine().split(" ");
		int[] arr = new int[inpString.length];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = Integer.parseInt(inpString[i]);
		}
		br.close();
		boolean result = canDo(arr);
		System.out.println("\n"+result);
	}
	public static boolean canDo(int[] nums)
	{
		if(nums == null) return true;
		if(nums.length <=2) return true;
		int count = 0;
		for(int i=1;i<nums.length && count<=1;i++)
		{
			if(nums[i-1] > nums[i])
			{
				count++;
				if(i-2<0 || nums[i-2] <= nums[i]) nums[i-1] = nums[i];
				else nums[i] = nums[i-1];
			}
		}
		return count<=1;
	}
}