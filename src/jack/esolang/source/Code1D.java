package jack.esolang.source;

public class Code1D<T> implements Code<T>
{
	private Object[] code;
	private int pc;
	
	public Code1D(int size)
	{
		code = new Object[size];
		pc = 0;
	}
	
	public Code1D(Object[] code)
	{
		this.code = code;
		pc = 0;
	}
	
	void set(int i, Opcode<T> op)
	{
		code[i] = op;
	}
	
	public int size()
	{
		return code.length;
	}
	
	@SuppressWarnings("unchecked")
	public Opcode<T> get(int i)
	{
		return (Opcode<T>)code[i];
	}
	
	public Opcode<T> get()
	{
		return get(pc);
	}
	
	public void resetPC()
	{
		pc = 0;
	}
	
	public void incrPC()
	{
		++pc;
	}
	
	public void decrPC()
	{
		--pc;
	}
	
	public void setPC(int i)
	{
		pc = i;
	}
	
	public int pc()
	{
		return pc;
	}
	
	public boolean finished()
	{
		return pc >= code.length || pc < 0;
	}
	
	@SuppressWarnings("unchecked")
	public String toString()
	{
		String s = "";
		
		for (int i = 0; i < code.length; ++i)
			s += ((Opcode<T>)code[i]).v.toString();
		
		return s;
	}
	
	public void dump()
	{
		for (int i = 0; i < 20; ++i)
		{
			if (pc+i < code.length)
			{
				System.out.print(get(i+pc).v);
			}
		}
		
		System.out.println();
		
		//for (int i = 0; i < 20; ++i)
		{
			System.out.println("^");
		}
	}
}
