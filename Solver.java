public class Solver {
    
    Rule rules;
    Game game;
    String type;
    
    public Solver(Game g){
        
        game = g;
        
        if (game.getName().equals("Soduku")) rules = new SodukuRules(g);  
        if (game.getName().equals("KenKen")) rules = new KenKenRules(g);
        type = game.getName();
        
    }
 
    
    public boolean label(){
        
      
        if (game.finished()){
            if (rules.allConstraints())
                return true;
        }
        
        Space s = game.nextUnsolved();
      //  System.out.println(s.getX()+" x, "+s.getY());
                
        while (s.morePossibilities()){
            s.nextPossibility();
            if (rules.constraints(s) && label()){
            
                return true;
            }
        }
       
        s.reset();
        
        return false;
    }

}