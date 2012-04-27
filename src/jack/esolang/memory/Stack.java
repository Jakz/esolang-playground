package jack.esolang.memory;

import java.util.*;

public class Stack<T>
{
	LinkedList<T> stack;
	
	Stack()
	{
		stack = new LinkedList<T>();
	}
	
	void push(T item)
	{
		stack.addFirst(item);
	}
	
	T pop()
	{
		return stack.removeFirst();
	}
	
	T peek()
	{
		return stack.pollFirst();
	}
}
