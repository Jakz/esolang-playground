package jack.esolang.cellular;

import org.codehaus.jparsec.*;
import org.codehaus.jparsec.functors.*;
import org.codehaus.jparsec.functors.Map;

import java.util.*;
import java.awt.Color;

public class DefParser
{
	static final Parser<Void> ignored = Parsers.or(Scanners.JAVA_BLOCK_COMMENT,Scanners.JAVA_LINE_COMMENT,Scanners.WHITESPACES).skipMany();
	
	public static void parse()
	{
		String[] operators = {"||","&&","==","!=","<=",">=","<",">","{","}","(",")",",",";",":","\""};
		String[] keywords = {"becomes","when","state","rgb"};

		//Parser<String> p = Scanners.isChar(',').next(Scanners.INTEGER).next(Scanners.isChar(',')).next(Scanners.INTEGER).next(Scanners.isChar(',').next(Scanners.INTEGER));

		Parser<GFXSpec> f = parseGFXSpec();
		
		System.out.println(f.parse("symbol: '*', foreground: rgb(255,255,255), background: rgb(30,30,30);"));
		
		/*
		Terminals operators = Terminals.operators(",:\"");
		Parser<?> integerTokenizer = Terminals.IntegerLiteral.TOKENIZER;
		Parser<String> integerSyntacticParser = Terminals.IntegerLiteral.PARSER;
		Parser<?> ignored = Parsers.or(Scanners.JAVA_BLOCK_COMMENT, Scanners.WHITESPACES);
		Parser<?> tokenizer = Parsers.or(operators.tokenizer(), integerTokenizer); // tokenizes the operators and integer
		Parser<List<String>> integers = integerSyntacticParser.sepBy(operators.token(","))
		    .from(tokenizer, ignored.skipMany());
		
		List<String> ints = integers.parse("255,128,0");
		
		for (String s : ints)
		{
			System.out.println(s);
		}*/
	}
	
	private static Parser<List<Integer>> parseIntegersList()
	{
		Terminals operators = Terminals.operators(",");
		Parser<?> integerTokenizer = Terminals.IntegerLiteral.TOKENIZER;
		Parser<String> integerSyntacticParser = Terminals.IntegerLiteral.PARSER;
		Parser<?> tokenizer = Parsers.or(operators.tokenizer(), integerTokenizer);
		Parser<List<String>> p = integerSyntacticParser.sepBy(operators.token(",")).from(tokenizer, ignored);
				
		Parser<List<Integer>> ints = p.map(new Map<List<String>, List<Integer>>() {
			public List<Integer> map(List<String> l)
			{
				ArrayList<Integer> ints = new ArrayList<Integer>();
				for (String s : l)
					ints.add(Integer.parseInt(s));
				return ints;
			}
		});

		return ints;
	}
	
	private static Parser<Color> parseColor()
	{
		Parser<List<Integer>> i = parseIntegersList();
		Parser<List<Integer>> i2 = i.between(Scanners.isChar('('), Scanners.isChar(')'));
		Parser<Color> col = Scanners.string("rgb").next(i2).map(new Map<List<Integer>, Color>() {
			public Color map(List<Integer> l) { return new Color(l.get(0),l.get(1),l.get(2)); }
		});
		
		return col;
	}
	
	private static Parser<GFXSpec> parseGFXSpec()
	{
		Parser<Color> fg = ignored.next(Scanners.string("foreground:")).next(ignored).next(parseColor()).followedBy(Scanners.isChar(','));
		Parser<Character> symbol = ignored.next(Scanners.string("symbol:")).next(ignored).next(parseSymbol()).followedBy(Scanners.isChar(','));
		Parser<Color> bg = ignored.next(Scanners.string("background:")).next(ignored).next(parseColor()).followedBy(Scanners.isChar(';'));
		
		Parser<Tuple3<Character,Color,Color>> gfx1 = Parsers.tuple(symbol, fg, bg);
		
		Parser<GFXSpec> gfx2 = gfx1.map(new Map<Tuple3<Character,Color,Color>, GFXSpec>(){
			public GFXSpec map(Tuple3<Character,Color,Color> t)
			{
				return new GFXSpec(t.a,t.b,t.c);
			}
		});
		
		return gfx2;
	}
	
	private static Parser<Character> parseSymbol()
	{
		return Scanners.SINGLE_QUOTE_CHAR.map(new Map<String, Character>() {
			public Character map(String str) { return str.charAt(1); }
		});
	}
}
