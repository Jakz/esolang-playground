package jack.esolang.cellular.rules;

import java.util.function.Predicate;

import jack.esolang.cellular.*;
import jack.esolang.cellular.rules.terms.Term;

public interface Condition
{
  public Predicate<Cell> compile();
  
  public void solveReferences(Automaton a);
  
  public static Condition and(Condition... conditions) { return new BinaryCondition(BinaryCondition.Op.AND, conditions); }
  public static Condition or(Condition... conditions) { return new BinaryCondition(BinaryCondition.Op.OR, conditions); }
  public static Condition not(Condition condition) { return new UnaryCondition(UnaryCondition.Op.NOT, condition); }
  
  public static <T extends Comparable<? super T>> Condition eq(Term<T> t1, Term<T> t2) { return new ComparisonCondition<>(ComparisonCondition.Op.EQ, t1, t2); }
  public static <T extends Comparable<? super T>> Condition neq(Term<T> t1, Term<T> t2) { return new ComparisonCondition<>(ComparisonCondition.Op.NEQ, t1, t2); }
  public static <T extends Comparable<? super T>> Condition geq(Term<T> t1, Term<T> t2) { return new ComparisonCondition<>(ComparisonCondition.Op.GEQ, t1, t2); }
  public static <T extends Comparable<? super T>> Condition gre(Term<T> t1, Term<T> t2) { return new ComparisonCondition<>(ComparisonCondition.Op.GRE, t1, t2); }
  public static <T extends Comparable<? super T>> Condition leq(Term<T> t1, Term<T> t2) { return new ComparisonCondition<>(ComparisonCondition.Op.LEQ, t1, t2); }
  public static <T extends Comparable<? super T>> Condition les(Term<T> t1, Term<T> t2) { return new ComparisonCondition<>(ComparisonCondition.Op.LES, t1, t2); }
}
