package jack.esolang.gui;

import jack.esolang.Main;
import jack.esolang.cellular.*;

import processing.core.PApplet;

public class GridSketch extends PApplet
{
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
      	fill(c.type.template.background);
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
    	a.reset(a.getType("dead"));
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
    	
    	if (c.type.name.equals("dead"))
    		c.type = a.getType("alive");
    	else
    		c.type = a.getType("dead");
    	
    	redraw();
    }
    else if (mouseButton == RIGHT)
    {
    	
    }
  }
  
  public void mouseMoved()
  { 
  	
  }
  
  public void mouseDragged()
  { 	

  }

  void reset()
  {
    /*lighting.map = new Lighting.Map();
    lighting.precomputeLighting();
    
    Main.backUpdated.clear();
    Main.updated.clear();*/
  }

}
