package jack.esolang.cellular.lang.rules;

import jack.esolang.cellular.Automaton;
import jack.esolang.cellular.Cell;
import jack.esolang.cellular.Type;

public interface Rule
{
  public boolean applyOnCell(Automaton a, Cell cell);
  public void solveReferences(Automaton a);
  
  public static Rule changeType(Type type, Condition condition) { return new FixedRule(type, condition); }
}