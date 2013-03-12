package pkg_game.pkg_door;
import pkg_game.pkg_room.*;
/**
 * Programme <b>Who is Jack ?</b><br>
 * Class CommonDoor - Une porte classique<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Héritant de la classe Door, elle modélise une porte classique, utilisable dans
 * les deux sens.<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2010.10.30 Version 7.45.1
 */
public class CommonDoor extends Door
{
    /**
     * Constructeur de la classe CommonDoor
     */
    public CommonDoor(String unlockItem, boolean state)
    {
        super(state,unlockItem);
    }
    
    /**
     * Redéfinition de la fonction abstraite définissant le comportement de la porte
     */
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
