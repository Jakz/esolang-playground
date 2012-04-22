package jack.esolang.source;

import java.util.*;
import jack.esolang.languages.*;

public class Program1D<T> implements Program<T>
{
	ArrayList<Opcode<T>> code;
	
	Program1D()
	{
		code = new ArrayList<Opcode<T>>();
	}
	
	void add(Opcode<T> op)
	{
		code.add(op);
	}
}
