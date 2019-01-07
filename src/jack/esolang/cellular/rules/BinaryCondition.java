package jack.esolang.cellular.rules;

import java.util.function.Predicate;

import jack.esolang.cellular.*;

public class BinaryCondition implements Condition
{
  public static enum Op
  {
    AND, OR
  }

  Op op;
  Condition[] conds;

  public BinaryCondition(Op op, Condition... conds)
  {
    this.conds = conds;
    this.op = op;
  }
  
  @Override
  public Predicate<Cell> compile()
  {
    switch (op)
    {
      case AND: return cell -> 
      {
        for (Condition c : conds)
          if (!c.compile().test(cell))
            return false;
        
        return true;
      };
      
      case OR: return cell -> 
      {
        for (Condition c : conds)
          if (c.compile().test(cell))
            return true;

        return false;
      };
      
      default: return c -> true;
    }
  }

  public void solveReferences(Automaton a)
  {
    for (Condition c : conds)
      c.solveReferences(a);
  }

  public String toString()
  {
    String s = "(";

    for (int i = 0; i < conds.length; ++i)
    {
      s += conds[i].toString();

      if (i < conds.length - 1)
        s+= op == Op.AND ? " && " : " || ";
    }

    s += ")";

    return s;
  }
}
