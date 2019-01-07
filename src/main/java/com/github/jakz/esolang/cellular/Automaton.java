package com.github.jakz.esolang.cellular;

import java.util.*;

public class Automaton
{
  Cell[][] cells;
  
  Map<String, Category> types;
  private Map<Type, GFXSpec> templates;
  
  Type defaultType;
  int w;
  int h;
  
  Automaton(int w, int h)
  {
    this.w = w;
    this.h = h;
    cells = new Cell[w][h];

    for (int i = 0; i < w; ++i)
      for (int j = 0; j < h; ++j)
      {
        cells[i][j] = new Cell(null, i, j);
      }

    types = new HashMap<>();
    templates = new HashMap<>();
  }

  public void addType(Category type)
  {
    types.put(type.name, type);
  }

  public void setDefaults(Type type)
  {
    defaultType = type;
  }

  public void setTemplates(Map<String, GFXSpec> specs)
  {
    for (String k : specs.keySet())
    {
      templates.put((Type)getType(k), specs.get(k));
    }
  }

  public GFXSpec getTemplate(Type t)
  {
    return templates.get(t);
  }

  public Category getType(String name)
  {
    return types.get(name);
  }

  public Category getCategory(String name)
  {
    return types.get(name);
  }

  public Collection<Category> getTypes()
  {
    return types.values();
  }

  public Type getDefaultType()
  {
    return defaultType;
  }

  public void reset(Type type)
  {
    for (int i = 0; i < w; ++i)
      for (int j = 0; j < h; ++j)
      {
        cells[i][j].type = type;
      }
  }

  public void reset()
  {
    reset(defaultType);
  }

  public void set(Type type, int i, int j)
  {
    cells[i][j].type = type;
  }

  public Cell get(int x, int y)
  {
    if (x < 0 || y < 0 || x >= w | y >= h)
      return null;
    else
      return cells[x][y];
  }

  public void update()
  {
    for (int i = 0; i < w; ++i)
      for (int j = 0; j < h; ++j)
      {
        cells[i][j].type.update(this, cells[i][j]);
      }

    for (int i = 0; i < w; ++i)
      for (int j = 0; j < h; ++j)
      {
        cells[i][j].update();
      }
  }

  public String toString()
  {
    String s = "Automata \n";
    for (Category r : types.values())
      s += r;
    return s;
  }
}
