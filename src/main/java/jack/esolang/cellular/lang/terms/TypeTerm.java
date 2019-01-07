package jack.esolang.cellular.lang.terms;

import jack.esolang.cellular.*;

public class TypeTerm implements Term<Type>
{
	Type type;
	
	public TypeTerm(Type type)
	{
		this.type = type;
	}
	
	public Type getValue(Automaton a, Cell cell)
	{
		return type;
	}
	
	public void solveReferences(Automaton a)
	{
		if (type instanceof TypePlaceholder)
		{
			this.type = (Type)a.getType(type.name);
		}
	}
	
	public String toString()
	{
		return type.name;
	}
}