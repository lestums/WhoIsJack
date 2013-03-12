package pkg_game.pkg_room;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import pkg_game.pkg_door.*;
import pkg_game.*;
import pkg_mvc.*;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Class Room - Une salle du jeu "Who is jack ?"<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle permet de créer une salle avec ses differentes sorties et une longue description ainsi que
 * les objets associés.<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2011.11.28 Version finale
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
    
    /**
     * Construteur Room : Crée une Room ayant "description" comme description. Par défaut une Room n'a pas de sortie.
     * Une image est egalement associé a cette salle
     * 
     * @param description Description de la salle
     * @param image Chemin d'acces a l'image liée a la salle
     */
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
        this.aTransport = pTransport;
    }//Room()

    /**
     * Défini les sorties disponibles pour une salle
     * @param direction Direction de la salle voisine
     * @param neighbor Référence de la salle voisine
     */
    public void setExits(String direction, Room neighbor, Door door) 
    {
        exits.put(direction, neighbor);
        doors.put(direction, door);
    }//setExit()
        
    /**
     * @return La sortie de la salle courante dans la direction précisée
     * @param direction Direction entrée par le joueur
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }// getExit()
    
    /**
     * Accesseur qui retourne la liste des objets contenus dans la salle
     */
    public ItemList getObjectRoom()
    {
        return this.objectRoom;
    }
    
    /**
     * Accesseur qui retourne le nom de la salle
     */
    public String getName()
    {
        return this.nomSalle;
    }
    
    /**
     * Accesseur qui retourne la liste des personnages présents dans la salle
     */
    public CharList getCharRoom()
    {
        return this.charRoom;
    }
    
    /**
     * Accesseur qui retourne la Map des portes contenues dans la salle
     */
    public HashMap<String,Door> getDoorMap()
    {
        return doors;    
    }
    
    /**
     * Accesseur qui retourne la porte dans la direction demandée
     * @param doorname Nom de la direction présentant une door
     */
    public Door getDoor(String doorname)
    {
        return doors.get(doorname);
    }
    
    /**
     * Récupère toutes les sorties de la pièce courante
     * @return Sorties disponibles pour la salle courante
     */
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
       
    /**
     * Accesseur - attribut description
     * @return Description de la salle courante
     */
    public String getShortDescription()
    {
        return description;
    }//getShortDescription()
    
    /**
     * Accesseur - attribut imageName
     * @return Nom de l'image
     */
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

}
