package com.github.jakz.esolang.languages.simple;

import com.github.jakz.esolang.compilers.*;
import com.github.jakz.esolang.io.*;
import com.github.jakz.esolang.languages.*;
import com.github.jakz.esolang.memory.*;
import com.github.jakz.esolang.source.*;

public class Brainfuck extends SimpleLanguage<Code1D<Character>, FixedTape<Integer>, StringStdin, PrintStdout<Character>>
{
  public Brainfuck()
  {
    super("Brainfuck", 1993, "Urban M�ller", "Jack", new SimpleCompiler1D(new Character[]{'+','-','<','>',',','.','[',']'}));
  }

  public void startExecution()
  {

  }

  public void endedExecution()
  {

  }

  public void execute(Character opcode)
  {
    //memory().dump(20);
    //code().dump();
    //System.out.println("Executing: "+opcode.v);

    switch (opcode)
    {
    case '>': { memory().advance(); break; }
    case '<': { memory().recede(); break; }
    case '+': { int i = memory().get(); memory.set(i + 1); break; }
    case '-': { int i = memory().get(); memory.set(i - 1); break; }
    case '.': { stdout().append((char)memory.get().intValue()); break; }
    case ',': { memory().set((int)stdin().fetch().charValue()); break; }
    case '[': {
      Integer i = memory().get();
      if (i == 0)
      {
        int scopes = 0;
        int pc = code().pc()+1;

        while (true)
        {
          char c = code().get(pc);

          if (c == '[')
            ++scopes;
          else if (c == ']')
          {
            if (scopes > 0) --scopes;
            else break;
          }

          ++pc;
        }

        code().setPC(pc);
      }
      break;
    }
    case ']': {
      Integer i = memory().get();
      if (i != 0)
      {
        int scopes = 0;
        int pc = code().pc()-1;

        while (true)
        {
          char c = code().get(pc);

          if (c == ']')
            ++scopes;
          else if (c == '[')
          {
            if (scopes > 0) --scopes;
            else break;
          }

          --pc;
        }

        code().setPC(pc);
      }
      break;
    }

    default: throw new com.github.jakz.esolang.exceptions.UnsupportedOpcodeException(name, opcode.toString());
    }

    code().incrPC();
  }
}
