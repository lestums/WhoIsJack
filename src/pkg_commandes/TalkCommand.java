package pkg_commandes;

import pkg_game.*;
import pkg_mvc.GameControl;
import pkg_mvc.GameView;
/**
 * Who is Jack
 * 
 * Talk command class
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
 */
public class TalkCommand extends Command
{
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