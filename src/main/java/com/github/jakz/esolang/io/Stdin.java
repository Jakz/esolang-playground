package com.github.jakz.esolang.io;

public interface Stdin<T>
{
	public void append(T t);
	public T fetch();
}
