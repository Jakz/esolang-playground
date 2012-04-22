package jack.esolang.memory;

public abstract class Builder<T>
{
	public abstract T build();
	
	public static Builder<Integer> intBuilder()
	{
		return new Builder<Integer>() {
			public Integer build() { return new Integer(0); }
		};
	}
}
