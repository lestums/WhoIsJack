package pkg_game.pkg_door;
import pkg_game.pkg_room.*;
/**
 * Who is Jack
 * 
 * CommonDoor class
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
 */
public class CommonDoor extends Door
{
    public CommonDoor(String unlockItem, boolean state)
    {
        super(state,unlockItem);
    }
    
    @Override
    public DoorSig useDoor(Room nextRoom)
    {
        if(!getState()){
            return DoorSig.CANUSE;
        } else {
            return DoorSig.LOCKED;
        }
    }
}
