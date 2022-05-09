
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
    if(lava){m.fell();
          return false;}
    return true;
    }
}
