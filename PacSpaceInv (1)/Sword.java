
public class Sword extends Base
{
    Player p;
    int stime;
    boolean appear;
    public Sword(Player p)
    {
        super(0,0,0,0);
        this.p = p;
        appear = false;
    }

    public void updateSword(){
        if(stime<0) appear = false;
        if(p.dir.equals("up")){
          xsiz = p.xsiz;
          x = p.x;
          ysiz = p.ysiz/2;
          y = p.y-ysiz;
        }
        if(p.dir.equals("down")){
          xsiz = p.xsiz;
          x = p.x;
          ysiz = p.ysiz/2;
          y = p.y+p.ysiz;
        }
        if(p.dir.equals("left")){
          xsiz = p.xsiz/2;
          x = p.x-xsiz;
          ysiz = p.ysiz;
          y = p.y;
        }
        if(p.dir.equals("right")){
          xsiz = p.xsiz/2;
          x = p.x+p.xsiz;
          ysiz = p.ysiz;
          y = p.y;
        }
    }
    
    
}
