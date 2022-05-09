
public class Enemy extends Moves
{
    boolean dead;
    public Enemy(int x, int y, int xsiz, int ysiz,int speed, int hp)
    {
        super(x,y,xsiz,ysiz,speed,hp);
    }

    public void fell(){dead = true;}
}

