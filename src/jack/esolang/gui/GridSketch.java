package jack.esolang.gui;

import jack.esolang.Main;
import jack.esolang.cellular.*;

import java.util.*;
import processing.core.PApplet;

public class GridSketch extends PApplet
{
	int lx = -1, ly = -1;
	
	Type selected;
  
	public void setup()
  {
  	size(Constants.W+200,Constants.H);
  	noLoop();
  	Life.buildLife();
  	
  	selected = Automaton.current().getDefaultType();

  	//redraw();
  }
      
  public void draw()
  {
  	background(120);
  	strokeWeight(1.0f);
  	stroke(0);
  	Automaton a = Automaton.current();
    
    for (int i = 0; i < Constants.WC; ++i)
      for (int j = 0; j < Constants.HC; ++j)
      {
        Cell c = a.get(i, j);
      	fill(a.getTemplate(c.type).background);
        rect(i*Constants.cellSize,Constants.H-Constants.cellSize*j - Constants.cellSize,Constants.cellSize,Constants.cellSize);
      }
    
    drawTypes();
  }
  
  public void drawTypes()
  {
  	Automaton a = Automaton.current();
  	Collection<Type> types = a.getTypes();
    
    int c = 0;
    for (Type t : types)
    {
    	GFXSpec spec = a.getTemplate(t);
    	strokeWeight(1.0f);
    	stroke(0);
    	fill(spec.background);
    	rect(Constants.W+10,10+c*30,20,20);
    	
    	fill(0);
    	text(t.name,Constants.W+36,25+c*30);
    	
    	if (selected == t)
    	{
    		stroke(230,230,0);
    		strokeWeight(2.0f);
    		noFill();
    		rect(Constants.W+8,8+c*30,100,24);
    	}
    	
    	++c;
    }
  }

  public void keyPressed()
  {
    if (key == ' ')
    {
    	Automaton a = Automaton.current();
    	a.update();
    	redraw();
    }
    else if (key == 'r')
    {
    	Automaton a = Automaton.current();
    	a.reset(a.getDefaultType());
    	redraw();
    }
    else if (key >= '0' && key <= '9')
    {
    	System.out.println("ASD");
    	int selectedType;
    	
    	if (key > '0')
    		selectedType = key - '1';
    	else
    		selectedType = 9;
    	
    	Automaton a = Automaton.current();
    	Collection<Type> types = a.getTypes();
    	
    	int c = 0;
      for (Type t : types)
      {
      	if (c == selectedType)
      	{
      		selected = t;
      		redraw();
      		return;
      	}
      	
      	++c;
      }
    }
  }

  public void mouseReleased()
  {    	

  }
  
  public void mousePressed()
  {    	
    if (mouseX > Constants.W)
    {
    	int selectedType = (mouseY - 10) / 30;
    	
    	Automaton a = Automaton.current();
    	Collection<Type> types = a.getTypes();
    	
    	int c = 0;
      for (Type t : types)
      {
      	if (c == selectedType)
      	{
      		selected = t;
      		redraw();
      		return;
      	}
      	
      	++c;
      }
    	
    }
    
    handleClick();
  }
  
  void handleClick()
  {
  	int x = mouseX;
    int y = mouseY;
   
    x /= Constants.cellSize;
    y = (Constants.H - y) / Constants.cellSize;
    
    if (x < 0 || x >= Constants.WC || y < 0 || y >= Constants.HC)
      return; 
  	
  	if (mouseButton == LEFT)
    {
    	Automaton a = Automaton.current();
    	Cell c = a.get(x, y);
    	
    	c.type = selected;

    	redraw();
    }
    else if (mouseButton == RIGHT)
    {
    	Automaton a = Automaton.current();
    	Cell c = a.get(x, y);
    	
    	c.type = a.getDefaultType();

    	redraw();
    }
    
    lx = x;
    ly = y;
  }
  
  public void mouseMoved()
  { 
  	
  }
  
  public void mouseDragged()
  { 	
    int x = mouseX;
    int y = mouseY;
   
    x /= Constants.cellSize;
    y = (Constants.H - y) / Constants.cellSize;
    
    if (x < 0 || x >= Constants.WC || y < 0 || y >= Constants.HC)
      return;
    
    if (lx == x && ly == y)
      return;

    handleClick();
  }

  void reset()
  {
    /*lighting.map = new Lighting.Map();
    lighting.precomputeLighting();
    
    Main.backUpdated.clear();
    Main.updated.clear();*/
  }

}
