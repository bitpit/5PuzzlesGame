public class SodukuRules implements Rules {
    
    private Game soduku;
    
    public SodukuRules(Game s){
        soduku = s;
    }

    public boolean row(){
        
        return true;
        
    }
    
    public boolean column(){
        return true;
    }
    
    
    public boolean shape(){
        
        return true;
    }

}