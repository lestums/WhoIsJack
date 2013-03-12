package  pkg_commandes;

/**
 * Who is Jack
 * 
 * CommandWord enum
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
 */
public enum CommandWord
{
 AIDE("aide"), INCONNU("?"), PRENDRE("prendre"), RETOUR("retour"), MANGER("manger"), REGARDER("regarder"), CREDITS("credits"),
 TEST("test"),CHARGER("charger"),DECLENCHER("declencher"), UTILISER("utiliser"), DEVERROUILLER("deverrouiller"), VERROUILLER("verrouiller"),
 ALLER("aller"), QUITTER("quitter"), DEPOSER("deposer"), ALEA("alea"), PARLER("parler");

    private String commandString;
     
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }//CommandWord()
    
    public String toString()
    {
        return commandString;
    }//toString()
}//CommandWord

