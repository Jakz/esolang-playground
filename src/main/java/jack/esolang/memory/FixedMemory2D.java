package jack.esolang.memory;

public class FixedMemory2D<T> implements Memory<T>
{
	private Object[][] memory;
	
	public FixedMemory2D(int width, int height, Builder<T> builder)
	{
		memory = new Object[width][height];
		
		for (int i = 0; i < width; ++i)
			for (int j = 0; j < height; ++j)
				memory[i][j] = builder.build();
	}
	
	@SuppressWarnings("unchecked")
	public T get(int i, int j)
	{
		return (T)memory[i][j];
	}
	
	public void set(int i, int j, T t)
	{
		memory[i][j] = t;
	}
}
