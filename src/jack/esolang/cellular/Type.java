package jack.esolang.cellular;

import jack.esolang.cellular.rules.*;

import java.util.*;

public class Type extends Category implements Comparable<Type>
{
	List<Category> categories;
	
	public Type() { }
	
	Type(String name)
	{
		super(name);
		this.rules = new ArrayList<Rule>();
		this.categories = new ArrayList<Category>();
	}
	
	public Type(String name, Rule[] rules)
	{
		super(name, rules);
		//this.rules = new ArrayList<Rule>();
		this.categories = new ArrayList<Category>();
	}
	
	void update(Cell cell)
	{
		for (Rule r : rules)
			if (r.applyOnCell(cell))
				return;
		
		for (Category c : categories)
			for (Rule r : c.rules())
				if (r.applyOnCell(cell))
					return;
		
		cell.nextType = cell.type;
	}
	
	public int compareTo(Type other)
	{
		return name.compareTo(name);
	}
	
	public void setCategories(List<Category> categories)
	{
		this.categories = categories;
	}
	
	public boolean equals(Object o)
	{
		if (o instanceof Type)
			return name.equals(((Type)o).name);
		else
		{
			for (int i = 0; i < categories.size(); ++i)
				if (categories.get(i).name.equals(((Category)o).name))
					return true;
					
			return false;
		}
	}
	
	public void solveReferences(Automaton a)
	{
		ArrayList<Category> solvedCats = new ArrayList<Category>();
		for (Category c : categories)
		{
			Category cc = a.getType(c.name);
			System.out.println("Solving "+c.name+" with "+cc);
			solvedCats.add(cc);
		}
		categories = solvedCats;
		
		for (Rule r : rules)
			r.solveReferences(a);
		
		for (Category c : categories)
			for (Rule r : c.rules())
				r.solveReferences(a);
	}
}
