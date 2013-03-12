package pkg_commandes;

import pkg_game.*;
import pkg_mvc.*;

/**
 * Who is Jack
 * 
 * Prendre command class
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
 */

public class PrendreCommand extends Command
{
    public String execute(Player player,GameView gui)
    {
        GameModel gameModel = GameControl.getGameModel();
        if(!hasSecondWord()) {
            return "\nVous n'avez pas saisi d'objet à prendre !\n";
        }//if
        else{
            Item objetPris = gameModel.getCurrentRoom().getObjectRoom().removeItem(getSecondWord());
            if(objetPris!=null){
                String  message = "Vous avez pris l'objet " + objetPris.getName();
                if(gameModel.getPlayer().getObjectPlayer().addItem(getSecondWord(),objetPris)){
                    GameControl.getGameScenario().validGoal(objetPris.onGather());
                } else {
                    message += "\n Vous ne pouvez pas porter cet objet, pas assez de place !";
                    gameModel.getCurrentRoom().getObjectRoom().addItem(getSecondWord(),objetPris);
                }
                return message;
            }//if
            else{
                return "\nL'objet que vous avez saisi ne se trouve pas dans la pièce !\n";
            }//else
        }//else
    }//execute()
}//PrendreCommand