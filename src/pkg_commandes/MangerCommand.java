package  pkg_commandes;
//Import de classes
import pkg_game.*;
import pkg_mvc.*;

/**
 * Who is Jack
 * 
 * Manger command class
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
 */
public class MangerCommand extends Command
{
    public String execute(Player player,GameView gui){
        ItemList list=GameControl.getGameModel().getPlayer().getObjectPlayer();
        if (list.getItemList().containsKey(getSecondWord())){
            Item eatBiscuit = list.removeItem(getSecondWord());
            if(eatBiscuit != null && eatBiscuit.getName() == "magikcookie"){
                list.setPoidsMax(9999);
                return "Vous avez manger le biscuit magique ! Vous pouvez porter plus d'objets !";
            }//if 
            else  return "Problème avec le biscuit ! Il a pas l'air bon :(";
        }//if 
        else   return "Vous ne pouvez pas manger sans biscuit ! >___<";
    }//execute()
}//MangerCommand
