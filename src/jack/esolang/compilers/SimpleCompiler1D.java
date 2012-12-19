package jack.esolang.compilers;

import java.util.*;
import jack.esolang.source.*;

public class SimpleCompiler1D implements Compiler<Character, Code1D<Character>>
{
	//Opcodes<Character> opcodes;
	
	public SimpleCompiler1D()
	{
		//this.opcodes = opcodes;
	}

	public Code1D<Character> compile(String source)
	{
		List<Opcode<Character>> arrayCode = new ArrayList<Opcode<Character>>();

		for (int i = 0; i < source.length(); ++i)
		{
			char c = source.charAt(i);
			Opcode<Character> op = new Opcode<Character>(c);
			//if (opcodes.valid(op))
			{
				arrayCode.add(op);
			}
		}
		
		Code1D<Character> program = new Code1D<Character>(arrayCode.toArray());
		
		return program;
	}
}
