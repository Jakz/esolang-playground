package jack.esolang.io;

public class PrintStdout<T> implements Stdout<T>
{
	public PrintStdout()
	{
		
	}
	
	public void append(T t)
	{
		System.out.print(t.toString());
	}
}
