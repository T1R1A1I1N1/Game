import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class GameGraph  extends JPanel
{
    Tile[][] map;
    Player p;
    Sword s;
    ArrayList<Enemy> bad;
    public GameGraph(Tile[][] map, Player p,Sword s, ArrayList<Enemy> bad)
    { this.map = map;
      this.p = p;
      this.s = s;
      this.bad = bad;
    }
    
    public void paint (Graphics g)         
    {
        super.paint(g); 
        for(Tile[] h : map){
          for(Tile d : h){
            g.setColor(d.c);
            g.drawRect(d.x,d.y,d.xsiz,d.ysiz);
            }
        }
        if(p.inv) g.setColor(Color.green);
        else g.setColor(Color.blue);
        g.fillRect(p.x,p.y,p.xsiz,p.ysiz);
        g.setColor(Color.red);
        if(s.appear)g.fillRect(s.x,s.y,s.xsiz,s.ysiz);
        g.setColor(Color.orange);
        for(Enemy e : bad){
            if(e.inv) g.setColor(Color.orange);
            else g.setColor(Color.yellow);
            g.fillRect(e.x,e.y,e.xsiz,e.ysiz);}
    }
}
