package  pkg_commandes;
//Import de classes
import pkg_game.*;
import pkg_mvc.*;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Class UtilCommand - Une commande du jeu<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle hérite de la classe abstraite Command. Elle permet de tester l'utilisation d'un objet<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2011.11.28 Version finale
 */
public class UtilCommand extends Command
{
    /**
     *  Cette méthode vérfie si le deuxième mot est bien tapé, on vérifie ensuite si l'objet (deuximème mot) est bien
     *  détenu par le joueur. Si c'est le cas, on peut utliser l'objet.
     *  Sinon on retourne un message d'erreur
     *  @param player le joueur
     *  @param gui l'interface graphique
     *  @return un message
     */
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