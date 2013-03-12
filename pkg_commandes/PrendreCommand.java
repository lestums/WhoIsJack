package pkg_commandes;
//Import de classes
import pkg_game.*;
import pkg_mvc.*;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Class PrendreCommand - Une commande du jeu "Who is jack ?"<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle permet de prendre un objet sélectionné.<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2010.11.28 Version finale
 */

public class PrendreCommand extends Command
{
    /**
     * Fonction qui permet d'exécuter la commande rentrée par le joueur:
     * si il existe un deuxième mot qui correspond à un objet, on vérifie le poids de l'objet.
     * Si le joueur peut l'emporter, l'objet est déplacé.
     * Sinon on retourne un message d'erreur
     * @param player le joueur
     * @param gui l'interface graphique
     * @return un message correspondant à la commande
     */
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