package jack.esolang.memory;

public abstract class Builder<T>
{
	public abstract T build();
	public abstract T clone(T val);
	
	public static Builder<Integer> intBuilder()
	{
		return new Builder<Integer>() {
			public Integer build() { return new Integer(0); }
			public Integer clone(Integer i) { return new Integer(i); }
		};
	}
}
