import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class GameMain implements ActionListener, KeyListener
{
  JFrame f1;
  JPanel main, sub;
  GameGraph g1;
  JButton b1,b2;
  boolean endgame,start;
  Tile[][] map;
  Player p;
  Sword s;
  ArrayList<Enemy> bad;
  public GameMain()
  {
    makeMap();
    setVariables();
    setPanel();
    game();
  }
  private void makeMap(){
    map = new Tile[18][18];
    for(int i = 1; i < map.length-1; i++){
    for(int j = 1; j < map.length-1; j++){
    map[i][j] = new NormalTile(i*40,j*40);}}
    for(int i = 0; i < map.length; i++){
      map[0][i] = new WallTile(0,i*40);
      map[17][i] = new WallTile(680,i*40);
      map[i][0] = new WallTile(i*40,0);
      map[i][17] = new WallTile(i*40,680);
    }
    }
  private void setPanel()
  {
    f1 = new JFrame("Graphics Example");
      f1.setSize(800,800);
      f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c1 = f1.getContentPane();
    
    b1 =  new JButton("Start");
      b1.addActionListener(this);
        
    b2 =  new JButton("End");
      b2.addActionListener(this);
      
    g1 = new GameGraph(map,p,s,bad);
      g1.addKeyListener(this);  
      
    sub = new JPanel(); 
      sub.add(b1);
      sub.add(b2);
    
    
    main = new JPanel();
      main.setLayout(new BorderLayout());          
      main.setSize(600,600);
      main.add(g1,BorderLayout.CENTER);
      main.add(sub,BorderLayout.SOUTH);
    c1.add(main);
    f1.show();
  }
  private void setVariables()
  {
    p = new Player(200,200,30,30);
    s = new Sword(p);
    bad = new ArrayList<Enemy>();
    bad.add(new Enemy(150,400,30,30));
  }
  private void game()
  {
    Thread runner = new Thread();
    while(!endgame)
    {    
      try 
      { 
        runner.sleep(5); 
      }
      catch(InterruptedException e) {}  
      if(start)
      {
        swordStuff();
        imstuff();
        collision();
        g1.repaint();
      }
    }
  }
  
  private void imstuff(){
    for(Enemy b: bad){b.stuff();}
    p.stuff();
    }
  
  private void swordStuff(){
    s.stime--;
    s.updateSword();
    
    }
  
  private void collision(){
    for(Enemy b: bad){
      if(Stat.collision(p,b))p.invtim = 200;
      if(Stat.collision(b,s) && s.appear) b.invtim = 200;
    }
    
    }

  public void actionPerformed (ActionEvent event)
  {
    if (event.getSource() == b1)
    {
       start = true; 
       g1.requestFocus();
    }
    if (event.getSource() == b2)
    {
       endgame = true;
    }
   }
  public void keyPressed(KeyEvent evt)
  {
    if(evt.getKeyCode() == 38)
     {
      //up 
      p.y-=3;
      if(!Stat.canMove(p,map)) p.y+=3;
      p.dir = "up";
     }
    if(evt.getKeyCode() == 40)
    {
      //down
      p.y+=3;
      if(!Stat.canMove(p,map)) p.y-=3;
      p.dir = "down";
    }
    if(evt.getKeyCode() == 37)
    {
       //left
       p.x-=3;
       if(!Stat.canMove(p,map)) p.x+=3;
       p.dir ="left";
    }
    if(evt.getKeyCode() == 39)
    {
       //right
       p.x+=3;
       if(!Stat.canMove(p,map)) p.x-=3;
       p.dir = "right";
    }
    if(evt.getKeyCode() == 32)
    {
       s.appear = true;
       s.stime = 100;
    }
  }
  
  public void keyReleased(KeyEvent evt)
  {}
  public void keyTyped(KeyEvent evt)
  {}
}
