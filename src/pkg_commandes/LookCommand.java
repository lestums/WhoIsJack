package pkg_commandes;
//Import de classes
import pkg_game.*;
import pkg_mvc.*;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Class LookCommand - Une commande du jeu<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle hérite de la classe abstraite Command. Elle permet de tester l'observation d'un objet<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2011.11.28 Version finale
 */

public class LookCommand extends Command
{
    /**
     *  Cette méthode vérfie si le deuxième mot est bien tapé, on vérifie ensuite si l'objet (deuximème mot) est bien
     *  détenu par le joueur. Si c'est le cas, on affiche les caractéristiques de l'objet.
     *  Sinon on retourne un message d'erreur
     *  @param player le joueur
     *  @param gui l'interface graphique
     *  @return un message
     */
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
