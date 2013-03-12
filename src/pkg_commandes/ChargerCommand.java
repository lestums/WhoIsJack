package  pkg_commandes;

import pkg_game.*;
import pkg_mvc.*;

/**
 * Who is Jack
 * 
 * Charge command
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
 */
public class ChargerCommand extends Command{
    
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