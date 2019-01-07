package com.github.jakz.esolang.exceptions;

public class TokenizerException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public TokenizerException(String buffer)
	{
		super("Lexer failed, buffer at end is \'"+buffer+"\'");
	}
}
