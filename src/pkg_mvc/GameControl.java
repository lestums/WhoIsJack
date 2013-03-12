package pkg_mvc;
//Import de classe
import java.util.Observable;
import java.util.Observer;
import pkg_commandes.*;
import pkg_mvc.*;
import pkg_game.*;
import java.awt.Container;
import javax.swing.JOptionPane;

/**
 * Programme <b>Who is Jack ?</b><br>
 * Class GameControl - Le controleur du jeu "Who is jack ?"<br><br>
 * 
 * Cette classe fait parti du jeu "Who is Jack ?"<br>
 * 
 * Elle représente la partie "Controleur" du design pattern MVC.<br>
 * Elle assure le controle et le lien entre la partie "Vue" et la partie "Modèle" en s'assurant
 * que la partie "Vue" soit toujours synchrone avec la partie "Modèle"
 * 
 * @author TRAN Anthony - RAVELONANOSY Lova - LE STUM Sébastien - PEYTOUREAU Julie
 * @version 2011.11.28 Version finale
 */
public class GameControl extends Observable
{
    //Attributs
    private static Parser parser;
    private static GameView gui;
    private static GameModel gameModel;
    private static GameScenario gameScenario;
    
    /**
     * Constructeur : Crée le jeu et initialise la carte interne
     */
    public GameControl(Container Cont) 
    {
        gameModel = new GameModel();
        gui = new GameView(gameModel,Cont);
        gui.showImage(gameModel.getCurrentRoom().getImageName());
        gui.printWelcome();
        gameScenario = new GameScenario();
        gameModel.addObserver(gui);
        parser = new Parser();
    }//Game()
    
    /**
     * Accesseur : Retourne le GameView lié au jeu
     */
    public static GameView getGameView()
    {
        return gui;
    }
    
    /**
     * Accesseur : Retourne le GameModel lié au jeu
     */
    public static GameModel getGameModel()
    {
        return gameModel;
    }
    
    /**
     * Accesseur : Retourne le GameScénario lié au jeu
     */
    public static GameScenario getGameScenario()
    {
        return gameScenario;
    }
    
    /**
     * Procédure qui effectue les vérification sur les déplacements, le statut de jeu, puis execute une commande
     * @param command La commande entrée par l'utilisateur
     */
    
    public static void play(String commandLine) 
    {            
        Command command = parser.getCommand(commandLine);
        GameControl.getGameScenario().checkScenario();
        if(gameModel.getNbDeplacement() == 0){
                gameModel.setStatut(Event.GAME_OVER);
        }
        
        if(GameControl.getGameScenario().endOfGame() == 0){ 
            if(command == null) {
                gui.display_message("Erreur","Commande incorrecte !",JOptionPane.ERROR_MESSAGE);
            } else {
                String message = command.execute(gameModel.getPlayer(),gui);
                gui.display_message("",message,JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            if(GameControl.getGameScenario().endOfGame() == -1)
                gui.display_message("Fin du jeu", "Fin du jeu ! Vous etes mort",JOptionPane.ERROR_MESSAGE);
            else
                gui.display_message("Victoire !","Bravo ! vous avez gagné !",JOptionPane.INFORMATION_MESSAGE);
        }
        gui.update_lists_labels();
    }
    
}//GameControl