package  pkg_commandes;

import pkg_game.*;
import pkg_mvc.*;

/**
 * Who is Jack
 * 
 * Quit command class
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
 */
public class QuitCommand extends Command
{
    public String execute(Player player,GameView gui){
        gui.killFrame();
        return "";
    }//execute()
}//QuitCommand
