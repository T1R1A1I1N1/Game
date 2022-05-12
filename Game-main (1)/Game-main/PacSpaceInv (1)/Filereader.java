import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
public class Filereader
{
    File f;
    FileReader fr;
    BufferedReader br;
    String[][] s;
    public Filereader()
    {
       f = new File("room1");
       s = new String[18][18];
    }
    
    public String[][] findFile(){
      try{
       fr = new FileReader(f);
       br = new BufferedReader(fr);
       for(int i = 0; i < 18; i++){
          for(int j = 0; j < 18; j++){
            s[i][j] = br.readLine();
            
          }
       }
       //s = br.readLine();
       br.close();
       
    }
    catch (IOException ex){}
    return s;
    }
}
