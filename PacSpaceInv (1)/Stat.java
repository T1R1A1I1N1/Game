import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
public class Stat
{
    
    public Stat()
    {
        
    }

    public static boolean collision(Base a, Base b){
      return (a.x<=b.x+b.xsiz && a.x >= b.x-a.xsiz && a.y<=b.y+b.ysiz && a.y >= b.y-a.ysiz);
    }
    
    public static boolean canMove(Moves m,Tile[][] map){
    boolean lava = true;
    for(Tile[] l: map){for(Tile t: l){
      if(Stat.collision(m,t)){
        if(t.toString().equals("wall")) return false;
        if(!t.toString().equals("lava")) {
          lava = false;
        }
      }
    }}
    if(lava){m.fell();}
    return true;
    }
    
    
    public static Tile[][] mapFile(File f){
      FileReader fr;
      BufferedReader br;
      String[] s;
      Tile[][] map;
      s = new String[18];
      try{
       fr = new FileReader(f);
       br = new BufferedReader(fr);
       for(int i = 0; i < 18; i++){
            s[i] = br.readLine();
            
          
       }
       //s = br.readLine();
       br.close();
       
      }
      catch (IOException ex){}
      map = new Tile[18][18];
       for(int i = 0; i < 18; i++){
        if(s[i].length() != 18) System.out.print("line is too short");
        for(int j = 0; j < 18; j++){
          String key = s[j].substring(i,i+1);
          if(key.equals("n")){map[j][i] = new NormalTile(i*30,j*30);}
          else if(key.equals("s")){map[j][i] = new SpikeTile(i*30,j*30,1);}
          else if(key.equals("w")){map[j][i] = new WallTile(i*30,j*30);}
          else if(key.equals("l")){map[j][i] = new LavaTile(i*30,j*30);}
          else {map[j][i] = new WaterTile(i*30,j*30);
            System.out.print("Value incompatible");}
        }
      }
      return map;
    }
}
