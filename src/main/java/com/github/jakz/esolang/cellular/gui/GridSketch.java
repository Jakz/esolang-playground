package com.github.jakz.esolang.cellular.gui;

import java.util.*;

import com.github.jakz.esolang.Main;
import com.github.jakz.esolang.cellular.*;

import processing.core.PApplet;

public class GridSketch extends PApplet
{
  int lx = -1, ly = -1;

  Type selected;
  Automaton automaton;
  
  public void setAutomaton(Automaton a)
  {
    this.automaton = a;
    selected = automaton.getDefaultType();
    repaint();
  }

  public void setup()
  {
    size(Constants.W+200,Constants.H,P2D);
    noLoop();

    textMode(SCREEN);
    //redraw();
  }

  public void draw()
  {	
    background(120);
    strokeWeight(1.0f);
    stroke(0);
   
    if (automaton != null)
    {
      for (int i = 0; i < Constants.WC; ++i)
        for (int j = 0; j < Constants.HC; ++j)
        {
          Cell c = automaton.get(i, j);
          fill(automaton.getTemplate(c.type).background);
          rect(i*Constants.cellSize,Constants.H-Constants.cellSize*j - Constants.cellSize,Constants.cellSize,Constants.cellSize);
        }

      drawTypes();
    }
  }

  public void drawTypes()
  {
    Automaton a = automaton;
    Collection<Category> types = a.getTypes();

    int c = 0;
    for (Category t : types)
    {
      if (t instanceof Type)
      {
        GFXSpec spec = a.getTemplate((Type)t);
        strokeWeight(1.0f);
        stroke(0);
        fill(spec.background);
        rect(Constants.W+10,10+c*30,20,20);

        if (spec.symbol != ' ')
        {
          textAlign(CENTER);
          fill(spec.foreground);
          text(spec.symbol+"",Constants.W+10+11,10+c*30+10+4);
        }

        fill(0);
        textAlign(LEFT);
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
  }

  public void keyPressed()
  {
    if (key == ' ')
    {
      automaton.update();
      redraw();
    }
    else if (key == 'r')
    {
      automaton.reset(automaton.getDefaultType());
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

      Collection<Category> types = automaton.getTypes();

      int c = 0;
      for (Category t : types)
      {
        if (t instanceof Type)
        {     	
          if (c == selectedType)
          {
            selected = (Type)t;
            redraw();
            return;
          }

          ++c;
        }
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

      Collection<Category> types = automaton.getTypes();

      int c = 0;
      for (Category t : types)
      {
        if (t instanceof Type)
        {     	
          if (c == selectedType)
          {
            selected = (Type)t;
            redraw();
            return;
          }

          ++c;
        }
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
      Cell c = automaton.get(x, y);

      c.type = selected;

      redraw();
    }
    else if (mouseButton == RIGHT)
    {
      Cell c = automaton.get(x, y);
      c.type = automaton.getDefaultType();

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
