import java.io.*;
import java.util.*;

//Assuming the function oracle exists in one package.
//DO NOT COMPILE THIS FILE

public class Day66
{
	public int unbiased()
	{
		int coin1 = 0, coin2 = 0;
		while(coin1 == coin2)
		{
			coin1 = biased();
			coin2 = biased();
		}
		return coin1;
	}
}