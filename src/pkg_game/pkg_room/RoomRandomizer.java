package pkg_game.pkg_room;
import java.util.Random;
import pkg_mvc.*;

/**
 * Who is Jack
 * 
 * RoomRandomizer class
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
 */
public class RoomRandomizer{
    
    public static Room findRandomRoom(){
        Random vR = new Random();
        String[] roomNames = GameControl.getGameModel().getSetRoom().toArray(new String[0]);
        int vI = vR.nextInt(roomNames.length);
        return GameControl.getGameModel().getRoom(roomNames[vI]);
    }
}//RoomRandomizer