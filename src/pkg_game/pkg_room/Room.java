package pkg_game.pkg_room;

import java.util.HashMap;
import java.util.Set;
import pkg_game.pkg_door.*;
import pkg_game.*;
import pkg_mvc.*;

/**
 * Who is Jack
 * 
 * Room class
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
 */

public class Room 
{
    private String nomSalle;
    private String description;
    private HashMap<String, Room> exits;
    private HashMap<String, Door> doors;
    private String imageName;
    private int nbImage;
    private ItemList objectRoom;
    private CharList charRoom;
    private boolean aTransport;
    
    public Room(String pNomSalle,String description, String image,int pNbImage, boolean pTransport) 
    {
        this.nomSalle = pNomSalle;
        this.description = description;
        exits = new HashMap<String, Room>();
        doors = new HashMap<String, Door>();
        this.charRoom = new CharList();
        this.objectRoom = new ItemList(9999);
        this.imageName = image;
        this.nbImage = pNbImage;
        this.setTransport(pTransport);
    }//Room()

    public void setExits(String direction, Room neighbor, Door door) 
    {
        exits.put(direction, neighbor);
        doors.put(direction, door);
    }//setExit()
    
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }// getExit()
    
    public ItemList getObjectRoom()
    {
        return this.objectRoom;
    }
    
    public String getName()
    {
        return this.nomSalle;
    }
   
    public CharList getCharRoom()
    {
        return this.charRoom;
    }
    
    public HashMap<String,Door> getDoorMap()
    {
        return doors;    
    }
    
    public Door getDoor(String doorname)
    {
        return doors.get(doorname);
    }
    
    public String getExitString()
    {
        StringBuilder vString = new StringBuilder(128);
        vString.append("Sorties existantes : ");
        Set<String> keys = exits.keySet();
        for(String exit : keys){
            vString.append(exit + ", ");
        }//for()    
        return vString.toString();
    }//getExitString()
    
    public String getShortDescription()
    {
        return description;
    }//getShortDescription()
    
    public String getImageName()
    {
        String imageM = "img/"+imageName;
        if(nbImage == 1){
            imageM+=".jpg";
            return imageM;
        }
        else{
            if(GameControl.getGameModel().getNbDeplacement()%12<=3) imageM+="_matin.jpg";
            else if(GameControl.getGameModel().getNbDeplacement()%12>3 && GameControl.getGameModel().getNbDeplacement()%12<=6) imageM+="_jour.jpg";
            else if(GameControl.getGameModel().getNbDeplacement()%12>6 && GameControl.getGameModel().getNbDeplacement()%12<=9) imageM+="_soir.jpg";
            else imageM+="_nuit.jpg";

            return imageM;
        }
    } //getImageName() 

	public boolean isTransport() {
		return aTransport;
	}

	public void setTransport(boolean aTransport) {
		this.aTransport = aTransport;
	}

}
