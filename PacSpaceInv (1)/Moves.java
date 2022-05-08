
public class Moves extends Base
{
    String dir = "down";
    boolean inv;
    int invtim;
    public Moves(int x, int y, int xsiz, int ysiz)
    {
       super(x,y,xsiz,ysiz);
    }
    
    public void stuff(){
      invtim--;
      inv = (invtim>0);
    }
}
