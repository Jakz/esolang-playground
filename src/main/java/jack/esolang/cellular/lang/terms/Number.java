package jack.esolang.cellular.lang.terms;

import jack.esolang.cellular.*;

public class Number implements Term<Integer>
{
	int i;
	
	public Number(int i)
	{
		this.i = i;
	}
	
	public Integer getValue(Automaton a, Cell cell)
	{
		return i;
	}
	
	public void solveReferences(Automaton a) {}
	
	public String toString()
	{
		return i+"";
	}
}
