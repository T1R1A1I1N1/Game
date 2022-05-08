import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
public class WaterTile extends Tile
{
    
    public WaterTile(int x, int y)
    {
        super(x,y,Color.blue);
    }

    public String toString(){return "water";}
}
