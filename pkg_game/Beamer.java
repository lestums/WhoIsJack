package pkg_game;

import pkg_game.pkg_room.*;


/**
 * Programme <b>Who is Jack ?</b><br>
 * Class Beamer - Un objet du jeu<br><br>
 * 
 * Cette classe fait partie du jeu "Who is jack ?"<br>
 * 
 * Elle permet la création d'un beamer, sorte d'item qui permet de <br>
 * se téléporter dans une salle sauvegardée précédement
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2011.11.28 Version finale
 */
public class Beamer extends Item
{
    private Room sauvRoom;
    
    /**
     * Constructeur de  Beamer
     */
    public Beamer(final int pPoids,final String pDescription,final String pName)
    {
       super(pPoids,pDescription,pName,Event.NO_EVENT,Event.NO_EVENT,"Ramassé : Beamer","Un objet étrange");
       sauvRoom = null;
    }
    
     /**
     * Modificateur sauvegardant la salle actuelle pour charger le beamer
     */
    public void setSauvRoom(final Room currentRoom){
        this.sauvRoom = currentRoom;
    }
    
    /**
     * Permet de récuperer la salle chargée par le beamer
     */
    public Room getSauvRoom(){
        return this.sauvRoom;
    }
    
    /**
     * Procédure permettant d'utiliser le beamer
     */
    public boolean useBeamer()
    {
        if(this.sauvRoom != null)
            return true;
        else
            return false;
    }
}//Beamer
