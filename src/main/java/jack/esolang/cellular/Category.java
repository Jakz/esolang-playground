package jack.esolang.cellular;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jack.esolang.cellular.lang.rules.FixedRule;
import jack.esolang.cellular.lang.rules.Rule;

public class Category
{
  public String name;
  List<Rule> rules;

  public Category() { }

  public Category(String name)
  {
    this.name = name;
    this.rules = new ArrayList<Rule>();
  }

  public Category(String name, Rule[] rules)
  {
    this.name = name;
    //this.rules = new ArrayList<Rule>();
    this.rules = Arrays.asList(rules);
  }

  public String toString()
  {
    String s = name+"\n";
    for (Rule r : rules)
      s += "    "+r.toString()+"\n";

    return s;
  }

  public void addRule(Rule rule)
  {
    rules.add(rule);
  }

  public List<Rule> rules()
  {
    return rules;
  }

  public void solveReferences(Automaton a)
  {
    for (Rule r : rules)
      r.solveReferences(a);
  }
  
  public static Category of(String name, Rule... rules)
  {
    return new Category(name, rules);
  }
}
