package jack.esolang.cellular;

public class Cell
{
	public Type type;
	public Type nextType;
	
	public final int x, y;
	
	Cell(Type type, int x, int y)
	{
		this.type = type;
		this.x = x;
		this.y = y;
	}
	
	void update()
	{
		type = nextType;
	}
}
