package  pkg_commandes;
//Import des classes
import pkg_game.*;
import pkg_mvc.*;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Class CreditsCommand - Une commande du jeu<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle hérite de la classe abstraite Command. Elle permet d'afficher le crédits du jeu<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2011.11.28 Version finale
 */
public class CreditsCommand extends Command
{
    /**
     *  Cette méthode affiche le crédit du jeu.
     *  @param player le joueur
     *  @param gui l'interface graphique
     *  @return un message
     */
    public String execute(Player player,GameView gui){
        return "\n> Who's Jack ? < \n" + "Jeu concu pour le Projet JAVA de l'unité PR3S02\n" + "ESIEE Engineering - I3S / Année 2011-2012\n" + "\nEquipe 6s?\n"
               + "\n" + "Développeurs :\n" + "     > TRAN Anthony\n" + "     > RAVELONANOSY Lova\n" + "     > LE STUM Sébastien\n" + "     > PEYTOUREAU Julie\n" + "\n"
               + "Déssinateur des illustrations :\n" + "     > TRAN Anthony\n";
    }//execute()
}//CreditsCommands
