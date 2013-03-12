package  pkg_commandes;
//Import de classes
import java.util.Scanner;
import java.io.File;
import pkg_game.*;
import pkg_mvc.*;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Class TestCommand - Une commande du jeu<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle hérite de la classe abstraite Command. Elle permet d'effectuer des tests sur le jeu.
 * <br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2011.11.28 Version finale
 */
public class TestCommand extends Command
{
    /**
     *  Cette méthode vérifie que le joueur a bien tapé un second mot (représentant un nom de fichier '.txt').
     *  On crée un objet Scanner qui prend le fichier de test en paramètre. 
     *  Si le fichier existe, on récupère chaque ligne de commande grâce à la méthode nextLine() tant qu'une ligne suivante existe.
     *  Chaque commande étant exécutée par la méthode play().
     *  @param player le joueur
     *  @param gui l'interface graphique
     *  @return un message
     */
    public String execute(Player player,GameView gui){
        Scanner sr=null;
        String ligne;
        if(!(hasSecondWord())) {
            return "Attention ! Aucun nom de fichier n'a été saisi !";
        }//if
        else{
            try{
                sr = new Scanner( new File( (String)getSecondWord() ) );
            }//try
            catch(Throwable e){
              return "Le fichier n'existe pas ! (N'oubliez pas l'extension '.txt'du fichier)";
            }//catch
            while(sr.hasNextLine()){
                ligne = sr.nextLine();
                GameControl.play(ligne);
            }//while()
            sr.close();
            return "";
        }//else
    }//execute()
}//TestCommand
