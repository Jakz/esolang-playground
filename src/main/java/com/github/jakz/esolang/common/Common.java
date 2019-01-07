package com.github.jakz.esolang.common;

import java.util.*;

public class Common
{
	private static Random r = new Random();
	
	public static int randInt(int x)
	{
		return r.nextInt(x);
	}
}
