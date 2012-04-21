package jack.esolang.cellular.parser;

import jack.esolang.cellular.*;
import java.awt.Color;

public class Builder
{	
	public static GFXSpec parse(ASTGFXSpec ast)
	{
		Node[] c = ast.children;
		
		if (c.length == 2)
			return new GFXSpec(parse((ASTSymbol)c[0]),parse((ASTColor)c[1]));
		else
			return new GFXSpec(parse((ASTSymbol)c[0]),parse((ASTColor)c[1]),parse((ASTColor)c[2]));
	}
	
	public static Color parse(ASTColor ast)
	{
		Node[] c = ast.children;
		
		Color col2 = new Color(parse((ASTInteger)c[0]),parse((ASTInteger)c[1]),parse((ASTInteger)c[2]));
		
		return col2;
	}
	
	public static int parse(ASTInteger ast)
	{
		return Integer.parseInt((String)ast.value);
	}
	
	public static char parse(ASTSymbol ast)
	{
		return parse((ASTCharacter)ast.children[0]);
	}
	
	public static char parse(ASTCharacter ast)
	{
		System.out.println("VALUE: \""+ast.value+"\"");
		return ((String)ast.value).charAt(0);
	}
}
