package pkg_game;


/**
 * Programme <b>Who is Jack ?</b><br>
 * Class NPCharacter - Un personnage du jeu "Who is Jack"<br><br>
 * 
 * Cette classe fait partie du jeu "Who is jack ?"<br>
 * 
 * Cree un personnage du jeu, pouvant parler
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2010.10.30 Version 7.45.1
 */
public class NPCharacter
{
    private String aSpeech;
    private String aDescription;
    private String aName;
    private Event aSpeechEvent;
    
    /**
     * Constructeur : Cree un personnage
     */
    public NPCharacter(final String pDescription, final String pName, final String pSpeech, final Event pSpeechEvent)
    {
        this.aDescription = pDescription;
        this.aName = pName;
        this.aSpeech = pSpeech;
        this.aSpeechEvent = pSpeechEvent;
    }// NPCharacter()
    
    /**
     * Modificateur qui change le dialogue du personnage
     */
    public void setSpeech(final String pSpeech){
        this.aSpeech = pSpeech;
    }//setSpeech()
    
    /**
     * Modificateur qui défini l'evenement associé au dialogue avec ce personnage
     */
    public void setSpeechEvent(final Event evenement){
        this.aSpeechEvent = evenement;
    }//setSpeechEvent()
    
    /**
     * Accesseur : Récupère le nom du personnage
     */
    public String getName()
    {
        return this.aName;
    }//getName()
    
    /**
     * Accesseur : Récupère le dialogue
     */
    public String getSpeech()
    {
        return this.aSpeech;
    }//getSpeech()
    
    /**
     * Accesseur : Récupère l'evenement lié au dialogue
     */
    public Event getSpeechEvent()
    {   
        return this.aSpeechEvent;
    }//getSpeechEvent()
}//NPCharacter
