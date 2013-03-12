package  pkg_commandes;
//Import de classes
import pkg_game.*;
import pkg_mvc.*;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Class MangerCommand - Une commande du jeu<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle hérite de la classe abstraite Command. Elle permet de manger un objet(magikcookie)<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2011.11.28 Version finale
 */
public class MangerCommand extends Command
{
    /**
     *  Cette méthode permet d'agrandir les capacité du joueur à emporter des objets.
     *  On vérifie si l'objet magikcookie(deuxième mot) est bien dans la hashmap du joueur, si c'set bien le cas 
     *  on le supprime de la hashmap avec removeItem() et on agrandit les capacités du joueur à emporter des objets
     *  grâce à la méthode setPoidsMax().
     *  Sinon on retourne un message d'erreur.
     *  @param player le joueur
     *  @param gui l'interface graphique
     *  @return un message
     */
    public String execute(Player player,GameView gui){
        ItemList list=GameControl.getGameModel().getPlayer().getObjectPlayer();
        if (list.getItemList().containsKey(getSecondWord())){
            Item eatBiscuit = list.removeItem(getSecondWord());
            if(eatBiscuit != null && eatBiscuit.getName() == "magikcookie"){
                list.setPoidsMax(9999);
                return "Vous avez manger le biscuit magique ! Vous pouvez porter plus d'objets !";
            }//if 
            else  return "Problème avec le biscuit ! Il a pas l'air bon :(";
        }//if 
        else   return "Vous ne pouvez pas manger sans biscuit ! >___<";
    }//execute()
}//MangerCommand
