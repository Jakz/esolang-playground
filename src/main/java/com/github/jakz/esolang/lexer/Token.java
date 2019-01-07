package com.github.jakz.esolang.lexer;

public class Token<T>
{
	private T value;
	
	Token(T value) { this.value = value; }
	T value() { return value; }
	
	public String toString() { return value.getClass().getName()+"("+value.toString()+")"; }
}
