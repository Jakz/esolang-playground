package jack.esolang.cellular;

public class Spec
{
	public String name;
	public SpecInfo info;
	public Type[] types;
	
	public Spec(SpecInfo info, Type[] types)
	{
		this.types = types;
		this.info = info;
	}
	
	public void createAutomaton()
	{
		Automaton a = new Automaton(Constants.WC,Constants.HC);

		for (Type t : types)
			a.addType(t);
		
		for (Type t : types)
			t.solveReferences();
			
		a.setDefault(a.getType(info.defaultType));
	}
	
	public String toString()
	{
		String s = "";
		for (Type t : types)
			s += "  "+t.toString()+"\n";
		
		return s;
	}
}
