package com.github.jakz.esolang.cellular.lang.terms;

import com.github.jakz.esolang.cellular.*;

public interface Term<T extends Comparable<? super T>> 
{
  public T getValue(Automaton automaton, Cell cell);
  public void solveReferences(Automaton a);
  
  public static Term<Integer> neighborCount(Category type) { return new NeighborCountTerm(type); }
  public static Term<Integer> number(int value) { return new Number(value); }
  public static Term<Type> neighborTypeAt(int direction) { return new NeighborTerm(direction); }


}
