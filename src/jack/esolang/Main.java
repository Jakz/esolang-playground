package jack.esolang;

import jack.esolang.cellular.defs.*;
import jack.esolang.gui.*;

import jack.esolang.languages.*;
import jack.esolang.source.*;
import jack.esolang.memory.*;
import jack.esolang.io.*;
import jack.esolang.lexer.*;

public class Main
{
	public static void main(String[] args)
	{
		//MainFrame mainFrame = new MainFrame();
		//AutomataRepository repo = new AutomataRepository();
		//repo.searchAndLoad();
		
		/*String helloWorld = 
			"++++++++++"+
			"["+
			"   >+++++++>++++++++++>+++>+<<<<-"+
			"]"+
			">++."+
			">+."+
			"+++++++."+
			"."+
			"+++."+
			">++."+
			"<<+++++++++++++++."+
			">."+
			"+++."+
			"------."+
			"--------."+
			">+."+
			">.";
		
		String fibonacci= "+++++++++++>+>>>>++++++++++++++++++++++++++++++++++++++++++++>++++++++++++++++++++++++++++++++<<<<<<[>[>>>>>>+>+<<<<<<<-]>>>>>>>[<<<<<<<+>>>>>>>-]<[>++++++++++[-<-[>>+>+<<<-]>>>[<<<+>>>-]+<[>[-]<[-]]>[<<[>>>+<<<-]>>[-]]<<]>>>[>>+>+<<<-]>>>[<<<+>>>-]+<[>[-]<[-]]>[<<+>>[-]]<<<<<<<]>>>>>[++++++++++++++++++++++++++++++++++++++++++++++++.[-]]++++++++++<[->-<]>++++++++++++++++++++++++++++++++++++++++++++++++.[-]<<<<<<<<<<<<[>>>+>+<<<<-]>>>>[<<<<+>>>>-]<-[>>.>.<<<[-]]<<[>>+>+<<<-]>>>[<<<+>>>-]<<[<+>-]>[<+>-]<<<-]";
		String rot13 = ",[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>++++++++++++++<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>>+++++[<----->-]<<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>++++++++++++++<-[>+<-[>+<-[>+<-[>+<-[>+<-[>++++++++++++++<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>>+++++[<----->-]<<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>++++++++++++++<-[>+<-]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]>.[-]<,]";
		
		Brainfuck bf = new Brainfuck();
		
		Code1D<Character> code = Compilers.compileCharProgram(rot13, bf);
		bf.setCode(code);
		bf.setMemory(new FixedTape<Integer>(1000, Builder.intBuilder()));
		bf.setStdin(new StringStdin("Antani"));
		bf.setStdout(new PrintStdout<Character>());
		bf.run();*/
		
		/*String helloWorld = 
			">              v\n"+
			"v  ,,,,,\"Hello\"<\n"+
			">48*,          v\n"+
			"v,,,,,,\"World!\"<\n"+
			">25*,@          \n";*/
		
		/*String helloWorld = 
			"2>:3g\" \"-!v\\  g30          <                                                    \n"+
			" |!`\"O\":+1_:.:03p>03g+:\"O\"`|                                                    \n"+
			" @               ^  p3\\\" \":<                                                    \n"+
			"2 234567890123456789012345678901234567890123456789012345678901234567890123456789\n";
		
		Befunge93 bf = new Befunge93();
		
		Code2D<Character> code = Compilers.compileChar2DProgram(helloWorld, bf);
		//System.out.println(code);
		bf.setCode(code);
		bf.setMemory(new Stack<Integer>());
		bf.setStdin(new StringStdin(""));
		bf.setStdout(new PrintStdout<String>());
		bf.run();*/
		
		Lexer<Byte> lexer = new Lexer();
		lexer.tokenize("[a;1=][2f;!]# \"");
	}
}
