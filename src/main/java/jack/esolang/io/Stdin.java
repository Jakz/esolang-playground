package jack.esolang.io;

public interface Stdin<T>
{
	public void append(T t);
	public T fetch();
}
