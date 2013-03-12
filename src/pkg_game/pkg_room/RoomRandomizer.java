package pkg_game.pkg_room;
import java.util.Random;
import pkg_mvc.*;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Class RoomRandomizer - Un RoomRandomizer du jeu "Who is jack ?"<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle permet de fournir aléatoirement une salle du jeu<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @@version 2011.11.28 Version finale
 */
public class RoomRandomizer{
    /**
     * Fonction statique permettant de retourner aléatoirement une room
     */
    public static Room findRandomRoom(){
        Random vR = new Random();
        String[] roomNames = GameControl.getGameModel().getSetRoom().toArray(new String[0]);
        int vI = vR.nextInt(roomNames.length);
        return GameControl.getGameModel().getRoom(roomNames[vI]);
    }
}//RoomRandomizer