package com.github.jakz.esolang.cellular.lang;

import java.awt.Color;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

import com.github.jakz.esolang.cellular.lang.parsers.CellularLanguageBaseVisitor;
import com.github.jakz.esolang.cellular.lang.parsers.CellularLanguageParser;
import com.github.jakz.esolang.cellular.lang.terms.Term;

public class CellularLanguage
{
  @FunctionalInterface
  public static interface BinaryTermOperator<T extends Comparable<? super T>> extends BiPredicate<Term<T>, Term<T>> { }
  
  public static class ColorVisitor extends CellularLanguageBaseVisitor<Color>
  {
    @Override
    public Color visitColor(CellularLanguageParser.ColorContext ctx)
    {
      int r = Integer.parseInt(ctx.NUMBER(0).getText());
      int g = Integer.parseInt(ctx.NUMBER(1).getText());
      int b = Integer.parseInt(ctx.NUMBER(2).getText());
      
      return new Color(r,g,b);
    }
  }
  
  public static class BinaryTermOperatorVisitor<T extends Comparable<? super T>> extends CellularLanguageBaseVisitor<BinaryTermOperator<T>>
  {
    @Override
    public BinaryTermOperator<T> visitBop(CellularLanguageParser.BopContext ctx)
    {
      switch (ctx.getText())
      {
        case "==": return (t1, t2) -> t1.equals(t2);
        case "!=": return (t1, t2) -> !t1.equals(t2);
        case ">=": return (t1, t2) -> t1. .compare(t2) > 0;
        case "<=": return (t1, t2) -> t1.equals(t2);
        case ">": return (t1, t2) -> t1.equals(t2);
        case "<": return (t1, t2) -> t1.equals(t2);
      }
    }
  }
}
