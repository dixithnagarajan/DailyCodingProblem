import java.io.*;
import java.util*;

public class Day16<T>
{
	int N;
	int size;
	HashSet<T> logForCheck;
	ArrayList<T> log;

	public Day16(int N)
	{
		this.N = N;
		size = 0;
		logForCheck = new HashSet<T>();
		log = new ArrayList<T>();
	}

	public boolean record_id(T log_id)
	{
		if(logForCheck.contains(log_id)) return false;
		if(size == this.N)
		{
			T val = log.get(0);
			log.remove(T);
			logForCheck.remove(T);
			log.add(log_id);
			logForCheck.add(log_id);
			return true;
		}
		log.add(log_id);
		logForCheck.add(log_id);
		size++;
	}

	public T get_last(int pos)
	{
		if((pos < 1) || (pos > N)) return null;
		return log.get(N-pos+1);
	}
}