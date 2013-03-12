package  pkg_commandes;
//Import de classes
import pkg_game.*;
import pkg_mvc.*;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Class ChargerCommand - Une commande du jeu "Who is jack ?"<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle permet de charger le beamer, un objet pour se téléporter.<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2010.11.28 Version finale
 */

public class ChargerCommand extends Command{
    /**
     * Fonction qui sauvegarde la pièce où se trouve le joueur.
     * @param player le joueur
     * @param gui l'interface graphique
     * @return un message correspondant à la commande
     */   
    public String execute(Player player,GameView gui)
    {
        GameModel gameModel = GameControl.getGameModel();
        if(gameModel.getPlayer().getObjectPlayer().getItemList().containsKey("beamer")){
            Beamer vB= (Beamer)gameModel.getPlayer().getObjectPlayer().getItem("beamer");
            vB.setSauvRoom(gameModel.getCurrentRoom());
            return "Votre beamer est chargé";
        } else return "Vous ne portez pas le beamer !";
    }//execute()
}//ChargerCommand