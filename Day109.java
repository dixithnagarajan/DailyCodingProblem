import java.io.*;
import java.util.*;

public class Day109
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		int result = swapBits((char)N);
		System.out.println(result);
	}
	public static int swapBits(char c)
	{
		return ((((c&(0b10101010))>>1) | ((c&(0b01010101))<<1))&((1<<8)-1));
	}
}