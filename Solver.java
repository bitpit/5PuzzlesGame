public class Solver extends Thread {
    
    public Rule rules;
    Game game;
    String type;
    
    public Solver(Game g){
        
        super("Solver");
        
        game = g;
         
        type = game.getName();
        
        if (type.equals("Soduku")) rules = new SodukuRules(g);  
        if (type.equals("KenKen")) rules = new KenKenRules(g);
        if (type.equals("Page472")) rules = new Page472Rules(g);
        
        
    }
 
    
    public boolean label(){
        
      
        if (game.finished()){
            System.out.println("finished");
            System.out.println("all constraints? "+rules.allConstraints());
            if (rules.allConstraints())
                return true;
            else
                return false;
        }
        
        Space s = game.nextUnsolved();
        
        Group row = s.getRow();
        Group column = s.getColumn();
                
        game.printBoardTerm();
        
        while (s.morePossibilities()){
            game.printBoardTerm();
            s.nextPossibility();
            if (rules.constraints(s) && label()){
            
                return true;
            }
        }
       
        s.reset();
        
        return false;
    }
    
    
    public void run(){
        label();
        game.printBoardTerm();
    }

}