import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.io.*;
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
  File f;
  public GameMain()
  {
    makeMap();
    setVariables();
    setPanel();
    game();
  }
  private void makeMap(){
    f = new File("room1");
    map = Stat.mapFile(f);
    /*map = new Tile[18][18];
    for(int i = 1; i < map.length-1; i++){
    for(int j = 1; j < map.length-1; j++){
      map[i][j] = new NormalTile(i*30,j*30);}}
    map[4][4] = new LavaTile(120,120);
    map[5][4] = new LavaTile(150,120);
    map[4][5] = new LavaTile(120,150);
    map[5][5] = new LavaTile(150,150);
    map[10][10] = new WaterTile(300,300);
    map[10][11] = new WaterTile(300,330);
    map[11][10] = new WaterTile(330,300);
    map[11][11] = new WaterTile(330,330);
    map[5][10] = new SpikeTile(150,300,1);
    for(int i = 0; i < map.length; i++){
      map[0][i] = new WallTile(0,i*30);
      map[17][i] = new WallTile(510,i*30);
      map[i][0] = new WallTile(i*30,0);
      map[i][17] = new WallTile(i*30,510);
    }*/
    }
  private void setPanel()
  {
    f1 = new JFrame("GAME!!!");
      f1.setSize(600,800);
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
      main.setSize(500,500);
      main.add(g1,BorderLayout.CENTER);
      main.add(sub,BorderLayout.SOUTH);
    c1.add(main);
    f1.show();
    f1.setResizable(false);
  }
  private void setVariables()
  {
    p = new Player(200,200,30,30,3,5);
    s = new Sword(p);
    bad = new ArrayList<Enemy>();
    bad.add(new Enemy(150,400,30,30,2,3));
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
        boxcollision();
        collision();
        moveEnemy();
        
        g1.repaint();
      }
    }
  }
  
  private void moveEnemy(){
    for(int i = 0; i < bad.size(); i++){
      
    }
    }
  private void boxcollision(){
    boolean swim = true;
    boolean safe = true;
    for(Tile[] g: map){
        for(Tile t: g){
        if(Stat.collision(t,p)) {
          if(t.toString().equals("spike") && !p.inv) p.hit(((SpikeTile)t).dam);
          if(!t.toString().equals("water")) swim = false;
          if(!t.toString().equals("normal")) safe = false;
        }
      }
    }
    p.swim = swim;
    if(safe){
      p.safex = p.x;
      p.safey = p.y;}
  }
  
  private void imstuff(){
    for(int i = 0; i < bad.size(); i++){bad.get(i).stuff();
      if(bad.get(i).hp <=0) {bad.remove(i);
      i--;}
    }
    p.stuff();
    if(p.hp<=0){ endgame = true;
      g1.endGame();
    }
    }
  
  private void swordStuff(){
    s.stime--;
    s.updateSword();
    
    }
  
  private void collision(){
    for(Enemy b: bad){
      if(Stat.collision(p,b) && !p.inv)p.hit();
      if(Stat.collision(b,s) && s.appear && !b.inv) b.hit();
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
      for(int i = p.speed; i >0; i--){
        p.y-=i;
        if(!Stat.canMove(p,map)) p.y+=i;
        else break;
        }
      p.dir = "up";
     }
    if(evt.getKeyCode() == 40)
    {
      //down
      for(int i = p.speed; i >0; i--){
        p.y+=i;
        if(!Stat.canMove(p,map)) p.y-=i;
        else break;
        }
      p.dir = "down";
    }
    if(evt.getKeyCode() == 37)
    {
       //left
       for(int i = p.speed; i >0; i--){
        p.x-=i;
        if(!Stat.canMove(p,map)) p.x+=i;
        else break;
        }
       p.dir ="left";
    }
    if(evt.getKeyCode() == 39)
    {
       //right
       for(int i = p.speed; i >0; i--){
        p.x+=i;
        if(!Stat.canMove(p,map)) p.x-=i;
        else break;
        }
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
