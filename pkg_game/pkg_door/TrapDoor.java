package pkg_game.pkg_door;
import pkg_game.pkg_room.*;
/**
 * Programme <b>Who is Jack ?</b><br>
 * Class TrapDoor - Une porte a sens unique<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Héritant de la classe Door, une trapdoor ne peut être franchi que dans un sens.<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2010.10.30 Version 7.45.1
 */
public class TrapDoor extends Door
{
    // instance variables - replace the example below with your own
    private Room sens;

    /**
     * Constructeur d'une TrapDoor, héritant des caractéristiques d'une porte et ajoutant le sens
     * de parcours
     */
    public TrapDoor(String unlockItem, boolean state, Room direction)
    {
        super(state,unlockItem);
        this.sens = direction;
    }
    
    /**
     * Redéfinition de la fonction abstraite de la classe mère pour utiliser la trapdoor selon ses
     * spécificités
     * @return Le signal renvoyé par la porte
     */
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
