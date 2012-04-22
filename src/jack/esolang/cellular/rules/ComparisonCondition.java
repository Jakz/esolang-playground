package jack.esolang.cellular.rules;

import jack.esolang.cellular.rules.terms.Term;
import jack.esolang.cellular.*;

public class ComparisonCondition<T extends Comparable<? super T>> implements Condition
{
	public static enum Op
	{
		EQ("=="),
		NEQ("!="),
		GEQ(">="),
		GRE(">"),
		LEQ("<="),
		LES("<");
		
		String str;
		
		Op(String str) { this.str = str; }
		
		public String toString() { return str; }
	};
	
	Term<T> t1, t2;
	Op op;
	
	public ComparisonCondition(Term<T> t1, Term<T> t2, Op op)
	{
		this.t1 = t1;
		this.t2 = t2;
		this.op = op;
	}
	
	public boolean evaluate(Cell cell)
	{
		switch (op)
		{
			case EQ: return t1.getValue(cell).equals(t2.getValue(cell));
			case NEQ: return !t1.getValue(cell).equals(t2.getValue(cell));
			case GEQ: return t1.getValue(cell).compareTo(t2.getValue(cell)) >= 0;
			case LEQ: return t1.getValue(cell).compareTo(t2.getValue(cell)) <= 0;
			case GRE: return t1.getValue(cell).compareTo(t2.getValue(cell)) > 0;
			case LES: return t1.getValue(cell).compareTo(t2.getValue(cell)) < 0;
			default: return false;
		}
	}
	
	public void solveReferences()
	{
		t1.solveReferences();
		t2.solveReferences();
	}
	
	public String toString()
	{
		return t1.toString()+" "+op+" "+t2.toString();
	}
}
