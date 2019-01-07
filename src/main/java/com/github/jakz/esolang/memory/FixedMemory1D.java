package com.github.jakz.esolang.memory;

public class FixedMemory1D<T> implements Memory<T>
{
	private Object[] memory;
	
	public FixedMemory1D(int size, Builder<T> builder)
	{
		memory = new Object[size];
		
		for (int i = 0; i < size; ++i)
			memory[i] = builder.build();
	}
	
	@SuppressWarnings("unchecked")
	public T get(int i)
	{
		return (T)memory[i];
	}
	
	public void set(int i, T t)
	{
		memory[i] = t;
	}
}
