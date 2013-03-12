package pkg_game;

import java.util.Stack;
import pkg_game.pkg_room.Room;
import pkg_mvc.*;

/**
 * Who is Jack
 * 
 * NPMovingChar class
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
 */
public class NPMovingChar extends NPCharacter
{
   private Stack<Room> path;
   
   public NPMovingChar(final String pDescription, final String pName, final String pSpeech, final Event pSpeechEvent)
   {
       super(pDescription,pName,pSpeech,pSpeechEvent);
       this.path = new Stack<Room>();
   }
   
   public Room getNextRoom()
   {
       return (Room)path.peek();
   }
   
   public Stack<Room> getStack()
   {
       return path;
   }
   
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
