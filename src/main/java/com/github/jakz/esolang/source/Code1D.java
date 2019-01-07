package com.github.jakz.esolang.source;

public class Code1D<T> implements Code<T>
{
	private T[] code;
	private int pc;
	
	public Code1D(int size)
	{
		code = (T[])new Object[size];
		pc = 0;
	}
	
	public Code1D(T[] code)
	{
		this.code = code;
		pc = 0;
	}
	
	void set(int i, T op)
	{
		code[i] = op;
	}
	
	public int size()
	{
		return code.length;
	}
	
	public T get(int i)
	{
		return code[i];
	}
	
	public T get()
	{
		return get(pc);
	}
	
	public void resetPC()
	{
		pc = 0;
	}
	
	public void incrPC()
	{
		++pc;
	}
	
	public void decrPC()
	{
		--pc;
	}
	
	public void setPC(int i)
	{
		pc = i;
	}
	
	public int pc()
	{
		return pc;
	}
	
	public boolean finished()
	{
		return pc >= code.length || pc < 0;
	}
	
	@SuppressWarnings("unchecked")
	public String toString()
	{
		String s = "";
		
		for (int i = 0; i < code.length; ++i)
			s += code[i].toString();
		
		return s;
	}
	
	public void dump()
	{
		for (int i = 0; i < 20; ++i)
		{
			if (pc+i < code.length)
			{
				System.out.print(get(i+pc));
			}
		}
		
		System.out.println();
		
		//for (int i = 0; i < 20; ++i)
		{
			System.out.println("^");
		}
	}
}
