package  pkg_commandes;
//Import de classes
import pkg_mvc.*;
import pkg_game.*;
import pkg_game.pkg_room.*;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Class AleaCommand - Une commande du jeu "Who is jack ?"<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle permet d'utiliser une TransporterRoom qui envoie le joueur dans une pièce choisie.<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2010.11.28 Version finale
 */
public class AleaCommand extends Command
{
    /**
     * Fonction qui permet d'exécuter la commande rentrée par le joueur:
     * si il existe un deuxième mot qui correspond à une pièce, la TransporterRoom n'est plus aléatoire.
     * sinon l'action reste ou redevient aléatoire.
     * @param player le joueur
     * @param gui l'interface graphique
     * @return un message correspondant à la commande
     */
    public String execute(Player player,GameView gui){
        if(hasSecondWord()){
            TransporterRoom transportRoom = (TransporterRoom)GameControl.getGameModel().getRoom("transport_room");
            if(GameControl.getGameModel().getRoom(getSecondWord())!=null){
                transportRoom.setAttribut(true,getSecondWord());
                return "Vous avez bloqué le mécanisme aléatoire.";
            } //if
            else  return "Erreur ! La salle demandée n'existe pas"; 
        }//if 
        else { 
            TransporterRoom transportRoom = (TransporterRoom)GameControl.getGameModel().getRoom("transport_room");
            transportRoom.setAttribut(true,null);
            return "Les tirages seront maintenant aléatoire";
        }//else
    }//execute()
}//AleaCommand