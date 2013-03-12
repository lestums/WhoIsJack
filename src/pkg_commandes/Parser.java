package  pkg_commandes;
import java.util.StringTokenizer;

/**
 * Who is Jack
 * 
 * Parser class
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
 */

public class Parser 
{
    private CommandWords commands;

    public Parser() 
    {
        commands = new CommandWords();
    }//Parser()

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
    
    public String showCommands()
    {
        return CommandWords.getCommandList();
    }//showCommands()
    
}//Parser