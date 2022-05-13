
public class Player extends Moves
{
    boolean swim;
    final int maxHP;
    public Player(int x, int y, int xsiz, int ysiz,int speed, int hp)
    {
        super(x,y,xsiz,ysiz,speed,hp);
        maxHP = hp;
    }

    public void fell(){
      if(invtim<0)hit();
      x = safex;
      y = safey;
    }
}
