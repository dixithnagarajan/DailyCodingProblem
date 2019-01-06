import java.io.*;
import java.util.*;

public class Test
{
	public static void main(String[] args)
	{
		Day154 d = new Day154();
		d.push(1);
		d.push(2);

		System.out.println(d.pop());
		System.out.println(d.pop());

		d.push(1);
		System.out.println(d.pop());
	}
}
