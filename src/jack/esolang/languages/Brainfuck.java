package jack.esolang.languages;

import jack.esolang.source.*;

public class Brainfuck implements Language<Character, Program1D<Character>>
{
	Program1D<Character> program;
	
	Brainfuck()
	{
		
	}
	
	public void startExecution()
	{
		
	}
	
	public void endedExecution()
	{
		
	}
	
	public void setProgram(Program1D<Character> program)
	{
		this.program = program;
	}
	
	public void execute(Opcode<Character> opcode)
	{
		switch (opcode.v)
		{
			
		}
	}
	
	public Opcodes<Character> opcodes()
	{
		Opcodes<Character> opcodes = new Opcodes<Character>();
		
		char[] chars = {'>', '<', '+', '-', '[', ']', '.', ','};	
		
		for (char c : chars)
			opcodes.add(new Opcode<Character>(c));
		
		return opcodes;
	}
}
