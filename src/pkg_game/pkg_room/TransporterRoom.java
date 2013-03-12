package pkg_game.pkg_room;
import pkg_mvc.*;

/**
 * Who is Jack
 * 
 * TransporterRoom class
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
 */
public class TransporterRoom extends Room{

    private boolean aAlea;
    private String aRoom;
    
    public TransporterRoom(String description, String image, int pNbImage, boolean pTransport)
    {
        super("Salle de télétransport",description, image, pNbImage, pTransport);  
        aAlea = false;
        aRoom = null;
    }
    
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
    
    public void setAttribut(final boolean pAlea, final String pRoom)
    {
        aAlea = pAlea;
        aRoom = pRoom;   
    }//setAttribut()*
    
}// TransporterRoom