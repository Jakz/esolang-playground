package jack.esolang.cellular;

import java.awt.Color;

/**
 * This class provides a graphical template for a kind of cells. This includes the symbol, the symbol color and the background of the cell.
 * 
 * @author Jack
 */
public class GFXTemplate
{
	public final char symbol;
	public final int foreground;
	public final int background;
	
	GFXTemplate(char symbol)
	{
		this.symbol = symbol;
		this.foreground = Color.black.getRGB();
		this.background = Color.white.getRGB();
	}
	
	GFXTemplate(Color background)
	{
		this.symbol = ' ';
		this.background = background.getRGB();
		this.foreground = Color.black.getRGB();
	}
}
