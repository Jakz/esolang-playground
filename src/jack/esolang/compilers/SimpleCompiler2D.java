package jack.esolang.compilers;

import java.util.*;

import jack.esolang.Console;
import jack.esolang.source.*;
import jack.esolang.languages.*;

public class SimpleCompiler2D implements Compiler<Character, Code2D<Character>>
{
	public SimpleCompiler2D()
	{
	}

	public Code2D<Character> compile(String source)
	{
		//Opcodes<Character> opcodes = language.opcodes();
		ArrayList<ArrayList<Opcode<Character>>> arrayCode = new ArrayList<ArrayList<Opcode<Character>>>();
		
		ArrayList<Opcode<Character>> row = new ArrayList<Opcode<Character>>();
		
		int maxRowLength = 0;

		for (int i = 0; i < source.length(); ++i)
		{
			char c = source.charAt(i);
			
			if (c == '\n')
			{
				if (row.size() > maxRowLength)
					maxRowLength = row.size();
				
				arrayCode.add(row);
				row = new ArrayList<Opcode<Character>>();
				continue;
			}
			
			Opcode<Character> op = new Opcode<Character>(c);
			row.add(op);
		}
		
		Opcode<Character>[][] rows = new Opcode[arrayCode.size()][maxRowLength];
		
		Console.i.debug("Compiling a 2D source of size "+arrayCode.size()+"x"+maxRowLength);
		
		for (int i = 0; i < rows.length; ++i)
		{
			for (int j = 0; j < maxRowLength; ++j)
			{
				if (j < arrayCode.get(i).size())
					rows[i][j] = arrayCode.get(i).get(j);
				else
					rows[i][j] = new Opcode<Character>(' ');
			}
		}
		
		Code2D<Character> program = new Code2D<Character>(rows);
		
		return program;
	}
}
