package pkg_commandes;

import pkg_game.*;
import pkg_mvc.*;
import pkg_game.pkg_door.Door;

/**
 * Who is Jack
 * 
 * Dev command class
 * 
 * @author LE STUM S�bastien
 * @version 2013.03.11 V1.0
 */
public class DevCommand extends Command
{
        public String execute(Player player,GameView gui){
        String message = null;
        GameModel gameModel=GameControl.getGameModel();
        if(!hasThirdWord()) 
            message = "D�verrouiller quoi ?";
        else {
            Door toOpen = gameModel.getCurrentRoom().getDoor(getThirdWord());
            Item itemToUnlock = gameModel.getPlayer().getObjectPlayer().getItem(toOpen.getItemToUnlock());
            if(itemToUnlock != null || getSecondWord() == "MASTERKEY"){
                switch(toOpen.unlockDoor(getSecondWord())){
                    case UNLOCKED :
                        message = "La porte est deverrouill�e !";
                        break;
                    case WRONG_ITEM :
                        message = "C'est pas la bonne cl� !";
                        break;
                    case ALREADY_UNLOCKED :
                        message = "La porte est dej� ouverte !";
                        break;
                    default :
                        message = "Cette porte n'existe pas !";
                        break;
                }//switch()
            }
            else {
                return "Vous ne poss�dez pas la cl� pour \n deverrouiller cette porte !";
            }//else
        }//else
        return message;
    }//execute()
}//DevCommand
