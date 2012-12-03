import java.util.ArrayList;
public class Solver extends Thread {
    
    public Rule rules;
    public Game game;
    public String type;
    private boolean labelled = false;
    
    public Solver(Game g){
        
        super("Solver");
        
        game = g;
         
        type = game.getName();
        
        if (type.equals("Soduku")) rules = new SodukuRules(g);  
        if (type.equals("KenKen")) rules = new KenKenRules(g);
        if (type.equals("Page472")) rules = new Page472Rules(g);
        if (type.equals("SixPack")) rules = new SixPackRules(g);
        
        
    }
 
    
    public boolean label(){
        
      
        if (game.finished()){
            if (rules.allConstraints())
                return true;
            else
                return false;
        }
        
        Space s = game.nextUnsolved();
                
        while (s.morePossibilities()){
            s.nextPossibility();
            if (rules.constraints(s) && label()){
                return true;
            }
        }
       
        s.reset();
        
        return false;
    }
    
    public boolean getLabelled(){
        return labelled;
    }
    
    
    public void run(){
        labelled = label();
        
    }

}