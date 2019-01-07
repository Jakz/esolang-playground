package com.github.jakz.esolang.cellular.lang.rules;

import java.util.function.Predicate;

import com.github.jakz.esolang.cellular.*;

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
  public Predicate<Cell> compile(Automaton a)
  {
    switch (op)
    {
      case AND: return cell -> 
      {
        for (Condition c : conds)
          if (!c.compile(a).test(cell))
            return false;
        
        return true;
      };
      
      case OR: return cell -> 
      {
        for (Condition c : conds)
          if (c.compile(a).test(cell))
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
