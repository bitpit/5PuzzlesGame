public class Solver {
    
    Rule rules;
    Game game;
    
    public Solver(Game g){
        
        game = g;
        
        if (game.getName().equals("Soduku")) rules = new SodukuRules(g);            
        
    }
 
    
    public boolean label(){
        
      
        if (game.finished()){
            if (rules.allConstraints())
                return true;
        }
        
        Space s = game.nextUnsolved();
                
        while (s.morePossibilities()){
            s.nextPossibility();
            if (rules.constraints(s) && label())
                return true;
        }
       
        s.reset();
        
        return false;
    }

}