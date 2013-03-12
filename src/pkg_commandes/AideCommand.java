package  pkg_commandes;

import pkg_game.*;
import pkg_mvc.*;

/**
 * Who is Jack
 * 
 * Help command
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
 */
public class AideCommand extends Command
{

    public String execute(Player player,GameView gui)
    {
        return "Vos commandes sont :"+CommandWords.getCommandList();
    }   
}

