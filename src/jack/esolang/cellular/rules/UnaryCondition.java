package jack.esolang.cellular.rules;

import jack.esolang.cellular.*;

public class UnaryCondition implements Condition
{
	public enum Op {
		NOT("!");
		
		public final String val;
		
		Op(String val)
		{
			this.val = val;
		}
		
		public String toString() { return val; }
	}
	
	private final Condition inner;
	private final Op op;

	public UnaryCondition(Op op, Condition inner)
	{
		this.inner = inner;
		this.op = op;
	}
	
	public boolean evaluate(Cell cell)
	{
		switch (op)
		{
			case NOT: return !inner.evaluate(cell);
			default: return false;
		}
	}
	
	public void solveReferences(Automaton a)
	{
		inner.solveReferences(a);
	}
	
	public String toString()
	{
		return op+"("+inner.toString()+")";
	}
}
