package jack.esolang.source;

public class Opcode<T>
{
	public T v;
	
	public Opcode(T opcode)
	{
		this.v = opcode;
	}
	
	@SuppressWarnings("unchecked")
	public boolean equals(Object o)
	{
		return v.equals(((Opcode<T>)o).v);
	}
	
	public int hashCode()
	{
		return v.hashCode();
	}
}
