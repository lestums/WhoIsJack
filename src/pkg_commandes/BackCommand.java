package pkg_commandes;
//Import de classes
import pkg_game.*;
import pkg_mvc.*;
import pkg_game.pkg_room.*;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Class BackCommand - Une commande du jeu "Who is jack ?"<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle permet d'appliquer la commande "retour", le déclenchement d'un retour en arrière dans le jeu, c'est-à-dire le retour à la commande précédente<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2010.11.28 Version finale
 */
public class BackCommand extends Command{
    /**
     * Fonction qui présente trois tests:
     * - si il y a un second mot, la méthode ne permet pas de revenir en arrière.
     * - si la pile n'est pas vide, on peut revenir en arrière.
     * - si le joueur est revenu au point départ, il ne peut plus revenir en arrière.
     * @param player le joueur
     * @param gui l'interface graphique
     * @return un message correspondant à la commande
     */ 
    public String execute(Player player,GameView gui)
    {
        GameModel gameModel = GameControl.getGameModel();    
        if(hasSecondWord()) {
            return "la commande back s'utilise seul !";
        }//if
        if(!(gameModel.getChemin().empty())){
            gameModel.gotoRoom((Room)gameModel.getChemin().pop());
            return "Vous êtes revenu revenu en arrière";
        }//if
        else{
            return "Vous êtes revenu au point de départ, vous ne pouvez donc pas retourner en arrière !";
        }//else  
    }//execute()
}//BackCommand