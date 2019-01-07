package com.github.jakz.esolang.compilers;

import java.util.*;

import com.github.jakz.esolang.Console;
import com.github.jakz.esolang.languages.*;
import com.github.jakz.esolang.source.*;

public class SimpleCompiler2D implements Compiler<Character, Code2D<Character>>
{
	public SimpleCompiler2D()
	{
	}

	public Code2D<Character> compile(String source)
	{
		//Opcodes<Character> opcodes = language.opcodes();
		ArrayList<ArrayList<Character>> arrayCode = new ArrayList<ArrayList<Character>>();
		
		ArrayList<Character> row = new ArrayList<Character>();
		
		int maxRowLength = 0;

		for (int i = 0; i < source.length(); ++i)
		{
			char c = source.charAt(i);
			
			if (c == '\n')
			{
				if (row.size() > maxRowLength)
					maxRowLength = row.size();
				
				arrayCode.add(row);
				row = new ArrayList<Character>();
				continue;
			}
			
			row.add(c);
		}
		
		Character[][] rows = new Character[arrayCode.size()][maxRowLength];
		
		Console.i.debug("Compiling a 2D source of size "+arrayCode.size()+"x"+maxRowLength);
		
		for (int i = 0; i < rows.length; ++i)
		{
			for (int j = 0; j < maxRowLength; ++j)
			{
				if (j < arrayCode.get(i).size())
					rows[i][j] = arrayCode.get(i).get(j);
				else
					rows[i][j] = ' ';
			}
		}
		
		Code2D<Character> program = new Code2D<Character>(rows);
		
		return program;
	}
}
