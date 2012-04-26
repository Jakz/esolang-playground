package jack.esolang.cellular;

import java.util.HashMap;

public class Spec
{
	public String name;
	public SpecInfo info;
	public Type[] types;
	public Category[] categories;
	public final HashMap<String, GFXSpec> templates;
	
	public Spec(SpecInfo info, Type[] types, Category[] categories, HashMap<String, GFXSpec> templates)
	{
		this.types = types;
		this.categories = categories;
		this.info = info;
		this.templates = templates;
	}
	
	public Automaton createAutomaton()
	{
		Automaton a = new Automaton(Constants.WC,Constants.HC);

		for (Category c : categories)
			a.addType(c);
		
		for (Type t : types)
			a.addType(t);
		
		for (Category c : categories)
			c.solveReferences(a);
		
		for (Type t : types)
			t.solveReferences(a);
		
			
		a.setDefaults((Type)a.getType(info.defaultType));
		a.setTemplates(templates);
		return a;
	}
	
	public String toString()
	{
		String s = "";
		for (Type t : types)
			s += "  "+t.toString()+"\n";
		
		return s;
	}
}
