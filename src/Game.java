import pkg_mvc.GameControl;
import javax.swing.JApplet;

/**
 * Who is Jack
 * 
 * Main class
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
 */
@SuppressWarnings("serial")
public class Game extends JApplet
{
    /**
      * Main entry point (Run with terminal)
      */
     public static void main(String[] pArgs ){
       new GameControl(null);
     } //main()
    
     /**
      * Main entry point (Run like Applet)
      */
    public void init(){
        new GameControl(getContentPane());
    }//init()
}//Game()
