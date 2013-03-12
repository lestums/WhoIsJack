package  pkg_commandes;
//Import des classes
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Class Parser - Parse la ligne d'entrée<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle permet de récuperer la saisie entrée par l'utilisateur et
 * la traite pour qu'elle soit utilisable<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2010.11.28 Version finale
 */


public class Parser 
{
    private CommandWords commands;

    /**
     * Constructeur : Crée un parseur qui est une ligne de commande
     */
    public Parser() 
    {
        commands = new CommandWords();
    }//Parser()

    /**
     * Découpe la ligne de commande en 2 mots et génère l'objet associé
     * @return command qui est entrée par l'utilisateur
     */
    public Command getCommand(String inputLine) 
    {
        String[] words = new String[3];
        int i=0;
        StringTokenizer tokenizer = new StringTokenizer(inputLine);
        while(tokenizer.hasMoreTokens() && i<3){
            words[i] = tokenizer.nextToken();
            i++;
        }

        Command command = commands.getCommand(words[0]);

        if(command != null) {
            command.setSecondWord(words[1],words[2]);
        }
        return command;
    }//getCommand()
    
    /**
     * Affiche une liste des commandes valides
     * @return une String
     */
    public String showCommands()
    {
        return commands.getCommandList();
    }//showCommands()
    
}//Parser