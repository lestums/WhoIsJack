package pkg_mvc;

import pkg_game.Event;
import pkg_game.NPCharacter;
import pkg_game.Item;
import pkg_game.pkg_door.*;
import java.util.HashMap;

/**
 * Who is Jack
 * 
 * GameScenario class
 * 
 * @author LE STUM S�bastien
 * @version 2013.03.11 V1.0
 */
public class GameScenario
{
    private GameModel gameModel;

    private Item journalintime;
    private Item collier;
    private Item chapeau;
    private Item cheveu1;
    private Item cheveu2;
    
    private HashMap<Event,Boolean> objectives;
    
    private boolean condition1;
    private boolean condition2;
    private boolean condition3;
    private boolean condition4;
    private boolean condition5;
    private boolean condition6;
    private boolean condition7;
    private boolean condition8;
    
    public GameScenario()
    {
        objectives = new HashMap<Event, Boolean>();
        for(Event evenement : Event.values()){
            if((evenement == Event.GAME_OVER || evenement == Event.NO_EVENT || evenement == Event.CONGRATULATION))
                continue;
            else {
                objectives.put(evenement,false);
            }
        }
        gameModel = GameControl.getGameModel();
        initGameScenario();
    }
    
    public void initGameScenario()
    {
        NPCharacter jack = new NPCharacter("Enqueteur","enqueteur","Bonjour, d�sol� mais ce n'est pas un endroit pour vous... \n Nous sommes occup�s...",Event.NO_EVENT);
        NPCharacter prostituee = new NPCharacter("Prostitu�e","prostituee","Coucou mon mignon, si tu veux quelque chose il faudra y mettre le prix...",Event.NO_EVENT);
        NPCharacter chef_enquete = new NPCharacter("Chef d'Enquete","chefenquete","Qu'est ce que vous faites là ?!?! \nSortez de mon bureau !",Event.NO_EVENT);
        NPCharacter enfant = new NPCharacter("Petit Enfant","enfant","Bonjour monsieur... (baisse la tete)",Event.NO_EVENT);
        NPCharacter jack_ginger = new NPCharacter("Enqueteur","enqueteur","Hahaha tu es tomb� dans mon piège ! tu va mourir !",Event.GAME_OVER);
        NPCharacter jack_home = new NPCharacter("Enqueteur","enqueteur","Faites comme chez vous ! \n\nReposez vous quelques minutes, nous discuterons apres.",Event.NO_EVENT);
        gameModel.getRoom("bureau").getCharRoom().addChar("enqueteur",jack);
        gameModel.getRoom("maisonClose").getCharRoom().addChar("prostituee",prostituee);
        gameModel.getRoom("bureau").getCharRoom().addChar("chefenquete",chef_enquete);
        gameModel.getRoom("impasse").getCharRoom().addChar("enfant",enfant);
        gameModel.getRoom("maisonGinger").getCharRoom().addChar("enqueteur",jack_ginger);
        gameModel.getRoom("maisonJack").getCharRoom().addChar("enqueteur",jack_home);
        
        journalintime = new Item(10,"Le journal intime de Polly, la prostitu�e assassin�e","diary",Event.NO_EVENT,Event.USE_DIARY,"Ramass� : Journal Intime","Cher journal, je suis fatigu�e de travailler la bas dans cette maison close... \nMais je n'ai pas le choix, il en faut pour rembourser ce collier que je n'aurais pas du acheter... \nMais il etait si beau....\n\n (le reste est tach� de sang...)");
        collier = new Item(10,"Un collier en or 18 carats","collier",Event.NO_EVENT,Event.HAVE_SEEN_NECK,"Ramass� : Collier Or 18 Carats de Polly","Le Collier de polly, que fait il ici ?");
        new Item(10,"Une empreinte relev�e sur Ginger\n une autre prostitu�e","emprunte",Event.NO_EVENT,Event.NO_EVENT,"Collect� : Emprunte","Emprunte digitale du tueur pr�sum�");
        chapeau = new Item(20,"Un chapeau melon gris où la lettre 'J' �tait brod�e","chapeau",Event.NO_EVENT,Event.HAVE_SEEN_HAT,"Ramass� : Chapeau","Un chapeau etrange... Avec un 'J' brod� dessus...");
        cheveu1 = new Item(10,"Un cheveu trouv� sur le corps de Ginger","cheveu1",Event.FOUND_HAIR,Event.NO_EVENT,"Collect� : Cheveu","Un cheveu du tueur, ca sera utile pour plus tard...");
        cheveu2 = new Item(10,"Un cheveu de l'enquêteur r�colt� \ndans sa salle de bain","cheveu2",Event.FOUND_HAIR,Event.NO_EVENT,"Collect� : Autre Cheveu","Avec mon comparateur ADN, je peux voir si le cheveu trouv� est le meme que celui que j'ai...");
    }
    
    public void checkScenario()
    {   
        new CommonDoor("MASTERKEY",true);
        new CommonDoor("rien",false);
        
        condition1 = objectives.get(Event.HAVE_NEWSPAPER);
        condition2 = objectives.get(Event.SPEECH_ENQUETE1);
        condition3 = objectives.get(Event.USE_DIARY);
        condition4 = objectives.get(Event.SPEECH_PROSTITUTE);
        condition5 = (objectives.get(Event.FOUND_HAIR) && objectives.get(Event.KID_INFOS));
        condition6 = objectives.get(Event.SPEECH_ENQUETE2);
        condition7 = objectives.get(Event.SPEECH_JACK);
        condition8 = (objectives.get(Event.HAVE_SEEN_HAT) && objectives.get(Event.HAVE_SEEN_NECK) && objectives.get(Event.USED_DNA_COMPARATOR));
        
        if(!condition1 && !condition2 && !condition3 && !condition4 && !condition5 && !condition6 && !condition7 && !condition8){
            gameModel.getRoom("rueSombre").getDoor("Est").lockDoor("MASTERKEY");
            gameModel.getRoom("rueGare").getDoor("Sud").lockDoor("MASTERKEY");
            gameModel.getRoom("rueSombre").getDoor("Sud-Ouest").lockDoor("MASTERKEY");
        }
        
        if(condition1 && !condition2 && !condition3 && !condition4 && !condition5 && !condition6 && !condition7 && !condition8){
             gameModel.getRoom("bureau").getCharRoom().getChar("enqueteur").setSpeech("Tiens bonjour ! Vous voulez nous aidez ? \nAlors allez voir le chef d'enquete il vous renseignera mieux que moi...");
             gameModel.getRoom("bureau").getCharRoom().getChar("chefenquete").setSpeech("Bonjour ! Nous n'avons que peu de temps et malheureusement \ntrop peu d'informations pour confondre ce Jack l'eventreur. \nVotre aide nous sera utile."+
                                                                                        "\n\nLa premiere victime a �t� retrouv�e morte dans un motel situ� \ndans un quartier malfam� de Londres. \nAller y jeter un coup d'oeil");
             gameModel.getRoom("bureau").getCharRoom().getChar("chefenquete").setSpeechEvent(Event.SPEECH_ENQUETE1); 
        }
        
        if(condition2 && !condition3 && !condition4 && !condition5 && !condition6 && !condition7 && !condition8){
            if(gameModel.getPlayer().getObjectPlayer().getItem("diary")==null){
                gameModel.getRoom("hotel").getObjectRoom().addItem("diary",journalintime);
            }
            gameModel.getRoom("rueSombre").getDoor("Sud-Ouest").unlockDoor("MASTERKEY");
            gameModel.getRoom("bureau").getCharRoom().getChar("enqueteur").setSpeech("Vous avez eu le lieu du premier meutre ? \nQu'attendez vous pour y aller ?! \nNous n'avons que peu de temps...");
            gameModel.getRoom("bureau").getCharRoom().getChar("chefenquete").setSpeech("Toujours la ?!? \n\nAllez a cet hotel maintenant, on a pas de temps a perdre... \nVous devriez surement trouver quelque chose d'interessant"+
                                                                                        " a exploiter... \nOn ne sait jamais...");                                                                        
        }
        
        if(condition3 && !condition4 && !condition5 && !condition6 && !condition7 && !condition8){
            gameModel.getRoom("bureau").getCharRoom().getChar("enqueteur").setSpeech("Vous devriez suivre les indications de ce Journal...\n Meme si c'est un endroit peu recommandable, vous devriez y aller");
            gameModel.getRoom("bureau").getCharRoom().getChar("chefenquete").setSpeech("Interessant de me montrer ca mais je pensais que VOUS vous en chargiez ? \nAllez y bon sang ne trainez pas comme ca alors \nque vous avez les indices en main...");    
            gameModel.getRoom("maisonClose").getCharRoom().getChar("prostituee").setSpeech("Elle a �t� tu�e je sais... \nC'est un d�traqu� ce mec j'vous dit ! \nAllez voir Ginger je m'inquiete un peu, elle habite pres de l'hotel \nou habitait Polly... Sinon quelque chose vous tente ?");     
            gameModel.getRoom("maisonClose").getCharRoom().getChar("prostituee").setSpeechEvent(Event.SPEECH_PROSTITUTE); 
        }
        
        if(condition4 && !condition5 && !condition6 && !condition7 && !condition8){
            if(gameModel.getPlayer().getObjectPlayer().getItem("cheveu1")==null){
                gameModel.getRoom("impasse").getObjectRoom().addItem("cheveu1",cheveu1);
            }
            gameModel.getRoom("rueSombre").getDoor("Est").unlockDoor("MASTERKEY");
            Door trapdoor_ginger =  new TrapDoor("MASTERKEY",false,gameModel.getRoom("maisonGinger"));
            gameModel.getRoom("rueSombre").getDoorMap().remove("Est");
            gameModel.getRoom("maisonGinger").getDoorMap().remove("Ouest");
            gameModel.getRoom("rueSombre").getDoorMap().put("Est",trapdoor_ginger);
            gameModel.getRoom("maisonGinger").getDoorMap().put("Ouest",trapdoor_ginger);
            
            gameModel.getRoom("bureau").getCharRoom().getChar("enqueteur").setSpeech("Ce qu'a dit cette prostitu�e est interessant, \nvous devriez suivre ces indications");
            gameModel.getRoom("bureau").getCharRoom().getChar("chefenquete").setSpeech("Quoi encore ?! Mais vous avez ce qu'il vous faut allez y !");    
            gameModel.getRoom("maisonClose").getCharRoom().getChar("prostituee").setSpeech("Quelque chose vous tente ?");    
            gameModel.getRoom("impasse").getCharRoom().getChar("enfant").setSpeech("(tremble) j'ai peur... j'ai vu un monsieur tout en noir, grand... \nIl avais un chapeau melon noir... C'etait horrible...");
            gameModel.getRoom("impasse").getCharRoom().getChar("enfant").setSpeechEvent(Event.KID_INFOS);
        }
        
        if(condition5 && !condition6 && !condition7 && !condition8){
            gameModel.getRoom("bureau").getCharRoom().getChar("enqueteur").setSpeech("Quelle journ�e de dingue, ce criminel est vraiment epatant dans un certain sens...");
            gameModel.getRoom("bureau").getCharRoom().getChar("chefenquete").setSpeech("L'affaire progresse un peu grace a vous... \nAttendez, il y a un autre meurtre vous devriez vous y rendre de ce pas...");        
            gameModel.getRoom("bureau").getCharRoom().getChar("chefenquete").setSpeechEvent(Event.SPEECH_ENQUETE2);
        }
        
        if(condition6 && !condition7 && !condition8){
            gameModel.getRoom("rueSombre").getDoor("Sud-Ouest").unlockDoor("MASTERKEY");
            gameModel.getRoom("rueSombre").getDoorMap().remove("Est");
            gameModel.getRoom("maisonGinger").getDoorMap().remove("Ouest");
            gameModel.getRoom("rueSombre").getDoorMap().put("Est",new CommonDoor("MASTERKEY",false));
            gameModel.getRoom("maisonGinger").getDoorMap().put("Ouest",new CommonDoor("MASTERKEY",false));
            
            gameModel.getRoom("bureau").getCharRoom().getChar("enqueteur").setSpeech("On y va... Encore une mort...");
            gameModel.getRoom("bureau").getCharRoom().getChar("chefenquete").setSpeech("Aller on y va, encore une pauvre femme tu�e...");        
            Door trapdoor = new TrapDoor("MASTERKEY",false,gameModel.getRoom("rueGare"));
            gameModel.getRoom("bureau").getDoorMap().remove("Sud");
            gameModel.getRoom("rueGare").getDoorMap().remove("Nord");
            gameModel.getRoom("rueGare").getDoorMap().put("Nord",trapdoor);
            gameModel.getRoom("bureau").getDoorMap().put("Sud",trapdoor);
            gameModel.getRoom("maisonGinger").getCharRoom().getChar("enqueteur").setSpeech("Encore une victime ! C'est incroyable... \nJe ne sais pas comment il fait, il parvient toujours a nous devancer. \n\nQu'en pensez vous ? \n\nJ'ai une id�e, venez chez moi ! Nous discuterons mieux de tout ca...");
            gameModel.getRoom("maisonGinger").getCharRoom().getChar("enqueteur").setSpeechEvent(Event.SPEECH_JACK);
        }
        
        if(condition7 && !condition8){
            if(gameModel.getPlayer().getObjectPlayer().getItem("chapeau")==null && gameModel.getPlayer().getObjectPlayer().getItem("collier")==null &&
               gameModel.getPlayer().getObjectPlayer().getItem("cheveu2")==null){
                    gameModel.getRoom("maisonJack").getObjectRoom().addItem("chapeau",chapeau);
                    gameModel.getRoom("maisonJack").getObjectRoom().addItem("collier",collier);
                    gameModel.getRoom("sallebain").getObjectRoom().addItem("cheveu2",cheveu2);
            }
            gameModel.getRoom("rueGare").getDoor("Sud").unlockDoor("MASTERKEY");
        }
        
        if(condition8){
            gameModel.getRoom("bureau").getDoorMap().remove("Sud");
            gameModel.getRoom("rueGare").getDoorMap().remove("Nord");
            gameModel.getRoom("rueGare").getDoorMap().put("Nord",new CommonDoor("MASTERKEY",false));
            gameModel.getRoom("bureau").getDoorMap().put("Sud",new CommonDoor("MASTERKEY",false));
            gameModel.getRoom("bureau").getCharRoom().getChar("chefenquete").setSpeech("Incroyable....\n\n Alors c'�tait lui... Merci de votre aide pr�cieuse. \nJe n'en reviens pas qu'il ai �t� sous notre nez depuis tout ce temps.");        
            gameModel.getRoom("bureau").getCharRoom().getChar("chefenquete").setSpeechEvent(Event.CONGRATULATION); 
        }
    }
    
    public int endOfGame(){
        return ((gameModel.getStatut() == Event.CONGRATULATION) ? 1 : ((gameModel.getStatut() == Event.GAME_OVER) ? -1 : 0));
    }            
    
    public int validGoal(Event evenement)
    {
        if(evenement == Event.GAME_OVER){
            gameModel.setStatut(Event.GAME_OVER);
            return -1;
        } else {
            if(evenement == Event.CONGRATULATION){
                gameModel.setStatut(Event.CONGRATULATION);
                return 1;
            } else {
                if(objectives.containsKey(evenement)){
                    objectives.remove(evenement);
                    objectives.put(evenement,true);
                    return 1;
                }
            }
        }
        return 0;
    }
}//GameScenario