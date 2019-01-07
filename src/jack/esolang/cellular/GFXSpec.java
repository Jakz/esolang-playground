package jack.esolang.cellular;

import java.awt.Color;

/**
 * This class provides a graphical template for a kind of cells. This includes the symbol, the symbol color and the background of the cell.
 * 
 * @author Jack
 */
public class GFXSpec
{
  public final char symbol;
  public final int foreground;
  public final int background;

  GFXSpec(char symbol)
  {
    this.symbol = symbol;
    this.foreground = Color.black.getRGB();
    this.background = Color.white.getRGB();
  }

  public GFXSpec(char symbol, Color foreground, Color background)
  {
    this.symbol = symbol;
    this.foreground = foreground.getRGB();
    this.background = background.getRGB();
  }

  public GFXSpec(char symbol, Color background)
  {
    this.symbol = symbol;
    this.foreground = Color.white.getRGB();
    this.background = background.getRGB();
  }

  GFXSpec(Color background)
  {
    this.symbol = ' ';
    this.background = background.getRGB();
    this.foreground = Color.black.getRGB();
  }

  public String toString()
  {
    return "GFXSpec("+symbol+", "+new Color(foreground,false)+", "+new Color(background,false)+")";
  }
  
  public static GFXSpec of(char symbol, Color fg, Color bg)
  {
    return new GFXSpec(symbol, fg, bg);
  }
}
