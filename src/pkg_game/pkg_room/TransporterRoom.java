package pkg_game.pkg_room;
import pkg_mvc.*;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Class TransporterRoom - Une salle du jeu "Who is jack ?"<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle permet de créer une salle de transport dans le jeu, qui nous téléportera aléatoirement<br>
 * selon la commande alea et le RoomRandomizer
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2011.11.28 Version finale
 */
public class TransporterRoom extends Room{

    private boolean aAlea;
    private String aRoom;
    
    /**
     * Constructeur de la salle Transporteur room
     */
    public TransporterRoom(String description, String image, int pNbImage, boolean pTransport)
    {
        super("Salle de télétransport",description, image, pNbImage, pTransport);  
        aAlea = false;
        aRoom = null;
    }
    
    /**
     * Retourne une pièce aléatoire, indépendante du paramètre de direction.
     * @param direction Ignoré
     * @return Une pièce aléatoire.
     */
    public Room getExit(String direction)
    {
        Room exit = super.getExit(direction);
        
        if(!(aAlea)){
            if(exit != null)
                return RoomRandomizer.findRandomRoom();
                else
                return null;
        }
        else {
           return GameControl.getGameModel().getRoom(aRoom);      
        }
    }//getExit()   
    
    /**
     * Modificateur des attributs alea et aRoom
     */
    public void setAttribut(final boolean pAlea, final String pRoom)
    {
        aAlea = pAlea;
        aRoom = pRoom;   
    }//setAttribut()*
    
}// TransporterRoom