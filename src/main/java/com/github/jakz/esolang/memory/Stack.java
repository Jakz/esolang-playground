package com.github.jakz.esolang.memory;

import java.util.*;

public class Stack<T>
{
	LinkedList<T> stack;
	
	public Stack()
	{
		stack = new LinkedList<T>();
	}
	
	public void push(T item)
	{
		stack.addFirst(item);
	}
	
	public T pop()
	{
		return stack.removeFirst();
	}
	
	public T peek()
	{
		return stack.pollFirst();
	}
	
	public String toString()
	{
		String s = "";
		for (T t : stack)
			s += t+" ";
		
		return s;
	}
}
