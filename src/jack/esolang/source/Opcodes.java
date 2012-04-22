package jack.esolang.source;

import java.util.*;

public class Opcodes<T>
{
	Set<Opcode<T>> opcodes;
	
	public Opcodes()
	{
		opcodes = new HashSet<Opcode<T>>();
	}
	
	public void add(Opcode<T> opcode)
	{
		opcodes.add(opcode);
	}
	
	public int count()
	{
		return opcodes.size();
	}
	
	public boolean valid(T v)
	{
		return opcodes.contains(v);
	}
}
