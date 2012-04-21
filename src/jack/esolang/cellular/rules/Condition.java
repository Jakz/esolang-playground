package jack.esolang.cellular.rules;

import jack.esolang.cellular.*;

public interface Condition
{
	public boolean evaluate(Cell cell);
	public void solveReferences();
}
