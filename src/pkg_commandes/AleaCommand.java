package  pkg_commandes;

import pkg_mvc.*;
import pkg_game.*;
import pkg_game.pkg_room.*;

/**
 * Who is Jack
 * 
 * Alea command
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
 */
public class AleaCommand extends Command
{
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