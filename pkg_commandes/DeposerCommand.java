package  pkg_commandes;
//Import de classes
import pkg_game.*;
import pkg_mvc.*;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Class DeposerCommand - Une commande du jeu "Who is jack ?"<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle permet de déclencher le beamer, un objet pour se téléporter.<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2010.11.28 Version finale
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