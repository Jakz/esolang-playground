package com.github.jakz.esolang.languages.falselang;

import com.github.jakz.esolang.io.PrintStdout;
import com.github.jakz.esolang.io.StringStdin;
import com.github.jakz.esolang.languages.ComplexLanguage;
import com.github.jakz.esolang.memory.*;
import com.github.jakz.esolang.source.*;

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
