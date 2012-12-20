package jack.esolang.languages;

import jack.esolang.compilers.Compiler;
import jack.esolang.source.*;

public class ComplexLanguage<T extends Instruction, C extends Code<T>, M, I, O> extends Language<T, C, M, I, O>
{
	public ComplexLanguage(String name, int year, String author, String coder, Compiler<T,C> compiler)
	{
		super(name, year, author, coder, compiler);
	}
	
	public void run()
	{
		while (!code.finished())
		{
			code.get().execute();
			code.incrPC();
		}
	}

	public void startExecution()
	{

	}

	public void endedExecution()
	{

	}
}
