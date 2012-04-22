package jack.esolang.source;

import java.util.*;

public class Opcodes<T>
{
	Set<Opcode<T>> opcodes;
	boolean ignoreOthers;
	
	public Opcodes(boolean ignoreOthers)
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
	
	public boolean valid(Opcode<T> v)
	{
		return opcodes.contains(v);
	}
}
