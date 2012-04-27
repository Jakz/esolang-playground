package jack.esolang.common;

public enum Direction
{
	UP(0,-1,"up"),
	RIGHT(1,0,"right"),
	DOWN(0,1,"down"),
	LEFT(1,0,"left");
	
	public final int x, y;
	public final String name;
	
	Direction(int x, int y, String name)
	{
		this.x = x;
		this.y = y;
		this.name = name;
	}
}
