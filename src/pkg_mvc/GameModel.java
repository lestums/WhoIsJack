package pkg_mvc;

import java.util.Observable;
import java.util.Stack;
import java.util.Set;
import java.util.HashMap;
import pkg_game.pkg_room.*;
import pkg_game.*;
import pkg_game.pkg_door.*;

/**
 * Who is Jack
 * 
 * GameModel class
 * 
 * @author LE STUM S�bastien
 * @version 2013.03.11 V1.0
 */
public class GameModel extends Observable
{
    private Room currentRoom;
    private Stack <Room> aChemin;
    private Player aPlayer;
    private int nbDeplacementRestant;
    private final String nameOfGame = "Who is Jack ?";
    private HashMap<String,Room> roomMap;
    private Room gare, librairie, rueGare, maisonJack, bureau, rueSombre, maisonClose, impasse, truands, hotel, maisonGinger, 
                 sallebain, egout_truand, egout_gare, egout_impasse, transportRoom;
    private Item carte, journal, magikcookie, dna_comparator, cle_transport;
    private Beamer beamer;
    private Door trapdoor;
    private Event statut;
    
    public GameModel()
    {
       aPlayer = new Player(currentRoom, "Anti-Jack");
       roomMap = new HashMap<String,Room>();
       nbDeplacementRestant = 80;
       createRooms();
       createItem();
       createChar();
    }//GameModel()
    
    private void createChar()
    {
        gare.getCharRoom().addChar("chefstat",new NPCharacter("Chef de Station","chefstat","Bonjour je suis le chef de station !",Event.NO_EVENT));
        truands.getCharRoom().addChar("truands",new NPCharacter("Truands","truands","Ahahahaahaha !!! Un bourge !!! Aller vide tes poches....",Event.GAME_OVER));
    }
    
    private void createItem()
    {
        //Crée les différents objets non essentiels du jeu
        journal = new Item(5,"Un journal : 'The London News'","journal",Event.HAVE_NEWSPAPER,Event.HAVE_NEWSPAPER,"Ramassé : Journal","Ceci est un simple journal, on y vois une des victimes de Jack");
        carte = new Item(10,"Une carte de Londres","carte",Event.NO_EVENT,Event.NO_EVENT,"Ramassé : Carte de Londres","Une carte de Londres très detaillée");
        magikcookie = new Item(0, "Un biscuit magique qui permet d'augmenter \n la taille de votre inventaire de 500","magikcookie",Event.NO_EVENT,Event.NO_EVENT,"Ramassé : Cookie Magique","Un délicieux cookie aux pouvoirs mystiques...\n Utilisez la commande manger pour le faire");
        dna_comparator = new Item(0, "Un comparateur ADN que vous avez ramenez avec vous.","adncomp",Event.NO_EVENT,Event.USED_DNA_COMPARATOR,"Ramassé : Comparateur ADN","Un comparateur d'ADN du XXIeme siècle");
        beamer = new Beamer(5,"Beamer qui permet, après avoir été chargé \n de se téléporter dans la salle sauvegardé","beamer");
        cle_transport = new Item(0, "Une petite clé jolie avec ecrit dessus : \n\tClé de la salle de transport","cletransport",Event.NO_EVENT,Event.USED_DNA_COMPARATOR,"Ramassé : Comparateur ADN","Une clé ne s'utilise pas comme ca...");
        //Place les différents objets dans les différentes pièces (initialisation)
        gare.getObjectRoom().addItem("magikcookie",magikcookie);
        librairie.getObjectRoom().addItem("carte",carte);
        librairie.getObjectRoom().addItem("journal",journal);
        gare.getObjectRoom().addItem("beamer",beamer);       
        aPlayer.getObjectPlayer().addItem("adncomp",dna_comparator);
        aPlayer.getObjectPlayer().addItem("cletransport",cle_transport);
    }
    
    private void createRooms()
    {
        gare = new Room("Gare de Londres", "dans la gare","gare",4,false);
        librairie = new Room("Librairie de la Gare","dans la librairie","librairie",4,false);
        rueGare = new Room("Grande Rue","dans la rue de la Gare","ruegare",4,false);
        maisonJack = new Room("Maison de l'enqueteur","dans la maison de Jack","jack",1,false);
        bureau = new Room("Bureau d'enquete de Londres","dans le bureau d'enquête","Bureau",4,false);
        rueSombre = new Room("Rue Sombre","dans la rue Sombre","ruesombre",4,false);
        maisonClose= new Room("Maison Close","dans la maison Close","maisonclose",4,false);
        impasse= new Room("Impasse","dans l'Impasse","impasse",4,false);
        truands= new Room("Un endroit reculé","chez les truands","truand",4,false);
        hotel= new Room("Hotel miteux","dans la chambre d'hôtel","hotel",4,false);
        maisonGinger= new Room("Maison de Ginger","chez Ginger","ginger",1,false);
        sallebain= new Room("Salle de bain","dans la salle de bain","SDB",4,false);
        egout_truand = new Room("Egouts de Londres","dans les égouts en dessous de chez les truands","egout2",1,false);
        egout_gare = new Room("Egouts de Londres","dans les égouts en dessous de la gare","egout3",1,false);
        egout_impasse = new Room("Egouts de Londres","dans les égouts en dessous de l'Impasse","egout1",1,false);
        transportRoom = new TransporterRoom("dans la piece de télétransport","transporterroom",1,true);
        
        // Crée les differentes portes
        trapdoor = new TrapDoor("MASTERKEY",false,truands);
        Door porte_transport = new CommonDoor("cletransport",true) ;      
        // initialise les sorties de chaque pièce
        gare.setExits("Est",rueGare,new CommonDoor("MASTERKEY",false));
        gare.setExits("Sud",librairie,new CommonDoor("MASTERKEY",false));
        gare.setExits("en-bas",egout_gare,new CommonDoor("MASTERKEY",false));
        gare.setExits("Nord",transportRoom,porte_transport);
        
        librairie.setExits("Nord",gare,new CommonDoor("MASTERKEY",false));
        
        rueGare.setExits("Nord",bureau,new CommonDoor("MASTERKEY",false));
        rueGare.setExits("Sud",maisonJack,new CommonDoor("MASTERKEY",false));
        rueGare.setExits("Est",rueSombre,new CommonDoor("MASTERKEY",false));
        rueGare.setExits("Ouest",gare,new CommonDoor("MASTERKEY",false));
        
        maisonJack.setExits("Nord",rueGare,new CommonDoor("MASTERKEY",false));
        
        bureau.setExits("Sud",rueGare,new CommonDoor("MASTERKEY",false));
        
        rueSombre.setExits("Nord-Ouest",maisonClose,new CommonDoor("MASTERKEY",false));
        rueSombre.setExits("Nord-Est",impasse,new CommonDoor("MASTERKEY",false));
        rueSombre.setExits("Sud-Ouest",hotel,new CommonDoor("MASTERKEY",false));
        rueSombre.setExits("Sud-Est",truands,new CommonDoor("MASTERKEY",false));
        rueSombre.setExits("Est",maisonGinger,new CommonDoor("MASTERKEY",false));
        rueSombre.setExits("Ouest",rueGare,new CommonDoor("MASTERKEY",false));
        
        maisonClose.setExits("Sud",rueSombre,new CommonDoor("MASTERKEY",false));
        
        impasse.setExits("Sud",rueSombre,new CommonDoor("MASTERKEY",false));
        impasse.setExits("en-bas",egout_impasse,new CommonDoor("MASTERKEY",false));
        
        truands.setExits("Nord",rueSombre,trapdoor);
        truands.setExits("en-bas",egout_truand,trapdoor);
        
        hotel.setExits("Nord",rueSombre,new CommonDoor("MASTERKEY",false));
        
        maisonGinger.setExits("Ouest",rueSombre,new CommonDoor("MASTERKEY",false));
        
        maisonJack.setExits("en-haut",sallebain,new CommonDoor("MASTERKEY",false));
        
        sallebain.setExits("en-bas",maisonJack,new CommonDoor("MASTERKEY",false));
        
        egout_gare.setExits("en-haut",gare,new CommonDoor("MASTERKEY",false));
        egout_gare.setExits("Est",egout_truand,new CommonDoor("MASTERKEY",false));
        egout_gare.setExits("Nord",egout_impasse,new CommonDoor("MASTERKEY",false));
        
        egout_impasse.setExits("en-haut",impasse,new CommonDoor("MASTERKEY",false));
        egout_impasse.setExits("Ouest",egout_gare,new CommonDoor("MASTERKEY",false));
        egout_impasse.setExits("Est",egout_truand,new CommonDoor("MASTERKEY",false));
        
        egout_truand.setExits("en-haut",truands,trapdoor);
        egout_truand.setExits("Est",egout_gare,new CommonDoor("MASTERKEY",false));
        egout_truand.setExits("Nord",egout_impasse,new CommonDoor("MASTERKEY",false));
        
        transportRoom.setExits("Sud",gare,porte_transport);     
        
        //Création d'une hashmap des rooms
        roomMap.put("gare",gare);
        roomMap.put("librairie",librairie);
        roomMap.put("rueGare",rueGare);
        roomMap.put("maisonJack",maisonJack);
        roomMap.put("bureau",bureau);
        roomMap.put("rueSombre",rueSombre);
        roomMap.put("maisonClose",maisonClose);
        roomMap.put("impasse",impasse);
        roomMap.put("truands",truands);
        roomMap.put("hotel",hotel);
        roomMap.put("maisonGinger",maisonGinger);
        roomMap.put("sallebain",sallebain);
        roomMap.put("egout_truand",egout_truand);
        roomMap.put("egout_gare",egout_gare);
        roomMap.put("egout_impasse",egout_impasse);
        roomMap.put("transport_room",transportRoom);
        
        //Initialise la pièce courante : on démarre le jeu à la gare
        currentRoom = gare;
        
        //Crée un pile(mémoire) afin de stocker les différentes pièces parcourues par le joueur. Elle est utlisé par la commance back pour que le joueur retrouve son chemin
        aChemin = new Stack<Room>();
    }//createRooms()
    
    public Room getCurrentRoom()
    {
        return currentRoom;
    }//getCurrentRoom()
   
    public Stack<Room> getChemin()
    {
        return aChemin;
    }//getChemin()
   
    public Event getStatut()
    {
        return this.statut;
    }
    
    public void setStatut(Event evenement)
    {
        this.statut = evenement;
    }
    
    public Room getRoom(String nomRoom)
    {
        return roomMap.get(nomRoom);
    }
    
    public Set<String> getSetRoom()
    {
        return roomMap.keySet();
    }
    
    public int getNbDeplacement(){
        return nbDeplacementRestant;
    }
    
    public void gotoRoom(Room nextRoom)
    {
        currentRoom = nextRoom;
        aPlayer.setCurrentPlayerRoom(nextRoom);
        nbDeplacementRestant -= 1;
        setChanged();
        notifyObservers();
    }//gotoRoom()
    
    public void gotoRoomMovingChar(NPMovingChar movingChar)
    {
         movingChar.moveChar(currentRoom);
    }
   
    public String getWelcomeString()
    {
        return "Bienvenue dans Who is Jack !\n\nVous vous retrouvez projeté dans le XIXème siècle, dans la peau d'un enqueteur renommé\n" +
               "\nAprès un long voyage en train, vous arrivez à Londres, là ou sévit " +
               "\nle légendaire Jack l'éventreur ! \n(Tapez 'aide' pour avoir la liste des commandes)";
    }//getWelcomeString()
    
    public String getGoodByeString()
    {
        return "Merci d'avoir joué ! A bientot ! =)";
    }//getGoodByeString()
    
    public String getNameOfGame()
    {
        return nameOfGame;
    }//getGoodByeString()
    
    public String getLongDescription() {
        return "\nVous êtes " + currentRoom.getShortDescription() + "\n" + "Il vous reste plus que "+nbDeplacementRestant + " déplacements\n"+
                currentRoom.getExitString() + "\n" + currentRoom.getCharRoom().getCharsString();
    }//getLongDescription()
    
    public Player getPlayer(){
       return this.aPlayer;
    }// getPlayer()
}//GameModel
