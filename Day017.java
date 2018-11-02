import java.io.*;
import java.util.*;

public class Day17
{
	public static void main(String[] args) throws IOException
	{
		String test = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		System.out.println(test);
		System.out.println(longestFilePath(test));
	}
	public static int longestFilePath(String s)
	{
			int level = 1;
			int count = 0;
			int maxlen = 0;
			HashMap<Integer, Integer> levelMap = new HashMap<Integer, Integer>();
			levelMap.put(0,0);
			boolean isFile = false;

			for(int i=0;i<s.length();i++)
			{
				while(s.charAt(i) == '\t')
				{
					level++;
					i++;
				}
				while((i < s.length()) && (s.charAt(i) != '\n'))
				{
					if(s.charAt(i) == '.') isFile = true;
					count++;
					i++;
				}
				if(isFile)
				{
					maxlen = Math.max(maxlen, count+levelMap.get(level-1));
				}
				else
				{
					levelMap.put(level,  1+count+levelMap.get(level-1));
				}

				isFile = false;
				count = 0;
				level = 1;
			}
			return maxlen;
	}
}