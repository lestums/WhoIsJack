package  pkg_commandes;
//Import de classe
import java.util.HashMap;
import java.lang.StringBuilder;


/**
 * Programme <b>Who is Jack ?</b><br>
 * Class CommandWords - Mots d'une ligne de commande<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle permet de recuperer la ligne de commande entrée par l'utilisateur et
 * de tester si elle est valide<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2010.11.28 Version finale
 */

public class CommandWords
{
    private HashMap<CommandWord, Command> validCommands;
    private HashMap<String, CommandWord> validCommandWords;
    
    /**
     * Constructeur : Etabli la HashMap des commandes valides a partir des types énumérés
     */
    public CommandWords()
    {
        validCommands = new HashMap<CommandWord, Command>();
        validCommands.put(CommandWord.AIDE, new AideCommand());
        validCommands.put(CommandWord.ALLER, new AllerCommand());
        validCommands.put(CommandWord.PRENDRE, new PrendreCommand());
        validCommands.put(CommandWord.DEPOSER, new DeposerCommand());
        validCommands.put(CommandWord.RETOUR, new BackCommand());
        validCommands.put(CommandWord.CHARGER, new ChargerCommand());
        validCommands.put(CommandWord.DECLENCHER, new DeclencherCommand());
        validCommands.put(CommandWord.UTILISER, new UtilCommand());     
        validCommands.put(CommandWord.DEVERROUILLER, new DevCommand());
        validCommands.put(CommandWord.VERROUILLER, new VerCommand());  
        validCommands.put(CommandWord.ALEA, new AleaCommand());
        validCommands.put(CommandWord.QUITTER, new QuitCommand());
        validCommands.put(CommandWord.TEST, new TestCommand());
        validCommands.put(CommandWord.MANGER, new MangerCommand());
        validCommands.put(CommandWord.CREDITS, new CreditsCommand());
        validCommands.put(CommandWord.PARLER, new TalkCommand());
        validCommands.put(CommandWord.REGARDER, new LookCommand());
        
        validCommandWords = new HashMap<String, CommandWord>();
        for(CommandWord command : CommandWord.values()) {
            if(command != CommandWord.INCONNU) {
                validCommandWords.put(command.toString(), command);
            }//if
        }//for
    }//CommandWords()
    
   /**
     * Accesseur qui vérifie si la commande existe dans la HashMap
     * @param commandWord la commande à vérifier
     * @erturn la commande validée
     */
    public Command getCommand(String commandWord)
    {
        return validCommands.get(getCommandWord(commandWord));
    }//getCommand()
    
    /**
     * Fonction qui retourne le mot de commande lié au mot fourni en parametre
     * @param commandWord Chaine de caractère de la commande voulue
     * @return La variable ENUM correspondant au mot
     */
    private CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommandWords.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.INCONNU;
        }
    }//getCommandWord()
    
    /**
     * Verifie si la chaine de caractère est un parametre valide
     * @param aString chaine de caractere a tester
     * @return true si la commande existe sinon false
     */
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }//isCommand()
    
    /**
     * @return Liste des commandes disponibles sous forme de String
     */
    public static String getCommandList()
    {
        StringBuilder vString = new StringBuilder(256);
        for(CommandWord command : CommandWord.values()) {
            vString.append(command.toString() + " - ");
        }//for
        return vString.toString();
    }//getCommandList()
}//CommandWords