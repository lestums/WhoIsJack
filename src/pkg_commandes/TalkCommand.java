package pkg_commandes;
//Import de classes
import pkg_game.*;
import pkg_game.pkg_room.*;
import pkg_mvc.GameControl;
import pkg_mvc.GameView;
import pkg_mvc.GameScenario;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Class TalkCommand - Une commande du jeu "Who is jack ?"<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle permet de faire parler un personnage.<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2010.11.28 Version finale
 */
public class TalkCommand extends Command
{
    /**
     * Fonction qui permet d'exécuter la commande rentrée par le joueur:
     * si il y a un second mot tapé, on identifie le personnage et déclenche l'affichage du script qui lui correspond. 
     * sinon affichage de messages d'erreur.
     * @param player le joueur
     * @param gui l'interface graphique
     * @return un message correspondant à la commande
     */
    public String execute(Player player,GameView gui){
        if(hasSecondWord()){
            NPCharacter character = GameControl.getGameModel().getCurrentRoom().getCharRoom().getChar(getSecondWord());
            if(character!=null){
                GameControl.getGameScenario().validGoal(character.getSpeechEvent());
                return character.getSpeech();
            }//if 
            else return "Il n'y a pas de personnage de ce nom dans cette pièce !";
        }//if 
        else return "Parler tout seul ?";
    }//execute()
}//TalkCommand