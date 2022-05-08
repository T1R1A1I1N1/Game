
public class Stat
{
    
    public Stat()
    {
        
    }

    public static boolean collision(Base a, Base b){
      return (a.x<=b.x+b.xsiz && a.x >= b.x-a.xsiz && a.y<=b.y+b.ysiz && a.y >= b.y-a.ysiz);
    }
    
    public static boolean canMove(Base b,Tile[][] map){
    for(Tile[] l: map){for(Tile t: l){
      if(Stat.collision(b,t) && t.toString().equals("wall")) return false;
    }}
    return true;
    }
}
