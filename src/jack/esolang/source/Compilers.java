package jack.esolang.source;

import jack.esolang.languages.*;
import java.util.*;

public class Compilers
{
	public static Code1D<Character> compileCharProgram(String source, Language<Character, Code1D<Character>, ?, ?, ?> language)
	{
		Opcodes<Character> opcodes = language.opcodes();
		ArrayList<Opcode<Character>> arrayCode = new ArrayList<Opcode<Character>>();

		for (int i = 0; i < source.length(); ++i)
		{
			char c = source.charAt(i);
			Opcode<Character> op = new Opcode<Character>(c);
			if (opcodes.valid(op))
			{
				arrayCode.add(op);
			}
		}
		
		Code1D<Character> program = new Code1D<Character>(arrayCode.toArray());
		
		return program;
	}
}
