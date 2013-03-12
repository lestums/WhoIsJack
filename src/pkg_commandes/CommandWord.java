package  pkg_commandes;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Enum CommandWord - Rassemble les commandes utiles dans le jeu<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Enumération des commandes utilisables et liaison de chaque valeur a une String correspondant a<br>
 * l'entrée utilisateur<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2010.11.28 Version finale
 */
public enum CommandWord
{
 AIDE("aide"), INCONNU("?"), PRENDRE("prendre"), RETOUR("retour"), MANGER("manger"), REGARDER("regarder"), CREDITS("credits"),
 TEST("test"),CHARGER("charger"),DECLENCHER("declencher"), UTILISER("utiliser"), DEVERROUILLER("deverrouiller"), VERROUILLER("verrouiller"),
 ALLER("aller"), QUITTER("quitter"), DEPOSER("deposer"), ALEA("alea"), PARLER("parler");

    private String commandString;
     
    /**
     * Initialise avec le mot de commande associé
     * @param commandString la ligne de commande
     */
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }//CommandWord()
    
    /**
     * @return commandString ,le mot de commande associé au type énuméré
     */
    public String toString()
    {
        return commandString;
    }//toString()
}//CommandWord

