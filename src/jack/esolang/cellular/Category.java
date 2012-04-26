package jack.esolang.cellular;

import jack.esolang.cellular.rules.FixedRule;
import jack.esolang.cellular.rules.Rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}
