package jack.esolang.compilers;

import java.util.*;
import jack.esolang.source.*;

public class SimpleCompiler1D implements Compiler<Character, Code1D<Character>>
{
	Set<Character> opcodes;
	
	public SimpleCompiler1D(Character[] opcodes)
	{
		this.opcodes = new HashSet<Character>(Arrays.asList(opcodes));
	}

	public Code1D<Character> compile(String source)
	{
		List<Character> arrayCode = new ArrayList<Character>();

		for (int i = 0; i < source.length(); ++i)
		{
			char c = source.charAt(i);
			
			if (opcodes.contains(c))
				arrayCode.add(c);
		}
		
		Code1D<Character> program = new Code1D<Character>(arrayCode.toArray(new Character[arrayCode.size()]));
		
		return program;
	}
}
