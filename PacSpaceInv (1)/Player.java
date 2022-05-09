
public class Player extends Moves
{
    boolean swim;
    public Player(int x, int y, int xsiz, int ysiz,int speed, int hp)
    {
        super(x,y,xsiz,ysiz,speed,hp);
    }

    public void fell(){if(invtim<0)hit();}
}
