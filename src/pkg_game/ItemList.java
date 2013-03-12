package pkg_game;

import java.util.HashMap;
import java.util.Set;

/**
 * Who is Jack
 * 
 * ItemList class
 * 
 * @author LE STUM S�bastien
 * @version 2013.03.11 V1.0
 */
public class ItemList
{
    private HashMap<String, Item> objectList;
    private int poidsCourant;
    private int poidsMax;
    
    public ItemList(final int pPoidsMax){
       this.poidsMax = pPoidsMax;
       this.objectList = new HashMap<String, Item>();
       this.poidsCourant = 0;
    }
    
    public boolean addItem(String pDescription,Item pObjet) 
    {
        if((poidsMax-poidsCourant)<pObjet.getPoids()){
            return false;
        } else {
            objectList.put(pDescription,pObjet);
            poidsCourant += pObjet.getPoids();
            return true;
        }
    }//addItem()
    
    public Item removeItem(String itemKey){
        if(objectList.containsKey(itemKey)){
           // Si itemKey se trouve bien dans objetRoom (Hashmap, map présentant les objets d'une pièce), on
           // récupère la valeur(Item) de la  clé itemKey puis supprime de objetRoom le couple <key,value>
           // avec la fonction remove()
           Item removedItem = objectList.remove(itemKey);
           poidsCourant -= removedItem.getPoids();
           return removedItem;
        }//if()
        return null;
    }// prendreItem()
   
    public HashMap<String,Item> getItemList(){
        return objectList;
    }
    
    public Item getItem(String item){
        return this.objectList.get(item);
    }
    
    public int getPoidsCourant(){
        return this.poidsCourant;
    }
   
    public int getPoidsMax(){
        return this.poidsMax;
    }
    
    public void setPoidsMax(final int poids){
        this.poidsMax = poids;
    }
    
    public String getObjectString(String Type)
    {
        String returnString = "Objets ";
        if(!(objectList.isEmpty())){
            Set<String> keys = objectList.keySet();

            if(Type.equals("Player")){
                returnString += "transport�s : \n";
                
            } else {
                returnString += "dans la pi�ce : \n";
            }
            
            for(String objet : keys){
                returnString += " - "+objet+": "+objectList.get(objet).getDescription()+ " qui p�se "+objectList.get(objet).getPoids()+" kg \n";
                
            }//for()
        } 
        else {
            if(Type.equals("Player")){
                returnString += "transport�s : vous ne poss�dez rien";
            } else {
                returnString += "dans la pi�ce : il n'y a aucun objet dans cette salle";
            }
        }   
        return returnString;
    }// getObjetString()
}//ItemList
