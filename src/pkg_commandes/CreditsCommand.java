package  pkg_commandes;

import pkg_game.*;
import pkg_mvc.*;

/**
 * Who is Jack
 * 
 * Credits command class
 * 
 * @author LE STUM S�bastien
 * @version 2013.03.11 V1.0
 */
public class CreditsCommand extends Command
{
    public String execute(Player player,GameView gui){
        return "\n> Who's Jack ? < \n" + "Jeu concu pour le Projet JAVA de l'unit� PR3S02\n" + "ESIEE Engineering - I3S / Ann�e 2011-2012\n" + "\nEquipe 6s?\n"
               + "\n" + "D�veloppeurs :\n" + "     > TRAN Anthony\n" + "     > RAVELONANOSY Lova\n" + "     > LE STUM S�bastien\n" + "     > PEYTOUREAU Julie\n" + "\n"
               + "D�ssinateur des illustrations :\n" + "     > TRAN Anthony\n";
    }//execute()
}//CreditsCommands
