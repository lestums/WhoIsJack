package  pkg_commandes;

import pkg_game.*;
import pkg_mvc.*;

/**
 * Who is Jack
 * 
 * Deposer command class
 * 
 * @author LE STUM S�bastien
 * @version 2013.03.11 V1.0
 */

public class DeposerCommand extends Command{
    /**
     * Fonction qui déplace le joueur dans la pièce sauvegardée.
     * @param player le joueur
     * @param gui l'interface graphique
     * @return un message correspondant à la commande
     */ 
    public String execute(Player player,GameView gui)
    {
        if(!hasSecondWord()) {
            return "\nVous n'avez pas saisi d'objet à deposer !\n";
        }//if
            else{
               Item objetDepose = GameControl.getGameModel().getPlayer().getObjectPlayer().removeItem(getSecondWord());
               if(objetDepose!=null){
                    String  message;
                    message="\nVous avez déposé l'objet "+getSecondWord()+"\n";
                    GameControl.getGameModel().getCurrentRoom().getObjectRoom().addItem(getSecondWord(),objetDepose);
                    return message;
                }//if
                else{
                    return"\nL'objet que vous avez saisi ne se trouve pas dans votre sac !\n";
                }//else
        }//else 
    }//execute()
}//DeposerCommand