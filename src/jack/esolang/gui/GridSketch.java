package jack.esolang.gui;

import jack.esolang.Main;
import jack.esolang.cellular.*;

import processing.core.PApplet;

public class GridSketch extends PApplet
{
	int lx = -1, ly = -1;
  
	public void setup()
  {
  	size(Constants.W,Constants.H);
  	noLoop();
  	Life.buildLife();
  	//redraw();
  }
      
  public void draw()
  {
  	background(0); 
  	Automaton a = Automaton.current();
    
    for (int i = 0; i < Constants.WC; ++i)
      for (int j = 0; j < Constants.HC; ++j)
      {
        Cell c = a.get(i, j);
      	fill(a.getTemplate(c.type).background);
        rect(i*Constants.cellSize,Constants.H-Constants.cellSize*j - Constants.cellSize,Constants.cellSize,Constants.cellSize);
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
  }

  public void mouseReleased()
  {    	

  }
  
  public void mousePressed()
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
    	
    	if (c.type == a.getLeftType())
    		c.type = a.getDefaultType();
    	else
    		c.type = a.getLeftType();

    	redraw();
    }
    else if (mouseButton == RIGHT)
    {
    	Automaton a = Automaton.current();
    	Cell c = a.get(x, y);
    	
    	if (c.type == a.getRightType())
    		c.type = a.getDefaultType();
    	else  	
    		c.type = a.getRightType();

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
    
    if (lx == x && ly == y)
      return;

    mousePressed();
  }

  void reset()
  {
    /*lighting.map = new Lighting.Map();
    lighting.precomputeLighting();
    
    Main.backUpdated.clear();
    Main.updated.clear();*/
  }

}
