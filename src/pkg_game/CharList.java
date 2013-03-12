package pkg_game;

import java.util.HashMap;
import java.util.Set;

/**
 * Who is Jack
 * 
 * CharList class
 * 
 * @author LE STUM S�bastien
 * @version 2013.03.11 V1.0
 */
public class CharList
{
    private HashMap<String, NPCharacter> charList;
    
    public CharList(){
       this.charList = new HashMap<String, NPCharacter>();
    }
    
    public void addChar(String pDescription,NPCharacter pObjet) 
    {
        charList.put(pDescription,pObjet);
    }//addItem()
    
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
   
    public HashMap<String,NPCharacter> getCharList(){
        return this.charList;
    }
    
    public NPCharacter getChar(String item){
        return this.charList.get(item);
    }
    
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
