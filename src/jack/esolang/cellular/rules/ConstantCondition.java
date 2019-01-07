package jack.esolang.cellular.rules;

import java.util.function.Predicate;

import jack.esolang.cellular.Automaton;
import jack.esolang.cellular.Cell;

public class ConstantCondition implements Condition
{
	private final boolean value;
	
	public ConstantCondition(boolean value)
	{
		this.value = value;
	}
	
	@Override
	public Predicate<Cell> compile() { return c -> value; }
	
	public void solveReferences(Automaton a) { }
	
	public String toString()
	{
		return Boolean.toString(value);
	}
}
