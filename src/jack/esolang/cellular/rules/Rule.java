package jack.esolang.cellular.rules;

import jack.esolang.cellular.Automaton;
import jack.esolang.cellular.Cell;

public interface Rule
{
	public boolean applyOnCell(Cell cell);
	public void solveReferences(Automaton a);
}