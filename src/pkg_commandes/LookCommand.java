package pkg_commandes;

import pkg_game.*;
import pkg_mvc.*;

/**
 * Who is Jack
 * 
 * Look command class
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
 */

public class LookCommand extends Command
{
    public String execute(Player player,GameView gui){
        GameModel gameModel = GameControl.getGameModel();
        if(hasSecondWord()){
            Item itemToObserve = gameModel.getPlayer().getObjectPlayer().getItem(getSecondWord());
            if(itemToObserve == null){
               return "Vous ne pouvez pas observer un objet que vous n'avez pas !";
            }//if 
            else {
               return itemToObserve.getDescription() + "\n" + "Poids de cet objet : " + itemToObserve.getPoids();
            }//else
        }//if
        return "Utiliser quoi ?";
    }//execute()
}//LookCommand
