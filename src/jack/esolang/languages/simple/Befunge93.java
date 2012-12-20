package jack.esolang.languages.simple;

import jack.esolang.io.*;
import jack.esolang.languages.*;
import jack.esolang.memory.*;
import jack.esolang.source.*;
import jack.esolang.common.*;
import jack.esolang.compilers.*;

public class Befunge93 extends SimpleLanguage<Code2D<Character>, Stack<Integer>, StringStdin, PrintStdout<String>>
{
	boolean stringMode = false;
	
	public Befunge93()
	{
		super("Befunge", 1993, "Chris Pressey", "Jack", new SimpleCompiler2D());
	}
	
	public void startExecution()
	{
		
	}
	
	public void endedExecution()
	{
		
	}
	
	public void execute(Character opcode)
	{
		//System.out.println("Executing: "+opcode.v+"   "+code().pc().x+","+code.pc().y+"   "+memory()+"  "+stringMode);
		
		if (stringMode)
		{
			if (opcode == '\"')
				stringMode = !stringMode;
			else
				memory().push((int)opcode);
		}
		else
		{	
			switch(opcode)
			{
				case '0': memory().push(0); break;
				case '1': memory().push(1); break;
				case '2': memory().push(2); break;
				case '3': memory().push(3); break;
				case '4': memory().push(4); break;
				case '5': memory().push(5); break;
				case '6': memory().push(6); break;
				case '7': memory().push(7); break;
				case '8': memory().push(8); break;
				case '9': memory().push(9); break;
				case '+':
				{
					int a = memory().pop(); int b = memory().pop();
					memory.push(a+b);
					break;
				}
				case '-':
				{
					int a = memory().pop(); int b = memory().pop();
					memory.push(b-a);
					break;
				}
				case '*':
				{
					int a = memory().pop(); int b = memory().pop();
					memory.push(a*b);
					break;
				}
				case '/':
				{
					int a = memory().pop(); int b = memory().pop();
					memory.push(b/a);
					break;
				}
				case '%':
				{
					int a = memory().pop(); int b = memory().pop();
					memory.push(b%a);
					break;
				}
				case '!':
				{
					int a = memory().pop(); 
					memory.push(a == 0 ? 1 : 0);
					break;
				}
				case '`':
				{
					int a = memory().pop(); int b = memory().pop();
					memory.push(b > a ? 1 : 0);
					break;
				}
				case '>':
				{
					code().setDirection(Direction.RIGHT);
					break;
				}
				case '<':
				{
					code().setDirection(Direction.LEFT);
					break;
				}
				case '^':
				{
					code().setDirection(Direction.UP);
					break;
				}
				case 'v':
				{
					code().setDirection(Direction.DOWN);
					break;
				}
				case '?':
				{
					code().setDirection(Direction.values()[Common.randInt(4)]);
					break;
				}
				case '_':
				{
					int a = memory().pop(); 
					code().setDirection(a == 0 ? Direction.RIGHT : Direction.LEFT);
					break;
				}
				case '|':
				{
					int a = memory().pop(); 
					code().setDirection(a == 0 ? Direction.DOWN : Direction.UP);
					break;
				}
				case '\"':
				{
					stringMode = !stringMode;
					break;
				}
				case ':':
				{
					int a = memory.pop();
					memory.push(a);
					memory.push(a);
					break;
				}
				case '\\':
				{
					int a = memory().pop(); int b = memory().pop();
					memory.push(a); memory.push(b);
					break;
				}
				case '$':
				{
					memory.pop();
					break;
				}
				case '.':
				{
					stdout().append(""+((int)memory.pop()));
					break;
				}
				case ',':
				{
					stdout().append(""+(char)(int)memory.pop());
					break;
				}
				case '#':
				{
					code().incrPC();
					break;
				}
				case 'p':
				{
					int y = memory.pop(), x = memory.pop(), v = memory.pop();
					code().set(y, x, (char)v);
					break;
				}
				case 'g':
				{
					int y = memory.pop(), x = memory.pop();
					memory().push((int)code().get(y, x));
					break;
				}
				case '&':
				{
					char c = stdin().fetch();
					memory.push((int)(c-'0'));
					break;
				}
				case '~':
				{
					char c = stdin().fetch();
					memory.push((int)c);
					break;
				}
				case '@':
				{
					code().finish();
				}
			}		
		}

		code().incrPC();
	}
}