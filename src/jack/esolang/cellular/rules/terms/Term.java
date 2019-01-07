package jack.esolang.cellular.rules.terms;

import jack.esolang.cellular.*;

public interface Term<T extends Comparable<? super T>> 
{
  public T getValue(Cell cell);
  public void solveReferences(Automaton a);
  
  public static Term<Integer> neighborCount(Category type) { return new NeighborCountTerm(type); }
  public static Term<Integer> number(int value) { return new Number(value); }
  public static Term<Type> neighborTypeAt(int direction) { return new NeighborTerm(direction); }


}
