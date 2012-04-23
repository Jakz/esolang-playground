package jack.esolang.cellular;

import jack.esolang.cellular.rules.*;
import java.util.*;

public class Type implements Comparable<Type>
{
	public String name;
	
	List<Rule> rules;
	ArrayList<Category> categories;
	
	Type()
	{
		
	}
	
	Type(String name)
	{
		this.name = name;
		this.rules = new ArrayList<Rule>();
		this.categories = new ArrayList<Category>();
	}
	
	public Type(String name, Rule[] rules)
	{
		this.name = name;
		//this.rules = new ArrayList<Rule>();
		this.rules = Arrays.asList(rules);
		this.categories = new ArrayList<Category>();
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
	
	void update(Cell cell)
	{
		for (Rule r : rules)
		{
			if (r.applyOnCell(cell))
				return;
		}
		
		cell.nextType = cell.type;
	}
	
	public int compareTo(Type other)
	{
		return name.compareTo(name);
	}
	
	public void solveReferences(Automaton a)
	{
		for (Rule r : rules)
			r.solveReferences(a);
	}
}
