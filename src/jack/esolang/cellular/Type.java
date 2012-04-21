package jack.esolang.cellular;

import jack.esolang.cellular.rules.*;
import java.util.*;

public class Type
{
	public final String name;
	public final GFXTemplate template;
	
	ArrayList<Rule> rules;
	ArrayList<Category> categories;
	
	Type(String name, GFXTemplate template)
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
}
