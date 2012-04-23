package jack.esolang.cellular.defs;

import jack.esolang.Console;
import jack.esolang.cellular.*;
import jack.esolang.cellular.parser.*;
import jack.esolang.gui.MainFrame;

import java.io.*;
import java.util.*;

public class AutomataRepository
{
	HashMap<String, Automaton> automata;
	
	private static class AutomataFilter implements FilenameFilter {
		public boolean accept(File dir, String name)
		{
			if (name.endsWith(".cas"))
				return true;
			
			return false;
		}
	}
	
	public AutomataRepository()
	{
		automata = new HashMap<String, Automaton>();
	}
	
	public void searchAndLoad()
	{
		Console.i.append("Searching for cellular automata specifications..");
		
		String path = AutomataRepository.class.getResource("AutomataRepository.class").getPath();
		path = path.substring(0, path.lastIndexOf('/'));
		
		File[] specs = new File(path).listFiles(new AutomataFilter());
		
		try
		{
			for (File f : specs)
			{
				InputStream is = new FileInputStream(f);
				eg2 parser = new eg2(is);
				Spec r = parser.Start();
	      
				Automaton a = r.createAutomaton();
				a.reset();
				
	      automata.put(r.info.name, a);
	      
	      System.out.println("Built specification for automata \""+r.info.name+"\"");
	      
	      System.out.println(automata.get(r.info.name).toString());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		Automaton.setCurrent(automata.get("rule110"));
		MainFrame frame = new MainFrame();
	}
}
