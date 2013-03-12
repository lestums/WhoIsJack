import pkg_mvc.GameControl;
import javax.swing.JApplet;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Class Game - Le controleur du jeu "Who is jack ?"<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle représente le commencement du jeu.<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2011.11.28 Version finale
 */
public class Game extends JApplet
{
    /**
      * Méthode principale appelée dans le cas d'un démarrage par un terminal
      */
     public static void main(String[] pArgs ){
       new GameControl(null);
     } //main()
    
     /**
      * Méthode principale appelée dans le cas d'un démarrage par applet
      */
    public void init(){
        new GameControl(getContentPane());
    }//init()
}//Game()
