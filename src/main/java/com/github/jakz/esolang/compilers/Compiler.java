package com.github.jakz.esolang.compilers;

import com.github.jakz.esolang.source.*;

public interface Compiler<T, C extends Code<T>>
{
	public C compile(String source);
}
