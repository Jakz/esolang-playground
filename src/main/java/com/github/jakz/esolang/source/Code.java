package com.github.jakz.esolang.source;

public interface Code<T>
{
	public int size();
	public boolean finished();
	public T get();
	
	public void incrPC();
}
