package pkg_game;

import pkg_game.pkg_room.*;

/**
 * Who is Jack
 * 
 * Beamer class
 * 
 * @author LE STUM S�bastien
 * @version 2013.03.11 V1.0
 */
public class Beamer extends Item
{
    private Room sauvRoom;
    
    public Beamer(final int pPoids,final String pDescription,final String pName)
    {
       super(pPoids,pDescription,pName,Event.NO_EVENT,Event.NO_EVENT,"Ramassé : Beamer","Un objet étrange");
       sauvRoom = null;
    }
    
    public void setSauvRoom(final Room currentRoom){
        this.sauvRoom = currentRoom;
    }
    
    public Room getSauvRoom(){
        return this.sauvRoom;
    }
  
    public boolean useBeamer()
    {
        if(this.sauvRoom != null)
            return true;
        else
            return false;
    }
}//Beamer
