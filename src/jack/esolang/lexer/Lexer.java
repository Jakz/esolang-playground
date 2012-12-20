package jack.esolang.lexer;

import java.util.*;
import jack.esolang.source.*;
import jack.esolang.exceptions.TokenizerException;

public class Lexer<T>
{
	List<LexerRule> regexes;
	StringBuilder buffer;
	
	int position;
	LexerRule type;
	
	List<Token<?>> tokens;
	
	public Lexer()
	{
		buffer = new StringBuilder();
		regexes = new LinkedList<LexerRule>();
		
		addRule(new LexerRule(RegexLibrary.INTEGER_SIMPLE, 0, TokenBuilder.INTEGER));
		addRule(new LexerRule("\"[^\"]*\"", 1, TokenBuilder.STRING));
		addRule(new LexerRule(RegexLibrary.WHITE_SPACE, 2, TokenBuilder.DUMMY));
		addRule(new LexerRule("\\[",3, TokenBuilder.OPCODE));
		addRule(new LexerRule("\\]",3, TokenBuilder.OPCODE));
		addRule(new LexerRule("[^\"]", 3, TokenBuilder.OPCODE));
		
		ready();
	}
	
	public void addRule(LexerRule regex)
	{
		regexes.add(regex);
	}
	
	public void ready()
	{
		Collections.sort(regexes);
		tokens = new ArrayList<Token<?>>();
		
		if (buffer.length() > 0)
			buffer.delete(0, buffer.length());
		
		type = null;
		position = 0;
	}
	
	private LexerRule matchingToken()
	{
		for (LexerRule regex : regexes)
		{
			if (regex.isMatching(buffer))
			{
				//System.out.print("Matched \'"+buffer+"\' with "+regex.regex.toString()+": ");
				return regex;
			}
		}
		
		//System.out.println("No match for \'"+buffer+"\'");
		return null;
	}
	
	private void emit(boolean last)
	{
		Token<?> token;
		
		if (!last)
		{
			token = type.build(buffer.substring(0, buffer.length()-1));
			buffer.delete(0, buffer.length()-1);
		}
		else
		{
			token = type.build(buffer.substring(0, buffer.length()));
			buffer.delete(0, buffer.length());
		}

		if (token != null)
			tokens.add(token);
		
		//System.out.println("EMITTING: "+token);
	}
	
	public Token<T>[] tokenize(String source)
	{
		buffer.append(source.charAt(position++));

		while (position < source.length())
		{
			//System.out.println("buffer: \""+buffer+"\"");
			
			LexerRule ntype = matchingToken();
			
			if (ntype != type && type != null)
			{
				emit(false);
				type = ntype;
			}
			else if (ntype != type)
				type = ntype;
			else
				buffer.append(source.charAt(position++));
		}

		if (type != null)
		{
			emit(false);
			LexerRule lastToken = matchingToken();
			
			if (lastToken != null)
				emit(true);
			else
				throw new TokenizerException(buffer.toString());
		}
		
		return tokens.toArray(new Token[tokens.size()]);
	}
}
