import java.io.*;
import java.uti.*;

public class Day24
{
	int val;
	Day24 left, right;
	Day24 parent;
	boolean isLocked;
	int lockedDescendents;

	public Day24(int a)
	{
		val = a;
		left = null;
		right = null;
		parent = null;
		isLocked = false;
		lockedDescendents = 0;
	}

	public boolean is_locked()
	{
		return isLocked;
	}

	public boolean lock()
	{
		Day24 p = this.parent;
		while(p!=null)
		{
			if(p.is_locked())
			{
				return false;
			}
			p = p.parent;
		}
		if(lockedDescendents > 0)
		{
			return false;
		}
		p = this.parent;
		while(p!=null)
		{
			p.lockedDescendents++;
		}
		this.isLocked = true;
		return true;
	}
	public boolean unlock()
	{
		Day24 p = this.parent;
		boolean areAncestorsUnlocked = true;
		while(p!=null)
		{
			if(p.is_locked())
			{
				areAncestorsUnlocked = false;
				break;
			}
		}
		if(lockedDescendents>0 || !areAncestorsUnlocked)
		{
			p = this.parent;
			while(p!=null)
			{
				p.lockedDescendents--;
			}
			this.isLocked = false;
			return true;
		}
		return false;
	}
}