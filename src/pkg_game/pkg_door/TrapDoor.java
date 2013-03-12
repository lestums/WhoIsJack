package pkg_game.pkg_door;
import pkg_game.pkg_room.*;

/**
 * Who is Jack
 * 
 * TrapDoor class
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
 */
public class TrapDoor extends Door
{
    // instance variables - replace the example below with your own
    private Room sens;

    public TrapDoor(String unlockItem, boolean state, Room direction)
    {
        super(state,unlockItem);
        this.sens = direction;
    }
    
    @Override
    public DoorSig useDoor(Room nextRoom)
    {
        if(sens == nextRoom){
            if(!getState()){
                return DoorSig.CANUSE;
            } else {
                return DoorSig.LOCKED;
            }
        } else
            return DoorSig.TRAPDOOR;
    }
}
