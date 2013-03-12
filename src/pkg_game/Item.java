package pkg_game;


/**
 * Who is Jack
 * 
 * Item class
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
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
    
    public int getPoids()
    {
        return this.aPoids;
    }
    
    public String getGatherString()
    {
        return this.textOnGather;
    }
    
    public String getUseString()
    {
        return this.textOnUse;
    }    
    
    public Event onGather()
    {
        return gatheringEvent;
    }
    
    public Event onUse()
    {
        return useEvent;
    }

    public String getDescription()
    {
        return this.aDescription;
    }  

    public String getName(){
        return this.aName;
    }//getName()
}//item