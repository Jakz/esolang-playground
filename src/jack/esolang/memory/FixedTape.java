package jack.esolang.memory;

public class FixedTape<T> extends FixedMemory1D<T>
{
	int pointer;
	
	public FixedTape(int size, Builder<T> builder)
	{
		super(size, builder);
		pointer = 0;
	}
	
	public T get()
	{
		return super.get(pointer);
	}
	
	public void set(T t)
	{
		super.set(pointer, t);
	}
	
	public void advance()
	{
		++pointer;
	}
	
	public void recede()
	{
		--pointer;
	}
	
	public void dump(int count)
	{
		for (int i = 0; i < count; ++i)
		{
			if (i != pointer)
				System.out.print(String.format(" %02d",get(i))+" ");
			else
				System.out.print(String.format(">%02d",get(i))+"<");
		}
		
		System.out.println();
	}
}
