package pkg_game;


/**
 * Who is Jack
 * 
 * NPCharacter class
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
 */
public class NPCharacter
{
    private String aSpeech;
    private String aDescription;
    private String aName;
    private Event aSpeechEvent;
    
    public NPCharacter(final String pDescription, final String pName, final String pSpeech, final Event pSpeechEvent)
    {
        this.setDescription(pDescription);
        this.aName = pName;
        this.aSpeech = pSpeech;
        this.aSpeechEvent = pSpeechEvent;
    }// NPCharacter()
    
    public void setSpeech(final String pSpeech){
        this.aSpeech = pSpeech;
    }//setSpeech()
    
    public void setSpeechEvent(final Event evenement){
        this.aSpeechEvent = evenement;
    }//setSpeechEvent()
    
    public String getName()
    {
        return this.aName;
    }//getName()
    
    public String getSpeech()
    {
        return this.aSpeech;
    }//getSpeech()
    
    public Event getSpeechEvent()
    {   
        return this.aSpeechEvent;
    }//getSpeechEvent()

	public String getDescription() {
		return aDescription;
	}

	public void setDescription(String aDescription) {
		this.aDescription = aDescription;
	}
}//NPCharacter
