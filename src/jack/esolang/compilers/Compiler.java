package jack.esolang.compilers;

import jack.esolang.source.*;

public interface Compiler<T>
{
	public Opcode<T> compile(String source);
}
