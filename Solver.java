public class Solver {
    
    Rules rules;
    Game game;

    public Solver(Game g){
        
        game = g;
	
        if (game.getName().equals("Soduku")) rules = new SodukuRules(g);            

    }
    
    
    public void solve(){
        System.out.println("will do stuff");
    }


}