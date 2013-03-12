package pkg_commandes;

import pkg_game.*;
import pkg_mvc.*;
import pkg_game.pkg_room.*;

/**
 * Who is Jack
 * 
 * Back command
 * 
 * @author LE STUM S�bastien
 * @version 2013.03.11 V1.0
 */
public class BackCommand extends Command{
    
    public String execute(Player player,GameView gui)
    {
        GameModel gameModel = GameControl.getGameModel();    
        if(hasSecondWord()) {
            return "La commande back s'utilise seul !";
        }//if
        if(!(gameModel.getChemin().empty())){
            gameModel.gotoRoom((Room)gameModel.getChemin().pop());
            return "Vous �tes revenu revenu en arri�re";
        }//if
        else{
            return "Vous �tes revenu au point de d�part, vous ne pouvez donc pas retourner en arri�re !";
        }//else  
    }//execute()
}//BackCommand