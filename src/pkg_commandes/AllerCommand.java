package  pkg_commandes;

import pkg_game.*;
import pkg_game.pkg_room.*;
import pkg_mvc.*;
import pkg_game.pkg_door.*;

/**
 * Who is Jack
 * 
 * Go command
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
 */
public class AllerCommand extends Command
{
    public String execute(Player player,GameView gui)
    {
        if(!hasSecondWord()) {
            return "Aller ou ?";
        }//if
        
        String direction = getSecondWord();
        GameModel gameModel = GameControl.getGameModel();
        Room currentRoom = gameModel.getCurrentRoom();
        Room nextRoom = currentRoom.getExit(direction);
        Door nextDoor = currentRoom.getDoor(direction);
        
        if (nextRoom == null)
            return "C'est pas malin de foncer dans un mur...";
        else {
            switch(nextDoor.useDoor(nextRoom)){

                case LOCKED :
                    return "la porte est fermée !";
                case TRAPDOOR :
                    return "C'est une porte a sens unique ! Vous ne pouvez pas \n faire demi tour !";
                case CANUSE :
                    gameModel.getChemin().push(currentRoom);
                    gameModel.gotoRoom(nextRoom);
                    break;
                default:
                	break;
                	
            }//switch()
            return "vide";
        } //else
    }//execute()
}//AllerCommand
