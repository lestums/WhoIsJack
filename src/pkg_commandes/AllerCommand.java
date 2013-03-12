package  pkg_commandes;
//Import de classes
import pkg_game.*;
import pkg_game.pkg_room.*;
import pkg_mvc.*;
import pkg_game.pkg_door.*;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Class AllerCommand - Une commande du jeu<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle hérite de la classe abstraite Command. Elle permet de se déplacer dans le jeu<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2011.11.28 Version finale
 */
public class AllerCommand extends Command
{
   /**
     *  Cette méthode réalise des vérifications pour le déplacement : on vérifie que le joueur a bien tapé un deuxième mot qui doit correspondre
     *  à une direction existante. On vérifie que dans la direction voulue, la porte n'est pas vérouiller ou que ce n'est pas 
     *  une trapdoor. Enfin on stocke la pièce courante dans une pile (afin d'utiliser la commande retour) et on se déplace 
     *  grâce à la méthode gotoRoom().
     *  Sinon dans les autres cas, on retourne un message d'erreur.
     *  @param player le joueur
     *  @param gui l'interface graphique
     *  @return un message
     */
    public String execute(Player player,GameView gui)
    {
        if(!hasSecondWord()) {
            return "Aller ou ?";
        }//if
        
        String direction = getSecondWord();
        GameModel gameModel = GameControl.getGameModel();
        Room currentRoom = gameModel.getCurrentRoom();
        Room nextRoom = currentRoom.getExit(direction);
        Door nextDoor = currentRoom.getDoor(direction);
        
        if (nextRoom == null)
            return "C'est pas malin de foncer dans un mur...";
        else {
            switch(nextDoor.useDoor(nextRoom)){

                case LOCKED :
                    return "la porte est fermée !";
                case TRAPDOOR :
                    return "C'est une porte a sens unique ! Vous ne pouvez pas \n faire demi tour !";
                case CANUSE :
                    gameModel.getChemin().push(currentRoom);
                    gameModel.gotoRoom(nextRoom);
                    break;
            }//switch()
            return "vide";
        } //else
    }//execute()
}//AllerCommand
