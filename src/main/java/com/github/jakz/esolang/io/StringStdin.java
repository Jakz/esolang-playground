package com.github.jakz.esolang.io;

public class StringStdin implements Stdin<Character>
{
	String input;
	int position;
	
	public StringStdin(String input)
	{
		this.input = input;
		position = 0;
	}
	
	public void append(Character c)
	{
		input = input+c;
	}
	
	public Character fetch()
	{
		return Character.valueOf(input.charAt(position++));
	}
}
