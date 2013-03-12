package pkg_game.pkg_door;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Enum DoorSig - Un evenement du jeu<br><br>
 * 
 * Cet enum fait partie du jeu "Who is jack ?"<br>
 * 
 * Il permet de générer la liste des "signaux" renvoyés par une porte quand on l'utilise
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2010.10.30 Version 7.45.1
 */
public enum DoorSig
{
    WRONG_ITEM, UNLOCKED, ALREADY_UNLOCKED, LOCKED, ALREADY_LOCKED, CANUSE, TRAPDOOR;
}
