package jack.esolang.languages;

import jack.esolang.source.*;
import jack.esolang.memory.*;
import jack.esolang.io.*;

public class Brainfuck extends Language<Character, Code1D<Character>, FixedTape<Integer>, StringStdin, PrintStdout<Character>>
{
	public Brainfuck()
	{
		super("Brainfuck", 1993, "Urban MŸller", "Jack");
	}
	
	public void startExecution()
	{
		
	}
	
	public void endedExecution()
	{
		
	}
	
	public void execute(Opcode<Character> opcode)
	{
		//memory().dump(20);
		//code().dump();
		//System.out.println("Executing: "+opcode.v);
		
		switch (opcode.v)
		{
			case '>': { memory().advance(); break; }
			case '<': { memory().recede(); break; }
			case '+': { int i = memory().get(); memory.set(i + 1); break; }
			case '-': { int i = memory().get(); memory.set(i - 1); break; }
			case '.': { stdout().append((char)memory.get().intValue()); break; }
			case ',': { memory().set((int)stdin().fetch().charValue()); break; }
			case '[': {
				Integer i = memory().get();
				if (i == 0)
				{
					int scopes = 0;
					int pc = code().pc()+1;
					
					while (true)
					{
						char c = code().get(pc).v;
						
						if (c == '[')
							++scopes;
						else if (c == ']')
						{
							if (scopes > 0) --scopes;
							else break;
						}
						
						++pc;
					}
					
					code().setPC(pc);
				}
				break;
			}
			case ']': {
				Integer i = memory().get();
				if (i != 0)
				{
					int scopes = 0;
					int pc = code().pc()-1;
					
					while (true)
					{
						char c = code().get(pc).v;
						
						if (c == ']')
							++scopes;
						else if (c == '[')
						{
							if (scopes > 0) --scopes;
							else break;
						}
						
						--pc;
					}

					code().setPC(pc);
				}
				break;
			}
			
			default: throw new jack.esolang.exceptions.UnsupportedOpcodeException(name, opcode.v.toString());
		}
			
		code().incrPC();
	}
	
	public Opcodes<Character> opcodes()
	{
		Opcodes<Character> opcodes = new Opcodes<Character>(true);
		
		char[] chars = {'>', '<', '+', '-', '[', ']', '.', ','};	
		
		for (char c : chars)
			opcodes.add(new Opcode<Character>(c));
		
		return opcodes;
	}
}
