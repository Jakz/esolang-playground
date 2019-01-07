package jack.esolang.lexer;

public abstract class TokenBuilder<T>
{
	public abstract Token<T> build(String string);
	
	public static TokenBuilder<Integer> INTEGER = new TokenBuilder<Integer>() {
		public Token<Integer> build(String string) { return new Token<Integer>(Integer.parseInt(string)); }
	};
	
	public static TokenBuilder<String> STRING = new TokenBuilder<String>() {
		public Token<String> build(String string) { return new Token<String>(string.substring(1, string.length()-2)); }
	};
	
	public static TokenBuilder<Character> OPCODE = new TokenBuilder<Character>() {
		public Token<Character> build(String string) { return new Token<Character>(string.charAt(0)); }
	};
	
	public static TokenBuilder<Integer> DUMMY = new TokenBuilder<Integer>() {
		public Token<Integer> build(String string) { return null; }
	};
}
