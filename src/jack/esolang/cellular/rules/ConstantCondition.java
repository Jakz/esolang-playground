package jack.esolang.cellular.rules;

import jack.esolang.cellular.Automaton;
import jack.esolang.cellular.Cell;

public class ConstantCondition implements Condition
{
	private final boolean value;
	
	public ConstantCondition(boolean value)
	{
		this.value = value;
	}
	
	public boolean evaluate(Cell cell)
	{
		return value;
	}
	
	public void solveReferences(Automaton a) { }
	
	public String toString()
	{
		return Boolean.toString(value);
	}
}
