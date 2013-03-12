package  pkg_commandes;

import pkg_game.*;
import pkg_mvc.*;

/**
 * Who is Jack
 * 
 * Command abstract class
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
 */
public abstract class Command
{
    private String secondWord=null;
    private String thirdWord = null;

    public void setSecondWord(String secondWord, String thirdWord)
    {
        this.secondWord = secondWord;
        this.thirdWord = thirdWord;
    }//setSecondWord()

    public String getSecondWord()
    {
        return secondWord;
    }//getSecondWord()

    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }//hasSecondWord()
    
    public String getThirdWord()
    {
        return thirdWord;
    }//getSecondWord()

    public boolean hasThirdWord()
    {
        return (thirdWord != null);
    }//hasSecondWord()
    
    public abstract String execute(Player player,GameView gui);
}//Command
