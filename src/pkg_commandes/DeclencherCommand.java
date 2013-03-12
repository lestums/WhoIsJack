package  pkg_commandes;
//Import des classes
import pkg_game.*;
import pkg_mvc.*;

/**
 * Who is Jack
 * 
 * Declencher command class
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
 */
public class DeclencherCommand extends Command
{
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
