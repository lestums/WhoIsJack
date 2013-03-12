package  pkg_commandes;
//Import de classes
import pkg_game.*;
import pkg_mvc.*;
import pkg_game.pkg_door.Door;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Class VerCommand - Une commande du jeu<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle hérite de la classe abstraite Command. Elle permet de verrouiller une porte<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2011.11.28 Version finale
 */
public class VerCommand extends Command
{
    /**
     *  Cette méthode vérifie que le joueur a bien tapé 3 mots sur la ligne de commande. Si c'est bien le cas,
     *  on vérifie que la porte existe bien grâce au troisième mot. Enfin nous vérifions l'état de la porte et 
     *  nous retournons un message en fonction de son état.
     *  Sinon on retourne un message d'erreur.
     *  @param player le joueur
     *  @param gui l'interface graphique
     *  @return un message
     */
    public String execute(Player player,GameView gui){
        String message = null;
        GameModel gameModel = GameControl.getGameModel();
        if(!hasThirdWord()) 
            message = "Verrouiller quoi ?";
        else {
            Door toClose = gameModel.getCurrentRoom().getDoor(getThirdWord());
            Item itemToLock = gameModel.getPlayer().getObjectPlayer().getItem(toClose.getItemToUnlock());
            if(itemToLock != null || getSecondWord() == "MASTERKEY"){
                switch(toClose.lockDoor(getSecondWord())){
                    case LOCKED :
                        message = "La porte est verrouillée !";
                        break;
                    case WRONG_ITEM :
                        message = "C'est pas la bonne clé !";
                        break;
                    case ALREADY_LOCKED :
                        message = "La porte est dejà fermée !";
                        break;
                    default :
                        message = "Cette porte n'existe pas !";
                        break;
                }//switch()
            } //if
            else 
                return "Vous ne possédez pas la clé pour \n verrouiller cette porte !";
        }//else
        return message;   
    }//execute()
}//VerCommand
