package jack.esolang.source;

import jack.esolang.languages.Language;

public class Compilers
{
	public static Program<Character> compileCharProgram(String source, Language<Character, Program<Character>> language)
	{
		Program1D<Character> program = new Program1D<Character>();
		Opcodes<Character> opcodes = language.opcodes();
		
		for (int i = 0; i < source.length(); ++i)
		{
			char c = source.charAt(i);
			
			if (opcodes.valid(c))
				program.add(new Opcode<Character>(c));
		}
		
		return program;
	}
}
