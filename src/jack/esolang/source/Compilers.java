package jack.esolang.source;

import jack.esolang.Console;
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
	
	public static Code2D<Character> compileChar2DProgram(String source, Language<Character, Code2D<Character>, ?, ?, ?> language)
	{
		Opcodes<Character> opcodes = language.opcodes();
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
