package  pkg_commandes;

import java.util.Scanner;
import java.io.File;
import pkg_game.*;
import pkg_mvc.*;

/**
 * Who is Jack
 * 
 * Test command class
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
 */
public class TestCommand extends Command
{
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
