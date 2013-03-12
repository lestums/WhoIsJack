package  pkg_commandes;
import pkg_game.*;
import pkg_mvc.*;
import pkg_game.pkg_door.Door;

/**
 * Who is Jack
 * 
 * Ver command class
 * 
 * @author LE STUM S�bastien
 * @version 2013.03.11 V1.0
 */
public class VerCommand extends Command
{
    public String execute(Player player,GameView gui){
        String message = null;
        GameModel gameModel = GameControl.getGameModel();
        if(!hasThirdWord()) 
            message = "Verrouiller quoi ?";
        else {
            Door toClose = gameModel.getCurrentRoom().getDoor(getThirdWord());
            Item itemToLock = gameModel.getPlayer().getObjectPlayer().getItem(toClose.getItemToUnlock());
            if(itemToLock != null || getSecondWord() == "MASTERKEY"){
                switch(toClose.lockDoor(getSecondWord())){
                    case LOCKED :
                        message = "La porte est verrouill�e !";
                        break;
                    case WRONG_ITEM :
                        message = "C'est pas la bonne cl� !";
                        break;
                    case ALREADY_LOCKED :
                        message = "La porte est dej� ferm�e !";
                        break;
                    default :
                        message = "Cette porte n'existe pas !";
                        break;
                }//switch()
            } //if
            else 
                return "Vous ne poss�dez pas la cl� pour \n verrouiller cette porte !";
        }//else
        return message;   
    }//execute()
}//VerCommand
