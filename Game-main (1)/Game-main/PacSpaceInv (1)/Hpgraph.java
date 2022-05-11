
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList; 

public class Hpgraph  extends JPanel
{
    Player p;
    public Hpgraph(Player p)
    {
        this.p = p;
    }
    
    public void paint (Graphics g)         
    {
        super.paint(g); 
        g.drawString(""+p.hp,0,0);
    }
}
