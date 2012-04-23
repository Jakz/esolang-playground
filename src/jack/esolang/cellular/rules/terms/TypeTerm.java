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
	
	public void solveReferences(Automaton a)
	{
		if (type instanceof TypePlaceholder)
		{
			this.type = a.getType(type.name);
		}
	}
	
	public String toString()
	{
		return type.name;
	}
}