package jack.esolang.source;

public class Opcode<T>
{
	public T v;
	
	public Opcode(T opcode)
	{
		this.v = opcode;
	}
}
