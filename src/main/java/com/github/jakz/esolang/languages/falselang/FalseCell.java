package com.github.jakz.esolang.languages.falselang;

public class FalseCell<T>
{
	T value;
	
	FalseCell(T value)
	{
		this.value = value;
	}
	
	void set(T value)
	{
		this.value = value;
	}
	
	T get()
	{
		return value;
	}
}
