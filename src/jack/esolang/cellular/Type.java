package jack.esolang.cellular;

import jack.esolang.cellular.rules.*;
import java.util.*;

public class Type implements Comparable<Type>
{
	public String name;
	public GFXSpec template;
	
	ArrayList<Rule> rules;
	ArrayList<Category> categories;
	
	Type()
	{
		
	}
	
	Type(String name, GFXSpec template)
	{
		this.name = name;
		this.template = template;
		this.rules = new ArrayList<Rule>();
		this.categories = new ArrayList<Category>();
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
}
