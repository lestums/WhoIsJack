package  pkg_commandes;
//Import des classes
import pkg_game.*;
import pkg_mvc.*;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Class DeclencherCommand - Une commande du jeu<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle hérite de la classe abstraite Command. Elle permet de revenir à un point sauvegardé préalablement<br>
 * grâce à la commande charger.
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2011.11.28 Version finale
 */
public class DeclencherCommand extends Command
{
    /**
     *  Cette méthode permet de revenir à un point sauvegaré : on vérifie tout d'abord si le joueur détient le beamer,
     *  si c'est le cas on récupère la pièce sauvegardé par l'accesseur getSauvRoom() puis on  déplace le joueur grâce 
     *  à la méthode gotoRoom() vers la pièce récupérée et on réinitialise la pièce courante à null.
     *  Sinon on retourne un message d'erreur.
     *  @param player le joueur
     *  @param gui l'interface graphique
     *  @return un message
     */
    public String execute(Player player,GameView gui)
    {
        GameModel gameModel = GameControl.getGameModel();
        Beamer vB= (Beamer) gameModel.getPlayer().getObjectPlayer().getItem("beamer");
        if(gameModel.getPlayer().getObjectPlayer().getItemList().containsKey("beamer")){
            if(vB.useBeamer()){
                gameModel.gotoRoom(vB.getSauvRoom());
                vB.setSauvRoom(null);
                return "Vous venez de déclencher votre beamer";
            } //if
            else    return "Impossible le beamer n'est pas chargé !";
        }//if
        else    return "Vous ne portez pas le beamer !";     
    }//execute()
    
}//DeclencherCommand
