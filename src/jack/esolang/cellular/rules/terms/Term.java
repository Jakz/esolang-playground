package jack.esolang.cellular.rules.terms;

import jack.esolang.cellular.*;

public interface Term<T extends Comparable<? super T>> 
{
	public T getValue(Cell cell);
	public void solveReferences();
}
