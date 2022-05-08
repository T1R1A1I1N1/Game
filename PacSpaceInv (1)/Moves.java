
public class Moves extends Base
{
    String dir = "down";
    boolean inv;
    int invtim,speed,hp;
    public Moves(int x, int y, int xsiz, int ysiz,int speed,int hp)
    {
       super(x,y,xsiz,ysiz);
       this.speed = speed;
       this.hp = hp;
    }
    
    public void hit(){
      invtim = 200;
      hp--;
    }
    
    public void stuff(){
      invtim--;
      inv = (invtim>0);
    }
}
