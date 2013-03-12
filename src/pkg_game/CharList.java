package pkg_game;

import java.util.HashMap;
import java.util.Set;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Class CharList - Une liste de personnages<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle permet la gestion d'une liste de personnages inclus dans le jeu<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2011.11.28 Version finale
 */
public class CharList
{
    private HashMap<String, NPCharacter> charList;
    
    /**
     * Construteur ItemList : Crée une liste d'item
     */
    public CharList(){
       this.charList = new HashMap<String, NPCharacter>();
    }
    
    /**
     * Ajoute un objet dans la salle
     * @param pDescription Description de l'objet
     * @param pObjet Référence de l'item
     */
    public void addChar(String pDescription,NPCharacter pObjet) 
    {
        charList.put(pDescription,pObjet);
    }//addItem()
    
    /**
     * Supprime l'objet pris par le joueur dans la pièce courante
     * @return l'objet Item pris par le joueur s'il se trouve dans la Hasmap objetsRoom sinon retourne null
     * @param key(String) de l'objet à prendre
     */
    public NPCharacter removeItem(String itemKey){
        if(charList.containsKey(itemKey)){
           // Si itemKey se trouve bien dans objetRoom (Hashmap, map présentant les objets d'une pièce), on
           // récupère la valeur(Item) de la  clé itemKey puis supprime de objetRoom le couple <key,value>
           // avec la fonction remove()
           NPCharacter removedCharacter = charList.remove(itemKey);
           return removedCharacter;
        }//if()
        return null;
    }// prendreItem()
   
    /**
     * Accesseur de la classe itemList qui retourne la liste des objec
     */
    public HashMap<String,NPCharacter> getCharList(){
        return this.charList;
    }
    
    /**
     * Accesseur qui retourne le personnage 'item' dans la liste
     * @param item Le nom du personnage recherché
     */
    public NPCharacter getChar(String item){
        return this.charList.get(item);
    }
    
    /**
     * Récupère tout les objets se trouvant dans la pièce courante
     * @return Objets présents dans la salle courante
     */
    public String getCharsString()
    {
        String returnString = "Personnages : ";
        if(!(charList.isEmpty())){
            Set<String> keys = charList.keySet();            
            for(String objet : keys){
                returnString += objet + ",";           
            }//for()
        } 
        else {
            returnString += "Il n'y a personne dans cette salle !";
        }   
        return returnString;
    }// getObjetString()
}
