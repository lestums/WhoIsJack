package pkg_commandes;
//Import de classes
import pkg_game.*;
import pkg_mvc.*;
import pkg_game.pkg_door.Door;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Class DevCommand - Une commande du jeu<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle hérite de la classe abstraite Command. Elle permet de déverrouiller une porte<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2011.11.28 Version finale
 */
public class DevCommand extends Command
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
        GameModel gameModel=GameControl.getGameModel();
        if(!hasThirdWord()) 
            message = "Déverrouiller quoi ?";
        else {
            Door toOpen = gameModel.getCurrentRoom().getDoor(getThirdWord());
            Item itemToUnlock = gameModel.getPlayer().getObjectPlayer().getItem(toOpen.getItemToUnlock());
            if(itemToUnlock != null || getSecondWord() == "MASTERKEY"){
                switch(toOpen.unlockDoor(getSecondWord())){
                    case UNLOCKED :
                        message = "La porte est deverrouillée !";
                        break;
                    case WRONG_ITEM :
                        message = "C'est pas la bonne clé !";
                        break;
                    case ALREADY_UNLOCKED :
                        message = "La porte est dejà ouverte !";
                        break;
                    default :
                        message = "Cette porte n'existe pas !";
                        break;
                }//switch()
            }
            else {
                return "Vous ne possédez pas la clé pour \n verrouiller cette porte !";
            }//else
        }//else
        return message;
    }//execute()
}//DevCommand
