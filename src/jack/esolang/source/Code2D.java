package jack.esolang.source;

import jack.esolang.common.*;

public class Code2D<T> implements Code<T>
{
	private Object[][] code;
	private Position pc;
	private Direction dir;
	private boolean finished;
	
	Code2D(int width, int height)
	{
		code = new Object[width][height];
		pc = new Position();
		dir = Direction.RIGHT;
	}
	
	Code2D(Object[][] code)
	{
		this.code = code;
		pc = new Position();
		dir = Direction.RIGHT;
	}
	
	void set(int i, int j, Opcode<T> op)
	{
		code[i][j] = op;
	}
	
	public int size()
	{
		return code.length;
	}
	
	@SuppressWarnings("unchecked")
	public Opcode<T> get(int i, int j)
	{
		return (Opcode<T>)code[i][j];
	}
	
	public Opcode<T> get()
	{
		return get(pc.x,pc.y);
	}
	
	public void resetPC()
	{
		pc.reset();
		dir = Direction.RIGHT;
	}
	
	public void incrPC()
	{
		pc.shift(dir);
		pc.wrap(code.length, code[0].length);
	}
	
	public void setDirection(Direction d)
	{
		this.dir = d;
	}
	
	public void setPC(Position p)
	{
		pc.set(p);
	}
	
	public Position pc()
	{
		return pc;
	}
	
	public boolean finished()
	{
		return finished;
	}
	
	@SuppressWarnings("unchecked")
	public String toString()
	{
		String s = "";
		
		for (int i = 0; i < code.length; ++i)
		{
			for (int j = 0; j < code.length; ++j)
			{
				s += ((Opcode<T>)code[i][j]).v.toString();
			}
			s += "\n";
		}
		
		return s;
	}
}
