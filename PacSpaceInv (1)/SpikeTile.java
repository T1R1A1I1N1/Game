import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
public class SpikeTile extends Tile
{
    int dam;
    public SpikeTile(int x, int y, int dam)
    {
        super(x,y,Color.magenta);
        this.dam = dam;
    }

    public String toString(){return "spike";}
}
