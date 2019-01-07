package com.github.jakz.esolang.cellular;

public class Constants
{
	public static int cellSize = 10;
	public static int W = 900;
	public static int H = 600;
	public static int WC = W / cellSize;
	public static int HC = H / cellSize;
	
	public static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3, UP_RIGHT = 4, DOWN_RIGHT = 5, DOWN_LEFT = 6, UP_LEFT = 7;
	public static final String[] dirsName = {"up","right","down","left","upright","downright","downleft","upleft"};
	public static final int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,-1},{-1,1}};
	public static final int DIRECTIONS = 8;
	public static final int DIRECTIONS_ORTHO = 4;
}
