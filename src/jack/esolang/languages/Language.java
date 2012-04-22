package jack.esolang.languages;

import jack.esolang.source.*;

public interface Language<T, P>
{
	public Opcodes<T> opcodes();
	
	public void startExecution();
	public void endedExecution();
	public void setProgram(P program);
	
	public void execute(Opcode<T> opcode);
}
