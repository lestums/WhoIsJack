package pkg_game;

import java.util.HashMap;
import java.util.Set;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Class ItemList - Une liste d'objets Item<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle permet la gestion d'une liste d'items inclus dans le jeu avec le poids courant des objets contenu dans la liste<br>
 * et le poids total supporté par la liste<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2011.11.28 Version finale
 */
public class ItemList
{
    private HashMap<String, Item> objectList;
    private int poidsCourant;
    private int poidsMax;
    
    /**
     * Construteur ItemList : Crée une liste d'item
     */
    public ItemList(final int pPoidsMax){
       this.poidsMax = pPoidsMax;
       this.objectList = new HashMap<String, Item>();
       this.poidsCourant = 0;
    }
    
    /**
     * Ajoute un objet dans la salle
     * @param pDescription Description de l'objet
     * @param pObjet Référence de l'item
     */
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
    
    /**
     * Supprime l'objet pris par le joueur dans la pièce courante
     * @return l'objet Item pris par le joueur s'il se trouve dans la Hasmap objetsRoom sinon retourne null
     * @param key(String) de l'objet à prendre
     */
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
   
    /**
     * Accesseur de la classe itemList qui retourne la liste des objec
     */
    public HashMap<String,Item> getItemList(){
        return objectList;
    }
    
    /**
     * Accesseur qui retourne l'objet stocké dans la liste
     * @param item Le nom de l'objet
     * @return L'objet / null si inexistant
     */
    public Item getItem(String item){
        return this.objectList.get(item);
    }
    
    /**
     * Accesseur qui retourne le poids courant de l'inventaire
     */
    public int getPoidsCourant(){
        return this.poidsCourant;
    }
    
    /**
     * Accesseur qui renvoie le poids maximum de l'inventaire
     */
    public int getPoidsMax(){
        return this.poidsMax;
    }
    
    /**
     * Modificateur de l'attribut poidsMax
     */
    public void setPoidsMax(final int poids){
        this.poidsMax = poids;
    }
    
    /**
     * Récupère tout les objets se trouvant dans la pièce courante
     * @return Objets présents dans la salle courante
     */
    public String getObjectString(String Type)
    {
        String returnString = "Objets ";
        if(!(objectList.isEmpty())){
            Set<String> keys = objectList.keySet();

            if(Type.equals("Player")){
                returnString += "transportés : \n";
                
            } else {
                returnString += "dans la pièce : \n";
            }
            
            for(String objet : keys){
                returnString += " - "+objet+": "+objectList.get(objet).getDescription()+ " qui pèse "+objectList.get(objet).getPoids()+" kg \n";
                
            }//for()
        } 
        else {
            if(Type.equals("Player")){
                returnString += "transportés : vous ne possédez rien";
            } else {
                returnString += "dans la pièce : il n'y a aucun objet dans cette salle";
            }
        }   
        return returnString;
    }// getObjetString()
}//ItemList
