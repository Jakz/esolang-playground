package com.github.jakz.esolang.cellular.lang.rules;

import java.util.function.Predicate;

import com.github.jakz.esolang.cellular.Automaton;
import com.github.jakz.esolang.cellular.Cell;

public class ConstantCondition implements Condition
{
	private final boolean value;
	
	public ConstantCondition(boolean value)
	{
		this.value = value;
	}
	
	@Override
	public Predicate<Cell> compile(Automaton a) { return c -> value; }
	
	public void solveReferences(Automaton a) { }
	
	public String toString()
	{
		return Boolean.toString(value);
	}
}
