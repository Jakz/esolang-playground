package jack.esolang.compilers;

import jack.esolang.source.*;

public interface Compiler<T, C extends Code<T>>
{
	public C compile(String source);
}
