package jack.esolang.cellular.lang.rules;

import java.util.function.Predicate;

import jack.esolang.cellular.*;
import jack.esolang.cellular.lang.terms.Term;

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
	
	public ComparisonCondition(Op op, Term<T> t1, Term<T> t2)
	{
		this.t1 = t1;
		this.t2 = t2;
		this.op = op;
	}
	
	@Override
	public Predicate<Cell> compile(Automaton a)
	{
	  return cell -> {
	    T v1 = t1.getValue(a, cell);
	    T v2 = t2.getValue(a, cell);

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
	  };
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
