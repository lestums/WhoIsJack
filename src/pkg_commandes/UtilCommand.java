package  pkg_commandes;
//Import de classes
import pkg_game.*;
import pkg_mvc.*;

/**
 * Who is Jack
 * 
 * Util command class
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
 */
public class UtilCommand extends Command
{

    public String execute(Player player,GameView gui)
    {
        GameModel gameModel = GameControl.getGameModel();
        if(hasSecondWord()){
            Item itemToUse = gameModel.getPlayer().getObjectPlayer().getItem(getSecondWord());
            if(itemToUse == null){
               return "Vous ne pouvez pas utiliser un objet que vous n'avez pas !";
            }//if 
            else {
               GameControl.getGameScenario().validGoal(itemToUse.onUse());
               return itemToUse.getUseString();
            }//else
        }//if
        return "Utiliser quoi ?";
    }//execute()
}//UtilCommand