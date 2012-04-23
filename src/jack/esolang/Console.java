package jack.esolang;

public class Console
{
	public final static Console i = new Console();
	
	public void append(String text)
	{
		System.out.println(text);
	}
}
