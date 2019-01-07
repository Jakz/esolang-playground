package com.github.jakz.esolang.languages;

import com.github.jakz.esolang.compilers.Compiler;
import com.github.jakz.esolang.source.*;

public abstract class SimpleLanguage<C extends Code<Character>, M, I, O> extends Language<Character, C, M, I, O>
{
	public SimpleLanguage(String name, int year, String author, String coder, Compiler<Character, C> compiler)
	{
		super(name, year, author, coder, compiler);
	}
	
	public abstract void endedExecution();
	public abstract void startExecution();
	
	public abstract void execute(Character opcode);
	
	public final void run()
	{
		while (!code.finished())
		{
			this.execute(code.get());
		}
	}
}
