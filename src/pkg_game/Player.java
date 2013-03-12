package pkg_game;

import pkg_game.pkg_room.*;

/**
 * Who is Jack
 * 
 * Player class
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
 */
public class Player
{
    private final int TAILLE_INVENTAIRE = 150;
    private ItemList inventaire;
    private Room currentPlayerRoom;
    private String nom_joueur;
    
    public Player(final Room currentRoom, String nom)
    {
        this.inventaire = new ItemList(TAILLE_INVENTAIRE);
        this.currentPlayerRoom = currentRoom;
        this.setNomJoueur(nom);
    }//Player() 
    
    public void setCurrentPlayerRoom(Room currentRoom)
    {
        this.currentPlayerRoom = currentRoom;
    }
    
    public Room getCurrentPlayerRoom(Room currentRoom)
    {
        return this.currentPlayerRoom;
    }
    
    public ItemList getObjectPlayer(){
        return this.inventaire;
    }

	public String getNomJoueur() {
		return nom_joueur;
	}

	public void setNomJoueur(String nom_joueur) {
		this.nom_joueur = nom_joueur;
	}
}//Player