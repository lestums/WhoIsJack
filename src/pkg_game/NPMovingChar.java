package pkg_game;

import java.util.Stack;
import pkg_game.pkg_room.Room;
import pkg_mvc.*;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Class NPMovingCharacter - Un personnage mobile du jeu "Who is Jack"<br><br>
 * 
 * Cette classe fait partie du jeu "Who is jack ?"<br>
 * 
 * Cree un personnage du jeu, pouvant parler et bouger selon une pile de déplacement
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2011.11.28 Version finale
 */
public class NPMovingChar extends NPCharacter
{
   private Stack<Room> path;
   
   /**
    * Constructeur : Cree un personnage mobile
    */
   public NPMovingChar(final String pDescription, final String pName, final String pSpeech, final Event pSpeechEvent)
   {
       super(pDescription,pName,pSpeech,pSpeechEvent);
       this.path = new Stack<Room>();
   }
   
   /**
    * Accesseur : Récupère la Room en haut de la pile de déplacement
    */
   public Room getNextRoom()
   {
       return (Room)path.peek();
   }
   
   /**
    * Accesseur : Recupère la pile de déplacement du personnage mobile
    */
   public Stack<Room> getStack()
   {
       return path;
   }
   
   /**
    * Fonction qui assure le déplacement du personnage mobile
    */
   public boolean moveChar(Room currentRoom)
   {
       if(!path.empty()){
           Room nextRoom = getNextRoom();
           GameControl.getGameModel().getCurrentRoom().getCharRoom().removeItem(this.getName());
           nextRoom.getCharRoom().addChar(this.getName(),this);
           path.pop();
           return true;
       } else {
           return false;
       }
   } 
}//NPMovingChar
