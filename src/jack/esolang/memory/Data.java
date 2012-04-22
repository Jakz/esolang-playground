package jack.esolang.memory;

public class Data<T>
{
	public T data;
	
	Data()
	{
		data = null;
	}
	
	Data(T data)
	{
		this.data = data;
	}
}
