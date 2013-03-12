package pkg_game.pkg_door;
import pkg_game.pkg_room.*;

/**
 * Who is Jack
 * 
 * Door class
 * 
 * @author LE STUM S�bastien
 * @version 2013.03.11 V1.0
 */
public abstract class Door
{
    private boolean lockState;
    private String itemToUnlock;
    
    /**
     * Constructeur de la classe Door : Initialise la porte avec son etat de verrou
     * et l'objet pouvant la deverrouiller
     */
    public Door(final boolean State, final String unlockItem)
    {
        this.lockState = State;
        this.itemToUnlock = unlockItem;
    }
    
    /**
     * Accesseur retournant l'etat du verrou de la porte
     */
    public boolean getState()
    {
        return lockState;
    }
    
    public String getItemToUnlock()
    {
        return itemToUnlock;
    }    
    
    /**
     * Fonction qui permet la gestion du deverrouillage d'une porte
     * @return Le signal renvoyé par la porte
     */
    public DoorSig unlockDoor(String unlockingItem)
    {
        if(getState()){
            if(unlockingItem.equals(itemToUnlock)){
                lockState = false;
                return DoorSig.UNLOCKED;
            } else {
                return DoorSig.WRONG_ITEM;
            }
        } else {
            return DoorSig.ALREADY_UNLOCKED;
        }
    }
    
    /**
     * Fonction qui permet la gestion du verrouillage d'une porte
     * @return Le signal renvoyé par la porte
     */
    public DoorSig lockDoor(String lockingItem)
    {
        if(!getState()){
            if(lockingItem.equals(itemToUnlock)){
                lockState = true;
                return DoorSig.LOCKED;
            } else {
                return DoorSig.WRONG_ITEM;
            }
        } else {
            return DoorSig.ALREADY_LOCKED;
        }
    }
    
    /**
     * Méthode abstraite de la classe Door qui defini qu'une porte peut être 
     * "utilisée" (empruntée)
     */
    public abstract DoorSig useDoor(Room nextRoom);
}
