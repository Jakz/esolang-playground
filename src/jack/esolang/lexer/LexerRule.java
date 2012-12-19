package jack.esolang.lexer;

import java.util.regex.*;

class LexerRule implements Comparable<LexerRule>
{
	final Pattern regex;
	final int priority;
	
	final TokenBuilder<?> builder;
	
	LexerRule(String regex, int priority, TokenBuilder<?> builder)
	{
		this.regex = Pattern.compile(regex);
		this.priority = priority;
		this.builder = builder;
	}
	
	@Override
	public int hashCode()
	{
		return regex.hashCode(); 
	}
	
	@Override
	public boolean equals(Object o)
	{
		return (o instanceof LexerRule) ? ((LexerRule)o).regex.equals(regex) : false;
	}
	
	@Override
	public int compareTo(LexerRule r2)
	{
		/*if (r2 != null)
			return regex.compareTo(r2.regex);
		else
			return 1;*/
		
		if (priority < r2.priority)
			return -1;
		else if (priority == r2.priority)
			return 0;
		else
			return 1;
	}
	
	public boolean isMatching(StringBuilder string)
	{
		return regex.matcher(string).matches();
	}
	
	public Token<?> build(String string)
	{
		return builder.build(string);
	}
	
	public boolean skip()
	{
		return builder == null;
	}
}