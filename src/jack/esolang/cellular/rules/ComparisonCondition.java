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
		T v1 = t1.getValue(cell);
		T v2 = t2.getValue(cell);
		
		if (v1 == null || v2 == null) return false;
		
		switch (op)
		{
			case EQ: return v1.equals(v2); 
			case NEQ: return !v1.equals(v2); 
			case GEQ: return v1.compareTo(v2) >= 0; 
			case LEQ: return v1.compareTo(v2) <= 0; 
			case GRE: return v1.compareTo(v2) > 0;
			case LES: return v1.compareTo(v2) < 0;
			default: return false;
		}
	}
	
	public void solveReferences(Automaton a)
	{
		t1.solveReferences(a);
		t2.solveReferences(a);
	}
	
	public String toString()
	{
		return t1.toString()+" "+op+" "+t2.toString();
	}
}
