package jack.esolang.languages.falselang;

import jack.esolang.io.PrintStdout;
import jack.esolang.io.StringStdin;
import jack.esolang.languages.ComplexLanguage;
import jack.esolang.memory.*;
import jack.esolang.source.*;

public class False extends ComplexLanguage<False.FalseInstruction, Code1D<False.FalseInstruction>, Stack<False.FalseCell>, StringStdin, PrintStdout<String>>
{
	FixedMemory1D<FalseCell<?>> variables;
	
	False()
	{
		super("False", 1993, "Wouter van Oortmerssen", "Jack", null);
		
		variables = new FixedMemory1D<FalseCell<?>>(26, builder());
	}
	
	public static class FalseCell<T>
	{
		T value;
		
		FalseCell(T value)
		{
			this.value = value;
		}
		
		void set(T value)
		{
			this.value = value;
		}
		
		T get()
		{
			return value;
		}
		
		public FalseCell<T> clone()
		{
			return new FalseCell<T>(value);
		}
	}
	
	public interface FalseInstruction extends Instruction
	{
		/*public class VarRefLoad implements FalseInstruction
		{
			char var;
			
			public VarRefLoad(char var) { this.var = var; }
			public void execute() { memory().push(variables.)
		}*/
	}
	
	public static Builder<FalseCell<?>> builder()
	{
		return new Builder<FalseCell<?>>() {
			public FalseCell<?> build() { return new FalseCell<Integer>(0); }
			public FalseCell<?> clone(FalseCell<?> i) { return i.clone(); }
		};
	}
}
