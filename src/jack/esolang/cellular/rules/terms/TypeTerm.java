package jack.esolang.cellular.rules.terms;

import jack.esolang.cellular.*;

public class TypeTerm implements Term<Type>
{
	Type type;
	
	public TypeTerm(Type type)
	{
		this.type = type;
	}
	
	public Type getValue(Cell cell)
	{
		return type;
	}
	
	public void solveReferences()
	{
		if (type instanceof TypePlaceholder)
		{
			this.type = Automaton.current().getType(type.name);
		}
	}
	
	public String toString()
	{
		return type.name;
	}
}