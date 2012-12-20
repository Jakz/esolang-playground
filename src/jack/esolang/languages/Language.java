package jack.esolang.languages;

import jack.esolang.source.*;
import jack.esolang.compilers.Compiler;

public abstract class Language<T, C extends Code<T>, M, I, O>
{
	public final String name;
	public final int year;
	public final String author;
	public final String coder;
	
	public C code;
	public M memory;
	public I stdin;
	public O stdout;
	
	Compiler<?,C> compiler;
	
	public Language(String name, int year, String author, String coder, Compiler<?,C> compiler)
	{
		this.name = name;
		this.year = year;
		this.author = author;
		this.coder = coder;
		
		this.compiler = compiler;
	}
	
	public final void run()
	{
		while (!code.finished())
		{
			this.execute(code.get());
		}
	}
	
	public final void setCode(C code)
	{
		this.code = code;
	}
	
	public final void setMemory(M memory)
	{
		this.memory = memory;
	}
	
	public final void setStdin(I stdin)
	{
		this.stdin = stdin;
	}
	
	public final void setStdout(O stdout)
	{
		this.stdout = stdout;
	}
	
	final public C code() { return code; }
	final public M memory() { return memory; }
	final public I stdin() { return stdin; }
	final public O stdout() { return stdout; }

	public abstract void startExecution();
	public abstract void endedExecution();
	
	public abstract void execute(T opcode);
	
	public C compile(String source)
	{
		return compiler.compile(source);
	}
}
