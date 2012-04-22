package jack.esolang.cellular.rules.terms;

import jack.esolang.cellular.*;

public class Number implements Term<Integer>
{
	int i;
	
	public Number(int i)
	{
		this.i = i;
	}
	
	public Integer getValue(Cell cell)
	{
		return i;
	}
	
	public void solveReferences() {}
	
	public String toString()
	{
		return i+"";
	}
}
