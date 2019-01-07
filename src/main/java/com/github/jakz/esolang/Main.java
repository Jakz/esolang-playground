package com.github.jakz.esolang;

import com.github.jakz.esolang.cellular.Automaton;
import com.github.jakz.esolang.cellular.Life;
import com.github.jakz.esolang.cellular.Spec;
import com.github.jakz.esolang.cellular.defs.*;
import com.github.jakz.esolang.cellular.gui.GridSketch;
import com.github.jakz.esolang.cellular.gui.MainFrame;
import com.github.jakz.esolang.io.*;
import com.github.jakz.esolang.languages.*;
import com.github.jakz.esolang.languages.simple.*;
import com.github.jakz.esolang.lexer.*;
import com.github.jakz.esolang.memory.*;
import com.github.jakz.esolang.source.*;

public class Main
{
	public static void main(String[] args)
	{
	  /*Spec spec = Life.buildLife();
	  Automaton a = spec.createAutomaton();
	  a.reset();
	  
	  MainFrame frame = new MainFrame();
	  frame.content.setAutomaton(a);
	  
	  if (true)
	    return;*/
	  
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
		
		Code1D<Character> code = bf.compile(helloWorld);
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
		
		String helloWorld = 
			"2>:3g\" \"-!v\\  g30          <                                                    \n"+
			" |!`\"O\":+1_:.:03p>03g+:\"O\"`|                                                    \n"+
			" @               ^  p3\\\" \":<                                                    \n"+
			"2 234567890123456789012345678901234567890123456789012345678901234567890123456789\n";
		
		Befunge93 bf = new Befunge93();
		
		Code2D<Character> code = bf.compile(helloWorld);
		//System.out.println(code);
		bf.setCode(code);
		bf.setMemory(new Stack<Integer>());
		bf.setStdin(new StringStdin(""));
		bf.setStdout(new PrintStdout<String>());
		bf.run();
		
		//Lexer<Byte> lexer = new Lexer();
		//lexer.tokenize("[a;1=][2f;!]# ");
	}
}
