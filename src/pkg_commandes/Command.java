package  pkg_commandes;
//Import de classes
import pkg_game.*;
import pkg_mvc.*;
/**
 * Programme <b>Who is Jack ?</b><br>
 * Class Command - Une ligne de commande du jeu "Who is jack ?"<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle permet de réaliser un traitement sur les deuxième et troisième mots de la ligne de commande.<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2010.11.28 Version finale
 */

public abstract class Command
{
    private String secondWord=null;
    private String thirdWord = null;

     /**
     * Méthode qui modifie les deux attributs par des valeurs en paramètre
     * @param secondWord et thirdWord les deux mots tapés qui suivent une commande
     */
    public void setSecondWord(String secondWord, String thirdWord)
    {
        this.secondWord = secondWord;
        this.thirdWord = thirdWord;
    }//setSecondWord()

    /**
     * @return Le second mot de la ligne parsée. Retourne null si il n'y en a pas
     */
    public String getSecondWord()
    {
        return secondWord;
    }//getSecondWord()

    /**
     * @return true si la commande a un deuxieme mot de commande
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }//hasSecondWord()
    
    /**
     * @return Le second mot de la ligne parsée. Retourne null si il n'y en a pas
     */
    public String getThirdWord()
    {
        return thirdWord;
    }//getSecondWord()

    /**
     * @return true si la commande a un deuxieme mot de commande
     */
    public boolean hasThirdWord()
    {
        return (thirdWord != null);
    }//hasSecondWord()
    
    /**
     * Méthode abstraite qui permet d'exécuter la commande rentrée par le joueur
     * @param player le joueur
     * @param gui l'interface graphique
     * @return un message correspondant à la commande
     */
    public abstract String execute(Player player,GameView gui);
}//Command
