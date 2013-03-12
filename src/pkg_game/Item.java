package pkg_game;


/**
 * Programme <b>Who is Jack ?</b><br>
 * Class Item - Un objet du jeu<br><br>
 * 
 * Cette classe fait partie du jeu "Who is jack ?"<br>
 * 
 * Elle permet la gestion d'un objet avec son poids et son nom<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2010.10.30 Version 7.45.1
 */

public class Item
{
    private int aPoids;
    private String aDescription;
    private String aName;
    private Event gatheringEvent;
    private Event useEvent;
    private String textOnGather;
    private String textOnUse;
        
    /**
     * Constructeur naturel de la classe Item
     * @param int Poids de l'objet
     * @param String Description de l'objet
     */
    public Item(final int pPoids,final String pDescription,final String pName, final Event pGatheringEvent, final Event pUseEvent, final String pTextOnGather, final String pTextOnUse)
    {
        this.aPoids=pPoids;
        this.aDescription=pDescription;
        this.aName=pName;
        this.gatheringEvent = pGatheringEvent;
        this.useEvent = pUseEvent;
        this.textOnGather = pTextOnGather;
        this.textOnUse = pTextOnUse;
    }//Item()
    
    /**
     * Retourne le poids de l'objet courant
     * @return Poids de l'objet
     */
    public int getPoids()
    {
        return this.aPoids;
    }
    
    /**
     * Accesseur qui retourne le texte qui intervient quand on ramasse un objet
     */
    public String getGatherString()
    {
        return this.textOnGather;
    }
    
    /**
     * Accesseur qui retourne le texte qui intervient quand on utilise un objet
     */
    public String getUseString()
    {
        return this.textOnUse;
    }    
    
    /**
     * Fonction qui retourne l'evenement de ramassage lié a l'objet
     */
    public Event onGather()
    {
        return gatheringEvent;
    }
    
    /**
     * Fonction qui retourne l'evenement d'utilisation lié a l'objet
     */
    public Event onUse()
    {
        return useEvent;
    }

    /**
     * Retourne le poids de l'objet courant
     * @return Poids de l'objet
     */
    public String getDescription()
    {
        return this.aDescription;
    }  
    
    /**
     * @return le nom de l'objet
     */
    public String getName(){
        return this.aName;
    }//getName()
}//item