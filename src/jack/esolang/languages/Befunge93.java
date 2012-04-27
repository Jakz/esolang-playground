package jack.esolang.languages;

import jack.esolang.io.*;
import jack.esolang.io.*;
import jack.esolang.memory.*;
import jack.esolang.source.*;

public class Befunge93 extends Language<Character, Code2D<Character>, Stack<Integer>, StringStdin, PrintStdout<Character>>
{
	public Befunge93()
	{
		super("Befunge", 1993, "Chris Pressey", "Jack");
	}
	
	public void startExecution()
	{
		
	}
	
	public void endedExecution()
	{
		
	}
	
	public void execute(Opcode<Character> opcode)
	{
		
		
	}
	
	public Opcodes<Character> opcodes()
	{
		Opcodes<Character> opcodes = new Opcodes<Character>(true);
		
		char[] chars = {
			'0','1','2','3','4','5','6','7','8','9',
			'+','-','*','/','%',
			'!','`','>','<','^','v',
			'?','_','|','\"',
			':','\\','$','.',',','#',
			'p','g','&','~','@'
		};	
		
		for (char c : chars)
			opcodes.add(new Opcode<Character>(c));
		
		return opcodes;
	}
	
}