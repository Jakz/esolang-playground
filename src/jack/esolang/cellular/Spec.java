package jack.esolang.cellular;

import java.util.HashMap;

public class Spec
{
	public String name;
	public SpecInfo info;
	public Type[] types;
	public final HashMap<String, GFXSpec> templates;
	
	public Spec(SpecInfo info, Type[] types, HashMap<String, GFXSpec> templates)
	{
		this.types = types;
		this.info = info;
		this.templates = templates;
	}
	
	public Automaton createAutomaton()
	{
		Automaton a = new Automaton(Constants.WC,Constants.HC);

		for (Type t : types)
			a.addType(t);
		
		for (Type t : types)
			t.solveReferences(a);
			
		a.setDefaults(a.getType(info.defaultType),a.getType(info.leftType),a.getType(info.rightType));
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
