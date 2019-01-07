package com.github.jakz.esolang.cellular.lang.rules;

import com.github.jakz.esolang.cellular.Automaton;
import com.github.jakz.esolang.cellular.Cell;
import com.github.jakz.esolang.cellular.Type;

public interface Rule
{
  public boolean applyOnCell(Automaton a, Cell cell);
  public void solveReferences(Automaton a);
  
  public static Rule changeType(Type type, Condition condition) { return new FixedRule(type, condition); }
}