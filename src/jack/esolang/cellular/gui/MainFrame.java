package jack.esolang.cellular.gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainFrame extends JFrame
{
  public MainFrame()
  {	
  	super("Esolang Cellular Automata");

    setLayout(new BorderLayout());
    GridSketch sketch = new GridSketch();
    sketch.init();
    add(sketch, BorderLayout.CENTER);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
    pack();
    setVisible(true);
    setLocation(100, 100);
  }
}