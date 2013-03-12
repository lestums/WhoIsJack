package pkg_game;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import pkg_game.pkg_room.*;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Class Player - Un joueur<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle gère la création et le statut d'un joueur du jeu<br>
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2011.11.28 Version finale
 */
public class Player
{
    private final int TAILLE_INVENTAIRE = 150;
    private ItemList inventaire;
    private Room currentPlayerRoom;
    private String nom_joueur;
    
    /**
     *  Constructeur : Initialise le joueur avec son nom et la salle courante
     */
    public Player(final Room currentRoom, String nom)
    {
        this.inventaire = new ItemList(TAILLE_INVENTAIRE);
        this.currentPlayerRoom = currentRoom;
        this.nom_joueur = nom;
    }//Player() 
    
    /**
     * Modificateur affectant la salle courante a la salle courante du joueur
     */
    public void setCurrentPlayerRoom(Room currentRoom)
    {
        this.currentPlayerRoom = currentRoom;
    }
    
    /**
     * Retourne l'objet représentant l'inventaire du joueur
     */
    public ItemList getObjectPlayer(){
        return this.inventaire;
    }
}//Player