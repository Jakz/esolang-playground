package jack.esolang.cellular.rules;

import java.util.function.Predicate;

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
	
	@Override
	public Predicate<Cell> compile()
	{
	  switch (op)
	  {
	    case NOT: return Predicate.not(inner.compile());
	    default: return inner.compile();
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
