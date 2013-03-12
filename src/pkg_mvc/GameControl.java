package pkg_mvc;

import java.util.Observable;
import pkg_commandes.*;
import pkg_game.*;
import java.awt.Container;
import javax.swing.JOptionPane;

/**
 * Who is Jack
 * 
 * GameControl class
 * 
 * @author LE STUM Sébastien
 * @version 2013.03.11 V1.0
 */
public class GameControl extends Observable
{
    //Attributs
    private static Parser parser;
    private static GameView gui;
    private static GameModel gameModel;
    private static GameScenario gameScenario;
    
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
    
    public static GameView getGameView()
    {
        return gui;
    }
    
    public static GameModel getGameModel()
    {
        return gameModel;
    }
    
    public static GameScenario getGameScenario()
    {
        return gameScenario;
    }
    
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